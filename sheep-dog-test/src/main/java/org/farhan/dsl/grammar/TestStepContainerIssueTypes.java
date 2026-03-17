package org.farhan.dsl.grammar;

public enum TestStepContainerIssueTypes {

	TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY", "Name should start with a capital");

	public final String id;
	public final String description;

	TestStepContainerIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
