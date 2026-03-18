package org.farhan.dsl.issues;

public enum TestSuiteIssueTypes {
	TEST_SUITE_NAME_ONLY("TEST_SUITE_NAME_ONLY", "Name should start with a capital");

	public final String id;
	public final String description;

	TestSuiteIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
