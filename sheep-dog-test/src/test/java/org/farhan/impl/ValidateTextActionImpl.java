package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.objects.xtext.ValidateTextAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateTextActionImpl extends TestObject implements ValidateTextAction {
	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				if (currentStep.getText() != null) {
					MockIDE.setValidationMessage(TextIssueDetector.validateNameWorkspace(currentStep.getText()));
				}
			}
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
