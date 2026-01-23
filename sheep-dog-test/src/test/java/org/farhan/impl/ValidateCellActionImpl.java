package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.lang.ICell;
import org.farhan.objects.xtext.ValidateCellAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateCellActionImpl extends TestObject implements ValidateCellAction {
	public void transition() {
		try {
			if (MockIDE.getValidationMessage().isEmpty()) {
				if (currentStep.getTable() != null) {
					if (currentStep.getTable().getRowList() != null) {
						if (currentStep.getTable().getRowList().getFirst() != null) {
							for (ICell c : currentStep.getTable().getRowList().getFirst().getCellList()) {
								MockIDE.setValidationMessage(CellIssueDetector.validateNameOnly(c));
								if (!MockIDE.getValidationMessage().isEmpty()) {
									break;
								}
							}
						}
					}
				}
			}
			// MockIDE.setAlternateObjects(TestStepIssueResolver.correctStepObjectNameWorkspace(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
