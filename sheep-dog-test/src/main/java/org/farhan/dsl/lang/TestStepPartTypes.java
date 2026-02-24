package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum TestStepPartTypes {

	SECTION("section", "backwards-compatible alias for 'type' to support legacy test steps"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	LANGUAGE("language", "The name of the Xtext grammar/language implementation"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	TYPE("type", "Grammar types (non-terminal rules) defined in the .xtext file"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	ASSIGNMENT("assignment", "Named assignments within grammar rules"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	FRAGMENT("fragment", "Test step regex fragments defining type enumerations"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	SCOPE("scope", "Issue scope levels from TypeIssueTypes enum");

	/**
	 * Stores the lowercase keyword string that appears in actual test step
	 * definitions.
	 */
	public final String value;
	/**
	 * Provides human-readable explanation of the keyword for documentation and UI
	 * display.
	 */
	public final String description;

	/**
	 * Initializes enum constant with keyword value and description for test step
	 * parsing.
	 *
	 * @param value the keyword value
	 * @param description the keyword description
	 */
	TestStepPartTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}