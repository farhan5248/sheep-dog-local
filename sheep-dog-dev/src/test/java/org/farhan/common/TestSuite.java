package org.farhan.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestSuite {

	protected List<List<String>> dataTable;

	protected void init(Object object, String component, String objectName) {
		((TestObject) object).setComponent(component);
		((TestObject) object).setPath(objectName);
	}

	protected void addRow(String... cells) {
		dataTable.add(new ArrayList<String>());
		for (String c : cells) {
			dataTable.getLast().add(c);
		}
	}

	protected void createTable() {
		dataTable = new ArrayList<>();
	}

	protected String getContent(String path) {
		try {
			return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return null;
		}
	}

}
