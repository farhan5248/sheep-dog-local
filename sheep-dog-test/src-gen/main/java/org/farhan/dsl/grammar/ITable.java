/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.ITable#getRowList <em>Row List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getTable()
 * @model
 * @generated
 */
public interface ITable extends EObject
{
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
