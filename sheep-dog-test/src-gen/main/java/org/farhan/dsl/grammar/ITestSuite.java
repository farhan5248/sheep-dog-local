/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.ITestSuite#getTestStepContainerList <em>Test Step Container List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestSuite()
 * @model
 * @generated
 */
public interface ITestSuite extends ITestDocument
{
	/**
	 * Returns the value of the '<em><b>Test Step Container List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar.ITestStepContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Step Container List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestSuite_TestStepContainerList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ITestStepContainer> getTestStepContainerList();

} // ITestSuite
