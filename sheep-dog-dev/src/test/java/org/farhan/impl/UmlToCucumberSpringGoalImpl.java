package org.farhan.impl;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToCucumberSpringGoal;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToCucumberSpringGoalImpl extends GoalObject implements UmlToCucumberSpringGoal {

	@Override
	public void transition() {
		runGoal("org.farhan.mbt.cucumber.ConvertUMLToCucumberSpring");
	}
}
