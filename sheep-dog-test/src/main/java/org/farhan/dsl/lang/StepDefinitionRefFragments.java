package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    private static final String PART_TYPE = getRegexFromPartTypes(StepDefinitionRefPartTypes.values());
    private static final String PART_NAME = "(.+)";
    private static final String PART = "(" + PART_NAME + " " + PART_TYPE + ")";

    private static final String STATE_TYPE = getRegexFromStateTypes(StepDefinitionRefStateTypes.values());
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

    private static String getRegexFromPartTypes(StepDefinitionRefPartTypes[] enumValues) {
        String regex = "(";
        for (StepDefinitionRefPartTypes enumValue : enumValues) {
            regex += enumValue.value + "|";
        }
        return regex.replaceAll("\\|$", ")");
    }

    private static String getRegexFromStateTypes(StepDefinitionRefStateTypes[] enumValues) {
        String regex = "(";
        for (StepDefinitionRefStateTypes enumValue : enumValues) {
            regex += enumValue.value + "|";
        }
        return regex.replaceAll("\\|$", ")");
    }
}
