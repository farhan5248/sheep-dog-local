package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.cucumber.cucumber.AbstractScenario;
import org.farhan.dsl.cucumber.cucumber.Cell;
import org.farhan.dsl.cucumber.cucumber.Examples;
import org.farhan.dsl.cucumber.cucumber.Row;
import org.farhan.dsl.cucumber.cucumber.Scenario;
import org.farhan.dsl.cucumber.cucumber.Step;
import org.farhan.mbt.cucumber.CucumberFeature;
import org.junit.jupiter.api.Assertions;

public class FeatureFileObject extends TestObjectFile {

	private CucumberFeature wrapper;

	private String listAsCsv(ArrayList<String> list) {
		String csv = "";
		for (String listItem : list) {
			csv += "," + listItem;
		}
		return csv.replaceFirst(",", "");
	}

	// --- get methods: return actual values, no assertions ---

	// Category 1: Value equality
	protected String getAbstractScenarioDescriptionValue(String name) {
		return wrapper.getScenarioDescription(getAbstractScenario(name));
	}

	protected String getAbstractScenarioTagsValue(String name) {
		AbstractScenario abstractScenario = getAbstractScenario(name);
		if (abstractScenario instanceof Scenario) {
			return listAsCsv(wrapper.getScenarioTags(abstractScenario));
		} else {
			return listAsCsv(wrapper.getScenarioOutlineTags(abstractScenario));
		}
	}

	protected String getDocStringValue(String name, String stepName) {
		return wrapper.getDocString(getStep(name, stepName));
	}

	protected String getFeatureNameValue() {
		return wrapper.getFeatureName();
	}

	protected String getFeatureStatementsValue() {
		return wrapper.getFeatureDescription();
	}

	protected String getFeatureTagsValue() {
		return listAsCsv(wrapper.getFeatureTags());
	}

	protected String getScenarioOutlineExamplesTableTagsValue(String name, String examplesName) {
		return listAsCsv(wrapper.getExamplesTags(getExamples(name, examplesName)));
	}

	protected String getScenarioOutlineExamplesTableDescriptionValue(String name, String examplesName) {
		return wrapper.getExamplesDescription(getExamples(name, examplesName));
	}

	// Category 2: Existence checks
	protected String getAbstractScenarioExistsValue(String name) {
		AbstractScenario s = getAbstractScenario(name);
		return s == null ? null : wrapper.getScenarioName(s);
	}

	protected String getStepExistsValue(String name, String stepName) {
		Step s = getStep(name, stepName);
		return s == null ? null : wrapper.getStepName(s);
	}

	protected String getScenarioOutlineExamplesExistsValue(String name, String examplesName) {
		Examples e = getExamples(name, examplesName);
		return e == null ? null : wrapper.getExamplesName(e);
	}

	protected String getScenarioOutlineExamplesTableRowExistsValue(String name, String examplesName, String rowName) {
		String row = getRow(getExamples(name, examplesName), rowName);
		return row;
	}

	protected String getAbstractScenarioStepStepTableRowExistsValue(String name, String stepName, String rowName) {
		ArrayList<String> row = getRow(getStep(name, stepName), rowName);
		return row == null ? null : rowName;
	}

	// Category 3: Parse + init
	protected String getFileExistsValue() {
		String exists = getObjectExists();
		try {
			wrapper = new CucumberFeature(properties.get("path").toString());
			wrapper.parse(sr.get("", properties.get("path").toString()));
		} catch (Exception e) {
			Assertions.fail(e);
		}
		return exists;
	}

	private AbstractScenario getAbstractScenario(String name) {
		for (AbstractScenario s : wrapper.getAbstractScenarioList()) {
			if (wrapper.getScenarioName(s).contentEquals(name)) {
				return s;
			}
		}
		return null;
	}

	private Examples getExamples(String name, String examplesName) {
		for (Examples e : wrapper.getExamplesList(getAbstractScenario(name))) {
			if (wrapper.getExamplesName(e).contentEquals(examplesName)) {
				return e;
			}
		}
		return null;
	}

	private String getRow(Examples examples, String rowName) {
		rowName = rowName.replaceAll(" +", " ");
		String rString = "|";
		for (String header : wrapper.getExamplesTable(examples)) {
			rString += " " + header + " |";
		}
		if (rString.contentEquals(rowName)) {
			return rowName;
		}
		for (Row row : wrapper.getExamplesRowList(examples)) {
			rString = "|";
			for (Cell c : row.getCells()) {
				rString += " " + c.getName() + " |";
			}
			if (rString.contentEquals(rowName)) {
				return rowName;
			}
		}
		return null;
	}

	private ArrayList<String> getRow(Step step, String rowName) {
		rowName = rowName.replaceAll(" +", " ");
		for (ArrayList<String> r : wrapper.getStepTable(step)) {
			String rString = "|";
			for (String c : r) {
				rString += " " + c + " |";
			}
			if (rString.contentEquals(rowName)) {
				return r;
			}
		}
		return null;
	}

	private Step getStep(String name, String stepName) {
		for (Step s : wrapper.getStepList(getAbstractScenario(name))) {
			if (wrapper.getStepName(s).contentEquals(stepName)) {
				return s;
			}
		}
		return null;
	}
}
