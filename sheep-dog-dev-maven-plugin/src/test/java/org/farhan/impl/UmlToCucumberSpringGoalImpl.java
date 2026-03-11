package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestConfig;
import org.farhan.objects.maven.UmlToCucumberSpringGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToCucumberSpringGoalImpl extends TestObjectGoalImpl implements UmlToCucumberSpringGoal {

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.maven.UMLToCucumberSpringMojo", TestConfig.getWorkingDir() + "code-prj/",
				TestConfig.getWorkingDir() + "spec-prj/");
	}
}
