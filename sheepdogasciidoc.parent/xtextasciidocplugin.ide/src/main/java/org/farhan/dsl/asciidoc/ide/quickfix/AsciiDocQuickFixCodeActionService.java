package org.farhan.dsl.asciidoc.ide.quickfix;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionKind;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.CreateFile;
import org.eclipse.lsp4j.CreateFileOptions;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentEdit;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.codeActions.QuickFixCodeActionService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.farhan.dsl.asciidoc.asciiDoc.Cell;
import org.farhan.dsl.asciidoc.asciiDoc.TestStep;
import org.farhan.dsl.asciidoc.asciiDoc.TestStepContainer;
import org.farhan.dsl.asciidoc.asciiDoc.TestSuite;
import org.farhan.dsl.asciidoc.asciiDoc.Text;
import org.farhan.dsl.asciidoc.impl.CellImpl;
import org.farhan.dsl.asciidoc.impl.TestProjectImpl;
import org.farhan.dsl.asciidoc.impl.TestStepContainerImpl;
import org.farhan.dsl.asciidoc.impl.TestStepImpl;
import org.farhan.dsl.asciidoc.impl.TestSuiteImpl;
import org.farhan.dsl.asciidoc.validation.AsciiDocValidator;
import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.dsl.grammar.SheepDogFactory;
import org.slf4j.Logger;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;

public class AsciiDocQuickFixCodeActionService extends QuickFixCodeActionService {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(AsciiDocQuickFixCodeActionService.class);

	@Override
	public List<Either<Command, CodeAction>> getCodeActions(Options options) {
		logger.debug("Entering getCodeActions with options {}", options.getURI());

		List<Diagnostic> diagnostics = options.getCodeActionParams().getContext().getDiagnostics();
		logger.debug("Diagnostics count from client: {}", diagnostics.size());

		// If client sent no diagnostics (e.g. LSP4E), compute them from the resource
		if (diagnostics.isEmpty()) {
			Range requestedRange = options.getCodeActionParams().getRange();
			logger.debug("Client sent no diagnostics, computing from resource for range {}", requestedRange);
			diagnostics = options.getLanguageServerAccess()
					.doSyncRead(options.getURI(), (ILanguageServerAccess.Context context) -> {
						options.setDocument(context.getDocument());
						options.setResource(context.getResource());
						return computeDiagnosticsFromResource(context, requestedRange);
					});
			logger.debug("Computed {} diagnostics from resource", diagnostics.size());
		}

		List<Either<Command, CodeAction>> codeActions = new ArrayList<>();
		for (Diagnostic diagnostic : diagnostics) {
			logger.debug("Examining diagnostic {} ", diagnostic.getCode().get().toString());
			if (canHandleDiagnostic(diagnostic)) {
				logger.debug("Handling diagnostic {} ", diagnostic.getCode().get().toString());
				codeActions.addAll(options.getLanguageServerAccess()
						.doSyncRead(options.getURI(), (ILanguageServerAccess.Context context) -> {
							options.setDocument(context.getDocument());
							options.setResource(context.getResource());
							return getCodeActionsForDiagnostic(options, diagnostic);
						}));
			}
		}
		logger.debug("Exiting getCodeActions");
		return codeActions;
	}

	private List<Diagnostic> computeDiagnosticsFromResource(ILanguageServerAccess.Context context, Range requestedRange) {
		List<Diagnostic> diagnostics = new ArrayList<>();
		if (!(context.getResource() instanceof XtextResource)) {
			return diagnostics;
		}
		XtextResource resource = (XtextResource) context.getResource();
		IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
		List<Issue> issues = validator.validate(resource, CheckMode.FAST_ONLY, CancelIndicator.NullImpl);
		Document document = context.getDocument();

		for (Issue issue : issues) {
			if (issue.getCode() == null) continue;

			Position start = document.getPosition(issue.getOffset());
			Position end = document.getPosition(issue.getOffset() + issue.getLength());
			Range issueRange = new Range(start, end);

			// Only include diagnostics that overlap with the requested range
			if (rangesOverlap(requestedRange, issueRange)) {
				Diagnostic diagnostic = new Diagnostic();
				diagnostic.setRange(issueRange);
				diagnostic.setMessage(issue.getMessage());
				diagnostic.setCode(issue.getCode());
				diagnostic.setSeverity(issue.getSeverity() == Severity.ERROR
						? DiagnosticSeverity.Error : DiagnosticSeverity.Warning);
				diagnostics.add(diagnostic);
				logger.debug("  Computed diagnostic: code={}, range={}", issue.getCode(), issueRange);
			}
		}
		return diagnostics;
	}

	private boolean rangesOverlap(Range a, Range b) {
		// a ends before b starts
		if (a.getEnd().getLine() < b.getStart().getLine()
				|| (a.getEnd().getLine() == b.getStart().getLine()
						&& a.getEnd().getCharacter() < b.getStart().getCharacter())) {
			return false;
		}
		// b ends before a starts
		if (b.getEnd().getLine() < a.getStart().getLine()
				|| (b.getEnd().getLine() == a.getStart().getLine()
						&& b.getEnd().getCharacter() < a.getStart().getCharacter())) {
			return false;
		}
		return true;
	}

	private boolean canHandleDiagnostic(Diagnostic diagnostic) {
		String code = diagnostic.getCode().get().toString();
		return AsciiDocValidator.CELL_NAME_ONLY.equals(code)
				|| AsciiDocValidator.TEST_STEP_CONTAINER_NAME_ONLY.equals(code)
				|| AsciiDocValidator.TEST_SUITE_NAME_ONLY.equals(code)
				|| AsciiDocValidator.ROW_CELL_LIST_WORKSPACE.equals(code)
				|| AsciiDocValidator.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.equals(code)
				|| AsciiDocValidator.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.equals(code)
				|| AsciiDocValidator.TEXT_NAME_WORKSPACE.equals(code);
	}

	private List<Either<Command, CodeAction>> getCodeActionsForDiagnostic(Options options, Diagnostic diagnostic) {
		logger.debug("Entering getCodeActionsForDiagnostic with diagnostic {} and options {} ",
				diagnostic.getCode().get().toString(), options.getURI());
		String code = diagnostic.getCode().get().toString();
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

		try {
			EObject eObject = getEObjectFromDiagnostic(options, diagnostic);
			initProject(eObject.eResource());
			if (AsciiDocValidator.CELL_NAME_ONLY.equals(code)) {
				Cell cell = (Cell) eObject;
				proposals = CellIssueResolver.correctNameOnly(new CellImpl(cell));
			} else if (AsciiDocValidator.TEST_STEP_CONTAINER_NAME_ONLY.equals(code)) {
				TestStepContainer container = (TestStepContainer) eObject;
				proposals = TestStepContainerIssueResolver.correctNameOnly(new TestStepContainerImpl(container));
			} else if (AsciiDocValidator.TEST_SUITE_NAME_ONLY.equals(code)) {
				TestSuite suite = (TestSuite) eObject;
				proposals = TestSuiteIssueResolver.correctNameOnly(new TestSuiteImpl(suite));
			} else if (AsciiDocValidator.ROW_CELL_LIST_WORKSPACE.equals(code)) {
				// TODO why does this need to be Cell and not Row? When it's a Row, there'a a class cast exception
				Cell cell = (Cell) eObject;
				// TODO why does RowIssueResolver need a TestStepImpl and not a RowImpl?
				proposals = RowIssueResolver
						.correctCellListWorkspace(new TestStepImpl((TestStep) cell.eContainer().eContainer().eContainer()));
			} else if (AsciiDocValidator.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.equals(code)) {
				TestStep step = (TestStep) eObject;
				proposals = TestStepIssueResolver.correctStepObjectNameWorkspace(new TestStepImpl(step));
			} else if (AsciiDocValidator.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.equals(code)) {
				TestStep step = (TestStep) eObject;
				proposals = TestStepIssueResolver.correctStepDefinitionNameWorkspace(new TestStepImpl(step));
			} else if (AsciiDocValidator.TEXT_NAME_WORKSPACE.equals(code)) {
				Text text = (Text) eObject;
				proposals = TextIssueResolver.correctNameWorkspace(new TestStepImpl((TestStep) text.eContainer()));
			}
		} catch (Exception e) {
			logger.error("Error getting proposals for code action", e);
		}
		logger.debug("Exiting getCodeActionsForDiagnostic");
		return createCodeActions(options, diagnostic, proposals);
	}

	private List<Either<Command, CodeAction>> createCodeActions(Options options, Diagnostic diagnostic,
			ArrayList<SheepDogIssueProposal> proposals) {
		logger.debug("Entering createCodeActions with {} proposals", proposals.size());
		List<Either<Command, CodeAction>> codeActions = new ArrayList<>();

		for (SheepDogIssueProposal p : proposals) {
			try {
				CodeAction action = new CodeAction();
				action.setKind(CodeActionKind.QuickFix);
				action.setTitle(p.getId());
				action.setDiagnostics(Collections.singletonList(diagnostic));

				WorkspaceEdit workspaceEdit = new WorkspaceEdit();

				if (!(p.getValue() instanceof org.farhan.dsl.grammar.IStepObject)) {
					// Same-file edit: use diagnostic range and options URI
					VersionedTextDocumentIdentifier textDocId = new VersionedTextDocumentIdentifier();
					textDocId.setUri(options.getURI());
					textDocId.setVersion(null);

					TextDocumentEdit textDocEdit = getTextDocumentEdit(
							diagnostic.getRange(), p, textDocId);

					workspaceEdit.setDocumentChanges(List.of(Either.forLeft(textDocEdit)));
				} else {
					// Workspace edit: create new file
					logger.debug("Creating new file for IStepObject");
					CreateFile createFile = getResourceOperation(p);
					logger.debug("createFile.getUri() for {}", createFile.getUri());
					VersionedTextDocumentIdentifier textDocId = new VersionedTextDocumentIdentifier();
					textDocId.setUri(createFile.getUri());
					textDocId.setVersion(null);

					TextDocumentEdit textDocEdit = getTextDocumentEdit(
							new Range(new Position(0, 0), new Position(0, 0)), p, textDocId);

					workspaceEdit.setDocumentChanges(List.of(Either.forRight(createFile), Either.forLeft(textDocEdit)));
				}

				action.setEdit(workspaceEdit);
				codeActions.add(Either.forRight(action));
			} catch (Exception e) {
				logger.error("Error creating code action for " + p.getId(), e);
			}
		}
		logger.debug("Exiting createCodeActions with {} code actions", codeActions.size());
		return codeActions;
	}

	private CreateFile getResourceOperation(SheepDogIssueProposal p) {
		CreateFile createFile = new CreateFile();
		TestProjectImpl testProject = (TestProjectImpl) SheepDogFactory.instance.createTestProject();
		org.farhan.dsl.grammar.IStepObject stepObject = (org.farhan.dsl.grammar.IStepObject) p.getValue();
		URI uri = URI.createFileURI(testProject.getName() + "/" + testProject.baseDir
				+ "/" + stepObject.getFullName());
		createFile.setUri(uri.toString());
		CreateFileOptions options = new CreateFileOptions();
		options.setOverwrite(true);
		options.setIgnoreIfExists(false);
		createFile.setOptions(options);
		return createFile;
	}

	private void initProject(Resource resource) {
		TestProjectImpl parent = (TestProjectImpl) SheepDogFactory.instance.createTestProject();
		String resourcePath = resource.getURI().toFileString().replace(File.separator, "/");
		String projectPath = resourcePath.split("src/test/resources/asciidoc/specs/")[0].replace("/",
				File.separator);
		parent.setName(new File(projectPath).getAbsolutePath());
	}

	private TextDocumentEdit getTextDocumentEdit(Range range, SheepDogIssueProposal p,
			VersionedTextDocumentIdentifier textDocId) throws Exception {
		TextEdit textEdit = new TextEdit();
		textEdit.setRange(range);
		if (p.getValue() instanceof org.farhan.dsl.asciidoc.impl.StepObjectImpl) {
			org.farhan.dsl.asciidoc.impl.StepObjectImpl stepObject = (org.farhan.dsl.asciidoc.impl.StepObjectImpl) p.getValue();
			textEdit.setNewText(stepObject.getContent());
		} else {
			textEdit.setNewText(p.getValue().toString());
		}
		TextDocumentEdit textDocEdit = new TextDocumentEdit();
		textDocEdit.setTextDocument(textDocId);
		@SuppressWarnings("unchecked")
		List edits = List.of(Either.forLeft(textEdit));
		textDocEdit.setEdits(edits);
		return textDocEdit;
	}

	private EObject getEObjectFromDiagnostic(Options options, Diagnostic diagnostic) {
		Resource resource = options.getResource();
		if (resource == null || !(resource instanceof XtextResource)) {
			return null;
		}

		XtextResource xtextResource = (XtextResource) resource;
		IParseResult parseResult = xtextResource.getParseResult();
		if (parseResult == null) {
			return null;
		}

		// Use the Document from options to convert position to offset
		Document document = options.getDocument();
		try {
			int offset = document.getOffSet(diagnostic.getRange().getStart());

			// Find EObject at offset using NodeModelUtils
			ICompositeNode rootNode = parseResult.getRootNode();
			ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);

			if (leafNode != null) {
				return NodeModelUtils.findActualSemanticObjectFor(leafNode);
			}
		} catch (Exception e) {
			logger.error("Error getting offset from document", e);
		}

		return null;
	}

}
