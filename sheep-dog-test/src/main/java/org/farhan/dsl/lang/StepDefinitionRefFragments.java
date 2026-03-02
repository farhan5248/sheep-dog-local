package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    private static final String PART_TYPE = getRegexFromTypes(StepDefinitionRefPartTypes.values());
    private static final String PART_NAME = "(.+)";
    private static final String PART = "(" + PART_NAME + " " + PART_TYPE + ")";

    private static final String STATE_TYPE = getRegexFromTypes(StepDefinitionRefStateTypes.values());
    private static final String STATE_DESC = "(.+)";
    private static final String STATE = "(" + STATE_TYPE + " " + STATE_DESC + ")";

    public static String getAll(String text) {
        return getGroup("^(" + PART + " " + STATE + ")$", text, 1);
    }

    public static String getPart(String text) {
        return getGroup("^(" + PART + " " + STATE + ")$", text, 2);
    }

    public static String getPartDesc(String text) {
        return getGroup("^(" + PART + " " + STATE + ")$", text, 3);
    }

    public static String getPartType(String text) {
        return getGroup("^(" + PART + " " + STATE + ")$", text, 4);
    }

    public static String getState(String text) {
        String result = getGroup("^(" + PART + " " + STATE + ")$", text, 5);
        if (!result.isEmpty()) return result;
        return getGroup("^(" + STATE + ")$", text, 1);
    }

    public static String getStateType(String text) {
        String result = getGroup("^(" + PART + " " + STATE + ")$", text, 6);
        if (!result.isEmpty()) return result;
        return getGroup("^(" + STATE + ")$", text, 3);
    }

    public static String getStateDesc(String text) {
        String result = getGroup("^(" + PART + " " + STATE + ")$", text, 7);
        if (!result.isEmpty()) return result;
        return getGroup("^(" + STATE + ")$", text, 4);
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
