package org.farhan.impl;

import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.objects.xtext.ValidateAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestObjectSheepDogImpl implements ValidateAction {

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        try {
            String validateDialog = (String) getProperty("validate annotation.Content");
            if (getProperty("cursor") instanceof ICell) {
                ICell cell = (ICell) getProperty("cursor");
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = CellIssueDetector.validateNameOnly(cell);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
            } else if (getProperty("cursor") instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) getProperty("cursor");
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepContainerIssueDetector.validateNameOnly(testStepContainer);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepContainerIssueDetector.validateTestStepListFile(testStepContainer);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
            } else if (getProperty("cursor") instanceof ITestStep) {
                ITestStep testStep = (ITestStep) getProperty("cursor");
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepIssueDetector.validateStepObjectNameOnly(testStep);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepIssueDetector.validateStepDefinitionNameOnly(testStep);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepIssueDetector.validateStepObjectNameWorkspace(testStep);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestStepIssueDetector.validateStepDefinitionNameWorkspace(testStep);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
            } else if (getProperty("cursor") instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) getProperty("cursor");
                if (validateDialog == null || validateDialog.isEmpty()) {
                    validateDialog = TestSuiteIssueDetector.validateNameOnly(testSuite);
                    if (validateDialog == null) {
                        validateDialog = "";
                    }
                }
            }
            setProperty("validate annotation.Content", validateDialog);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace"))
                    .getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        } else if (getProperty("Step Object Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace"))
                    .getTestDocument(replaceKeyword(getProperty("Step Object Full Name").toString())));
            properties.remove("Step Object Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }
}
