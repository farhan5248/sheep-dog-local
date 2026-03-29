package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.maven.UmlToCucumberGuiceGoal;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToCucumberGuiceGoalImpl extends TestObjectGoalImpl implements UmlToCucumberGuiceGoal {

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.cucumber.ConvertUMLToCucumberGuice");
	}
}
