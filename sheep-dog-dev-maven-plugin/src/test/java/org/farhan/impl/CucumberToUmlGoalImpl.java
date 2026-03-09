package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestConfig;
import org.farhan.common.GoalObject;
import org.farhan.objects.maven.CucumberToUmlGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class CucumberToUmlGoalImpl extends GoalObject implements CucumberToUmlGoal {

	public void setTags(HashMap<String, String> keyMap) {
		properties.put("tags", keyMap.get("Tags"));
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		// TODO implement later
	}

	@Override
	public void transition() {
		runGoal("org.farhan.mbt.maven.CucumberToUMLMojo", TestConfig.getWorkingDir() + "code-prj/",
				TestConfig.getWorkingDir() + "spec-prj/");
	}

}
