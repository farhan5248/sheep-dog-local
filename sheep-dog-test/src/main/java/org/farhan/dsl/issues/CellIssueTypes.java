package org.farhan.dsl.issues;

public enum CellIssueTypes {
	CELL_NAME_ONLY("CELL_NAME_ONLY", "Name should start with a capital");

	public final String id;
	public final String description;

	CellIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
