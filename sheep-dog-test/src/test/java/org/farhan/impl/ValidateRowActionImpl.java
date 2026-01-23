package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.objects.xtext.ValidateRowAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateRowActionImpl extends TestObject implements ValidateRowAction {
	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				if (currentStep.getTable() != null) {
					MockIDE.setValidationMessage(RowIssueDetector
							.validateCellListWorkspace(currentStep.getTable().getRowList().getFirst()));
				}
			}
			//MockIDE.setAlternateObjects(TestStepIssueResolver.correctStepObjectNameWorkspace(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
