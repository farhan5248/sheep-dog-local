package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.app.ProcessAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessAsciidocFileImpl extends TestObjectFileAdocImpl implements ProcessAsciidocFile,
		org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile {

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
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public void setCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
	}
}
