/**
 */
package org.farhan.dsl.grammar2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.farhan.dsl.grammar2.ISheepDogPackage;
import org.farhan.dsl.grammar2.IStepDefinition;
import org.farhan.dsl.grammar2.IStepObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Step Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar2.impl.StepObjectImpl#getStepDefinitionList <em>Step Definition List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StepObjectImpl extends TestDocumentImpl implements IStepObject
{
	/**
	 * The cached value of the '{@link #getStepDefinitionList() <em>Step Definition List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepDefinitionList()
	 * @generated
	 * @ordered
	 */
	protected EList<IStepDefinition> stepDefinitionList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepObjectImpl()
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
		return ISheepDogPackage.Literals.STEP_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IStepDefinition> getStepDefinitionList()
	{
		if (stepDefinitionList == null)
		{
			stepDefinitionList = new EObjectContainmentEList<IStepDefinition>(IStepDefinition.class, this, ISheepDogPackage.STEP_OBJECT__STEP_DEFINITION_LIST);
		}
		return stepDefinitionList;
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
			case ISheepDogPackage.STEP_OBJECT__STEP_DEFINITION_LIST:
				return ((InternalEList<?>)getStepDefinitionList()).basicRemove(otherEnd, msgs);
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
			case ISheepDogPackage.STEP_OBJECT__STEP_DEFINITION_LIST:
				return getStepDefinitionList();
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
			case ISheepDogPackage.STEP_OBJECT__STEP_DEFINITION_LIST:
				getStepDefinitionList().clear();
				getStepDefinitionList().addAll((Collection<? extends IStepDefinition>)newValue);
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
			case ISheepDogPackage.STEP_OBJECT__STEP_DEFINITION_LIST:
				getStepDefinitionList().clear();
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
			case ISheepDogPackage.STEP_OBJECT__STEP_DEFINITION_LIST:
				return stepDefinitionList != null && !stepDefinitionList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StepObjectImpl
