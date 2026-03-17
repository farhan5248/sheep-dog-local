package org.farhan.dsl.grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepObjectRefFragments {

    private static final Pattern STEP_OBJECT_PATTERN = Pattern.compile(
            "^(.+?)(?=\\s+(?:is|are|was|were|will|can|does|do|has|have|had|should|would|could|must|may|might)\\b)");

    public static String getAll(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = STEP_OBJECT_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

}
