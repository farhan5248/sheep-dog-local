package org.farhan.dsl.lang;

public enum TestStepComponentTypes {

	APPLICATION("application", "GUI web application"),
	SERVICE("service", "RESTful or SOAP webservice"),
	PLUGIN("plugin", "Maven or Eclipse plugin"),
	BATCHJOB("batchjob", "EOD or ETL batchjob"),
	PROJECT("project", "Collection of files such as a Maven project");

	public final String value;
	public final String description;

	TestStepComponentTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}