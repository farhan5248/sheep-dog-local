package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestConfig;
import org.farhan.objects.maven.AsciidoctorToUmlGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class AsciidoctorToUmlGoalImpl extends TestObjectGoalImpl implements AsciidoctorToUmlGoal {

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.maven.AsciiDoctorToUMLMojo", TestConfig.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.maven.AsciiDoctorToUMLMojo", TestConfig.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		properties.put("tags", keyMap.get("Tags"));
	}
}
