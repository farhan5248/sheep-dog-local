package org.farhan.dsl.issues;

/**
 * Validation issue types for row grammar elements.
 * <p>
 * Separates issue definitions from validation logic, enabling consistent error
 * messages across validators.
 * </p>
 */
public enum RowIssueTypes {

	ROW_CELL_LIST_WORKSPACE("ROW_CELL_LIST_WORKSPACE",
			"The step parameters don't exist for the step definition");

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
	RowIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}

}
