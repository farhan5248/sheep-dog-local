package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToCucumberSpringGoal;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToCucumberSpringGoalImpl extends GoalObject implements UmlToCucumberSpringGoal {

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		// TODO implement later
	}

	@Override
	public void transition() {
		runGoal("org.farhan.mbt.cucumber.ConvertUMLToCucumberSpring");
	}
}
