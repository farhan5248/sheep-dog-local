package org.farhan.mbt.core;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;

public class UMLTestData extends UMLElement {

	private EAnnotation umlElement;

	public UMLTestData(String name, UMLTestCase parent) {
		umlElement = createAnnotation(parent.getUmlElement(), name);
	}

	public UMLTestData(EAnnotation umlElement, UMLTestCase parent) {
		this.umlElement = umlElement;
	}

	public void setTable(ArrayList<String> headers) {
		String value = "";
		for (String e : headers) {
			value += e + "|";
		}
		umlElement.getDetails().put("Data", value);
	}

	public void addRow(ArrayList<String> examplesRow) {

		for (Entry<String, String> s : umlElement.getDetails().entrySet()) {
			if (s.getKey().equals("Data")) {
				String value = s.getValue() + "\n";
				for (String e : examplesRow) {
					value += e + "|";
				}
				umlElement.getDetails().put("Data", value);
			}
		}
	}

	public String getName() {
		return umlElement.getSource();
	}

	public ArrayList<String> getTable() {
		ArrayList<String> paramNames = new ArrayList<String>();
		for (Entry<String, String> s : umlElement.getDetails().entrySet()) {
			if (s.getKey().equals("Data")) {
				for (String cell : s.getValue().split("\n")[0].split("\\|")) {
					if (!cell.isEmpty()) {
						paramNames.add(cell);
					}
				}
			}
		}
		return paramNames;
	}

	public ArrayList<ArrayList<String>> getRowList() {
		ArrayList<ArrayList<String>> examplesRowList = new ArrayList<ArrayList<String>>();
		for (Entry<String, String> s : umlElement.getDetails().entrySet()) {
			if (s.getKey().equals("Data")) {
				String[] rows = s.getValue().split("\n");
				int rowCnt = rows.length;
				for (int i = 1; i < rowCnt; i++) {
					String[] row = rows[i].split("\\|");
					ArrayList<String> cellList = new ArrayList<String>();
					int cellCnt = row.length;
					for (int j = 0; j < cellCnt; j++) {
						cellList.add(row[j]);
					}
					examplesRowList.add(cellList);
				}
			}
		}
		return examplesRowList;
	}

	public void setTags(ArrayList<String> tags) {
		String value = "";
		for (String e : tags) {
			value += e + "\n";
		}
		umlElement.getDetails().put("Tags", value.trim());
	}

	public ArrayList<String> getTags() {
		ArrayList<String> paramNames = new ArrayList<String>();
		for (Entry<String, String> s : umlElement.getDetails().entrySet()) {
			if (s.getKey().equals("Tags")) {
				for (String cell : s.getValue().split("\n")) {
					if (!cell.isEmpty()) {
						paramNames.add(cell);
					}
				}
			}
		}
		return paramNames;
	}

	public void setDescription(String description) {
		umlElement.getDetails().put("Description", description);
	}

	public String getDescription() {
		for (Entry<String, String> s : umlElement.getDetails().entrySet()) {
			if (s.getKey().equals("Description")) {
				return s.getValue();
			}
		}
		return "";
	}

}
