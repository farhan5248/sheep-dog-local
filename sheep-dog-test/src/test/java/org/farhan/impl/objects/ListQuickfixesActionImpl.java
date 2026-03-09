package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectIDE;
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
public class ListQuickfixesActionImpl extends TestObjectIDE implements ListQuickfixesAction {

    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestObjectIDE.cursor instanceof ICell) {
                ICell cell = (ICell) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                    TestObjectIDE.listQuickfixesDialog.addAll(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (TestObjectIDE.cursor instanceof IRow) {
                IRow row = (IRow) TestObjectIDE.cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                if (TestObjectIDE.validateDialog.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
                    if (testStep.getTable() != null) {
                        if (testStep.getTable().getRowList() != null) {
                            if (testStep.getTable().getRowList().getFirst() != null) {
                                TestObjectIDE.listQuickfixesDialog
                                        .addAll(RowIssueResolver.correctCellListWorkspace(testStep));
                            }
                        }
                    }
                }
            } else if (TestObjectIDE.cursor instanceof IText) {
                IText text = (IText) TestObjectIDE.cursor;
                ITestStep testStep = (ITestStep) text.getParent();
                if (TestObjectIDE.validateDialog.contentEquals(TextIssueTypes.TEXT_NAME_WORKSPACE.description)) {
                    TestObjectIDE.listQuickfixesDialog.addAll(TextIssueResolver.correctNameWorkspace(testStep));
                }
            } else if (TestObjectIDE.cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                    TestObjectIDE.listQuickfixesDialog
                            .addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                } else if (TestObjectIDE.validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
                    TestObjectIDE.listQuickfixesDialog
                            .addAll(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                }
            } else if (TestObjectIDE.cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog
                        .contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                    TestObjectIDE.listQuickfixesDialog
                            .addAll(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
                }
            } else if (TestObjectIDE.cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                    TestObjectIDE.listQuickfixesDialog.addAll(TestSuiteIssueResolver.correctNameOnly(testSuite));
                }
            } else {
                Assertions.fail("Unknown Element Type");
            }
        } catch (Exception e) {
            Assertions.fail(e);
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
        // TODO implement later
    }
}
