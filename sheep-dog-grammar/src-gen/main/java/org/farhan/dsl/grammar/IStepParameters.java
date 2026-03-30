/**
 */
package org.farhan.dsl.grammar;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.IStepParameters#getName <em>Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.IStepParameters#getContainer <em>Container</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.IStepParameters#getDescription <em>Description</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.IStepParameters#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepParameters()
 * @model
 * @generated
 */
public interface IStepParameters
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepParameters_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IStepParameters#getName <em>Name</em>}' attribute.
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
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepParameters_Container()
	 * @model
	 * @generated
	 */
	Object getContainer();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IStepParameters#getContainer <em>Container</em>}' attribute.
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
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepParameters_Description()
	 * @model containment="true"
	 * @generated
	 */
	IDescription getDescription();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IStepParameters#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(IDescription value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' containment reference.
	 * @see #setTable(ITable)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getStepParameters_Table()
	 * @model containment="true"
	 * @generated
	 */
	ITable getTable();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IStepParameters#getTable <em>Table</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' containment reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(ITable value);

} // IStepParameters
