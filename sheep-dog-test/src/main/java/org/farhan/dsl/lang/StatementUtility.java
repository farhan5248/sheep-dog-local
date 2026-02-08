package org.farhan.dsl.lang;

import java.util.List;
import java.util.TreeSet;

/**
 * Static helper methods for grammar element operations.
 * <p>
 * Separates utility operations from grammar model classes, keeping interfaces
 * focused on data access.
 * </p>
 */
public class StatementUtility {

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
	 * @param statementList the list of statements to convert
	 * @return String concatenation of all statement names
	 */
	public static String getStatementListAsString(List<IStatement> statementList) {
		String documentation = "";
		for (IStatement s : statementList) {
			documentation += s.getName();
		}
		return documentation;
	}
}
