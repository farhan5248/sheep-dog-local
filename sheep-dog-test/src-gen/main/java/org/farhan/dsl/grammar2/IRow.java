/**
 */
package org.farhan.dsl.grammar2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar2.IRow#getCellList <em>Cell List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getRow()
 * @model
 * @generated
 */
public interface IRow extends EObject
{
	/**
	 * Returns the value of the '<em><b>Cell List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar2.ICell}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getRow_CellList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ICell> getCellList();

} // IRow
