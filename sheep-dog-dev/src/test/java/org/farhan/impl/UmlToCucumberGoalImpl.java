package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.maven.UmlToCucumberGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class UmlToCucumberGoalImpl extends TestObjectGoalImpl implements UmlToCucumberGoal {

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		setProperty("tags", keyMap.get("Tags"));
	}

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.cucumber.ConvertUMLToCucumber");
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.cucumber.ConvertUMLToCucumber");
	}
}
