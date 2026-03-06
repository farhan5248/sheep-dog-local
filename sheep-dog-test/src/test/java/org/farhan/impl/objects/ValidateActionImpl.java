package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.objects.xtext.ValidateAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestIDEObject implements ValidateAction {

    public void transition() {
        if (properties.get("Node Path") != null) {
            setCursor(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestIDEObject.cursor instanceof ICell) {
                ICell cell = (ICell) TestIDEObject.cursor;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = CellIssueDetector.validateNameOnly(cell);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                }
            } else if (TestIDEObject.cursor instanceof IRow) {
                IRow row = (IRow) TestIDEObject.cursor;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = RowIssueDetector.validateCellListWorkspace(row);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                }
            } else if (TestIDEObject.cursor instanceof IText) {
                IText text = (IText) TestIDEObject.cursor;
                if (TestIDEObject.validateDialog == null || TestIDEObject.validateDialog.isEmpty()) {
                    TestIDEObject.validateDialog = TextIssueDetector.validateNameWorkspace(text);
                    if (TestIDEObject.validateDialog == null) {
                        TestIDEObject.validateDialog = "";
                    }
                }
            } else if (TestIDEObject.cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) TestIDEObject.cursor;
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
            } else if (TestIDEObject.cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestIDEObject.cursor;
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
            } else if (TestIDEObject.cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) TestIDEObject.cursor;
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
        properties.put("Node Path", keyMap.get("Node Path"));
    }
}
