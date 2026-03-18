package org.farhan.dsl.grammar;

public enum RowIssueTypes {
	ROW_CELL_LIST_WORKSPACE("ROW_CELL_LIST_WORKSPACE",
		"The step parameters don't exist for the step definition");

	public final String id;
	public final String description;

	RowIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
