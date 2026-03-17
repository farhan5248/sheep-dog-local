package org.farhan.dsl.grammar;

public enum StepObjectRefObjectEdgeTypes {

    REQUEST("request", "Web-service request"),
    GOAL("goal", "Maven plugin goal"),
    ACTION("action", "Eclipse plugin action"),
    JOB("job", "EOD or ETL batchjob");

    public final String type;
    public final String description;

    StepObjectRefObjectEdgeTypes(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static String getDescriptionFor(String type) {
        for (StepObjectRefObjectEdgeTypes value : values()) {
            if (value.type.equals(type)) {
                return value.description;
            }
        }
        return "";
    }
}
