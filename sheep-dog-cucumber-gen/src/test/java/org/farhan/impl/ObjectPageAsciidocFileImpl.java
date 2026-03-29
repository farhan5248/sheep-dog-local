package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageAsciidocFileImpl extends TestObjectFileAdocImpl implements ObjectPageAsciidocFile {

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public String getContent(HashMap<String, String> keyMap) {
		return getContent();
	}

	@Override
	public String getCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public void setCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
	}
}
