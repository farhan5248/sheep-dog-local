package org.farhan.dsl.deprecated;

import java.util.TreeSet;

import org.farhan.dsl.lang.StatementUtility;

public class StatementNameHelper {

	public static boolean isTag(String word) {
		return StatementUtility.isTag(word);
	}

	public static boolean isTodo(String word) {
		return StatementUtility.isTodo(word);
	}

	public static TreeSet<String> getTags(String name) {
		return StatementUtility.getTags(name);
	}
}
