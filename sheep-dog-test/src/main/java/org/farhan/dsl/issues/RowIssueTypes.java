package org.farhan.dsl.issues;

public enum RowIssueTypes {

	ROW_CELL_LIST_WORKSPACE("ROW_CELL_LIST_WORKSPACE", "The step parameters don't exist for the step definition");

	public final String id;
	public final String description;

	RowIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}
}