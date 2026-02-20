package org.farhan.dsl.issues;

/**
 * Validation issue types for test step container grammar elements.
 * <p>
 * Separates issue definitions from validation logic, enabling consistent error
 * messages across validators.
 * </p>
 */
public enum TestStepContainerIssueTypes {

	TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY",
			"Name should start with a capital"),

	TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE("TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE",
			"The first step must have a component");

	/**
	 * Issue identifier following structured naming pattern.
	 */
	public final String id;

	/**
	 * Human-readable description of the validation issue.
	 */
	public final String description;

	/**
	 * Initializes issue type with identifier and description.
	 *
	 * @param value       the issue identifier
	 * @param description the issue description
	 */
	TestStepContainerIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}

}
