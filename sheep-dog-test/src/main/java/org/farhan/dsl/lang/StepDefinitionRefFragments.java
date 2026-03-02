package org.farhan.dsl.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    private static final String PART_DESC = "(.+?)";
    private static final String PART_TYPE = "( \\w+)";
    private static final String PART = "(" + PART_DESC + PART_TYPE + ")";

    private static final String STATE_DESC = getRegexFromTypes(StepDefinitionRefStateTypes.values());
    private static final String STATE_TYPE = "( \\w+)";
    private static final String STATE = "(" + STATE_DESC + STATE_TYPE + ")";

    // STATE-ONLY pattern: ^((is|isn't|will be|won't be) (.+))$
    // Group 1: full State
    // Group 2: StateType keyword (e.g. "is", "isn't", "will be", "won't be")
    // Group 3: StateDesc (the remainder, e.g. "created as follows")
    private static final String STATE_ONLY_REGEX = buildStateOnlyPattern();

    // Full pattern: ^(PART STATE)$
    // = ^(((.+?)( \w+))(( is| isn't| will be| won't be)( \w+)))$
    // Group 1: full StepDefinitionRef
    // Group 2: Part
    // Group 3: PartDesc
    // Group 4: PartType (leading space, trimmed when returned)
    // Group 5: State (leading space, trimmed when returned)
    // Group 6: StateDesc keyword (leading space, trimmed when returned)
    // Group 7: StateType word (leading space, trimmed when returned)

    public static String getAll(String text) {
        return getGroup("^(" + PART + STATE + ")$", text, 1);
    }

    public static String getPart(String text) {
        return getGroup("^(" + PART + STATE + ")$", text, 2);
    }

    public static String getPartDesc(String text) {
        return getGroup("^(" + PART + STATE + ")$", text, 3);
    }

    public static String getPartType(String text) {
        return getGroup("^(" + PART + STATE + ")$", text, 4);
    }

    public static String getState(String text) {
        return getGroup(STATE_ONLY_REGEX, text, 1);
    }

    public static String getStateDesc(String text) {
        return getGroup(STATE_ONLY_REGEX, text, 3);
    }

    public static String getStateType(String text) {
        return getGroup(STATE_ONLY_REGEX, text, 2);
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

    private static String buildStateOnlyPattern() {
        String types = "";
        for (StepDefinitionRefStateTypes t : StepDefinitionRefStateTypes.values()) {
            types += t.value + "|";
        }
        types = types.replaceAll("\\|$", "");
        return "^((" + types + ") (.+))$";
    }

    private static String getRegexFromTypes(Enum<?>[] enumValues) {
        String regex = "(";
        for (Enum<?> enumValue : enumValues) {
            if (enumValue instanceof StepDefinitionRefStateTypes) {
                regex += " " + ((StepDefinitionRefStateTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepDefinitionRefPartTypes) {
                regex += " " + ((StepDefinitionRefPartTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }
}
