package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum StepObjectRefObjectVertexTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	FILE("file", "Any sort of file"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	PAGE("page", "Web page"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	RESPONSE("response", "Web service response"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	DIALOG("dialog", "Window dialog box"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	DIRECTORY("directory", "File directory"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	POPUP("popup", "List of options for quickfix or content proposal"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	ANNOTATION("annotation", "Visual indicator for error or warning messages"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	HOVER("hover", "Popup displaying information on mouse hover"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	TOOLTIP("tooltip", "Small popup displaying descriptive text");

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
	StepObjectRefObjectVertexTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}