/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.ITable#getContainer <em>Container</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.ITable#getRowList <em>Row List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTable()
 * @model
 * @generated
 */
public interface ITable
{
	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(Object)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTable_Container()
	 * @model
	 * @generated
	 */
	Object getContainer();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.ITable#getContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Object value);

	/**
	 * Returns the value of the '<em><b>Row List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar.IRow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTable_RowList()
	 * @model containment="true"
	 * @generated
	 */
	EList<IRow> getRowList();

} // ITable
