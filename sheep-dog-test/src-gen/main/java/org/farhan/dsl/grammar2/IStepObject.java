/**
 */
package org.farhan.dsl.grammar2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar2.IStepObject#getStepDefinitionList <em>Step Definition List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getStepObject()
 * @model
 * @generated
 */
public interface IStepObject extends ITestDocument
{
	/**
	 * Returns the value of the '<em><b>Step Definition List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar2.IStepDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Definition List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getStepObject_StepDefinitionList()
	 * @model containment="true"
	 * @generated
	 */
	EList<IStepDefinition> getStepDefinitionList();

} // IStepObject
