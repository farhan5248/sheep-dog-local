package org.farhan.common;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.io.PrintWriter;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;

public abstract class TestObject {

	protected static TestStepImpl currentStep;

	public static ITestProject testProject;

	protected static String getStackTraceAsString(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	protected HashMap<String, String> keyValue = new HashMap<String, String>();

	protected ITable stepParametersTable;

	protected void addTestCaseStep(String stepName) {

		ITestSuite testSuite = testProject.getTestSuite("");
		if (testSuite == null) {
			testSuite = testProject.createTestSuite("");
		}
		ITestStepContainer testCase = testSuite.getTestStepContainer("");
		if (testCase == null) {
			testCase = testSuite.createTestCase("");
		}
		currentStep = (TestStepImpl) testCase.createTestStep(stepName);
		testCase.getTestStepList().add(currentStep);
		if (stepParametersTable != null) {
			// this is for situations where the keymap order isn't preserved
			currentStep.setTable(stepParametersTable);
			stepParametersTable.setParent(currentStep);
			stepParametersTable = null;
		}
	}

	protected void addTestSetupStep(String stepName) {
		ITestSuite testSuite = testProject.getTestSuite("");
		if (testSuite == null) {
			testSuite = testProject.createTestSuite("");
		}
		ITestStepContainer testSetup = testSuite.getTestStepContainer("");
		if (testSetup == null) {
			testSetup = testSuite.createTestSetup("");
		}
		currentStep = (TestStepImpl) testSetup.createTestStep(stepName);
		testSetup.getTestStepList().add(currentStep);
		if (stepParametersTable != null) {
			// this is for situations where the keymap order isn't preserved
			currentStep.setTable(stepParametersTable);
			stepParametersTable.setParent(currentStep);
			stepParametersTable = null;
		}
	}

	public void assertInputOutputs(DataTable dataTable) {
		processInputOutputs(dataTable, "assert", "");
	}

	public void assertInputOutputs(DataTable dataTable, String sectionName) {
		processInputOutputs(dataTable, "assert", sectionName);
	}

	public void assertInputOutputs(DataTable dataTable, String sectionName, boolean negativeTest) {
		processInputOutputs(dataTable, "assert", sectionName);
	}

	public void assertInputOutputs(String key) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, "true");
		processInputOutputs(row, "assert", "");
	}

	public void assertInputOutputs(String key, boolean negativeTest) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, Boolean.toString(negativeTest));
		processInputOutputs(row, "assert", "");
	}

	public void assertInputOutputs(String key, String value) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, value);
		processInputOutputs(row, "assert", "");
	}

	protected String cellsToString(ArrayList<ICell> cells) {
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

	private String cleanName(String name) {
		return name.replaceAll("[ \\-\\(\\)/]", "");
	}

	protected String getSpecial(String value) {
		if (value.contentEquals("empty")) {
			return "";
		} else {
			return value;
		}
	}

	private void processInputOutputs(DataTable dataTable, String operation, String sectionName) {
		List<List<String>> data = dataTable.asLists();

		ArrayList<String> headers = new ArrayList<String>();
		for (String cell : data.get(0)) {
			headers.add(cell);
		}
		for (int i = 1; i < data.size(); i++) {
			HashMap<String, String> row = new HashMap<String, String>();
			for (int j = 0; j < data.get(i).size(); j++) {
				row.put(headers.get(j), data.get(i).get(j));
			}
			processInputOutputs(row, operation, sectionName);
		}
	}

	private void processInputOutputs(HashMap<String, String> row, String operation, String sectionName) {
		try {
			for (String fieldName : row.keySet()) {
				this.getClass().getMethod(operation + cleanName(sectionName) + cleanName(fieldName), HashMap.class)
						.invoke(this, row);
			}
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	public void setComponent(String component) {
		keyValue.put("component", component);
	}

	public void setInputOutputs(DataTable dataTable) {
		processInputOutputs(dataTable, "set", "");
	}

	public void setInputOutputs(DataTable dataTable, String sectionName) {
		processInputOutputs(dataTable, "set", sectionName);
	}

	public void setInputOutputs(DataTable dataTable, String sectionName, boolean negativeTest) {
		processInputOutputs(dataTable, "set", sectionName);
	}

	public void setInputOutputs(String key) {
		// TODO in the future, the value can be true/false for is present/valid etc when
		// is vs isn't is used
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, "true");
		processInputOutputs(row, "set", "");
	}

	public void setInputOutputs(String key, String value) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, value);
		processInputOutputs(row, "set", "");
	}

	public void setPath(String path) {
		keyValue.put("path", path);
	}

	public void transition() {
	}
}
