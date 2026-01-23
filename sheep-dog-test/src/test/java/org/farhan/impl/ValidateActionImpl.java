package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.dsl.lang.ICell;
import org.farhan.objects.xtext.ValidateAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestObject implements ValidateAction {
	public void transition() {
		try {
			if (elementType.contentEquals("Cell")) {
				if (MockIDE.getValidationMessage().isEmpty()) {
					if (currentStep.getTable() != null) {
						if (currentStep.getTable().getRowList() != null) {
							if (currentStep.getTable().getRowList().getFirst() != null) {
								for (ICell c : currentStep.getTable().getRowList().getFirst().getCellList()) {
									MockIDE.setValidationMessage(CellIssueDetector.validateNameOnly(c));
									if (!MockIDE.getValidationMessage().isEmpty()) {
										break;
									}
								}
							}
						}
					}
				}
			} else if (elementType.contentEquals("Row")) {
				if (MockIDE.getValidationMessage().isEmpty()) {
					if (currentStep.getTable() != null) {
						MockIDE.setValidationMessage(RowIssueDetector
								.validateCellListWorkspace(currentStep.getTable().getRowList().getFirst()));
					}
				}
			} else if (elementType.contentEquals("Text")) {
				if (MockIDE.getValidationMessage().isEmpty()) {
					if (currentStep.getText() != null) {
						MockIDE.setValidationMessage(TextIssueDetector.validateNameWorkspace(currentStep.getText()));
					}
				}
			} else if (elementType.contentEquals("Test Step")) {
				if (MockIDE.getValidationMessage().isEmpty()) {
					MockIDE.setValidationMessage(TestStepIssueDetector.validateStepObjectNameOnly(currentStep));
					if (MockIDE.getValidationMessage().isEmpty()) {
						MockIDE.setValidationMessage(TestStepIssueDetector.validateStepDefinitionNameOnly(currentStep));
						if (MockIDE.getValidationMessage().isEmpty()) {
							MockIDE.setValidationMessage(
									TestStepIssueDetector.validateStepObjectNameWorkspace(currentStep));
							if (MockIDE.getValidationMessage().isEmpty()) {
								MockIDE.setValidationMessage(
										TestStepIssueDetector.validateStepDefinitionNameWorkspace(currentStep));
							}
						}
					}
				}
			} else if (elementType.contentEquals("Test Step Container")) {
				if (MockIDE.getValidationMessage().isEmpty()) {
					MockIDE.setValidationMessage(
							TestStepContainerIssueDetector.validateTestStepListFile(testStepContainer));
					if (MockIDE.getValidationMessage().isEmpty()) {
						MockIDE.setValidationMessage(
								TestStepContainerIssueDetector.validateNameOnly(testStepContainer));
					}
				}
			} else if (elementType.contentEquals("Test Suite")) {
				if (MockIDE.getValidationMessage().isEmpty()) {
					MockIDE.setValidationMessage(TestSuiteIssueDetector.validateNameOnly(testSuite));
				}
			} else {
				Assertions.fail("Unknown Element Type");
			}
			// TODO remove this
			// MockIDE.setAlternateObjects(TestStepIssueResolver.correctStepObjectNameWorkspace(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}

	@Override
	public void setElementType(HashMap<String, String> keyMap) {
		elementType = keyMap.get("Element Type");
	}

	@Override
	public void setSelectedStep(HashMap<String, String> keyMap) {
		currentStep = (TestStepImpl) currentStep.getParent().getTestStepList()
				.get(Integer.valueOf(keyMap.get("Selected Step")) - 1);
	}
}
