package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestConfig;
import org.farhan.objects.maven.UmlToAsciidoctorGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class UmlToAsciidoctorGoalImpl extends TestObjectGoalImpl implements UmlToAsciidoctorGoal {

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.maven.UMLToAsciiDoctorMojo", TestConfig.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.maven.UMLToAsciiDoctorMojo", TestConfig.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		properties.put("tags", keyMap.get("Tags"));
	}
}
