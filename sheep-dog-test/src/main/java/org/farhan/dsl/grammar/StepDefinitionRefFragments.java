package org.farhan.dsl.grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    private static final String PART_TYPES =
            "type|language|assignment|fragment|scope|node";

    private static final Pattern PART_PATTERN = Pattern.compile(
            "(\\S+)\\s+(" + PART_TYPES + ")(?=\\s+(?:is|are|was|were|will|can|does|do|has|have|had|should|would|could|must|may|might)\\b|$)");

    private static final Pattern STATE_PATTERN = Pattern.compile(
            "(won't be|will be|isn't|is)\\s+(.+)");

    public static String getAll(String text) {
        if (text == null || text.isBlank()) {
            return "";
        }
        return text.strip();
    }

    public static String getPart(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = PART_PATTERN.matcher(text);
        String result = "";
        while (matcher.find()) {
            result = matcher.group(1) + " " + matcher.group(2);
        }
        return result;
    }

    public static String getPartDesc(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = PART_PATTERN.matcher(text);
        String result = "";
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    public static String getPartType(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = PART_PATTERN.matcher(text);
        String result = "";
        while (matcher.find()) {
            result = matcher.group(2);
        }
        return result;
    }

    public static String getPartTypeDesc(String text) {
        String type = getPartType(text);
        for (StepDefinitionRefPartTypes e : StepDefinitionRefPartTypes.values()) {
            if (e.value.equals(type)) {
                return e.description;
            }
        }
        return "";
    }

    public static String getState(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = STATE_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1) + " " + matcher.group(2);
        }
        return "";
    }

    public static String getStateDesc(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = STATE_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return "";
    }

    public static String getStateType(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = STATE_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static String getStateTypeDesc(String text) {
        String stateType = getStateType(text);
        for (StepDefinitionRefStateTypes e : StepDefinitionRefStateTypes.values()) {
            if (e.value.equals(stateType)) {
                return e.description;
            }
        }
        return "";
    }

}
