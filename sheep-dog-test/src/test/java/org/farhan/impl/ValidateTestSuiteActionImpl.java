package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.objects.xtext.ValidateTestSuiteAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateTestSuiteActionImpl extends TestObject implements ValidateTestSuiteAction {

	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				MockIDE.setValidationMessage(TestSuiteIssueDetector.validateNameOnly(testSuite));
			}
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
