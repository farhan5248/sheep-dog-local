package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepObjectRefFragments {

    private static final String COMPONENT_NAME = "( [^/]+)";
    private static final String COMPONENT_TYPE = getRegexFromTypes(StepObjectRefComponentTypes.values());
    private static final String COMPONENT = "(" + COMPONENT_NAME + COMPONENT_TYPE + ")";
    private static final String OBJECT_TYPE = buildObjectTypeRegex();
    private static final String OBJECT_NAME = "( [^/]+)";
    private static final String OBJECT = "(" + OBJECT_NAME + OBJECT_TYPE + ")";

    public static String getAll(String text) {
        return getGroup("^(The" + COMPONENT + "?" + OBJECT + "?)", text, 1);
    }

    public static String getComponent(String text) {
        return getGroup("^(The" + COMPONENT + "?)", text, 2);
    }

    public static String getComponentName(String text) {
        return getGroup("^(The" + COMPONENT + "?)", text, 3);
    }

    public static String getComponentType(String text) {
        return getGroup("^(The" + COMPONENT + "?)", text, 4);
    }

    public static String getObject(String text) {
        return getGroup("^(The" + COMPONENT + "?" + OBJECT + "?)", text, 5);
    }

    public static String getObjectEdgeType(String text) {
        String objectType = getObjectType(text);
        for (StepObjectRefObjectEdgeTypes e : StepObjectRefObjectEdgeTypes.values()) {
            if (e.value.equals(objectType)) {
                return objectType;
            }
        }
        return null;
    }

    public static String getObjectName(String text) {
        return getGroup("^(The" + COMPONENT + "?" + OBJECT + "?)", text, 6);
    }

    public static String getObjectType(String text) {
        return getGroup("^(The" + COMPONENT + "?" + OBJECT + "?)", text, 7);
    }

    public static String getObjectVertexType(String text) {
        String objectType = getObjectType(text);
        for (StepObjectRefObjectVertexTypes v : StepObjectRefObjectVertexTypes.values()) {
            if (v.value.equals(objectType)) {
                return objectType;
            }
        }
        return null;
    }

    private static String getGroup(String regex, String text, int group) {
        Matcher m = Pattern.compile(regex).matcher(text);
        if (m.find()) {
            String temp = m.group(group);
            if (temp != null) {
                return temp.trim();
            } else {
                return "";
            }
        }
        return "";
    }

    private static String buildObjectTypeRegex() {
        String regex = "(";
        for (StepObjectRefObjectEdgeTypes e : StepObjectRefObjectEdgeTypes.values()) {
            regex += " " + e.value + "|";
        }
        for (StepObjectRefObjectVertexTypes v : StepObjectRefObjectVertexTypes.values()) {
            regex += " " + v.value + "|";
        }
        return regex.replaceAll("\\|$", ")");
    }

    private static String getRegexFromTypes(Enum<?>[] enumValues) {
        String regex = "(";
        for (Enum<?> enumValue : enumValues) {
            if (enumValue instanceof StepObjectRefComponentTypes) {
                regex += " " + ((StepObjectRefComponentTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepObjectRefObjectEdgeTypes) {
                regex += " " + ((StepObjectRefObjectEdgeTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepObjectRefObjectVertexTypes) {
                regex += " " + ((StepObjectRefObjectVertexTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }
}
