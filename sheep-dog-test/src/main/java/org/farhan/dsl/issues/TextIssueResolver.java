package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class TextIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueResolver.class);

	public static void applyTextContentWorkspace(IText theText) throws Exception {
		logger.debug("Entry: applyTextContentWorkspace({})", theText);
		ITestStep testStep = theText.getParent();
		if (testStep == null) {
			logger.debug("Exit: applyTextContentWorkspace(null testStep)");
			return;
		}
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
		if (stepObjectFullName.isEmpty()) {
			logger.debug("Exit: applyTextContentWorkspace(empty stepObjectFullName)");
			return;
		}
		ITestProject project = SheepDogUtility.getTestProjectParentForText(theText);
		if (project == null) {
			logger.debug("Exit: applyTextContentWorkspace(null project)");
			return;
		}
		ITestDocument doc = project.getTestDocument(stepObjectFullName);
		if (!(doc instanceof IStepObject)) {
			logger.debug("Exit: applyTextContentWorkspace(doc not IStepObject)");
			return;
		}
		IStepDefinition stepDef = ((IStepObject) doc).getStepDefinition(testStep.getStepDefinitionName());
		if (stepDef == null) {
			logger.debug("Exit: applyTextContentWorkspace(null stepDef)");
			return;
		}
		IStepParameters stepParameters = SheepDogBuilder.createStepParameters(stepDef, "Content");
		ITable newTable = SheepDogBuilder.createTable(stepParameters);
		IRow newRow = SheepDogBuilder.createRow(newTable);
		SheepDogBuilder.createCell(newRow, "Content");
		logger.debug("Exit: applyTextContentWorkspace");
	}

	public static ArrayList<SheepDogIssueProposal> correctContentWorkspace(IText theText) throws Exception {
		logger.debug("Entry: correctContentWorkspace({})", theText);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		SheepDogIssueProposal proposal = new SheepDogIssueProposal();
		proposal.setId("Generate Content");
		proposal.setDescription("");
		proposals.add(proposal);
		logger.debug("Exit: correctContentWorkspace({})", proposals);
		return proposals;
	}
}
