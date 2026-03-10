package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestConfig;
import org.farhan.common.TestObjectGoal;
import org.farhan.objects.maven.AsciidoctorToUmlGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class AsciidoctorToUmlGoalImpl extends TestObjectGoal implements AsciidoctorToUmlGoal {

	public void transition() {
		runGoal("org.farhan.mbt.maven.AsciiDoctorToUMLMojo", TestConfig.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		// TODO implement later
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		// TODO implement later
	}

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		properties.put("tags", keyMap.get("Tags"));
	}
}
