package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEElement;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.impl.ide.TestStepImpl;
import org.farhan.objects.xtext.ValidateAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestIDEElement implements ValidateAction {

    public void transition() {
        try {
            if (TestIDEElement.isElementType("Cell")) {
                if (TestIDEElement.validateDialog.isEmpty()) {
                    if (TestIDEElement.testStep.getTable() != null) {
                        if (TestIDEElement.testStep.getTable().getRowList() != null) {
                            if (TestIDEElement.testStep.getTable().getRowList().getFirst() != null) {
                                if (TestIDEElement.testStep.getTable().getRowList().getFirst().getCellList() != null) {
                                    if (TestIDEElement.testStep.getTable().getRowList().getFirst().getCellList()
                                            .getFirst() != null) {
                                        TestIDEElement.validateDialog = CellIssueDetector
                                                .validateNameOnly(TestIDEElement.testStep.getTable().getRowList()
                                                        .getFirst().getCellList().getFirst());
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (TestIDEElement.isElementType("Row")) {
                if (TestIDEElement.validateDialog.isEmpty()) {
                    if (TestIDEElement.testStep.getTable() != null) {
                        if (TestIDEElement.testStep.getTable().getRowList() != null) {
                            if (TestIDEElement.testStep.getTable().getRowList().getFirst() != null) {
                                TestIDEElement.validateDialog = RowIssueDetector.validateCellListWorkspace(
                                        TestIDEElement.testStep.getTable().getRowList().getFirst());
                            }
                        }
                    }
                }
            } else if (TestIDEElement.isElementType("Text")) {
                if (TestIDEElement.validateDialog.isEmpty()) {
                    if (TestIDEElement.testStep.getText() != null) {
                        TestIDEElement.validateDialog = TextIssueDetector
                                .validateNameWorkspace(TestIDEElement.testStep.getText());
                    }
                }
            } else if (TestIDEElement.isElementType("Test Step")) {
                if (TestIDEElement.validateDialog.isEmpty()) {
                    TestIDEElement.validateDialog = TestStepIssueDetector
                            .validateStepObjectNameOnly(TestIDEElement.testStep);
                    if (TestIDEElement.validateDialog.isEmpty()) {
                        TestIDEElement.validateDialog = TestStepIssueDetector
                                .validateStepDefinitionNameOnly(TestIDEElement.testStep);
                        if (TestIDEElement.validateDialog.isEmpty()) {
                            TestIDEElement.validateDialog = TestStepIssueDetector
                                    .validateStepObjectNameWorkspace(TestIDEElement.testStep);
                            if (TestIDEElement.validateDialog.isEmpty()) {
                                TestIDEElement.validateDialog = TestStepIssueDetector
                                        .validateStepDefinitionNameWorkspace(TestIDEElement.testStep);
                            }
                        }
                    }
                }
            } else if (TestIDEElement.isElementType("Test Step Container")) {
                if (TestIDEElement.validateDialog.isEmpty()) {
                    TestIDEElement.validateDialog = TestStepContainerIssueDetector
                            .validateTestStepListFile(TestIDEElement.testStepContainer);
                    if (TestIDEElement.validateDialog.isEmpty()) {
                        TestIDEElement.validateDialog = TestStepContainerIssueDetector
                                .validateNameOnly(TestIDEElement.testStepContainer);
                    }
                }
            } else if (TestIDEElement.isElementType("Test Suite")) {
                if (TestIDEElement.validateDialog.isEmpty()) {
                    TestIDEElement.validateDialog = TestSuiteIssueDetector.validateNameOnly(TestIDEElement.testSuite);
                }
            } else {
                Assertions.fail("Unknown Element Type");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setElementType(HashMap<String, String> keyMap) {
        TestIDEElement.setElementType(keyMap.get("Element Type"));
    }

    @Override
    public void setSelectedStep(HashMap<String, String> keyMap) {
        TestIDEElement.testStep = (TestStepImpl) TestIDEElement.testStep.getParent().getTestStepList()
                .get(Integer.valueOf(keyMap.get("Selected Step")) - 1);
    }
}
