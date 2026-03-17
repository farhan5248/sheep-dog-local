package org.farhan.dsl.grammar;

public enum StepObjectRefComponentTypes {

    APPLICATION("application", "GUI web application"),
    PROJECT("project", "Collection of files such as a Maven project"),
    SERVICE("service", "RESTful or SOAP webservice"),
    BATCHJOB("batchjob", "EOD or ETL batchjob"),
    PLUGIN("plugin", "Maven or Eclipse plugin");

    public final String value;
    public final String description;

    StepObjectRefComponentTypes(String value, String description) {
        this.value = value;
        this.description = description;
    }

}
