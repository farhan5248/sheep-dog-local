package org.farhan.dsl.grammar;

public enum StepObjectRefObjectEdgeTypes {

    REQUEST("request", "Web-service request"),
    GOAL("goal", "Maven plugin goal"),
    ACTION("action", "Eclipse plugin action"),
    JOB("job", "EOD or ETL batchjob");

    public final String value;
    public final String description;

    StepObjectRefObjectEdgeTypes(String value, String description) {
        this.value = value;
        this.description = description;
    }

}
