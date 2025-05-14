package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.FileObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessAsciidocFileImpl2 extends FileObject implements ProcessAsciidocFile {

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

}
