package org.farhan.dsl.issues;

public enum TestStepContainerIssueTypes {

	TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY", "Name should start with a capital");

	public final String id;
	public final String description;

	TestStepContainerIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}
}
