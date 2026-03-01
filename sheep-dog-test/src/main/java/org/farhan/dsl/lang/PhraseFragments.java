package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseFragments {

    private static final String TAG = "^@(\\w+)$";
    private static final String TODO = "^TODO(.*)$";

    public static ArrayList<String> getTagAsList(String name) {
        ArrayList<String> tags = new ArrayList<String>();
        for (String word : name.split(" ")) {
            if (isTodo(word)) {
                return tags;
            }
            if (isTag(word)) {
                tags.add(getTagDesc(word));
            }
        }
        return tags;
    }

    public static String getTagDesc(String text) {
        return getGroup(TAG, text, 1);
    }

    public static String getTodoType(String text) {
        return "";
    }

    public static String getTodoDesc(String text) {
        return "";
    }

    public static String getTag(String text) {
        return getGroup(TAG, text, 0);
    }

    public static String getTodo(String text) {
        return getGroup(TODO, text, 0);
    }

    public static boolean isTag(String text) {
        return !getGroup(TAG, text, 0).isEmpty();
    }

    public static boolean isTodo(String text) {
        return !getGroup(TODO, text, 0).isEmpty();
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
