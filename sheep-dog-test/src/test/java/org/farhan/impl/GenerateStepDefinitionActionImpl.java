package org.farhan.impl;

import org.farhan.common.TestObject;
import org.farhan.dsl.issues.SheepDogBuilder;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GenerateStepDefinitionActionImpl extends TestObject implements GenerateStepDefinitionAction {

	public void transition() {
		try {
			SheepDogBuilder.generateStepDefinition(currentStep, this.testProject);
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
