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
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogFactory;
import org.farhan.impl.TestStepContainerImpl;
import org.farhan.impl.TestStepImpl;
import org.farhan.impl.TestSuiteImpl;
import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;

public abstract class TestObject {

	public static ITestProject testProject;
	public static TestSuiteImpl testSuite;
	public static TestStepContainerImpl testStepContainer;
	public static TestStepImpl currentStep;
	public static String elementType;

	protected static String getStackTraceAsString(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	public static void reset() {
		testSuite = null;
		testStepContainer = null;
		currentStep = null;
		elementType = null;
		testProject = SheepDogFactory.instance.createTestProject();
	}

	protected HashMap<String, String> keyValue = new HashMap<String, String>();

	protected ITable stepParametersTable;
	protected IText stepText;

	protected void addTestSuite(String testSuiteName) {
		ITestSuite testSuite = testProject.getTestSuite(testSuiteName);
		if (testSuite == null) {
			testSuite = SheepDogBuilder.createTestSuite(testProject, testSuiteName);
		}
		TestObject.testSuite = (TestSuiteImpl) testSuite;
	}

	protected void addTestStepContainer(String testStepContainerName) {
		if (testSuite == null) {
			addTestSuite("Test Suite");
		}
		ITestStepContainer testCase = testSuite.getTestStepContainer(testStepContainerName);
		if (testCase == null) {
			testCase = SheepDogBuilder.createTestCase(testSuite, testStepContainerName);
		}
		TestObject.testStepContainer = (TestStepContainerImpl) testCase;
	}

	protected void addTestCaseStep(String stepName) {
		if (testSuite == null) {
			addTestSuite("Test Suite");
		}
		if (testStepContainer == null) {
			addTestStepContainer("Test Step Container");
		}
		currentStep = (TestStepImpl) SheepDogBuilder.createTestStep(testStepContainer, stepName);
		testStepContainer.addTestStep(currentStep);
		if (stepParametersTable != null) {
			// this is for situations where the keymap order isn't preserved
			currentStep.setTable(stepParametersTable);
			stepParametersTable = null;
		}
		if (stepText != null) {
			currentStep.setText(stepText);
			stepText = null;
		}
	}

	protected void addTestSetupStep(String stepName) {
		if (testSuite == null) {
			addTestSuite("");
		}
		if (testStepContainer == null) {
			addTestStepContainer("");
		}
		currentStep = (TestStepImpl) SheepDogBuilder.createTestStep(testStepContainer, stepName);
		testStepContainer.addTestStep(currentStep);
		if (stepParametersTable != null) {
			// this is for situations where the keymap order isn't preserved
			currentStep.setTable(stepParametersTable);
			stepParametersTable = null;
		}
		if (stepText != null) {
			currentStep.setText(stepText);
			stepText = null;
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

	protected String cellsToString(List<ICell> cells) {
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
