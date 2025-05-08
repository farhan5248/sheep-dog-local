package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToCucumberGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class UmlToCucumberGoalImpl extends GoalObject implements UmlToCucumberGoal {

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		attributes.put("tags", keyMap.get("Tags"));
	}

	public void transition() {
		runGoal("org.farhan.mbt.convert.ConvertUMLToCucumber");
	}
}
