/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.IDescription#getLineList <em>Line List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar.ISheepDogPackage#getDescription()
 * @model
 * @generated
 */
public interface IDescription
{
	/**
	 * Returns the value of the '<em><b>Line List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar.ILine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar.ISheepDogPackage#getDescription_LineList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ILine> getLineList();

} // IDescription
