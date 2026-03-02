package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    private static final String OBJECT_TYPE = buildObjectTypeRegex();
    private static final String PART_TYPE = buildPartTypeRegex();
    private static final String STATE_TYPE = buildStateTypeRegex();

    // Pattern: ^\s*[^/]+ OBJECT_TYPE (PART_DESC) PART_TYPE STATE_TYPE (STATE_DESC)
    // Group 1: OBJECT_TYPE, Group 2: PART_DESC, Group 3: PART_TYPE,
    // Group 4: STATE_TYPE, Group 5: STATE_DESC
    private static final String FULL_PATTERN =
            "^\\s*[^/]+" + OBJECT_TYPE + "( .+)" + PART_TYPE + STATE_TYPE + "( .*)";

    // Pattern for steps with state but no part: ^\s*[^/]+ OBJECT_TYPE STATE_TYPE (STATE_DESC)
    // Group 1: OBJECT_TYPE, Group 2: STATE_TYPE, Group 3: STATE_DESC
    private static final String STATE_PATTERN =
            "^\\s*[^/]+" + OBJECT_TYPE + STATE_TYPE + "( .*)";

    public static String getAll(String text) {
        return getGroup(FULL_PATTERN, text, 0);
    }

    public static String getPart(String text) {
        String desc = getPartDesc(text);
        String type = getPartType(text);
        if (!desc.isEmpty() && !type.isEmpty()) {
            return desc + " " + type;
        }
        return "";
    }

    public static String getPartDesc(String text) {
        return getGroup(FULL_PATTERN, text, 2);
    }

    public static String getPartType(String text) {
        return getGroup(FULL_PATTERN, text, 3);
    }

    public static String getState(String text) {
        String type = getStateType(text);
        String desc = getStateDesc(text);
        if (!type.isEmpty()) {
            return desc.isEmpty() ? type : type + " " + desc;
        }
        return "";
    }

    public static String getStateDesc(String text) {
        String stateType = getGroup(FULL_PATTERN, text, 4);
        return stateType.isEmpty() ? getGroup(STATE_PATTERN, text, 3) : getGroup(FULL_PATTERN, text, 5);
    }

    public static String getStateType(String text) {
        String result = getGroup(FULL_PATTERN, text, 4);
        return result.isEmpty() ? getGroup(STATE_PATTERN, text, 2) : result;
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
        for (StepObjectRefObjectVertexTypes t : StepObjectRefObjectVertexTypes.values()) {
            regex += " " + t.value + "|";
        }
        for (StepObjectRefObjectEdgeTypes t : StepObjectRefObjectEdgeTypes.values()) {
            regex += " " + t.value + "|";
        }
        return regex.replaceAll("\\|$", ")");
    }

    private static String buildPartTypeRegex() {
        String regex = "(";
        for (StepDefinitionRefPartTypes t : StepDefinitionRefPartTypes.values()) {
            regex += " " + t.value + "|";
        }
        return regex.replaceAll("\\|$", ")");
    }

    private static String buildStateTypeRegex() {
        String regex = "(";
        for (StepDefinitionRefStateTypes t : StepDefinitionRefStateTypes.values()) {
            regex += " " + t.value + "|";
        }
        return regex.replaceAll("\\|$", ")");
    }
}
