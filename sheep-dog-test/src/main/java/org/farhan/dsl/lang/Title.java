package org.farhan.dsl.lang;

import java.util.TreeSet;

public class Title {

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param name the name string to extract tags from
     * @return TreeSet of tag strings without the "@" prefix
     */
    public static TreeSet<String> getTags(String name) {
    	TreeSet<String> tags = new TreeSet<String>();
    	for (String word : name.split(" ")) {
    		if (isTag(word)) {
    			tags.add(word.replace("@", ""));
    		}
    	}
    	return tags;
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param word the word to check
     * @return true if the word starts with "@", false otherwise
     */
    public static boolean isTag(String word) {
    	return word.startsWith("@");
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param word the word to check
     * @return true if the word equals "TODO", false otherwise
     */
    public static boolean isTodo(String word) {
    	return word.contentEquals("TODO");
    }

}
