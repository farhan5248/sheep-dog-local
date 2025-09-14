package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.dsl.common.Utilities;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObject implements InputFileAsciidocFile,
		org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile {

	@Override
	public void assertObjectName(HashMap<String, String> keyMap) {
		try {
			Assertions.assertNotNull(getLanguageAccess().getStepObject(keyMap.get("Object Name")));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void assertParameters(HashMap<String, String> keyMap) {
		try {
			getLanguageAccess().createStepObject(keyMap.get("Object Name"));
			IStepDefinition sd = (IStepDefinition) getLanguageAccess()
					.createStepDefinition(keyMap.get("Step Definition Name"));

			boolean found = false;
			for (IStepParameters sp : sd.getStepParameterList()) {
				if (cellsToString(sp.getTable().getFirst()).contains(keyMap.get("Parameters"))) {
					found = true;
				}
			}
			Assertions.assertTrue(found);
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}

	}

	@Override
	public void assertStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			Object stepObject = getLanguageAccess().getStepObject(keyMap.get("Object Name"));
			Assertions.assertNotNull(stepObject);
			for (Object stepDef : getLanguageAccess().getStepDefinitions(stepObject)) {
				if (getLanguageAccess().getStepDefinitionName((Object) stepDef)
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
			getLanguageAccess().createStepObject(keyMap.get("Object Name"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setParameters(HashMap<String, String> keyMap) {
		try {
			getLanguageAccess().createStepObject(keyMap.get("Object Name"));
			IStepDefinition stepDefinition = (IStepDefinition) getLanguageAccess()
					.createStepDefinition(keyMap.get("Step Definition Name"));
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(keyMap.get("Parameters"));
			stepDefinition.createStepParameters(parameters);
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			getLanguageAccess().createStepObject(keyMap.get("Object Name"));
			getLanguageAccess().createStepDefinition(keyMap.get("Step Definition Name"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setStepDefinitionDescription(HashMap<String, String> keyMap) {
		try {
			getLanguageAccess().createStepObject(keyMap.get("Object Name"));
			getLanguageAccess().setStepDefinitionDescription(keyMap.get("Step Definition Name"),
					keyMap.get("Step Definition Description"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setObjectDescription(HashMap<String, String> keyMap) {
		try {
			getLanguageAccess().createStepObject(keyMap.get("Object Name"));
			getLanguageAccess().setStepObjectDescription(keyMap.get("Object Description"));
		} catch (Exception e) {
			Assertions.fail(Utilities.getStackTraceAsString(e));
		}
	}
}
