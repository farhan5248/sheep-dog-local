package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.FileObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageAsciidocFileImpl extends FileObject implements ObjectPageAsciidocFile {

	@Override
	public void assertContent(HashMap<String, String> keyMap) {
		assertContent(keyMap.get("Content"));
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public void setCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
	}

	@Override
	public void assertCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
	}

}
