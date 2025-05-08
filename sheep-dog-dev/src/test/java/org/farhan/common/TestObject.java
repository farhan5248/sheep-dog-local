package org.farhan.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import com.google.inject.Key;

import io.cucumber.datatable.DataTable;

public abstract class TestObject {

	protected HashMap<String, String> attributes = new HashMap<String, String>();

	protected GoalObject getGoalClass(String contains) throws Exception {
		for (Key<?> b : Config.classes.getBindings().keySet()) {
			if (b.getTypeLiteral().toString().contains(contains)
					&& b.getTypeLiteral().toString().startsWith("org.farhan.objects.maven.")) {
				GoalObject object = (GoalObject) Config.classes.getInstance(b);
				if (object.attributes.size() > 1) {
					return object;
				}
			}
		}
		return null;
	}

	public String getStackTraceAsString(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		return exceptionAsString;
	}

	public void assertInputOutputs(DataTable dataTable) {
		processInputOutputs(dataTable, "assert", "", false);
	}

	public void assertInputOutputs(DataTable dataTable, String sectionName) {
		processInputOutputs(dataTable, "assert", sectionName, false);
	}

	public void assertInputOutputs(List<List<String>> dataTable, String sectionName) {
		processInputOutputs(dataTable, "assert", sectionName, false);
	}

	public void assertInputOutputs(DataTable dataTable, String sectionName, boolean negativeTest) {
		processInputOutputs(dataTable, "assert", sectionName, negativeTest);
	}

	public void assertInputOutputs(String key) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, "true");
		processInputOutputs(row, "assert", "", false);
	}

	public void assertInputOutputs(String key, boolean negativeTest) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, Boolean.toString(negativeTest));
		processInputOutputs(row, "assert", "", negativeTest);
	}

	public void assertInputOutputs(String key, String value) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, value);
		processInputOutputs(row, "assert", "", false);
	}

	private String cleanName(String name) {
		return name.replaceAll("[ \\-\\(\\)/]", "");
	}

	private void processInputOutputs(DataTable dataTable, String operation, String sectionName, boolean negativeTest) {
		processInputOutputs(dataTable.asLists(), operation, sectionName, negativeTest);
	}

	private void processInputOutputs(List<List<String>> data, String operation, String sectionName,
			boolean negativeTest) {

		ArrayList<String> headers = new ArrayList<String>();
		for (String cell : data.get(0)) {
			headers.add(cell);
		}
		for (int i = 1; i < data.size(); i++) {
			HashMap<String, String> row = new HashMap<String, String>();
			for (int j = 0; j < data.get(i).size(); j++) {
				row.put(headers.get(j), data.get(i).get(j));
			}
			processInputOutputs(row, operation, sectionName, negativeTest);
		}
	}

	private void processInputOutputs(HashMap<String, String> row, String operation, String sectionName,
			boolean negativeTest) {
		try {
			if (negativeTest) {
				this.getClass().getMethod(operation + cleanName(sectionName) + "Negative", HashMap.class).invoke(this,
						row);
			} else {
				for (String columnName : row.keySet()) {
					this.getClass().getMethod(operation + cleanName(sectionName) + cleanName(columnName), HashMap.class)
							.invoke(this, row);
				}
			}
		} catch (Exception e) {
			Assertions.fail(getStackTraceAsString(e));
		}
	}

	public void setComponent(String component) {
		attributes.put("component", component);
	}

	public void setInputOutputs(DataTable dataTable) {
		processInputOutputs(dataTable, "set", "", false);
	}

	public void setInputOutputs(DataTable dataTable, String sectionName) {
		processInputOutputs(dataTable, "set", sectionName, false);
	}

	public void setInputOutputs(DataTable dataTable, String sectionName, boolean negativeTest) {
		processInputOutputs(dataTable, "set", sectionName, negativeTest);
	}

	public void setInputOutputs(String key, String value) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, value);
		processInputOutputs(row, "set", "", false);
	}

	public void setPath(String path) {
		attributes.put("path", path);
	}

	public void transition() {
	}

	public void setInputOutputs(String key) {
		HashMap<String, String> row = new HashMap<String, String>();
		row.put(key, "true");
		processInputOutputs(row, "set", "", false);
	}
}
