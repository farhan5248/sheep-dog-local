package org.farhan.dsl.lang;

import java.util.ArrayList;

/**
 * Interface representing a list of statements.
 * Used in StepParameters and TestData.
 */
public interface IStatementList {

	/**
	 * Gets the list of statements.
	 * @return the statement list
	 */
	ArrayList<IStatement> getStatementList();

	/**
	 * Sets the list of statements.
	 * @param value the statement list
	 */
	void setStatementList(ArrayList<IStatement> value);

	/**
	 * Gets the parent element containing this statement list.
	 * Parent can be either IStepParameters or ITestData.
	 * @return the parent element
	 */
	Object getParent();

	/**
	 * Sets the parent element for this statement list.
	 * @param value the parent element (IStepParameters or ITestData)
	 */
	void setParent(Object value);
}
