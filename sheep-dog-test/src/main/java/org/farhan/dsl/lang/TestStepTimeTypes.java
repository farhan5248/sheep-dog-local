package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum TestStepTimeTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	AT(" at", "Specifies exact time"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	BEFORE(" before", "Specifies time constraint - earlier than"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	AFTER(" after", "Specifies time constraint - later than"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	IN(" in", "Specifies duration or time period"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	ON(" on", "Specifies specific date or time");

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
	TestStepTimeTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}