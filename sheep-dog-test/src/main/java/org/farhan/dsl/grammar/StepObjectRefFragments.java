package org.farhan.dsl.grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepObjectRefFragments {

    private static final String OBJECT_TYPE = "( file| page| response| dialog| directory| popup| annotation| hover| tooltip| request| goal| job| action)";

    public static String getAll(String text) {
        return getGroup("^(The .+" + OBJECT_TYPE + ")", text, 1);
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
