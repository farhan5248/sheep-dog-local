package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.FileObject;
import org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.app.ProcessFeatureFile;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessFeatureFileImpl extends FileObject implements ProcessFeatureFile {

	@Override
	public void assertContent(HashMap<String, String> keyMap) {
		assertContent(keyMap.get("Content"));
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

}
