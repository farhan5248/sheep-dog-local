package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum TestStepPartTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	SECTION("section", "Used to specify a part in a document"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	FRAGMENT("fragment", "Used to specify a part in some code"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	TABLE("table", "Table in a document"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	SNIPPET("snippet", "Same as fragment"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	LIST("list", "Same as table");

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