package org.farhan.dsl.issues;

public enum RowIssueTypes {

	ROW_REFERENCE_CELL_LIST("ROW_REFERENCE_CELL_LIST", "The step parameters don't exist for the step definition");

	public final String value;
	public final String description;

	RowIssueTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}