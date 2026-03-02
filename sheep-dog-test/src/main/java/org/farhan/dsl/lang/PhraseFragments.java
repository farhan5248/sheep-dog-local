package org.farhan.dsl.lang;

import java.util.ArrayList;

public class PhraseFragments {

    public static ArrayList<String> getTagAsList(String name) {
        ArrayList<String> tags = new ArrayList<String>();
        for (String word : name.split(" ")) {
            if (!getTag(word).isEmpty()) {
                tags.add(getTagDesc(word));
            }
        }
        return tags;
    }

    public static String getTagDesc(String text) {
        String tag = getTag(text);
        if (!tag.isEmpty()) {
            return tag.substring(1);
        }
        return "";
    }

    public static String getTodoType(String text) {
        return getTodo(text);
    }

    public static String getTodoDesc(String text) {
        if (text != null) {
            int idx = text.indexOf("TODO");
            if (idx >= 0) {
                return text.substring(idx + "TODO".length()).trim();
            }
        }
        return "";
    }

    public static String getTag(String text) {
        if (text != null && text.startsWith("@")) {
            return text;
        }
        return "";
    }

    public static String getTodo(String text) {
        if (text != null) {
            for (String word : text.split(" ")) {
                if (word.equals("TODO")) {
                    return "TODO";
                }
            }
        }
        return "";
    }

}
