package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AppInputFileAsciidocFileImpl extends TestObject implements InputFileAsciidocFile {

	@Override
	public void setObjectName(HashMap<String, String> keyMap) {
		try {
			SheepDogBuilder.createStepObject(MockIDE.testProject, keyMap.get("Object Name"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(MockIDE.testProject, keyMap.get("Object Name"));
			SheepDogBuilder.createStepDefinition(stepObject, keyMap.get("Step Definition Name"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}
}
