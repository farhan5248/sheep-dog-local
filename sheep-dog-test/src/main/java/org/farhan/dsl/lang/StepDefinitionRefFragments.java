package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    private static final String PART_TYPE = getRegexFromTypes(StepDefinitionRefPartTypes.values());
    private static final String PART_DESC = "(.+)";
    private static final String PART = "(" + PART_DESC + " " + PART_TYPE + ")";
    private static final String STATE_TYPE = getRegexFromTypes(StepDefinitionRefStateTypes.values());
    private static final String STATE_DESC = "(.+)";
    private static final String STATE = "(" + STATE_TYPE + " " + STATE_DESC + ")";
    private static final String STEP_DEFINITION_REF = "^" + PART + " " + STATE + "$";
    private static final String STATE_ONLY = "^" + STATE + "$";

    public static String getAll(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 0);
    }

    public static String getPart(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 1);
    }

    public static String getPartDesc(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 2);
    }

    public static String getPartType(String text) {
        return getGroup(STEP_DEFINITION_REF, text, 3);
    }

    public static String getState(String text) {
        return getStateGroup(text, 4, 1);
    }

    public static String getStateType(String text) {
        return getStateGroup(text, 5, 2);
    }

    public static String getStateDesc(String text) {
        return getStateGroup(text, 6, 3);
    }

    private static String getStateGroup(String text, int refGroup, int stateOnlyGroup) {
        String result = getGroup(STEP_DEFINITION_REF, text, refGroup);
        if (result.isEmpty()) {
            result = getGroup(STATE_ONLY, text, stateOnlyGroup);
        }
        return result;
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
            if (enumValue instanceof StepDefinitionRefPartTypes) {
                regex += ((StepDefinitionRefPartTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepDefinitionRefStateTypes) {
                regex += ((StepDefinitionRefStateTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }
}
