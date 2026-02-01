package org.farhan.impl.objects;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GenerateStepDefinitionActionImpl extends TestObject implements GenerateStepDefinitionAction {

	public void transition() {
		try {
			SheepDogBuilder.createTestStepReferencedElements(MockIDE.testStep);
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}
}
