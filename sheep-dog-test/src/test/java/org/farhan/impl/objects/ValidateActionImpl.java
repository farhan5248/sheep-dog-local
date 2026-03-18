package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.CellIssueDetector;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.RowIssueDetector;
import org.farhan.dsl.grammar.TestStepContainerIssueDetector;
import org.farhan.dsl.grammar.TestStepIssueDetector;
import org.farhan.dsl.grammar.TestSuiteIssueDetector;
import org.farhan.dsl.grammar.TextIssueDetector;
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

        if (cursor instanceof IText) {
            IText text = (IText) cursor;
            ITestProject workspace = (ITestProject) getProperty("workspace");
            validateDialog = TextIssueDetector.validateContentWorkspace(text, workspace);
        } else if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            validateDialog = CellIssueDetector.validateNameOnly(cell);
        } else if (cursor instanceof IRow) {
            IRow row = (IRow) cursor;
            ITestProject workspace = (ITestProject) getProperty("workspace");
            validateDialog = RowIssueDetector.validateCellListWorkspace(row, workspace);
        } else if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            validateDialog = TestStepIssueDetector.validateNameOnly(testStep);
            if (validateDialog.isEmpty()) {
                ITestProject workspace = (ITestProject) getProperty("workspace");
                validateDialog = TestStepIssueDetector.validateStepObjectNameWorkspace(testStep, workspace);
            }
            if (validateDialog.isEmpty()) {
                ITestProject workspace = (ITestProject) getProperty("workspace");
                validateDialog = TestStepIssueDetector.validateStepDefinitionNameWorkspace(testStep, workspace);
            }
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
