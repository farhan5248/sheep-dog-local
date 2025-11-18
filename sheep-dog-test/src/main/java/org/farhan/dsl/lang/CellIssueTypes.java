package org.farhan.dsl.lang;

public enum CellIssueTypes {

	CELL_NAME("CELL_NAME", "Name should start with a capital");

	public final String value;
	public final String description;

	CellIssueTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}
