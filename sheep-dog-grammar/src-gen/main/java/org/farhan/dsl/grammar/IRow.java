/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.IRow#getContainer <em>Container</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.IRow#getCellList <em>Cell List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getRow()
 * @model
 * @generated
 */
public interface IRow
{
	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(Object)
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getRow_Container()
	 * @model
	 * @generated
	 */
	Object getContainer();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar.IRow#getContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Object value);

	/**
	 * Returns the value of the '<em><b>Cell List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar.ICell}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getRow_CellList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ICell> getCellList();

} // IRow
