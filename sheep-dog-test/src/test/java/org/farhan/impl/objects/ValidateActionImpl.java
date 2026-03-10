package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectAction;
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
public class ValidateActionImpl extends TestObjectAction implements ValidateAction {

    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (cursor instanceof ICell) {
                ICell cell = (ICell) cursor;
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = CellIssueDetector.validateNameOnly(cell);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
            } else if (cursor instanceof IRow) {
                IRow row = (IRow) cursor;
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = RowIssueDetector.validateCellListWorkspace(row);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
            } else if (cursor instanceof IText) {
                IText text = (IText) cursor;
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TextIssueDetector.validateNameWorkspace(text);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
            } else if (cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) cursor;
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepIssueDetector.validateStepObjectNameOnly(testStep);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                    if (validateDialog.isEmpty()) {
                        validateDialog = TestStepIssueDetector.validateStepDefinitionNameOnly(testStep);
                        if (validateDialog == null) {
                            validateDialog = "";
                        }
                        if (validateDialog.isEmpty()) {
                            validateDialog = TestStepIssueDetector
                                    .validateStepObjectNameWorkspace(testStep);
                            if (validateDialog == null) {
                                validateDialog = "";
                            }
                            if (validateDialog.isEmpty()) {
                                validateDialog = TestStepIssueDetector
                                        .validateStepDefinitionNameWorkspace(testStep);
                                if (validateDialog == null) {
                                    validateDialog = "";
                                }
                            }
                        }
                    }
                }
            } else if (cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) cursor;
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepContainerIssueDetector
                            .validateTestStepListFile(testStepContainer);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                    if (validateDialog.isEmpty()) {
                        validateDialog = TestStepContainerIssueDetector
                                .validateNameOnly(testStepContainer);
                        if (validateDialog == null) {
                            validateDialog = "";
                        }
                    }
                }
            } else if (cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) cursor;
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestSuiteIssueDetector.validateNameOnly(testSuite);
                    if (validateDialog == null) {
                        validateDialog = "";
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
