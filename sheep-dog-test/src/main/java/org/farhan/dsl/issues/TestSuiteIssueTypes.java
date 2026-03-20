package org.farhan.dsl.issues;

/**
 * Validation issue types for test suite grammar elements.
 * <p>
 * Separates issue definitions from validation logic, enabling consistent error
 * messages across validators.
 * </p>
 */
public enum TestSuiteIssueTypes {

	TEST_SUITE_NAME_ONLY("TEST_SUITE_NAME_ONLY",
			"Name should start with a capital");

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
	TestSuiteIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}

}
