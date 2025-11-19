package org.farhan.dsl.issues;

public enum TestStepContainerIssueTypes {

	TEST_STEP_CONTAINER_NAME("TEST_STEP_CONTAINER_NAME", "Name should start with a capital");

	public final String value;
	public final String description;

	TestStepContainerIssueTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}
