package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepObjectRefFragments {

    private static final String COMPONENT_TYPE = getRegexFromTypes(StepObjectRefComponentTypes.values());
    private static final String COMPONENT_NAME = "([\\w-]+)";
    static final String COMPONENT = "( " + COMPONENT_NAME + " " + COMPONENT_TYPE + ")";

    private static final String OBJECT_TYPE = getObjectTypeRegex();
    private static final String OBJECT_NAME = "(.+)";
    static final String OBJECT = "( " + OBJECT_NAME + " " + OBJECT_TYPE + ")";

    private static final String STEP_OBJECT_REF = "^The" + COMPONENT + "?" + OBJECT + "?";

    public static String getAll(String text) {
        return getGroup(STEP_OBJECT_REF, text, 0);
    }

    public static String getComponent(String text) {
        return getGroup(STEP_OBJECT_REF, text, 1);
    }

    public static String getComponentName(String text) {
        return getGroup(STEP_OBJECT_REF, text, 2);
    }

    public static String getComponentType(String text) {
        return getGroup(STEP_OBJECT_REF, text, 3);
    }

    public static String getObject(String text) {
        return getGroup(STEP_OBJECT_REF, text, 4);
    }

    public static String getObjectEdgeType(String text) {
        String objectType = getObjectType(text);
        if (!objectType.isEmpty()) {
            for (StepObjectRefObjectEdgeTypes t : StepObjectRefObjectEdgeTypes.values()) {
                if (t.value.equals(objectType)) {
                    return objectType;
                }
            }
        }
        return "";
    }

    public static String getObjectName(String text) {
        return getGroup(STEP_OBJECT_REF, text, 5);
    }

    public static String getObjectType(String text) {
        return getGroup(STEP_OBJECT_REF, text, 6);
    }

    public static String getObjectVertexType(String text) {
        String objectType = getObjectType(text);
        if (!objectType.isEmpty()) {
            for (StepObjectRefObjectVertexTypes t : StepObjectRefObjectVertexTypes.values()) {
                if (t.value.equals(objectType)) {
                    return objectType;
                }
            }
        }
        return "";
    }

    public static boolean isObjectEdgeType(String text) {
        return !getObjectEdgeType(text).isEmpty();
    }

    public static boolean isObjectVertexType(String text) {
        return !getObjectVertexType(text).isEmpty();
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

    private static String getRegexFromTypes(Enum<?>[] enumValues) {
        String regex = "(";
        for (Enum<?> enumValue : enumValues) {
            if (enumValue instanceof StepObjectRefComponentTypes) {
                regex += ((StepObjectRefComponentTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepObjectRefObjectVertexTypes) {
                regex += ((StepObjectRefObjectVertexTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepObjectRefObjectEdgeTypes) {
                regex += ((StepObjectRefObjectEdgeTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }

    private static String getObjectTypeRegex() {
        String regex = "(";
        for (StepObjectRefObjectVertexTypes t : StepObjectRefObjectVertexTypes.values()) {
            regex += t.value + "|";
        }
        for (StepObjectRefObjectEdgeTypes t : StepObjectRefObjectEdgeTypes.values()) {
            regex += t.value + "|";
        }
        return regex.replaceAll("\\|$", ")");
    }
}
