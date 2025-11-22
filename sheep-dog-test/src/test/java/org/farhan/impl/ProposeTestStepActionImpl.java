package org.farhan.impl;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ProposeTestStepAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProposeTestStepActionImpl extends TestObject implements ProposeTestStepAction {

	public void transition() {
		try {
			MockIDE.setProposalList(TestStepIssueResolver.proposeNameOnly(currentStep));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
