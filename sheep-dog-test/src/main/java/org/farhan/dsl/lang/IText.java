package org.farhan.dsl.lang;

/**
 * Interface representing a raw text block (docstring) in a test step. Text
 * blocks are delimited by '----' markers and contain raw content.
 */
public interface IText {

	/**
	 * Gets the raw text content (without delimiters).
	 * 
	 * @return the text content
	 */
	String getName();

	/**
	 * Sets the raw text content.
	 * 
	 * @param value the text content
	 */
	void setName(String value);

	/**
	 * Gets the parent test step containing this text.
	 * 
	 * @return the parent ITestStep (Given/When/Then/And)
	 */
	ITestStep getParent();

}
