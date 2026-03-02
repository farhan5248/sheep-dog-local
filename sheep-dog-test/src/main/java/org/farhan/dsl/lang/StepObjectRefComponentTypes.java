package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum StepObjectRefComponentTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	APPLICATION("application", "GUI web application"),
	PROJECT("project", "Development project"),
	SERVICE("service", "Microservice or backend service"),
	BATCHJOB("batchjob", "Scheduled batch job"),
	PLUGIN("plugin", "IDE or framework plugin");

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
	StepObjectRefComponentTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}