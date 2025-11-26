package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ValidateWarningAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateWarningActionImpl extends TestObject implements ValidateWarningAction {
	// TODO instead of validate a warning, validate references (step object, step
	// definition, step parameters)

	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				MockIDE.setValidationMessage(TestStepIssueDetector.validateNameObjectWorkspace(currentStep));
				if (MockIDE.getValidationMessage().isEmpty()) {
					MockIDE.setValidationMessage(TestStepIssueDetector.validateNamePredicateWorkspace(currentStep));
					if (MockIDE.getValidationMessage().isEmpty()) {
						MockIDE.setValidationMessage(RowIssueDetector
								.validateCellListWorkspace(currentStep.getTable().getRowList().getFirst()));
					}
				}
			}
			MockIDE.setAlternateObjects(TestStepIssueResolver.proposeNameWorkspace(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
