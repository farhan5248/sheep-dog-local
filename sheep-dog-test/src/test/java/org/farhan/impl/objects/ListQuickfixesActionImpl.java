package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
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
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesActionImpl extends TestObjectActionImpl implements ListQuickfixesAction {

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
                if (validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                    listQuickfixesDialog.addAll(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (cursor instanceof IRow) {
                IRow row = (IRow) cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                if (validateDialog.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
                    if (testStep.getTable() != null) {
                        if (testStep.getTable().getRowList() != null) {
                            if (testStep.getTable().getRowList().getFirst() != null) {
                                listQuickfixesDialog
                                        .addAll(RowIssueResolver.correctCellListWorkspace(testStep));
                            }
                        }
                    }
                }
            } else if (cursor instanceof IText) {
                IText text = (IText) cursor;
                ITestStep testStep = (ITestStep) text.getParent();
                if (validateDialog.contentEquals(TextIssueTypes.TEXT_NAME_WORKSPACE.description)) {
                    listQuickfixesDialog.addAll(TextIssueResolver.correctNameWorkspace(testStep));
                }
            } else if (cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) cursor;
                if (validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                    listQuickfixesDialog
                            .addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                } else if (validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
                    listQuickfixesDialog
                            .addAll(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                }
            } else if (cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) cursor;
                if (validateDialog
                        .contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                    listQuickfixesDialog
                            .addAll(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
                }
            } else if (cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) cursor;
                if (validateDialog.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                    listQuickfixesDialog.addAll(TestSuiteIssueResolver.correctNameOnly(testSuite));
                }
            } else {
                Assertions.fail("Unknown Element Type");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }
}
