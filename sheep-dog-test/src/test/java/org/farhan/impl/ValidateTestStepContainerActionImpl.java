package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.objects.xtext.ValidateTestStepContainerAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateTestStepContainerActionImpl extends TestObject implements ValidateTestStepContainerAction {

	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				MockIDE.setValidationMessage(
						TestStepContainerIssueDetector.validateTestStepListFile(testStepContainer));
				if (MockIDE.getValidationMessage().isEmpty()) {
					MockIDE.setValidationMessage(TestStepContainerIssueDetector.validateNameOnly(testStepContainer));
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
