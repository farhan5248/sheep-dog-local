package org.farhan.dsl.sheepdog.ui.syntaxcoloring;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.farhan.dsl.lang.*;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.farhan.dsl.sheepdog.sheepDog.Table;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.TestData;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;
import org.farhan.dsl.sheepdog.sheepDog.TestSuite;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class SheepDogSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

    @Override
    public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
            CancelIndicator cancelIndicator) {
        if (resource == null || resource.getParseResult() == null || resource.getContents().size() <= 0) {
            return;
        }
        if (resource.getContents().get(0) instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) resource.getContents().get(0);
            for (Statement s : testSuite.getStatementList()) {
                highlightStatement(s, acceptor, 0);
            }
            for (Object child : testSuite.getTestStepContainerList()) {
                if (child instanceof TestSetup) {
                    TestSetup ts = (TestSetup) child;
                    for (Statement s : ts.getStatementList()) {
                        highlightStatement(s, acceptor, 0);
                    }
                    for (TestStep s : ts.getTestStepList()) {
                        highlightTable(s.getTable(), acceptor);
                    }
                } else if (child instanceof TestCase) {
                    TestCase tc = (TestCase) child;
                    for (Statement s : tc.getStatementList()) {
                        highlightStatement(s, acceptor, 0);
                    }
                    for (TestStep s : tc.getTestStepList()) {
                        if (tc.getTestDataList().size() > 0) {
                            highlightStepParameters(s, acceptor, 0);
                        }
                        highlightTable(s.getTable(), acceptor);
                    }
                    for (TestData example : tc.getTestDataList()) {
                        if (example.getStatementList() != null) {
                            for (Statement s : example.getStatementList().getStatementList()) {
                                highlightStatement(s, acceptor, 0);
                            }
                        }
                        highlightTable(example.getTable(), acceptor);
                    }
                }
            }
        } else {
            StepObject stepObject = (StepObject) resource.getContents().get(0);
            for (Statement s : stepObject.getStatementList()) {
                highlightStatement(s, acceptor, 0);
            }
            for (StepDefinition child : stepObject.getStepDefinitionList()) {
                for (Statement s : child.getStatementList()) {
                    highlightStatement(s, acceptor, 0);
                }
                for (StepParameters sp : child.getStepParameterList()) {
                    if (sp.getStatementList() != null) {
                        for (Statement s : sp.getStatementList().getStatementList()) {
                            highlightStatement(s, acceptor, 0);
                        }
                    }
                    highlightTable(sp.getTable(), acceptor);
                }
            }
        }
    }

    private void highlightStepParameters(TestStep testStep, IHighlightedPositionAcceptor acceptor, int current) {
        if (testStep != null) {
            INode node = NodeModelUtils.getNode(testStep);
            // TODO only highlight names referenced in the table header
            // Right now this will highlight a multi-line string
            int start = node.getText().indexOf('{', current);
            int stop = node.getText().indexOf('}', start);
            if (start > 0 && stop > 0 && node.getText().charAt(start + 1) != ' ') {
                acceptor.addPosition(node.getTotalOffset() + start, stop - start + 1,
                        SheepDogHighlightingConfiguration.TBL_ID);
                this.highlightStepParameters(testStep, acceptor, stop + 1);
            }
        }
    }

    private void highlightStatement(Statement statement, IHighlightedPositionAcceptor acceptor, int current) {
        if (statement != null) {
            INode node = NodeModelUtils.getNode(statement);
            int offset = node.getTotalOffset();
            for (String line : node.getText().split("\n")) {
                if (TitleFragments.isTodo(line)) {
                    acceptor.addPosition(offset + current, line.length(), SheepDogHighlightingConfiguration.TODO_ID);
                    current += line.length() + 1;
                } else {
                    for (String word : line.split(" ")) {
                        if (TitleFragments.isTag(word)) {
                            acceptor.addPosition(offset + current, word.length(),
                                    SheepDogHighlightingConfiguration.TAG_ID);
                        } else {
                            acceptor.addPosition(offset + current, word.length(),
                                    SheepDogHighlightingConfiguration.STATEMENT_ID);
                        }
                        current += word.length() + 1;
                    }
                }
            }
        }
    }

    private void highlightTable(Table table, IHighlightedPositionAcceptor acceptor) {
        if (table != null) {
            if (table.getRowList().size() > 0) {
                INode node = NodeModelUtils.getNode(table.getRowList().get(0));
                acceptor.addPosition(node.getTotalOffset(), node.getLength(), SheepDogHighlightingConfiguration.TBL_ID);
            }
        }
    }

}
