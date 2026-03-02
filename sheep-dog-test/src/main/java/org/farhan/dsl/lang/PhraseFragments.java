package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseFragments {

    private static final String TAG_PATTERN = "^@(.+)$";
    private static final String TODO_PATTERN = "(DONE|TODO|DOING|WONT)\\s?(.*)$";

    public static ArrayList<String> getTagAsList(String name) {
        ArrayList<String> tags = new ArrayList<String>();
        for (String word : name.split(" ")) {
            if (isTag(word)) {
                tags.add(getTagDesc(word));
            }
        }
        return tags;
    }

    private static boolean isTag(String word) {
        return word.startsWith("@");
    }

    public static String getTagDesc(String text) {
        return getGroup(TAG_PATTERN, text, 1);
    }

    public static String getTodoType(String text) {
        return getGroup(TODO_PATTERN, text, 1);
    }

    public static String getTodoDesc(String text) {
        return getGroup(TODO_PATTERN, text, 2);
    }

    public static String getTag(String text) {
        return getGroup(TAG_PATTERN, text, 0);
    }

    public static String getTodo(String text) {
        return getGroup(TODO_PATTERN, text, 0);
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
