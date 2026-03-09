package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.AsciidoctorToUmlGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class AsciidoctorToUmlGoalImpl extends GoalObject implements AsciidoctorToUmlGoal {

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		attributes.put("tags", keyMap.get("Tags"));
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
	public void transition() {
		runGoal("org.farhan.mbt.asciidoctor.ConvertAsciidoctorToUML");
	}
}
