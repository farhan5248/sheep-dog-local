package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.maven.UmlToAsciidoctorGoal;

import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class UmlToAsciidoctorGoalImpl extends TestObjectGoalImpl implements UmlToAsciidoctorGoal {

	@Override
	public void setTags(HashMap<String, String> keyMap) {
		setProperty("tags", keyMap.get("Tags"));
	}

	@Override
	public void setExecuted(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.asciidoctor.ConvertUMLToAsciidoctor");
	}

	@Override
	public void setExecutedWith(HashMap<String, String> keyMap) {
		runGoal("org.farhan.mbt.asciidoctor.ConvertUMLToAsciidoctor");
	}
}
