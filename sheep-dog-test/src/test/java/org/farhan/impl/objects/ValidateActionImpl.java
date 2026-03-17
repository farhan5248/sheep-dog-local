package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.CellIssueDetector;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.TestStepContainerIssueDetector;
import org.farhan.dsl.grammar.TestStepIssueDetector;
import org.farhan.dsl.grammar.TestSuiteIssueDetector;
import org.farhan.objects.xtext.ValidateAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestObjectSheepDogImpl implements ValidateAction {

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }

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

        // Main code entry point - delegate to IssueDetector
        Object cursor = getProperty("cursor");
        String validateDialog = "";

        if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            validateDialog = CellIssueDetector.validateNameOnly(cell);
        } else if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            validateDialog = TestStepIssueDetector.validateNameOnly(testStep);
        } else if (cursor instanceof ITestStepContainer) {
            ITestStepContainer testStepContainer = (ITestStepContainer) cursor;
            validateDialog = TestStepContainerIssueDetector.validateNameOnly(testStepContainer);
        } else if (cursor instanceof ITestSuite) {
            ITestSuite testSuite = (ITestSuite) cursor;
            validateDialog = TestSuiteIssueDetector.validateNameOnly(testSuite);
        }

        setProperty("validate annotation.Content", validateDialog);
    }
}
