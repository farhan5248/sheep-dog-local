package org.farhan.dsl.lang;

import java.util.List;

/**
 * Interface representing a list of statements. Used in StepParameters and
 * TestData.
 */
public interface IStatementList {

	/**
	 * Gets the list of statements.
	 * 
	 * @return the statement list
	 */
	List<IStatement> getStatementList();

	/**
	 * Gets the parent element containing this statement list. Parent can be either
	 * IStepParameters or ITestData.
	 * 
	 * @return the parent element
	 */
	Object getParent();

	/**
	 * Sets the parent element for this statement list.
	 * 
	 * @param value the parent element (IStepParameters or ITestData)
	 */
	void setParent(Object value);
}
