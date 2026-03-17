package org.farhan.dsl.grammar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseTodoFragments {

    private static final Pattern TODO_PATTERN = Pattern.compile("TODO\\s+(.+)");

    public static String getTodoType(String text) {
        if (text != null && text.contains("TODO")) {
            return "TODO";
        }
        return "";
    }

    public static String getTodoDesc(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        Matcher matcher = TODO_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }
}
