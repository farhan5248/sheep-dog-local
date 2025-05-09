/**
 * generated by Xtext 2.39.0.M1
 */
package org.farhan.dsl.sheepdog.sheepDog.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogPackage;
import org.farhan.dsl.sheepdog.sheepDog.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.farhan.dsl.sheepdog.sheepDog.impl.TableImpl#getRowList <em>Row List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableImpl extends MinimalEObjectImpl.Container implements Table
{
  /**
   * The cached value of the '{@link #getRowList() <em>Row List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRowList()
   * @generated
   * @ordered
   */
  protected EList<Row> rowList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TableImpl()
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
    return SheepDogPackage.Literals.TABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Row> getRowList()
  {
    if (rowList == null)
    {
      rowList = new EObjectContainmentEList<Row>(Row.class, this, SheepDogPackage.TABLE__ROW_LIST);
    }
    return rowList;
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
      case SheepDogPackage.TABLE__ROW_LIST:
        return ((InternalEList<?>)getRowList()).basicRemove(otherEnd, msgs);
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
      case SheepDogPackage.TABLE__ROW_LIST:
        return getRowList();
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
      case SheepDogPackage.TABLE__ROW_LIST:
        getRowList().clear();
        getRowList().addAll((Collection<? extends Row>)newValue);
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
      case SheepDogPackage.TABLE__ROW_LIST:
        getRowList().clear();
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
      case SheepDogPackage.TABLE__ROW_LIST:
        return rowList != null && !rowList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TableImpl
