package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.GoalObject;
import org.farhan.objects.maven.UmlToAsciidoctorGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class UmlToAsciidoctorGoalImpl extends GoalObject implements UmlToAsciidoctorGoal {

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		attributes.put("tags", keyMap.get("Tags"));
	}

	public void transition() {
		runGoal("org.farhan.mbt.asciidoctor.ConvertUMLToAsciidoctor");
	}
}
