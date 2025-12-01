package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObject implements InputFileAsciidocFile,
		org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile {

	@Override
	public void assertObjectName(HashMap<String, String> keyMap) {
		try {
			Assertions.assertNotNull(testProject.getStepObject(keyMap.get("Object Name")));
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	@Override
	public void assertParameters(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = testProject.getStepObject(keyMap.get("Object Name"));
			IStepDefinition stepDefinition = stepObject.getStepDefinition(keyMap.get("Step Definition Name"));

			boolean found = false;
			for (IStepParameters sp : stepDefinition.getStepParameterList()) {
				if (cellsToString(sp.getTable().getRowList().getFirst().getCellList())
						.contains(keyMap.get("Parameters"))) {
					found = true;
				}
			}
			Assertions.assertTrue(found);
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}

	}

	@Override
	public void assertStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = testProject.getStepObject(keyMap.get("Object Name"));
			Assertions.assertNotNull(stepObject);
			for (IStepDefinition stepDef : stepObject.getStepDefinitionList()) {
				if (stepDef.getName().contentEquals(keyMap.get("Step Definition Name"))) {
					return;
				}
			}
			Assertions.fail("No step defintion found");
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	@Override
	public void setObjectDescription(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(testProject, keyMap.get("Object Name"));
			IStatement statement = new StatementImpl(keyMap.get("Object Description"));
			statement.setParent(stepObject);
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	@Override
	public void setObjectName(HashMap<String, String> keyMap) {
		try {
			SheepDogBuilder.createStepObject(testProject, keyMap.get("Object Name"));
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	@Override
	public void setParameters(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(testProject, keyMap.get("Object Name"));
			IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
					keyMap.get("Step Definition Name"));
			IRow parameters = new RowImpl();
			ICell cell = new CellImpl(keyMap.get("Parameters"));
			cell.setParent(parameters);
			SheepDogBuilder.createStepParameters(stepDefinition, parameters);
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	@Override
	public void setStepDefinitionDescription(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(testProject, keyMap.get("Object Name"));
			IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
					keyMap.get("Step Definition Name"));
			IStatement statement = new StatementImpl(keyMap.get("Step Definition Description"));
			statement.setParent(stepDefinition);
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	@Override
	public void setStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(testProject, keyMap.get("Object Name"));
			SheepDogBuilder.createStepDefinition(stepObject, keyMap.get("Step Definition Name"));
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}
}
