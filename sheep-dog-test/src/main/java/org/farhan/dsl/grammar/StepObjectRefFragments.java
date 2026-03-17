package org.farhan.dsl.grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepObjectRefFragments {

    private static final Pattern STEP_OBJECT_PATTERN = Pattern.compile(
            "^(.+?)(?=\\s+(?:is|are|was|were|will|can|does|do|has|have|had|should|would|could|must|may|might)\\b)");

    private static final Pattern COMPONENT_PATTERN = Pattern.compile(
            "^The\\s+(\\S+)\\s+(application|project|service|batchjob|plugin)(?:\\s+.*)?$",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern COMPONENT_PREFIX_PATTERN = Pattern.compile(
            "^The\\s+\\S+\\s+(?:application|project|service|batchjob|plugin)\\s+(.+)$",
            Pattern.CASE_INSENSITIVE);

    private static final String OBJECT_TYPES =
            "file|page|response|dialog|directory|request|goal|job|action|popup|annotation|hover|tooltip";

    private static final Pattern OBJECT_TYPE_PATTERN = Pattern.compile(
            "\\b(" + OBJECT_TYPES + ")\\b");

    private static final Pattern OBJECT_NAME_PATTERN = Pattern.compile(
            "^(.*?)\\s*(?:" + OBJECT_TYPES + ")(?:\\s.*)?$");

    public static String getAll(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = STEP_OBJECT_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static String getComponent(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = COMPONENT_PATTERN.matcher(text);
        if (matcher.matches()) {
            return matcher.group(1) + " " + matcher.group(2).toLowerCase();
        }
        return "";
    }

    public static String getComponentName(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = COMPONENT_PATTERN.matcher(text);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return "";
    }

    public static String getComponentType(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = COMPONENT_PATTERN.matcher(text);
        if (matcher.matches()) {
            return matcher.group(2).toLowerCase();
        }
        return "";
    }

    public static String getComponentTypeDesc(String text) {
        String type = getComponentType(text);
        for (StepObjectRefComponentTypes e : StepObjectRefComponentTypes.values()) {
            if (e.value.equals(type)) {
                return e.description;
            }
        }
        return "";
    }

    public static String getObject(String text) {
        String name = getObjectName(text);
        String type = getObjectType(text);
        if (name.isEmpty() && type.isEmpty()) {
            return "";
        }
        return (name + " " + type).trim();
    }

    public static String getObjectName(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        String remainder = stripComponentPrefix(text);
        Matcher matcher = OBJECT_NAME_PATTERN.matcher(remainder);
        if (matcher.matches()) {
            return matcher.group(1).trim();
        }
        return "";
    }

    public static String getObjectTypeDesc(String text) {
        String type = getObjectType(text);
        for (StepObjectRefObjectVertexTypes e : StepObjectRefObjectVertexTypes.values()) {
            if (e.value.equals(type)) {
                return e.description;
            }
        }
        return "";
    }

    public static String getObjectEdgeTypeDesc(String text) {
        String type = getObjectType(text);
        for (StepObjectRefObjectEdgeTypes e : StepObjectRefObjectEdgeTypes.values()) {
            if (e.value.equals(type)) {
                return e.description;
            }
        }
        return "";
    }

    public static String getObjectType(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        String remainder = stripComponentPrefix(text);
        Matcher matcher = OBJECT_TYPE_PATTERN.matcher(remainder);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private static String stripComponentPrefix(String text) {
        Matcher matcher = COMPONENT_PREFIX_PATTERN.matcher(text);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return text;
    }

}
