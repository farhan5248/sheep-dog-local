package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.FileObject;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah.BlahObjectPageStepsJavaFile;
import org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.app.ProcessFeatureFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.app.ProcessAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class FileImpl extends FileObject
		implements BlahObjectPageStepsJavaFile, ObjectPageJavaFile, ObjectPageAsciidocFile, ProcessAsciidocFile,
		ProcessFeatureFile, org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile,
		org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.ProcessFeatureFile {

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
