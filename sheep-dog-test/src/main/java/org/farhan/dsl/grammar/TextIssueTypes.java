package org.farhan.dsl.grammar;

public enum TextIssueTypes {
	TEXT_CONTENT_WORKSPACE("TEXT_CONTENT_WORKSPACE",
		"The step parameters don't exist for the step definition");

	public final String id;
	public final String description;

	TextIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
