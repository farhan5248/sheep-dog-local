package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum StepDefinitionRefStateTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	IS("is", "Maps to setter method"),
	ISN_T("isn't", "Maps to negative setter method"),
	WILL_BE("will be", "Maps to future positive setter method"),
	WONT_BE("won't be", "Maps to future negative setter method");

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
	StepDefinitionRefStateTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}