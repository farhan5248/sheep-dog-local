package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.CellIssueTypes;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.RowIssueTypes;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepContainerIssueTypes;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TestStepIssueTypes;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueTypes;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.dsl.issues.TextIssueTypes;
import org.farhan.objects.xtext.ApplyQuickfixAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ApplyQuickfixActionImpl extends TestObjectSheepDogImpl implements ApplyQuickfixAction {

    private static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
        for (SheepDogIssueProposal p : proposals) {
            if (p.getValue() instanceof IStepObject) {
                ITestProject workspace = (ITestProject) getProperty("workspace");
                IStepObject newStepObject = (IStepObject) p.getValue();
                ITestDocument existing = SheepDogUtility.getTestDocument(workspace, newStepObject.getFullName());
                if (existing != null) {
                    workspace.getTestDocumentList().remove(existing);
                }
                workspace.getTestDocumentList().add(newStepObject);
            } else {
                Object cursor = getProperty("cursor");
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
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", SheepDogUtility.getTestDocument((ITestProject) getProperty("workspace"), replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            String validateDialog = (String) getProperty("validate annotation.Content");
            Object cursor = getProperty("cursor");
            if (cursor instanceof ICell) {
                ICell cell = (ICell) cursor;
                if (validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                    applyProposal(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (cursor instanceof IRow) {
                IRow row = (IRow) cursor;
                ITestStep testStep = SheepDogUtility.getTestStepParent(row);
                if (validateDialog.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
                    if (testStep.getTable() != null) {
                        if (testStep.getTable().getRowList() != null) {
                            if (testStep.getTable().getRowList().getFirst() != null) {
                                applyProposal(RowIssueResolver.correctCellListWorkspace(testStep));
                            }
                        }
                    }
                }
            } else if (cursor instanceof IText) {
                IText text = (IText) cursor;
                ITestStep testStep = SheepDogUtility.getTestStepParent(text);
                if (validateDialog.contentEquals(TextIssueTypes.TEXT_NAME_WORKSPACE.description)) {
                    applyProposal(TextIssueResolver.correctNameWorkspace(testStep));
                }
            } else if (cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) cursor;
                if (validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                    applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                } else if (validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
                    applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                }
            } else if (cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) cursor;
                if (validateDialog
                        .contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                    applyProposal(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
                }
            } else if (cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) cursor;
                if (validateDialog.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                    applyProposal(TestSuiteIssueResolver.correctNameOnly(testSuite));
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
