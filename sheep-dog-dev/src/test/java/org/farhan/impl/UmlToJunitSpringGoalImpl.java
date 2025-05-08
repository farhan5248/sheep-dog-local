package org.farhan.impl;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToJunitSpringGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToJunitSpringGoalImpl extends GoalObject implements UmlToJunitSpringGoal {

	@Override
	public void transition() {
		runGoal("org.farhan.mbt.convert.ConvertUMLToJunitSpring");
	}
}
