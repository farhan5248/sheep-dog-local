package org.farhan.dsl.grammar;

public class StepDefinitionRefFragments {

    public static String getAll(String text) {
        if (text == null || text.isBlank()) {
            return "";
        }
        return text.strip();
    }

}
