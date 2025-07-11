package org.farhan.mbt.core;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class UMLTestStep extends UMLElement {

	private Message umlElement;

	public UMLTestStep(Message umlElement, UMLElement parent, String id) {
		this.id = id;
		this.umlElement = umlElement;
		this.parent = parent;
	}

	public UMLTestStep(String name, UMLElement parent, String id) {
		this.id = id;
		String keyword = name.split(" ")[0];
		if (parent instanceof UMLTestCase) {
			umlElement = ((UMLTestCase) parent).getUmlElement().createMessage(name.substring(keyword.length() + 1));
		} else {
			umlElement = ((UMLTestSetup) parent).getUmlElement().createMessage(name.substring(keyword.length() + 1));
		}
		this.parent = parent;
	}

	private ValueSpecification createArgument(String name, String value) {
		LiteralString ls = (LiteralString) umlElement.getArgument(name, null);
		if (ls == null) {
			ls = UMLFactory.eINSTANCE.createLiteralString();
			ls = (LiteralString) umlElement.createArgument(name, null, ls.eClass());
			ls.setName(name);
			ls.setValue(value);
		}
		return ls;
	}

	public String getKeyword() {
		return umlElement.getEAnnotation("Step").getDetails().get("Keyword");
	}

	public String getName() {
		return getKeyword() + " " + umlElement.getName();
	}

	public String getNameLong() {
		return umlElement.getEAnnotation("Step").getDetails().get("LongName");
	}

	public ArrayList<ArrayList<String>> getStepData() {
		if (!hasStepTable()) {
			return null;
		}
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		ArrayList<String> row;
		ValueSpecification vs = (LiteralString) umlElement.getArgument("dataTable", null);
		for (Entry<String, String> r : vs.getEAnnotation("dataTable").getDetails()) {
			row = new ArrayList<String>();
			for (String cell : r.getValue().split(" \\|")) {
				row.add(cell);
			}
			table.add(row);
		}
		return table;
	}

	public String getStepText() {
		if (!hasDocString()) {
			return null;
		}
		ValueSpecification vs = (LiteralString) umlElement.getArgument("docString", null);
		EMap<String, String> docString = vs.getEAnnotation("docString").getDetails();
		String content = "";
		for (int i = 0; i < docString.keySet().size(); i++) {
			content += "\n" + docString.get(i).getValue();
		}
		content = content.replaceFirst("\n", "");
		return content;
	}

	public boolean hasDocString() {
		return umlElement.getArgument("docString", null) != null;
	}

	public boolean hasStepTable() {
		return umlElement.getArgument("dataTable", null) != null;
	}

	public void setKeyword(String keyword) {
		if (!keyword.endsWith(":")) {
			keyword += ":";
		}
		createAnnotation(umlElement, "Step", "Keyword", keyword);
	}

	public void setNameLong(String stepNameLong) {
		String keyword = stepNameLong.split(" ")[0];
		if (!keyword.endsWith(":")) {
			stepNameLong = stepNameLong.replaceFirst("^" + keyword, keyword + ":");
		}
		createAnnotation(umlElement, "Step", "LongName", stepNameLong);
	}

	public void setStepData(ArrayList<ArrayList<String>> stepTableRowList) {
		ValueSpecification table = createArgument("dataTable", "");
		// header
		String row = "";
		for (int i = 0; i < stepTableRowList.get(0).size(); i++) {
			row += stepTableRowList.get(0).get(i) + " |";
		}
		createAnnotation(table, "dataTable", String.valueOf(0), row);
		// body
		for (int i = 1; i < stepTableRowList.size(); i++) {
			row = "";
			ArrayList<String> bodyRow = stepTableRowList.get(i);
			for (int j = 0; j < bodyRow.size(); j++) {
				row += stepTableRowList.get(i).get(j).replace("{", "<").replace("}", ">") + " |";
			}
			createAnnotation(table, "dataTable", String.valueOf(i), row);
		}
	}

	public void setStepText(String content) {
		ValueSpecification vs = createArgument("docString", "");
		String[] lines = content.split("\n");
		for (int i = 0; i < lines.length; i++) {
			createAnnotation(vs, "docString", String.valueOf(i), lines[i]);
		}
	}

}
