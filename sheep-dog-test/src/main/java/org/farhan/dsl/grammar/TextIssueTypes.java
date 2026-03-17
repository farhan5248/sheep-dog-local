package org.farhan.dsl.grammar;

public enum TextIssueTypes {

	TEXT_STEP_PARAMETER_LIST_WORKSPACE("TEXT_STEP_PARAMETER_LIST_WORKSPACE",
			"The step parameters don't exist for the step definition");

	public final String id;
	public final String description;

	TextIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
