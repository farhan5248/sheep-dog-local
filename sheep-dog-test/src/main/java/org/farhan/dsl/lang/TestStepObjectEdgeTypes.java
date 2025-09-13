package org.farhan.dsl.lang;

public enum TestStepObjectEdgeTypes {

	REQUEST("request", "Web-service request"),
	GOAL("goal", "Maven plugin goal"),
	JOB("job", "EOD or ETL batchjob"),
	ACTION("action", "Eclipse plugin action");

	public final String value;
	public final String description;

	TestStepObjectEdgeTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}