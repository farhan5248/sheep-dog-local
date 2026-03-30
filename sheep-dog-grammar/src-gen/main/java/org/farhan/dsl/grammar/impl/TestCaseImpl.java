/**
 */
package org.farhan.dsl.grammar.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.farhan.dsl.grammar.ISheepDogPackage;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestCaseImpl#getTestDataList <em>Test Data List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestCaseImpl extends TestStepContainerImpl implements ITestCase
{
	/**
	 * The cached value of the '{@link #getTestDataList() <em>Test Data List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestDataList()
	 * @generated
	 * @ordered
	 */
	protected EList<ITestData> testDataList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ISheepDogPackage.Literals.TEST_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ITestData> getTestDataList()
	{
		if (testDataList == null)
		{
			testDataList = new EObjectContainmentEList<ITestData>(ITestData.class, this, ISheepDogPackage.TEST_CASE__TEST_DATA_LIST);
		}
		return testDataList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ISheepDogPackage.TEST_CASE__TEST_DATA_LIST:
				return ((InternalEList<?>)getTestDataList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ISheepDogPackage.TEST_CASE__TEST_DATA_LIST:
				return getTestDataList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ISheepDogPackage.TEST_CASE__TEST_DATA_LIST:
				getTestDataList().clear();
				getTestDataList().addAll((Collection<? extends ITestData>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ISheepDogPackage.TEST_CASE__TEST_DATA_LIST:
				getTestDataList().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ISheepDogPackage.TEST_CASE__TEST_DATA_LIST:
				return testDataList != null && !testDataList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestCaseImpl
