package org.farhan.dsl.issues;

public enum TextIssueTypes {

	TEXT_NAME_WORKSPACE("TEXT_NAME_WORKSPACE", "The step parameters don't exist for the step definition");

	public final String id;
	public final String description;

	TextIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}
}
