package org.farhan.dsl.lang;

import java.util.TreeSet;

public class StatementUtility {

	public static boolean isTag(String word) {
		return word.startsWith("@");
	}

	public static boolean isTodo(String word) {
		return word.contentEquals("TODO");
	}

	public static TreeSet<String> getTags(String name) {
		TreeSet<String> tags = new TreeSet<String>();
		for (String word : name.split(" ")) {
			if (isTag(word)) {
				tags.add(word.replace("@", ""));
			}
		}
		return tags;
	}
}
