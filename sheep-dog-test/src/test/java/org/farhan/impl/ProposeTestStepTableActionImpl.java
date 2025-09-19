package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.lang.TestStepIssueResolver;
import org.farhan.objects.xtext.ProposeTestStepTableAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProposeTestStepTableActionImpl extends TestObject implements ProposeTestStepTableAction {

	public void transition() {
		try {
			MockIDE.setProposalList(TestStepIssueResolver.proposeStepParameters(currentStep, this.testProject));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
