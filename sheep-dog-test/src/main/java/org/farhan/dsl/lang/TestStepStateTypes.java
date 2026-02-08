package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum TestStepStateTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	IS("is", "Maps to setter method"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	ISNT("isn't", "Maps to setter method but used to remove something"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	WILL_BE("will be", "Maps to assertion method"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	WONT_BE("won't be", "Maps to assertion method for negative testing");

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
	TestStepStateTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}