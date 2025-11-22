package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.objects.xtext.ProposeTestStepTableAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProposeTestStepTableActionImpl extends TestObject implements ProposeTestStepTableAction {

	public void transition() {
		try {
			currentStep.setTable(new TableImpl());
			currentStep.getTable().setParent(currentStep);
			RowImpl row = new RowImpl();
			row.setParent(currentStep.getTable());
			currentStep.getTable().getRowList().add(row);
			MockIDE.setProposalList(RowIssueResolver.proposeCellListWorkspace(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
