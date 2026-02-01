package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.impl.ide.CellImpl;
import org.farhan.impl.ide.RowImpl;
import org.farhan.impl.ide.StatementImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObject implements InputFileAsciidocFile {

	@Override
	public void assertObjectName(HashMap<String, String> keyMap) {
		try {
			Assertions.assertNotNull(MockIDE.testProject.getStepObject(keyMap.get("Object Name")));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void assertParameters(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = MockIDE.testProject.getStepObject(keyMap.get("Object Name"));
			IStepDefinition stepDefinition = stepObject.getStepDefinition(keyMap.get("Step Definition Name"));

			for (IStepParameters sp : stepDefinition.getStepParameterList()) {
				if (cellsToString(sp.getTable().getRowList().getFirst().getCellList())
						.contains(keyMap.get("Parameters"))) {
					return;
				}
			}
			Assertions.fail("No parameters found: " + keyMap.get("Parameters"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void assertStepDefinitionName(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = MockIDE.testProject.getStepObject(keyMap.get("Object Name"));
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
			IStepObject stepObject = SheepDogBuilder.createStepObject(MockIDE.testProject, keyMap.get("Object Name"));
			stepObject.addStatement(new StatementImpl(keyMap.get("Object Description")));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setObjectName(HashMap<String, String> keyMap) {
		try {
			SheepDogBuilder.createStepObject(MockIDE.testProject, keyMap.get("Object Name"));
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setParameters(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(MockIDE.testProject, keyMap.get("Object Name"));
			IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
					keyMap.get("Step Definition Name"));
			IRow row = new RowImpl();
			ICell cell = new CellImpl(keyMap.get("Parameters"));
			row.addCell(cell);
			SheepDogBuilder.createStepParameters(stepDefinition, row);
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setStepDefinitionDescription(HashMap<String, String> keyMap) {
		try {
			IStepObject stepObject = SheepDogBuilder.createStepObject(MockIDE.testProject, keyMap.get("Object Name"));
			IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
					keyMap.get("Step Definition Name"));
			stepDefinition.addStatement(new StatementImpl(keyMap.get("Step Definition Description")));
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

	private String cellsToString(List<ICell> cells) {
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (ICell cell : cells) {
			sortedCells.add(cell.getName());
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}
}
