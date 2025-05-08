package org.farhan.impl;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToJunitGuiceGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToJunitGuiceGoalImpl extends GoalObject implements UmlToJunitGuiceGoal {

	@Override
	public void transition() {
		runGoal("org.farhan.mbt.convert.ConvertUMLToJunitGuice");
	}
}
