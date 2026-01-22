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
	// TODO instead of validate a warning, validate issue types or do
	// fast/normal/expensive validation. There has to be enough information in the
	// test step names for Claude to infer everything it needs when combined with
	// the design pattern md files.

	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				MockIDE.setValidationMessage(TestStepIssueDetector.validateStepObjectNameWorkspace(currentStep));
				if (MockIDE.getValidationMessage().isEmpty()) {
					MockIDE.setValidationMessage(TestStepIssueDetector.validateStepDefinitionNameWorkspace(currentStep));
					if (MockIDE.getValidationMessage().isEmpty()) {
						if (currentStep.getTable() != null) {
							MockIDE.setValidationMessage(RowIssueDetector
									.validateCellListWorkspace(currentStep.getTable().getRowList().getFirst()));
						}
					}
				}
			}
			MockIDE.setAlternateObjects(TestStepIssueResolver.correctStepObjectNameWorkspace(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
