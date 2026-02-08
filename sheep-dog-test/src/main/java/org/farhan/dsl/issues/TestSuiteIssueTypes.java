package org.farhan.dsl.issues;

/**
 * Enum constants for validation error types.
 * <p>
 * Separates error type definitions from validation logic, providing stable
 * identifiers for detector-resolver coordination.
 * </p>
 */
public enum TestSuiteIssueTypes {

	/**
	 * Defines a validation error type with unique identifier and user-facing
	 * description.
	 */
	TEST_SUITE_NAME_ONLY("TEST_SUITE_NAME_ONLY", "Name should start with a capital");

	/**
	 * Unique identifier matching the enum name, used to link detectors with
	 * resolvers.
	 */
	public final String id;

	/**
	 * Human-readable error message displayed to users when validation fails.
	 */
	public final String description;

	TestSuiteIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}
}
