package org.farhan.impl;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToCucumberGuiceGoal;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToCucumberGuiceGoalImpl extends GoalObject implements UmlToCucumberGuiceGoal {

	@Override
	public void transition() {
		runGoal("org.farhan.mbt.cucumber.ConvertUMLToCucumberGuice");
	}
}
