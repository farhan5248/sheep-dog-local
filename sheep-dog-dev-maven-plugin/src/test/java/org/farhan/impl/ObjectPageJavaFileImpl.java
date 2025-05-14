package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.FileObject;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageJavaFileImpl extends FileObject implements ObjectPageJavaFile {

	@Override
	public void assertContent(HashMap<String, String> keyMap) {
		assertContent(keyMap.get("Content"));
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public void assertPresent(HashMap<String, String> keyMap) {
		assertObjectExists();
	}
}
