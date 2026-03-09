package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.Config;
import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToCucumberGuiceGoal;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class UmlToCucumberGuiceGoalImpl extends GoalObject implements UmlToCucumberGuiceGoal {

	public void transition() {
		runGoal("org.farhan.mbt.maven.UMLToCucumberGuiceMojo", Config.getWorkingDir() + "code-prj/",
				Config.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		// TODO implement later
	}

}
