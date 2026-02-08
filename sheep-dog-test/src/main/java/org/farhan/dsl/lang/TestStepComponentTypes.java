package org.farhan.dsl.lang;

/**
 * Enum constants for test step keyword patterns.
 * <p>
 * Separates keyword definitions from parsing logic, enabling centralized
 * maintenance of domain vocabulary.
 * </p>
 */
public enum TestStepComponentTypes {

	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	APPLICATION("application", "GUI web application"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	SERVICE("service", "RESTful or SOAP webservice"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	PLUGIN("plugin", "Maven or Eclipse plugin"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	BATCHJOB("batchjob", "EOD or ETL batchjob"),
	/**
	 * Defines a keyword constant with associated value and description for test step
	 * matching.
	 */
	PROJECT("project", "Collection of files such as a Maven project");

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
	TestStepComponentTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}