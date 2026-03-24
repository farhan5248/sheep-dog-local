/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.ITestCase#getTestDataList <em>Test Data List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestCase()
 * @model
 * @generated
 */
public interface ITestCase extends ITestStepContainer
{
	/**
	 * Returns the value of the '<em><b>Test Data List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar.ITestData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Data List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestCase_TestDataList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ITestData> getTestDataList();

} // ITestCase
