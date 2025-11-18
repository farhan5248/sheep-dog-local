package org.farhan.dsl.lang;

public enum TestSuiteIssueTypes {

	TEST_SUITE_NAME("TEST_SUITE_NAME", "Name should start with a capital");

	public final String value;
	public final String description;

	TestSuiteIssueTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}
