/**
 */
package org.farhan.dsl.grammar2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar2.ITestProject#getName <em>Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar2.ITestProject#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar2.ITestProject#getTestDocumentList <em>Test Document List</em>}</li>
 * </ul>
 *
 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getTestProject()
 * @model
 * @generated
 */
public interface ITestProject extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getTestProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar2.ITestProject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Extension</em>' attribute.
	 * @see #setFileExtension(String)
	 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getTestProject_FileExtension()
	 * @model
	 * @generated
	 */
	String getFileExtension();

	/**
	 * Sets the value of the '{@link org.farhan.dsl.grammar2.ITestProject#getFileExtension <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Extension</em>' attribute.
	 * @see #getFileExtension()
	 * @generated
	 */
	void setFileExtension(String value);

	/**
	 * Returns the value of the '<em><b>Test Document List</b></em>' containment reference list.
	 * The list contents are of type {@link org.farhan.dsl.grammar2.ITestDocument}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Document List</em>' containment reference list.
	 * @see org.farhan.dsl.grammar2.ISheepDogPackage#getTestProject_TestDocumentList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ITestDocument> getTestDocumentList();

} // ITestProject
