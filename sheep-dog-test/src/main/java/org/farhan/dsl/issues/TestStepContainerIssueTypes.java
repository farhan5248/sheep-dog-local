package org.farhan.dsl.issues;

/**
 * Enum constants for validation error types.
 * <p>
 * Separates error type definitions from validation logic, providing stable
 * identifiers for detector-resolver coordination.
 * </p>
 */
public enum TestStepContainerIssueTypes {

	/**
	 * Defines a validation error type with unique identifier and user-facing
	 * description.
	 */
	TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY", "Name should start with a capital"),

	/**
	 * Defines a validation error type with unique identifier and user-facing
	 * description.
	 */
	TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE("TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE",
			"The first step must have a component");

	/**
	 * Unique identifier matching the enum name, used to link detectors with
	 * resolvers.
	 */
	public final String id;

	/**
	 * Human-readable error message displayed to users when validation fails.
	 */
	public final String description;

	TestStepContainerIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}
}
