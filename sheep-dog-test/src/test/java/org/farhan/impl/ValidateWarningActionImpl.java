package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.lang.TestStepIssueDetector;
import org.farhan.dsl.lang.TestStepIssueResolver;
import org.farhan.objects.xtext.ValidateWarningAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateWarningActionImpl extends TestObject implements ValidateWarningAction {

	public void transition() {
		try {

			MockIDE.setValidationMessage(TestStepIssueDetector.validateSemantics(currentStep, this.testProject));
			MockIDE.setAlternateObjects(TestStepIssueResolver.proposeStepObject(currentStep, this.testProject));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
