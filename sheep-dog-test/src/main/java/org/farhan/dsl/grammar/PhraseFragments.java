package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseFragments {

    private static final Pattern TAG_PATTERN = Pattern.compile("@(\\w+)");
    private static final Pattern TODO_PATTERN = Pattern.compile("TODO\\s+(.+)");

    public static String getTagList(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        if (text.contains("TODO")) {
            return "";
        }
        Matcher matcher = TAG_PATTERN.matcher(text);
        List<String> tags = new ArrayList<>();
        while (matcher.find()) {
            tags.add(matcher.group(1));
        }
        return String.join(", ", tags);
    }

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
