package org.farhan.impl.objects;

import org.farhan.common.TestIDEElement;
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
public class GenerateStepDefinitionActionImpl extends TestIDEElement implements GenerateStepDefinitionAction {

	public void transition() {
		try {
			if (!TestStepIssueDetector.validateStepObjectNameWorkspace(TestIDEElement.testStep).isEmpty()) {
				TestIDEElement.applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(TestIDEElement.testStep));
			}
			if (!TestStepIssueDetector.validateStepDefinitionNameWorkspace(TestIDEElement.testStep).isEmpty()) {
				TestIDEElement.applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(TestIDEElement.testStep));
			}
			if (TestIDEElement.stepTable != null) {
				if (!TestIDEElement.stepTable.getRowList().isEmpty() && TestIDEElement.stepTable.getRowList().getFirst() != null) {
					if (!RowIssueDetector.validateCellListWorkspace(TestIDEElement.testStep.getTable().getRowList().getFirst())
							.isEmpty()) {
						TestIDEElement.applyProposal(RowIssueResolver.correctCellListWorkspace(TestIDEElement.testStep));
					}
				}
			}
			if (TestIDEElement.testStep.getText() != null) {
				if (!TextIssueDetector.validateNameWorkspace(TestIDEElement.testStep.getText()).isEmpty()) {
					TestIDEElement.applyProposal(TextIssueResolver.correctNameWorkspace(TestIDEElement.testStep));
				}
			}
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

}
