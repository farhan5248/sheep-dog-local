package org.farhan.impl;

import org.farhan.common.TestObject;
import org.farhan.dsl.common.LanguageHelper;
import org.farhan.dsl.common.Utilities;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GenerateStepDefinitionActionImpl extends TestObject implements GenerateStepDefinitionAction {

    public void transition() {
		try {
			LanguageHelper.generate(getEclipseMock(), null);
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + Utilities.getStackTraceAsString(e));
		}
	}
}
