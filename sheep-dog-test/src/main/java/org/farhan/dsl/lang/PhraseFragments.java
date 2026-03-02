package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseFragments {

    public static ArrayList<String> getTagAsList(String line) {
        ArrayList<String> tags = new ArrayList<String>();
        for (String word : line.split(" ")) {
            if (isTag(word)) {
                tags.add(getTagDesc(word));
            }
        }
        return tags;
    }

    public static String getTagDesc(String text) {
        return getGroup("^@(.+)$", text, 1);
    }

    public static String getTodoType(String text) {
        return getGroup("\\b(TODO)\\b", text, 1);
    }

    public static String getTodoDesc(String text) {
        return getGroup("\\bTODO (.+)$", text, 1);
    }

    public static String getTag(String text) {
        return getGroup("^(@.+)$", text, 1);
    }

    public static String getTodo(String text) {
        return getGroup("\\b(TODO .+)$", text, 1);
    }

    private static boolean isTag(String word) {
        return word.startsWith("@");
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
