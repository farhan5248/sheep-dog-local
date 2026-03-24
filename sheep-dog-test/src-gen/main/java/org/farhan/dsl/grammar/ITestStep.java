/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.ITestStep#getStepObjectName <em>Step Object Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.ITestStep#getStepDefinitionName <em>Step Definition Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.ITestStep#getFullName <em>Full Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.ITestStep#getTable <em>Table</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.ITestStep#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestStep()
 * @model
 * @generated
 */
public interface ITestStep extends EObject
{
	/**
	 * Returns the value of the '<em><b>Step Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Object Name</em>' attribute.
	 * @see #setStepObjectName(String)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestStep_StepObjectName()
	 * @model
	 * @generated
	 */
	String getStepObjectName();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.ITestStep#getStepObjectName <em>Step Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Object Name</em>' attribute.
	 * @see #getStepObjectName()
	 * @generated
	 */
	void setStepObjectName(String value);

	/**
	 * Returns the value of the '<em><b>Step Definition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Definition Name</em>' attribute.
	 * @see #setStepDefinitionName(String)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestStep_StepDefinitionName()
	 * @model
	 * @generated
	 */
	String getStepDefinitionName();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.ITestStep#getStepDefinitionName <em>Step Definition Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Definition Name</em>' attribute.
	 * @see #getStepDefinitionName()
	 * @generated
	 */
	void setStepDefinitionName(String value);

	/**
	 * Returns the value of the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Name</em>' attribute.
	 * @see #setFullName(String)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestStep_FullName()
	 * @model
	 * @generated
	 */
	String getFullName();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.ITestStep#getFullName <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Name</em>' attribute.
	 * @see #getFullName()
	 * @generated
	 */
	void setFullName(String value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' containment reference.
	 * @see #setTable(ITable)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestStep_Table()
	 * @model containment="true"
	 * @generated
	 */
	ITable getTable();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.ITestStep#getTable <em>Table</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' containment reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(ITable value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' containment reference.
	 * @see #setText(IText)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTestStep_Text()
	 * @model containment="true"
	 * @generated
	 */
	IText getText();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.ITestStep#getText <em>Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' containment reference.
	 * @see #getText()
	 * @generated
	 */
	void setText(IText value);

} // ITestStep
