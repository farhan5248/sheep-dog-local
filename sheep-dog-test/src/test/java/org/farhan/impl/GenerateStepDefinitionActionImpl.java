package org.farhan.impl;

import org.farhan.common.TestObject;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GenerateStepDefinitionActionImpl extends TestObject implements GenerateStepDefinitionAction {

	public void transition() {
		try {
			// TODO there should be actions for each issue type, not one for each menu item?
			SheepDogBuilder.createStepObject(currentStep);
			SheepDogBuilder.createStepDefinition(currentStep);
			SheepDogBuilder.createStepParameters(currentStep);
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
