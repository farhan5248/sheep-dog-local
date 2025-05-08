package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.Config;
import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToAsciidoctorGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class UmlToAsciidoctorGoalImpl extends GoalObject implements UmlToAsciidoctorGoal {

	public void transition() {
		runGoal("org.farhan.mbt.maven.UMLToAsciiDoctorMojo", Config.getWorkingDir() + "spec-prj/");
	}

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		attributes.put("tags", keyMap.get("Tags"));
	}
}
