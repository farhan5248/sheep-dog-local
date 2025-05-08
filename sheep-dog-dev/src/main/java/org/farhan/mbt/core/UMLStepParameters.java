package org.farhan.mbt.core;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAnnotation;

public class UMLStepParameters extends UMLElement {

	private EAnnotation umlElement;

	public UMLStepParameters(String name, UMLStepDefinition parent) {
		umlElement = createAnnotation(parent.getUmlElement(), name);
	}

	public UMLStepParameters(EAnnotation umlElement, UMLStepDefinition parent) {
		this.umlElement = umlElement;
	}

	public void addRow(ArrayList<String> stepParametersRow) {
		String value = "";
		for (String e : stepParametersRow) {
			value += e + "|";
		}
		umlElement.getDetails().put(String.valueOf(umlElement.getDetails().size()), value);
	}

	public void addTable(ArrayList<String> headers) {
		String value = "";
		for (String e : headers) {
			value += e + "|";
		}
		umlElement.getDetails().put("0", value);
	}

	public String getName() {
		return umlElement.getSource();
	}

	public ArrayList<String> getTable() {
		ArrayList<String> paramNames = new ArrayList<String>();
		for (String cell : umlElement.getDetails().getFirst().getValue().split("\\|")) {
			paramNames.add(cell);
		}
		return paramNames;
	}

	public ArrayList<ArrayList<String>> getRowList() {
		ArrayList<ArrayList<String>> rowList = new ArrayList<ArrayList<String>>();
		int rowCnt = umlElement.getDetails().size();
		for (int i = 1; i < rowCnt; i++) {
			String[] row = umlElement.getDetails().get(i).getValue().split("\\|");
			ArrayList<String> cellList = new ArrayList<String>();
			int cellCnt = row.length;
			for (int j = 0; j < cellCnt; j++) {
				cellList.add(row[j]);
			}
			rowList.add(cellList);
		}
		return rowList;
	}

	public EAnnotation getUmlElement() {
		return umlElement;
	}
}
