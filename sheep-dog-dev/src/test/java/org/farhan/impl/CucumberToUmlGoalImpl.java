package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.CucumberToUmlGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class CucumberToUmlGoalImpl extends GoalObject implements CucumberToUmlGoal {

	public void setTags(HashMap<String, String> keyMap) {
		attributes.put("tags", keyMap.get("Tags"));
	}

	@Override
	public void transition() {
		runGoal("org.farhan.mbt.convert.ConvertCucumberToUML");
	}

}
