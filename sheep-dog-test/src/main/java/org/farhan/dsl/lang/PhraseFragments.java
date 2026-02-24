package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseFragments {

    private static final String TODO_TYPE = "(TODO)";
    private static final String TODO_DESC = "( \\S.*)";
    private static final String TODO = "(" + TODO_TYPE + TODO_DESC + ")";
    private static final String TAG_TYPE = "(@)";
    private static final String TAG_DESC = "(\\S+)";
    private static final String TAG = "(" + TAG_TYPE + TAG_DESC + ")";
    private static final String PHRASE = "((" + TAG + ")+|" + TODO + "|.+)";

    public static String getAll(String text) {
        return getGroup(PhraseFragments.PHRASE, text, 0);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param name the name string to extract tags from
     * @return TreeSet of tag strings without the "@" prefix
     */
    public static ArrayList<String> getTagAsList(String name) {
        ArrayList<String> tags = new ArrayList<String>();
        for (String word : name.split(" ")) {
            if (isTag(word)) {
                tags.add(getTagDesc(word));
            }
        }
        return tags;
    }

    public static String getTagDesc(String text) {
        return getGroup(TAG, text, 3);
    }

    public static String getTodoType(String text) {
        return getGroup(TODO, text, 2);
    }

    public static String getTodoDesc(String text) {
        return getGroup(TODO, text, 3);
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param word the word to check
     * @return true if the word starts with "@", false otherwise
     */
    public static boolean isTag(String text) {
        return !getGroup(TAG, text, 0).isEmpty();
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param word the word to check
     * @return true if the word equals "TODO", false otherwise
     */
    public static boolean isTodo(String text) {
        return !getGroup(TODO, text, 0).isEmpty();
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param regex the regular expression pattern
     * @param text  the text to match against
     * @param group the group number to extract
     * @return the matched group text, trimmed, or empty string if no match
     */
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
