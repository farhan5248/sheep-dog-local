package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepObjectRefFragments {

    private static final String COMPONENT_NAME = "( [^/]+)";
    private static final String COMPONENT_TYPE = getRegexFromTypes(StepObjectRefComponentTypes.values());
    private static final String COMPONENT = "(" + COMPONENT_NAME + COMPONENT_TYPE + ")";
    private static final String OBJECT_TYPE = getRegexFromTypes(StepObjectRefObjectEdgeTypes.values(),
            StepObjectRefObjectVertexTypes.values());
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
        return getObjectTypeIfInEnum(text, StepObjectRefObjectEdgeTypes.values());
    }

    public static String getObjectName(String text) {
        return getGroup("^(The" + COMPONENT + "?" + OBJECT + "?)", text, 6);
    }

    public static String getObjectType(String text) {
        return getGroup("^(The" + COMPONENT + "?" + OBJECT + "?)", text, 7);
    }

    public static String getObjectVertexType(String text) {
        return getObjectTypeIfInEnum(text, StepObjectRefObjectVertexTypes.values());
    }

    private static String getObjectTypeIfInEnum(String text, Enum<?>[] enumValues) {
        String objectType = getObjectType(text);
        for (Enum<?> e : enumValues) {
            if (e instanceof StepObjectRefObjectEdgeTypes) {
                if (((StepObjectRefObjectEdgeTypes) e).value.equals(objectType)) {
                    return objectType;
                }
            } else if (e instanceof StepObjectRefObjectVertexTypes) {
                if (((StepObjectRefObjectVertexTypes) e).value.equals(objectType)) {
                    return objectType;
                }
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

    private static String getRegexFromTypes(Enum<?>[]... enumArrays) {
        String regex = "(";
        for (Enum<?>[] enumValues : enumArrays) {
            for (Enum<?> enumValue : enumValues) {
                if (enumValue instanceof StepObjectRefComponentTypes) {
                    regex += " " + ((StepObjectRefComponentTypes) enumValue).value + "|";
                } else if (enumValue instanceof StepObjectRefObjectEdgeTypes) {
                    regex += " " + ((StepObjectRefObjectEdgeTypes) enumValue).value + "|";
                } else if (enumValue instanceof StepObjectRefObjectVertexTypes) {
                    regex += " " + ((StepObjectRefObjectVertexTypes) enumValue).value + "|";
                }
            }
        }
        return regex.replaceAll("\\|$", ")");
    }
}
