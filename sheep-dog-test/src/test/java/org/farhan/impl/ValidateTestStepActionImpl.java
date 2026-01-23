package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.objects.xtext.ValidateTestStepAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateTestStepActionImpl extends TestObject implements ValidateTestStepAction {

	public void transition() {
		try {
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
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
