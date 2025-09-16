package org.farhan.impl;

import org.farhan.common.TestObject;
import org.farhan.dsl.deprecated.LanguageHelper;
import org.farhan.dsl.deprecated.Utilities;
import org.farhan.objects.xtext.ProposeTestStepAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProposeTestStepActionImpl extends TestObject implements ProposeTestStepAction {

	public void transition() {
		try {
			getLanguageAccess().setProposalList(LanguageHelper.proposeTestStepName(getLanguageAccess()));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + Utilities.getStackTraceAsString(e));
		}
	}
}
