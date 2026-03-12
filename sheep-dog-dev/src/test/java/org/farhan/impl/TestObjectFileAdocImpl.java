package org.farhan.impl;

import java.util.ArrayList;

import org.farhan.common.Utilities;
import org.farhan.mbt.asciidoctor.AsciiDoctorStepObject;
import org.farhan.mbt.asciidoctor.AsciiDoctorTestSuite;
import org.farhan.dsl.sheepdog.sheepDog.TestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.TestData;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.junit.jupiter.api.Assertions;

public class TestObjectFileAdocImpl extends TestObjectFileImpl {

	private AsciiDoctorTestSuite testSuite;
	private AsciiDoctorStepObject stepObject;

	protected void deleteObject() {
		getObjectExists();
		try {
			sr.delete("", object);
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	// Category 1: Value equality
	protected String getAbstractScenarioDescriptionValue(String name) {
		return testSuite.getScenarioDescription(getAbstractScenario(name));
	}

	protected String getAbstractScenarioTagsValue(String name) {
		return (String) Utilities.listAsCsv(testSuite.getAbstractScenarioTags(getAbstractScenario(name)));
	}

	protected String getDocStringValue(String name, String stepName) {
		return testSuite.getDocString(getStep(name, stepName));
	}

	protected String getFeatureNameValue() {
		return testSuite.getFeatureName();
	}

	protected String getFeatureStatementsValue() {
		return testSuite.getFeatureDescription();
	}

	protected String getExamplesTagsValue(String name, String examplesName) {
		return (String) Utilities.listAsCsv(testSuite.getExamplesTags(getExamples(name, examplesName)));
	}

	protected String getScenarioOutlineExamplesTableDescriptionValue(String name, String examplesName) {
		return testSuite.getExamplesDescription(getExamples(name, examplesName));
	}

	protected String getStepDefinitionDescriptionValue(String name) {
		return stepObject.getStepDefinitionDescription(getStepDefinition(name));
	}

	protected String getStepObjectNameValue() {
		return stepObject.getStepObjectName();
	}

	protected String getStepObjectStatementsValue() {
		return stepObject.getStepObjectDescription();
	}

	// Category 2: Existence checks — return found name or null
	protected String getAbstractScenarioExistsValue(String name) {
		TestStepContainer s = getAbstractScenario(name);
		return s == null ? null : testSuite.getScenarioName(s);
	}

	protected String getStepExistsValue(String name, String stepName) {
		TestStep s = getStep(name, stepName);
		return s == null ? null : testSuite.getStepName(s);
	}

	protected String getScenarioOutlineExamplesExistsValue(String name, String examplesName) {
		TestData e = getExamples(name, examplesName);
		return e == null ? null : testSuite.getExamplesName(e);
	}

	protected String getScenarioOutlineExamplesTableRowExistsValue(String name, String examplesName, String rowName) {
		ArrayList<String> row = getExamplesRow(getExamples(name, examplesName), rowName);
		return row == null ? null : rowName;
	}

	protected String getAbstractScenarioStepStepTableRowExistsValue(String name, String stepName, String rowName) {
		ArrayList<String> row = getRow(getStep(name, stepName), rowName);
		return row == null ? null : rowName;
	}

	protected String getStepDefinitionExistsValue(String name) {
		StepDefinition s = getStepDefinition(name);
		return s == null ? null : stepObject.getStepDefinitionName(s);
	}

	protected String getStepDefinitionParametersExistsValue(String name, String parametersName) {
		StepParameters p = getParameters(name, parametersName);
		return p == null ? null : stepObject.getStepParametersName(p);
	}

	protected String getStepDefinitionParametersTableRowExistsValue(String name, String parametersName, String rowName) {
		ArrayList<String> row = getParametersRow(getParameters(name, parametersName), rowName);
		return row == null ? null : rowName;
	}

	// Category 3: Parse + init — parse file and return getObjectExists()
	protected String getTestSuiteExistsValue() {
		String exists = getObjectExists();
		try {
			testSuite = new AsciiDoctorTestSuite(object);
			testSuite.parse(sr.get("", object));
		} catch (Exception e) {
			Assertions.fail(e);
		}
		return exists;
	}

	protected String getStepObjectExistsValue() {
		String exists = getObjectExists();
		try {
			stepObject = new AsciiDoctorStepObject(object);
			stepObject.parse(sr.get("", object));
		} catch (Exception e) {
			Assertions.fail(e);
		}
		return exists;
	}

	private TestStepContainer getAbstractScenario(String name) {
		for (TestStepContainer s : testSuite.getAbstractScenarioList()) {
			if (testSuite.getScenarioName(s).contentEquals(name)) {
				return s;
			}
		}
		return null;
	}

	protected TestData getExamples(String name, String examplesName) {
		for (TestData e : testSuite.getExamplesList(getAbstractScenario(name))) {
			if (testSuite.getExamplesName(e).contentEquals(examplesName)) {
				return e;
			}
		}
		return null;
	}

	private ArrayList<String> getExamplesRow(TestData examples, String rowName) {
		return getRow(testSuite.getExamplesRowList(examples), testSuite.getExamplesTable(examples), rowName);
	}

	protected StepParameters getParameters(String name, String parametersName) {
		for (StepParameters e : stepObject.getStepParametersList(getStepDefinition(name))) {
			if (stepObject.getStepParametersName(e).contentEquals(parametersName)) {
				return e;
			}
		}
		return null;
	}

	private ArrayList<String> getParametersRow(StepParameters parameters, String rowName) {
		return getRow(stepObject.getStepParametersRowList(parameters), stepObject.getStepParametersTable(parameters),
				rowName);
	}

	private ArrayList<String> getRow(ArrayList<Row> rows, ArrayList<String> header, String rowName) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		ArrayList<String> row = new ArrayList<String>();
		table.add(row);
		for (String colName : header) {
			row.add(colName);
		}
		for (Row r : rows) {
			row = new ArrayList<String>();
			table.add(row);
			for (Cell c : r.getCellList()) {
				row.add(c.getName());
			}
		}
		for (ArrayList<String> cellList : table) {
			String rowCsv = "";
			for (String cell : cellList) {
				rowCsv += ", " + cell;
			}
			rowCsv = rowCsv.replaceFirst(", ", "");
			if (rowCsv.contentEquals(rowName)) {
				return cellList;
			}
		}
		return null;
	}

	private ArrayList<String> getRow(TestStep step, String csvRow) {
		csvRow = csvRow.replaceAll(" +", " ");
		for (ArrayList<String> row : testSuite.getStepTable(step)) {
			// convert it to csv
			String rowCsv = "";
			for (String cell : row) {
				rowCsv += ", " + cell;
			}
			rowCsv = rowCsv.replaceFirst(", ", "");
			// if it matches, return it
			if (rowCsv.contentEquals(csvRow)) {
				return row;
			}
		}
		return null;
	}

	private TestStep getStep(String name, String stepName) {
		for (TestStep s : testSuite.getStepList(getAbstractScenario(name))) {
			if (testSuite.getStepName(s).contentEquals(stepName)) {
				return s;
			}
		}
		return null;
	}

	private StepDefinition getStepDefinition(String name) {
		for (StepDefinition s : stepObject.getStepDefinitionList()) {
			if (stepObject.getStepDefinitionName(s).contentEquals(name)) {
				return s;
			}
		}
		return null;
	}
}
