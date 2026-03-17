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
			Object cursor = getProperty("cursor");
			if (cursor instanceof ICell) {
				ICell cell = (ICell) cursor;
				String result = CellIssueDetector.validateNameOnly(cell);
				setProperty("validate annotation.Content", result);
			} else if (cursor instanceof ITestSuite) {
				ITestSuite testSuite = (ITestSuite) cursor;
				String result = TestSuiteIssueDetector.validateNameOnly(testSuite);
				setProperty("validate annotation.Content", result);
			} else if (cursor instanceof ITestStep) {
				ITestStep testStep = (ITestStep) cursor;
				String result = TestStepIssueDetector.validateNameOnly(testStep);
				setProperty("validate annotation.Content", result);
			} else if (cursor instanceof ITestStepContainer) {
				ITestStepContainer testStepContainer = (ITestStepContainer) cursor;
				String result = TestStepContainerIssueDetector.validateNameOnly(testStepContainer);
				setProperty("validate annotation.Content", result);
			}
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	private void navigateToDocument() {
		if (getProperty("Test Suite Full Name") != null) {
			setProperty("cursor", ((ITestProject) getProperty("workspace"))
					.getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
			properties.remove("Test Suite Full Name");
		}
	}

	private void navigateToNode() {
		if (getProperty("Node Path") != null) {
			setCursorAtNode(getProperty("Node Path").toString());
			properties.remove("Node Path");
		}
	}
}
