package org.farhan.dsl.grammar;

public enum TestStepContainerIssueTypes {
	TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY", "Name should start with a capital"),
	TEST_STEP_CONTAINER_TEST_STEP_LIST_ONLY("TEST_STEP_CONTAINER_TEST_STEP_LIST_ONLY", "The first step must have a component");

	public final String id;
	public final String description;

	TestStepContainerIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
