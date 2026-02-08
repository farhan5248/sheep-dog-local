package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum TestStepAttachmentTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	WITH("with", "Used to specify plugin parameters"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	AS_FOLLOWS("as follows", "Used to specify data on a page or in a file");

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
	TestStepAttachmentTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}
