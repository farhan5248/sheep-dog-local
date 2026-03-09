package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectIDE;
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
public class ValidateActionImpl extends TestObjectIDE implements ValidateAction {

    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestObjectIDE.cursor instanceof ICell) {
                ICell cell = (ICell) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog == null || TestObjectIDE.validateDialog.isEmpty()) {
                    TestObjectIDE.validateDialog = CellIssueDetector.validateNameOnly(cell);
                    if (TestObjectIDE.validateDialog == null) {
                        TestObjectIDE.validateDialog = "";
                    }
                }
            } else if (TestObjectIDE.cursor instanceof IRow) {
                IRow row = (IRow) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog == null || TestObjectIDE.validateDialog.isEmpty()) {
                    TestObjectIDE.validateDialog = RowIssueDetector.validateCellListWorkspace(row);
                    if (TestObjectIDE.validateDialog == null) {
                        TestObjectIDE.validateDialog = "";
                    }
                }
            } else if (TestObjectIDE.cursor instanceof IText) {
                IText text = (IText) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog == null || TestObjectIDE.validateDialog.isEmpty()) {
                    TestObjectIDE.validateDialog = TextIssueDetector.validateNameWorkspace(text);
                    if (TestObjectIDE.validateDialog == null) {
                        TestObjectIDE.validateDialog = "";
                    }
                }
            } else if (TestObjectIDE.cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog == null || TestObjectIDE.validateDialog.isEmpty()) {
                    TestObjectIDE.validateDialog = TestStepIssueDetector.validateStepObjectNameOnly(testStep);
                    if (TestObjectIDE.validateDialog == null) {
                        TestObjectIDE.validateDialog = "";
                    }
                    if (TestObjectIDE.validateDialog.isEmpty()) {
                        TestObjectIDE.validateDialog = TestStepIssueDetector.validateStepDefinitionNameOnly(testStep);
                        if (TestObjectIDE.validateDialog == null) {
                            TestObjectIDE.validateDialog = "";
                        }
                        if (TestObjectIDE.validateDialog.isEmpty()) {
                            TestObjectIDE.validateDialog = TestStepIssueDetector
                                    .validateStepObjectNameWorkspace(testStep);
                            if (TestObjectIDE.validateDialog == null) {
                                TestObjectIDE.validateDialog = "";
                            }
                            if (TestObjectIDE.validateDialog.isEmpty()) {
                                TestObjectIDE.validateDialog = TestStepIssueDetector
                                        .validateStepDefinitionNameWorkspace(testStep);
                                if (TestObjectIDE.validateDialog == null) {
                                    TestObjectIDE.validateDialog = "";
                                }
                            }
                        }
                    }
                }
            } else if (TestObjectIDE.cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog == null || TestObjectIDE.validateDialog.isEmpty()) {
                    TestObjectIDE.validateDialog = TestStepContainerIssueDetector
                            .validateTestStepListFile(testStepContainer);
                    if (TestObjectIDE.validateDialog == null) {
                        TestObjectIDE.validateDialog = "";
                    }
                    if (TestObjectIDE.validateDialog.isEmpty()) {
                        TestObjectIDE.validateDialog = TestStepContainerIssueDetector
                                .validateNameOnly(testStepContainer);
                        if (TestObjectIDE.validateDialog == null) {
                            TestObjectIDE.validateDialog = "";
                        }
                    }
                }
            } else if (TestObjectIDE.cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) TestObjectIDE.cursor;
                if (TestObjectIDE.validateDialog == null || TestObjectIDE.validateDialog.isEmpty()) {
                    TestObjectIDE.validateDialog = TestSuiteIssueDetector.validateNameOnly(testSuite);
                    if (TestObjectIDE.validateDialog == null) {
                        TestObjectIDE.validateDialog = "";
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

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
    }
}
