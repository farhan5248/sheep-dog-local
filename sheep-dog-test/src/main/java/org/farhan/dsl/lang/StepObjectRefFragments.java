package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepObjectRefFragments {

    private static final String COMPONENT_NAME = "( " + "[^/]" + "+)";
    private static final String COMPONENT_TYPE = getRegexFromTypes(StepObjectRefComponentTypes.values());
    private static final String COMPONENT = "(" + COMPONENT_NAME + COMPONENT_TYPE + ")";
    private static final String OBJECT_NAME = "( .+)";
    private static final String OBJECT_EDGE_TYPE = getRegexFromTypes(StepObjectRefObjectEdgeTypes.values());
    private static final String OBJECT_VERTEX_TYPE = getRegexFromTypes(StepObjectRefObjectVertexTypes.values());
    private static final String OBJECT_TYPE = "(" + OBJECT_VERTEX_TYPE + "|" + OBJECT_EDGE_TYPE + ")";
    private static final String OBJECT = "(" + OBJECT_NAME + OBJECT_TYPE + ")";
    private static final String STEP_OBJECT_REF = "^(The" + COMPONENT + "?" + OBJECT + ")";

    /**
     * Extracts the complete matched text from formatted input, returning the
     * entire reference as a single string for full pattern validation or
     * processing.
     *
     * @param text the text to parse
     * @return the step object name portion
     */
    public static String getAll(String text) {
        return getGroup(STEP_OBJECT_REF, text, 0);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the component portion
     */
    public static String getComponent(String text) {
        return getGroup("^(The" + StepObjectRefFragments.COMPONENT + "?" + ")", text, 2);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the component name portion
     */
    public static String getComponentName(String text) {
        return getGroup("^(The" + StepObjectRefFragments.COMPONENT + "?" + ")", text, 3);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the component type portion
     */
    public static String getComponentType(String text) {
        return getGroup("^(The" + StepObjectRefFragments.COMPONENT + "?" + ")", text, 4);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the object portion
     */
    public static String getObject(String text) {
        return getGroup(STEP_OBJECT_REF, text, 5);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the object edge type portion
     */
    public static String getObjectEdgeType(String text) {
        return getGroup(STEP_OBJECT_REF, text, 9);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the object name portion
     */
    public static String getObjectName(String text) {
        return getGroup(STEP_OBJECT_REF, text, 6);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the object type portion
     */
    public static String getObjectType(String text) {
        return getGroup(STEP_OBJECT_REF, text, 7);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the object vertex type portion
     */
    public static String getObjectVertexType(String text) {
        return getGroup(STEP_OBJECT_REF, text, 8);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to check
     * @return true if the text contains an edge object type, false otherwise
     */
    public static boolean isObjectEdgeType(String text) {
        return !getObjectEdgeType(text).isEmpty();
    }

    public static boolean isObjectVertexType(String text) {
        return !getObjectVertexType(text).isEmpty();
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param regex the regular expression pattern
     * @param text  the text to match against
     * @param group the group number to extract
     * @return the matched group text, trimmed, or empty string if no match
     */
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

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param enumValues array of enum values to convert to regex
     * @return regex pattern string with alternation of all enum values
     */
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
