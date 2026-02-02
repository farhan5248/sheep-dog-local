package org.farhan.impl.objects;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GenerateStepDefinitionActionImpl extends TestObject implements GenerateStepDefinitionAction {

	public void transition() {
		try {
			if (!TestStepIssueDetector.validateStepObjectNameWorkspace(MockIDE.testStep).isEmpty()) {
				MockIDE.applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(MockIDE.testStep));
			}
			if (!TestStepIssueDetector.validateStepDefinitionNameWorkspace(MockIDE.testStep).isEmpty()) {
				MockIDE.applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(MockIDE.testStep));
			}
			if (MockIDE.stepTable != null) {
				if (!MockIDE.stepTable.getRowList().isEmpty() && MockIDE.stepTable.getRowList().getFirst() != null) {
					if (!RowIssueDetector.validateCellListWorkspace(MockIDE.testStep.getTable().getRowList().getFirst())
							.isEmpty()) {
						MockIDE.applyProposal(RowIssueResolver.correctCellListWorkspace(MockIDE.testStep));
					}
				}
			}
			if (MockIDE.testStep.getText() != null) {
				if (!TextIssueDetector.validateNameWorkspace(MockIDE.testStep.getText()).isEmpty()) {
					MockIDE.applyProposal(TextIssueResolver.correctNameWorkspace(MockIDE.testStep));
				}
			}
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

}
