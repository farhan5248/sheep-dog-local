package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEElement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestIDEElement implements InputFileAsciidocFile {

	@Override
	public void assertObjectName(HashMap<String, String> keyMap) {
		try {
			Assertions.assertNotNull(TestIDEElement.testProject.getStepObject(keyMap.get("Object Name")));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void assertParameters(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = TestIDEElement.testProject.getStepObject(keyMap.get("Object Name"));
			IStepDefinition stepDefinition = stepObject.getStepDefinition(keyMap.get("Step Definition Name"));
			if (stepDefinition.getStepParameters(keyMap.get("Parameters")) != null) {
				return;
			}
			Assertions.fail("No parameters found: " + keyMap.get("Parameters"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void assertStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = TestIDEElement.testProject.getStepObject(keyMap.get("Object Name"));
			Assertions.assertNotNull(stepObject);
			for (IStepDefinition stepDef : stepObject.getStepDefinitionList()) {
				if (stepDef.getName().contentEquals(keyMap.get("Step Definition Name"))) {
					return;
				}
			}
			Assertions.fail("No step defintion found" + keyMap.get("Step Definition Name"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setObjectDescription(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEElement.testProject, keyMap.get("Object Name"));
			SheepDogBuilder.createStatement(stepObject, keyMap.get("Object Description"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setObjectName(HashMap<String, String> keyMap) {
		try {
			SheepDogBuilder.createStepObject(TestIDEElement.testProject, keyMap.get("Object Name"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setParameters(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEElement.testProject, keyMap.get("Object Name"));
			IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
					keyMap.get("Step Definition Name"));
			SheepDogBuilder.createStepParameters(stepDefinition, keyMap.get("Parameters"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setStepDefinitionDescription(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEElement.testProject, keyMap.get("Object Name"));
			IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
					keyMap.get("Step Definition Name"));
			SheepDogBuilder.createStatement(stepDefinition, keyMap.get("Step Definition Description"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEElement.testProject, keyMap.get("Object Name"));
			SheepDogBuilder.createStepDefinition(stepObject, keyMap.get("Step Definition Name"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}
}
