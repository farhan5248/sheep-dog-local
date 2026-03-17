package org.farhan.dsl.grammar;

public class SheepDogUtility {

	/**
	 * Checks if the given text starts with a capital letter.
	 *
	 * @param text the text to check
	 * @return true if text is not null/empty and starts with a capital letter
	 */
	public static boolean startsWithCapital(String text) {
		if (text == null || text.isEmpty()) {
			return false;
		}
		return Character.isUpperCase(text.charAt(0));
	}
}
