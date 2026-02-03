package org.farhan.dsl.lang;

import java.util.List;

/**
 * Interface representing a list of statements. Used in StepParameters and
 * TestData.
 */
public interface IStatementList {

	/**
	 * Gets a statement by index.
	 *
	 * @param index the zero-based index
	 * @return the statement at the specified index
	 */
	IStatement getStatement(int index);

	/**
	 * Gets a statement by name.
	 *
	 * @param name the statement name
	 * @return the statement with the specified name, or null if not found
	 */
	IStatement getStatement(String name);

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
	boolean addStatement(IStatement value);
}
