package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    private static final String OBJECT_VERTEX_TYPE = getRegexFromTypes(StepObjectRefObjectVertexTypes.values());
    private static final String OBJECT_EDGE_TYPE = getRegexFromTypes(StepObjectRefObjectEdgeTypes.values());
    private static final String OBJECT_TYPE = OBJECT_VERTEX_TYPE.substring(0, OBJECT_VERTEX_TYPE.length() - 1) + "|"
            + OBJECT_EDGE_TYPE.substring(1);
    private static final String PART_TYPE = getRegexFromTypes(StepDefinitionRefPartTypes.values());
    private static final String STATE_TYPE = getRegexFromTypes(StepDefinitionRefStateTypes.values());

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

    private static String getRegexFromTypes(Enum<?>[] enumValues) {
        String regex = "(";
        for (Enum<?> enumValue : enumValues) {
            if (enumValue instanceof StepObjectRefObjectVertexTypes) {
                regex += " " + ((StepObjectRefObjectVertexTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepObjectRefObjectEdgeTypes) {
                regex += " " + ((StepObjectRefObjectEdgeTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepDefinitionRefPartTypes) {
                regex += " " + ((StepDefinitionRefPartTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepDefinitionRefStateTypes) {
                regex += " " + ((StepDefinitionRefStateTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }
}
