package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObjectFile;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageJavaFileImpl extends TestObjectFile implements ObjectPageJavaFile {

	@Override
	public String getContent(HashMap<String, String> keyMap) {
		return getContent();
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
	public String getCreatedAsFollows(HashMap<String, String> keyMap) {
		return getObjectExists();
	}
}
