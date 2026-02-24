package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
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
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesActionImpl extends TestIDEObject implements ListQuickfixesAction {

    public void transition() {
        try {
            if (TestIDEObject.selectedElement.contains("Cell/")) {
                ICell cell = (ICell) TestIDEObject.focus;
                if (TestIDEObject.validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                    TestIDEObject.listQuickfixesDialog.addAll(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (TestIDEObject.selectedElement.contains("Row/")) {
                IRow row = (IRow) TestIDEObject.focus;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                if (TestIDEObject.validateDialog.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
                    if (testStep.getTable() != null) {
                        if (testStep.getTable().getRowList() != null) {
                            if (testStep.getTable().getRowList().getFirst() != null) {
                                TestIDEObject.listQuickfixesDialog
                                        .addAll(RowIssueResolver.correctCellListWorkspace(testStep));
                            }
                        }
                    }
                }
            } else if (TestIDEObject.selectedElement.contains("Text/")) {
                IText text = (IText) TestIDEObject.focus;
                ITestStep testStep = (ITestStep) text.getParent();
                if (TestIDEObject.validateDialog.contentEquals(TextIssueTypes.TEXT_NAME_WORKSPACE.description)) {
                    TestIDEObject.listQuickfixesDialog.addAll(TextIssueResolver.correctNameWorkspace(testStep));
                }
            } else if (TestIDEObject.selectedElement.contains("TestStep/")) {
                ITestStep testStep = (ITestStep) TestIDEObject.focus;
                if (TestIDEObject.validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                    TestIDEObject.listQuickfixesDialog
                            .addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                } else if (TestIDEObject.validateDialog
                        .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
                    TestIDEObject.listQuickfixesDialog
                            .addAll(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                }
            } else if (TestIDEObject.selectedElement.contains("TestStepContainer/")) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestIDEObject.focus;
                if (TestIDEObject.validateDialog
                        .contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                    TestIDEObject.listQuickfixesDialog
                            .addAll(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
                }
            } else if (TestIDEObject.selectedElement.contains("TestSuite/")) {
                ITestSuite testSuite = (ITestSuite) TestIDEObject.focus;
                if (TestIDEObject.validateDialog.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                    TestIDEObject.listQuickfixesDialog.addAll(TestSuiteIssueResolver.correctNameOnly(testSuite));
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
        setSelectedElement(keyMap.get("Node Path"));
    }
}
