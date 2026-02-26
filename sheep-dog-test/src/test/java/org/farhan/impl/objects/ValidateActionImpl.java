package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.objects.xtext.ValidateAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestIDEObject implements ValidateAction {

    public void transition() {
        try {
            if (TestIDEObject.selectedNode.contains("Cell/")) {
                ICell cell = (ICell) TestIDEObject.focus;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = CellIssueDetector.validateNameOnly(cell);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                }
            } else if (TestIDEObject.selectedNode.contains("Row/")) {
                IRow row = (IRow) TestIDEObject.focus;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = RowIssueDetector.validateCellListWorkspace(row);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                }
            } else if (TestIDEObject.selectedNode.contains("Text/")) {
                IText text = (IText) TestIDEObject.focus;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = TextIssueDetector.validateNameWorkspace(text);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                }
            } else if (TestIDEObject.selectedNode.contains("TestStep/")) {
                ITestStep testStep = (ITestStep) TestIDEObject.focus;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = TestStepIssueDetector.validateStepObjectNameOnly(testStep);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                    if (TestIDEObject.validateDialog.isEmpty()) {
                        TestIDEObject.validateDialog = TestStepIssueDetector.validateStepDefinitionNameOnly(testStep);
                        if (TestIDEObject.validateDialog == null) {
                            TestIDEObject.validateDialog = "";
                        }
                        if (TestIDEObject.validateDialog.isEmpty()) {
                            TestIDEObject.validateDialog = TestStepIssueDetector
                                    .validateStepObjectNameWorkspace(testStep);
                            if (TestIDEObject.validateDialog == null) {
                                TestIDEObject.validateDialog = "";
                            }
                            if (TestIDEObject.validateDialog.isEmpty()) {
                                TestIDEObject.validateDialog = TestStepIssueDetector
                                        .validateStepDefinitionNameWorkspace(testStep);
                                if (TestIDEObject.validateDialog == null) {
                                    TestIDEObject.validateDialog = "";
                                }
                            }
                        }
                    }
                }
            } else if (TestIDEObject.selectedNode.contains("TestCase/")
                    || TestIDEObject.selectedNode.contains("TestSetup/")) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestIDEObject.focus;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = TestStepContainerIssueDetector
                            .validateTestStepListFile(testStepContainer);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                    if (TestIDEObject.validateDialog.isEmpty()) {
                        TestIDEObject.validateDialog = TestStepContainerIssueDetector
                                .validateNameOnly(testStepContainer);
                        if (TestIDEObject.validateDialog == null) {
                            TestIDEObject.validateDialog = "";
                        }
                    }
                }
            } else if (TestIDEObject.selectedNode.contains("TestSuite/")) {
                ITestSuite testSuite = (ITestSuite) TestIDEObject.focus;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = TestSuiteIssueDetector.validateNameOnly(testSuite);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
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
        setSelectedNode(keyMap.get("Node Path"));
    }
}
