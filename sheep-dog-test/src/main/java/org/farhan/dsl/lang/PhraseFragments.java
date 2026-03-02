package org.farhan.dsl.lang;

import java.util.ArrayList;

public class PhraseFragments {

    public static ArrayList<String> getTagAsList(String line) {
        ArrayList<String> tags = new ArrayList<>();
        if (line == null || line.trim().isEmpty()) {
            return tags;
        }
        for (String word : line.trim().split("\\s+")) {
            if (word.startsWith("@")) {
                tags.add(word.substring(1));
            }
        }
        return tags;
    }

    public static String getTagDesc(String text) {
        return null;
    }

    public static String getTodoType(String text) {
        if (text != null && text.contains("TODO")) {
            return "TODO";
        }
        return null;
    }

    public static String getTodoDesc(String text) {
        if (text != null && text.contains("TODO")) {
            return text.substring(text.indexOf("TODO") + 4).trim();
        }
        return null;
    }

    public static String getTag(String text) {
        return null;
    }

    public static String getTodo(String text) {
        return null;
    }

}
