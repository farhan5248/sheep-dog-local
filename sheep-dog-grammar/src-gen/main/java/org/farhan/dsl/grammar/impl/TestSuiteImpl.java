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
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestSuiteImpl#getTestStepContainerList <em>Test Step Container List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSuiteImpl extends TestDocumentImpl implements ITestSuite
{
	/**
	 * The cached value of the '{@link #getTestStepContainerList() <em>Test Step Container List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestStepContainerList()
	 * @generated
	 * @ordered
	 */
	protected EList<ITestStepContainer> testStepContainerList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSuiteImpl()
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
		return ISheepDogPackage.Literals.TEST_SUITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ITestStepContainer> getTestStepContainerList()
	{
		if (testStepContainerList == null)
		{
			testStepContainerList = new EObjectContainmentEList<ITestStepContainer>(ITestStepContainer.class, this, ISheepDogPackage.TEST_SUITE__TEST_STEP_CONTAINER_LIST);
		}
		return testStepContainerList;
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
			case ISheepDogPackage.TEST_SUITE__TEST_STEP_CONTAINER_LIST:
				return ((InternalEList<?>)getTestStepContainerList()).basicRemove(otherEnd, msgs);
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
			case ISheepDogPackage.TEST_SUITE__TEST_STEP_CONTAINER_LIST:
				return getTestStepContainerList();
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
			case ISheepDogPackage.TEST_SUITE__TEST_STEP_CONTAINER_LIST:
				getTestStepContainerList().clear();
				getTestStepContainerList().addAll((Collection<? extends ITestStepContainer>)newValue);
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
			case ISheepDogPackage.TEST_SUITE__TEST_STEP_CONTAINER_LIST:
				getTestStepContainerList().clear();
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
			case ISheepDogPackage.TEST_SUITE__TEST_STEP_CONTAINER_LIST:
				return testStepContainerList != null && !testStepContainerList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestSuiteImpl
