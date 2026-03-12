package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestConfig;
import org.farhan.objects.maven.UmlToCucumberGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToCucumberGoalImpl extends TestObjectGoalImpl implements UmlToCucumberGoal {

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.maven.UMLToCucumberMojo", TestConfig.getWorkingDir() + "code-prj/",
				TestConfig.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.maven.UMLToCucumberMojo", TestConfig.getWorkingDir() + "code-prj/",
				TestConfig.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		setProperty("tags", keyMap.get("Tags"));
	}
}
