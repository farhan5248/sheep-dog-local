/**
 */
package org.farhan.dsl.grammar.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ISheepDogPackage;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepParameters;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Step Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.impl.StepDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.StepDefinitionImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.StepDefinitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.StepDefinitionImpl#getStepParameterList <em>Step Parameter List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StepDefinitionImpl extends MinimalEObjectImpl.Container implements IStepDefinition
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONTAINER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected Object container = CONTAINER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected IDescription description;

	/**
	 * The cached value of the '{@link #getStepParameterList() <em>Step Parameter List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepParameterList()
	 * @generated
	 * @ordered
	 */
	protected EList<IStepParameters> stepParameterList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepDefinitionImpl()
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
		return ISheepDogPackage.Literals.STEP_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.STEP_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getContainer()
	{
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainer(Object newContainer)
	{
		Object oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.STEP_DEFINITION__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IDescription getDescription()
	{
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(IDescription newDescription, NotificationChain msgs)
	{
		IDescription oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ISheepDogPackage.STEP_DEFINITION__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(IDescription newDescription)
	{
		if (newDescription != description)
		{
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ISheepDogPackage.STEP_DEFINITION__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ISheepDogPackage.STEP_DEFINITION__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.STEP_DEFINITION__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IStepParameters> getStepParameterList()
	{
		if (stepParameterList == null)
		{
			stepParameterList = new EObjectContainmentEList<IStepParameters>(IStepParameters.class, this, ISheepDogPackage.STEP_DEFINITION__STEP_PARAMETER_LIST);
		}
		return stepParameterList;
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
			case ISheepDogPackage.STEP_DEFINITION__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case ISheepDogPackage.STEP_DEFINITION__STEP_PARAMETER_LIST:
				return ((InternalEList<?>)getStepParameterList()).basicRemove(otherEnd, msgs);
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
			case ISheepDogPackage.STEP_DEFINITION__NAME:
				return getName();
			case ISheepDogPackage.STEP_DEFINITION__CONTAINER:
				return getContainer();
			case ISheepDogPackage.STEP_DEFINITION__DESCRIPTION:
				return getDescription();
			case ISheepDogPackage.STEP_DEFINITION__STEP_PARAMETER_LIST:
				return getStepParameterList();
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
			case ISheepDogPackage.STEP_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case ISheepDogPackage.STEP_DEFINITION__CONTAINER:
				setContainer(newValue);
				return;
			case ISheepDogPackage.STEP_DEFINITION__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case ISheepDogPackage.STEP_DEFINITION__STEP_PARAMETER_LIST:
				getStepParameterList().clear();
				getStepParameterList().addAll((Collection<? extends IStepParameters>)newValue);
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
			case ISheepDogPackage.STEP_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ISheepDogPackage.STEP_DEFINITION__CONTAINER:
				setContainer(CONTAINER_EDEFAULT);
				return;
			case ISheepDogPackage.STEP_DEFINITION__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case ISheepDogPackage.STEP_DEFINITION__STEP_PARAMETER_LIST:
				getStepParameterList().clear();
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
			case ISheepDogPackage.STEP_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ISheepDogPackage.STEP_DEFINITION__CONTAINER:
				return CONTAINER_EDEFAULT == null ? container != null : !CONTAINER_EDEFAULT.equals(container);
			case ISheepDogPackage.STEP_DEFINITION__DESCRIPTION:
				return description != null;
			case ISheepDogPackage.STEP_DEFINITION__STEP_PARAMETER_LIST:
				return stepParameterList != null && !stepParameterList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", container: ");
		result.append(container);
		result.append(')');
		return result.toString();
	}

} //StepDefinitionImpl
