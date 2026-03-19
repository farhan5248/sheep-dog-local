package org.farhan.dsl.grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitionRefFragments {

    public static String getAll(String text) {
        return getGroup("^((?:is|isn't|will be|won't be)(?:\\s+.*)?)$", text.trim(), 1);
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

}
