package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.objects.xtext.ApplyQuickfixAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ApplyQuickfixActionImpl extends TestObjectSheepDogImpl implements ApplyQuickfixAction {

    private static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
        for (SheepDogIssueProposal p : proposals) {
            if (p.getValue() instanceof IStepObject) {
                testProject.addStepObject((IStepObject) p.getValue());
            } else {
                if (cursor instanceof ICell) {
                    ((ICell) cursor).setName(p.getValue().toString());
                } else if (cursor instanceof ITestSuite) {
                    ((ITestSuite) cursor).setName(p.getValue().toString());
                } else if (cursor instanceof ITestStepContainer) {
                    ((ITestStepContainer) cursor).setName(p.getValue().toString());
                }
            }
        }
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        properties.put("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        if (properties.get("Test Suite Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        }
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (cursor instanceof ICell) {
                ICell cell = (ICell) cursor;
                if (!CellIssueDetector.validateNameOnly(cell).isEmpty()) {
                    applyProposal(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (cursor instanceof IRow) {
                IRow row = (IRow) cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                if (!testStep.getTable().getRowList().isEmpty()
                        && (testStep.getTable().getRowList().getFirst() != null)) {
                    if (!RowIssueDetector.validateCellListWorkspace(row).isEmpty()) {
                        applyProposal(RowIssueResolver.correctCellListWorkspace(testStep));
                    }
                }
            } else if (cursor instanceof IText) {
                IText text = (IText) cursor;
                ITestStep testStep = (ITestStep) text.getParent();
                if (!TextIssueDetector.validateNameWorkspace(text).isEmpty()) {
                    applyProposal(TextIssueResolver.correctNameWorkspace(testStep));
                }
            } else if (cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) cursor;
                if (!TestStepIssueDetector.validateStepObjectNameWorkspace(testStep).isEmpty()) {
                    applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                }
                if (!TestStepIssueDetector.validateStepDefinitionNameWorkspace(testStep).isEmpty()) {
                    applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                }
            } else if (cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) cursor;
                if (!TestStepContainerIssueDetector.validateNameOnly(testStepContainer).isEmpty()) {
                    applyProposal(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
                }
            } else if (cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) cursor;
                if (!TestSuiteIssueDetector.validateNameOnly(testSuite).isEmpty()) {
                    applyProposal(TestSuiteIssueResolver.correctNameOnly(testSuite));
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
