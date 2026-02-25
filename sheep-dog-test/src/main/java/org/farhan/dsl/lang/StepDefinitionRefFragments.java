package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {
    private static final String PART_DESC = "(.+)";
    private static final String PART_TYPE = getRegexFromTypes(StepDefinitionRefPartTypes.values());
    private static final String PART = "(" + PART_DESC + " " + PART_TYPE + " )";
    private static final String STATE_DESC = "(.+)";
    private static final String STATE_TYPE = getRegexFromTypes(StepDefinitionRefStateTypes.values());
    private static final String STATE = "(" + STATE_TYPE + " " + STATE_DESC + ")";
    private static final String STEP_DEFINITION_REF = "(" + PART + "?" + STATE + ")";

    /**
     * Extracts the complete matched text from formatted input, returning the
     * entire reference as a single string for full pattern validation or
     * processing.
     *
     * @param text the text to parse
     * @return the step definition name portion
     */
    public static String getAll(String text) {
        return getGroup(StepDefinitionRefFragments.STEP_DEFINITION_REF, text, 0);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the part portion
     */
    public static String getPart(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 2);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the part description portion
     */
    public static String getPartDesc(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 3);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the part type portion
     */
    public static String getPartType(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 4);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the state portion
     */
    public static String getState(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 5);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the state description portion
     */
    public static String getStateDesc(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 6);
    }

    /**
     * Extracts a specific named fragment from formatted text using predefined
     * regex patterns and group positions.
     *
     * @param text the text to parse
     * @return the state type portion
     */
    public static String getStateType(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 7);
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
            if (enumValue instanceof StepDefinitionRefPartTypes) {
                regex += ((StepDefinitionRefPartTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepDefinitionRefStateTypes) {
                regex += ((StepDefinitionRefStateTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }

}
