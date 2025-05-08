package org.farhan.dsl.common;

import java.util.TreeSet;

public class StatementNameHelper {

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
