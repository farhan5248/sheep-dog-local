/**
 */
package org.farhan.dsl.grammar.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.farhan.dsl.grammar.ISheepDogPackage;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestStepImpl#getStepObjectName <em>Step Object Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestStepImpl#getStepDefinitionName <em>Step Definition Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestStepImpl#getFullName <em>Full Name</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestStepImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestStepImpl#getTable <em>Table</em>}</li>
 *   <li>{@link org.farhan.dsl.grammar.impl.TestStepImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestStepImpl extends MinimalEObjectImpl.Container implements ITestStep
{
	/**
	 * The default value of the '{@link #getStepObjectName() <em>Step Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepObjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String STEP_OBJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStepObjectName() <em>Step Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepObjectName()
	 * @generated
	 * @ordered
	 */
	protected String stepObjectName = STEP_OBJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepDefinitionName() <em>Step Definition Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepDefinitionName()
	 * @generated
	 * @ordered
	 */
	protected static final String STEP_DEFINITION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStepDefinitionName() <em>Step Definition Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepDefinitionName()
	 * @generated
	 * @ordered
	 */
	protected String stepDefinitionName = STEP_DEFINITION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFullName() <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullName()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullName() <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullName()
	 * @generated
	 * @ordered
	 */
	protected String fullName = FULL_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getTable() <em>Table</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected ITable table;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected IText text;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestStepImpl()
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
		return ISheepDogPackage.Literals.TEST_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStepObjectName()
	{
		return stepObjectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStepObjectName(String newStepObjectName)
	{
		String oldStepObjectName = stepObjectName;
		stepObjectName = newStepObjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__STEP_OBJECT_NAME, oldStepObjectName, stepObjectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStepDefinitionName()
	{
		return stepDefinitionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStepDefinitionName(String newStepDefinitionName)
	{
		String oldStepDefinitionName = stepDefinitionName;
		stepDefinitionName = newStepDefinitionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__STEP_DEFINITION_NAME, oldStepDefinitionName, stepDefinitionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFullName()
	{
		return fullName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFullName(String newFullName)
	{
		String oldFullName = fullName;
		fullName = newFullName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__FULL_NAME, oldFullName, fullName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITable getTable()
	{
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTable(ITable newTable, NotificationChain msgs)
	{
		ITable oldTable = table;
		table = newTable;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__TABLE, oldTable, newTable);
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
	public void setTable(ITable newTable)
	{
		if (newTable != table)
		{
			NotificationChain msgs = null;
			if (table != null)
				msgs = ((InternalEObject)table).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ISheepDogPackage.TEST_STEP__TABLE, null, msgs);
			if (newTable != null)
				msgs = ((InternalEObject)newTable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ISheepDogPackage.TEST_STEP__TABLE, null, msgs);
			msgs = basicSetTable(newTable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__TABLE, newTable, newTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IText getText()
	{
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetText(IText newText, NotificationChain msgs)
	{
		IText oldText = text;
		text = newText;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__TEXT, oldText, newText);
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
	public void setText(IText newText)
	{
		if (newText != text)
		{
			NotificationChain msgs = null;
			if (text != null)
				msgs = ((InternalEObject)text).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ISheepDogPackage.TEST_STEP__TEXT, null, msgs);
			if (newText != null)
				msgs = ((InternalEObject)newText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ISheepDogPackage.TEST_STEP__TEXT, null, msgs);
			msgs = basicSetText(newText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISheepDogPackage.TEST_STEP__TEXT, newText, newText));
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
			case ISheepDogPackage.TEST_STEP__TABLE:
				return basicSetTable(null, msgs);
			case ISheepDogPackage.TEST_STEP__TEXT:
				return basicSetText(null, msgs);
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
			case ISheepDogPackage.TEST_STEP__STEP_OBJECT_NAME:
				return getStepObjectName();
			case ISheepDogPackage.TEST_STEP__STEP_DEFINITION_NAME:
				return getStepDefinitionName();
			case ISheepDogPackage.TEST_STEP__FULL_NAME:
				return getFullName();
			case ISheepDogPackage.TEST_STEP__CONTAINER:
				return getContainer();
			case ISheepDogPackage.TEST_STEP__TABLE:
				return getTable();
			case ISheepDogPackage.TEST_STEP__TEXT:
				return getText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ISheepDogPackage.TEST_STEP__STEP_OBJECT_NAME:
				setStepObjectName((String)newValue);
				return;
			case ISheepDogPackage.TEST_STEP__STEP_DEFINITION_NAME:
				setStepDefinitionName((String)newValue);
				return;
			case ISheepDogPackage.TEST_STEP__FULL_NAME:
				setFullName((String)newValue);
				return;
			case ISheepDogPackage.TEST_STEP__CONTAINER:
				setContainer(newValue);
				return;
			case ISheepDogPackage.TEST_STEP__TABLE:
				setTable((ITable)newValue);
				return;
			case ISheepDogPackage.TEST_STEP__TEXT:
				setText((IText)newValue);
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
			case ISheepDogPackage.TEST_STEP__STEP_OBJECT_NAME:
				setStepObjectName(STEP_OBJECT_NAME_EDEFAULT);
				return;
			case ISheepDogPackage.TEST_STEP__STEP_DEFINITION_NAME:
				setStepDefinitionName(STEP_DEFINITION_NAME_EDEFAULT);
				return;
			case ISheepDogPackage.TEST_STEP__FULL_NAME:
				setFullName(FULL_NAME_EDEFAULT);
				return;
			case ISheepDogPackage.TEST_STEP__CONTAINER:
				setContainer(CONTAINER_EDEFAULT);
				return;
			case ISheepDogPackage.TEST_STEP__TABLE:
				setTable((ITable)null);
				return;
			case ISheepDogPackage.TEST_STEP__TEXT:
				setText((IText)null);
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
			case ISheepDogPackage.TEST_STEP__STEP_OBJECT_NAME:
				return STEP_OBJECT_NAME_EDEFAULT == null ? stepObjectName != null : !STEP_OBJECT_NAME_EDEFAULT.equals(stepObjectName);
			case ISheepDogPackage.TEST_STEP__STEP_DEFINITION_NAME:
				return STEP_DEFINITION_NAME_EDEFAULT == null ? stepDefinitionName != null : !STEP_DEFINITION_NAME_EDEFAULT.equals(stepDefinitionName);
			case ISheepDogPackage.TEST_STEP__FULL_NAME:
				return FULL_NAME_EDEFAULT == null ? fullName != null : !FULL_NAME_EDEFAULT.equals(fullName);
			case ISheepDogPackage.TEST_STEP__CONTAINER:
				return CONTAINER_EDEFAULT == null ? container != null : !CONTAINER_EDEFAULT.equals(container);
			case ISheepDogPackage.TEST_STEP__TABLE:
				return table != null;
			case ISheepDogPackage.TEST_STEP__TEXT:
				return text != null;
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
		result.append(" (stepObjectName: ");
		result.append(stepObjectName);
		result.append(", stepDefinitionName: ");
		result.append(stepDefinitionName);
		result.append(", fullName: ");
		result.append(fullName);
		result.append(", container: ");
		result.append(container);
		result.append(')');
		return result.toString();
	}

} //TestStepImpl
