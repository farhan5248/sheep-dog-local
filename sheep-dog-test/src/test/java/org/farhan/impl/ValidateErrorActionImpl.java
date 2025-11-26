package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.objects.xtext.ValidateErrorAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateErrorActionImpl extends TestObject implements ValidateErrorAction {

	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				MockIDE.setValidationMessage(
						TestStepContainerIssueDetector.validateTestStepListFile(currentStep.getParent()));
				if (MockIDE.getValidationMessage().isEmpty()) {
					MockIDE.setValidationMessage(TestStepIssueDetector.validateNameObjectOnly(currentStep));
					if (MockIDE.getValidationMessage().isEmpty()) {
						MockIDE.setValidationMessage(TestStepIssueDetector.validateNamePredicateOnly(currentStep));
						if (MockIDE.getValidationMessage().isEmpty()) {
							MockIDE.setValidationMessage(TestStepIssueDetector.validateNameComponentOnly(currentStep));
						}
					}
				}
			}
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}

	@Override
	public void setSelectedStep(HashMap<String, String> keyMap) {
		currentStep = (TestStepImpl) currentStep.getParent().getTestStepList()
				.get(Integer.valueOf(keyMap.get("Selected Step")) - 1);
	}
}
