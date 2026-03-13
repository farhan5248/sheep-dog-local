package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestProject;
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
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
        String result = "";
        Object cursor = getProperty("cursor");
        if (cursor instanceof IRow) {
            result = RowIssueDetector.validateCellListWorkspace((IRow) cursor);
        } else if (cursor instanceof ICell) {
            result = CellIssueDetector.validateNameOnly((ICell) cursor);
        } else if (cursor instanceof ITestSuite) {
            result = TestSuiteIssueDetector.validateNameOnly((ITestSuite) cursor);
        } else if (cursor instanceof ITestStepContainer) {
            result = TestStepContainerIssueDetector.validateNameOnly((ITestStepContainer) cursor);
        } else if (cursor instanceof ITestStep) {
            result = TestStepIssueDetector.validateStepObjectNameWorkspace((ITestStep) cursor);
            if (result.isEmpty()) {
                result = TestStepIssueDetector.validateStepDefinitionNameWorkspace((ITestStep) cursor);
            }
        } else if (cursor instanceof IText) {
            result = TextIssueDetector.validateContentWorkspace((IText) cursor);
        }
        setProperty("validate annotation.Content", result);
    }
}
