package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.dsl.common.Utilities;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObject implements InputFileAsciidocFile,
		org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile {

	@Override
	public void assertObjectName(HashMap<String, String> keyMap) {
		try {
			Assertions.assertNotNull(getEclipseMock().getStepObject(keyMap.get("Object Name")));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void assertParameters(HashMap<String, String> keyMap) {
		try {
			getEclipseMock().createStepObject(keyMap.get("Object Name"));
			getEclipseMock().createStepDefinition(keyMap.get("Step Definition Name"));
			Assertions.assertTrue(getEclipseMock().getStepDefinitionParameters(keyMap.get("Step Definition Name"))
					.toString().contains("[" + keyMap.get("Parameters") + "]"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}

	}

	@Override
	public void assertStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			Object stepObject = getEclipseMock().getStepObject(keyMap.get("Object Name"));
			Assertions.assertNotNull(stepObject);
			for (Object stepDef : getEclipseMock().getStepDefinitions(stepObject)) {
				if (getEclipseMock().getStepDefinitionName((Object) stepDef)
						.contentEquals(keyMap.get("Step Definition Name"))) {
					return;
				}
			}
			Assertions.fail("No step defintion found");
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setObjectName(HashMap<String, String> keyMap) {
		try {
			getEclipseMock().createStepObject(keyMap.get("Object Name"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setParameters(HashMap<String, String> keyMap) {
		try {
			getEclipseMock().createStepObject(keyMap.get("Object Name"));
			@SuppressWarnings("unchecked")
			ArrayList<ArrayList<String>> stepDefinitionList = (ArrayList<ArrayList<String>>) getEclipseMock()
					.createStepDefinition(keyMap.get("Step Definition Name"));
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(keyMap.get("Parameters"));
			stepDefinitionList.add(parameters);
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			getEclipseMock().createStepObject(keyMap.get("Object Name"));
			getEclipseMock().createStepDefinition(keyMap.get("Step Definition Name"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setStepDefinitionDescription(HashMap<String, String> keyMap) {
		try {
			getEclipseMock().createStepObject(keyMap.get("Object Name"));
			getEclipseMock().setStepDefinitionDescription(keyMap.get("Step Definition Name"),
					keyMap.get("Step Definition Description"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setObjectDescription(HashMap<String, String> keyMap) {
		try {
			getEclipseMock().createStepObject(keyMap.get("Object Name"));
			getEclipseMock().setStepObjectDescription(keyMap.get("Object Description"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}
}
