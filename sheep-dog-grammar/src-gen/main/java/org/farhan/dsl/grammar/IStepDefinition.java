/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.IStepDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.IStepDefinition#getContainer <em>Container</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.IStepDefinition#getDescription <em>Description</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.IStepDefinition#getStepParameterList <em>Step Parameter List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepDefinition()
 * @model
 * @generated
 */
public interface IStepDefinition
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepDefinition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IStepDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(Object)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepDefinition_Container()
	 * @model
	 * @generated
	 */
	Object getContainer();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IStepDefinition#getContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Object value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(IDescription)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepDefinition_Description()
	 * @model containment="true"
	 * @generated
	 */
	IDescription getDescription();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IStepDefinition#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(IDescription value);

	/**
	 * Returns the value of the '<em><b>Step Parameter List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar.IStepParameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Parameter List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepDefinition_StepParameterList()
	 * @model containment="true"
	 * @generated
	 */
	EList<IStepParameters> getStepParameterList();

} // IStepDefinition
