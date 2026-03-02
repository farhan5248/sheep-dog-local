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
	ANNOTATION("annotation", "Inline annotation element"),
	DIALOG("dialog", "Modal dialog element"),
	DIRECTORY("directory", "Any sort of directory"),
	FILE("file", "Any sort of file"),
	HOVER("hover", "Hover tooltip element"),
	PAGE("page", "Web or UI page"),
	POPUP("popup", "Popup or dropdown element"),
	RESPONSE("response", "Response data or message"),
	TOOLTIP("tooltip", "Status tooltip element");

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