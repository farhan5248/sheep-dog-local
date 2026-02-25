package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum StepObjectRefObjectEdgeTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	REQUEST("request", "Web-service request"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	GOAL("goal", "Maven plugin goal"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	JOB("job", "EOD or ETL batchjob"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	ACTION("action", "Eclipse plugin action");

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
	StepObjectRefObjectEdgeTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}