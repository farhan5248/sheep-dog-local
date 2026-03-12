package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.maven.CucumberToUmlGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class CucumberToUmlGoalImpl extends TestObjectGoalImpl implements CucumberToUmlGoal {

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		setProperty("tags", keyMap.get("Tags"));
	}

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.cucumber.ConvertCucumberToUML");
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.cucumber.ConvertCucumberToUML");
	}

}
