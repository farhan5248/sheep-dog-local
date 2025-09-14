package org.farhan.impl;

import org.farhan.common.TestObject;
import org.farhan.dsl.common.LanguageHelper;
import org.farhan.dsl.common.Utilities;
import org.farhan.objects.xtext.ProposeTestStepTableAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProposeTestStepTableActionImpl extends TestObject implements ProposeTestStepTableAction {

	public void transition() {
		try {
			getLanguageAccess().setProposalList(LanguageHelper.proposeStepParameters(getLanguageAccess()));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + Utilities.getStackTraceAsString(e));
		}
	}
}
