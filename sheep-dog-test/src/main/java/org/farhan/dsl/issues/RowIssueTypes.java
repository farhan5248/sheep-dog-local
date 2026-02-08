package org.farhan.dsl.issues;

/**
 * Enum constants for validation error types.
 * <p>
 * Separates error type definitions from validation logic, providing stable
 * identifiers for detector-resolver coordination.
 * </p>
 */
public enum RowIssueTypes {

	/**
	 * Defines a validation error type with unique identifier and user-facing
	 * description.
	 */
	ROW_CELL_LIST_WORKSPACE("ROW_CELL_LIST_WORKSPACE", "The step parameters don't exist for the step definition");

	/**
	 * Unique identifier matching the enum name, used to link detectors with
	 * resolvers.
	 */
	public final String id;

	/**
	 * Human-readable error message displayed to users when validation fails.
	 */
	public final String description;

	RowIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}
}