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
			String message = "";
			message = TestStepIssueDetector.validateReference(currentStep);
			if (currentStep.getTable() != null) {
				message += RowIssueDetector.validateReference(currentStep.getTable().getRowList().getFirst());
			}			
			MockIDE.setValidationMessage(message);
			MockIDE.setAlternateObjects(TestStepIssueResolver.proposeReference(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
