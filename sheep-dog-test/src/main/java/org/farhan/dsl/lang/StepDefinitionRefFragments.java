package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {
    private static final String PART_DESC = "(.+)";
    private static final String PART_TYPE = getRegexFromTypes(TestStepPartTypes.values());
    private static final String PART = "(" + PART_DESC + " " + PART_TYPE + " )";
    private static final String STATE_DESC = "(\\S+)";
    private static final String STATE_TYPE = getRegexFromTypes(TestStepStateTypes.values());
    private static final String STATE = "(" + STATE_TYPE + " " + STATE_DESC + ")";
    private static final String TIME_DESC = "(.+)";
    private static final String TIME_TYPE = getRegexFromTypes(TestStepTimeTypes.values());
    private static final String TIME = "( " + TIME_TYPE + " " + TIME_DESC + ")";
    private static final String ATTACHMENT = "( " + getRegexFromTypes(TestStepAttachmentTypes.values()) + ")";
    private static final String STEP_DEFINITION_REF = "(" + PART + "?" + STATE + TIME + "?" + ATTACHMENT + "?" + ")";

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
            if (enumValue instanceof TestStepAttachmentTypes) {
                regex += ((TestStepAttachmentTypes) enumValue).value + "|";
            } else if (enumValue instanceof TestStepPartTypes) {
                regex += ((TestStepPartTypes) enumValue).value + "|";
            } else if (enumValue instanceof TestStepStateTypes) {
                regex += ((TestStepStateTypes) enumValue).value + "|";
            } else if (enumValue instanceof TestStepTimeTypes) {
                regex += ((TestStepTimeTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
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
     * @param text the text to parse
     * @return the attachment portion
     */
    public static String getAttachment(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 11);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the part portion
     */
    public static String getPart(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 2);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the part description portion
     */
    public static String getPartDesc(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 3);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the part type portion
     */
    public static String getPartType(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 4);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the state portion
     */
    public static String getState(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 5);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the state description portion
     */
    public static String getStateDesc(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 6);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
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
     * @param text the text to parse
     * @return the time portion
     */
    public static String getTime(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 8);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the time type portion
     */
    public static String getTimeType(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 9);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the time description portion
     */
    public static String getTimeDesc(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 10);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param text the text to parse
     * @return the step definition name portion
     */
    public static String getStepDefinitionName(String text) {
        return getGroup(StepDefinitionRefFragments.STEP_DEFINITION_REF, text, 0);
    }

}
