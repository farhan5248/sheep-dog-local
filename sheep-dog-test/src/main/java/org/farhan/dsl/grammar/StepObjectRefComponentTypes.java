package org.farhan.dsl.grammar;

public enum StepObjectRefComponentTypes {

    APPLICATION("application", "GUI web application"),
    PROJECT("project", "Collection of files such as a Maven project"),
    SERVICE("service", "RESTful or SOAP webservice"),
    BATCHJOB("batchjob", "EOD or ETL batchjob"),
    PLUGIN("plugin", "Maven or Eclipse plugin");

    public final String type;
    public final String description;

    StepObjectRefComponentTypes(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static String getDescriptionFor(String type) {
        for (StepObjectRefComponentTypes value : values()) {
            if (value.type.equals(type)) {
                return value.description;
            }
        }
        return "";
    }
}
