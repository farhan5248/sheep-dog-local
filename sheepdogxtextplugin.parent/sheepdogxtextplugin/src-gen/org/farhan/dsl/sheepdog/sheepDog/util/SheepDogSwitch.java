/**
 * generated by Xtext 2.39.0.M1
 */
package org.farhan.dsl.sheepdog.sheepDog.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.farhan.dsl.sheepdog.sheepDog.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.farhan.dsl.sheepdog.sheepDog.SheepDogPackage
 * @generated
 */
public class SheepDogSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SheepDogPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SheepDogSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SheepDogPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case SheepDogPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.STEP_OBJECT:
      {
        StepObject stepObject = (StepObject)theEObject;
        T result = caseStepObject(stepObject);
        if (result == null) result = caseModel(stepObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.STEP_DEFINITION:
      {
        StepDefinition stepDefinition = (StepDefinition)theEObject;
        T result = caseStepDefinition(stepDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.STEP_PARAMETERS:
      {
        StepParameters stepParameters = (StepParameters)theEObject;
        T result = caseStepParameters(stepParameters);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TEST_SUITE:
      {
        TestSuite testSuite = (TestSuite)theEObject;
        T result = caseTestSuite(testSuite);
        if (result == null) result = caseModel(testSuite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TEST_STEP_CONTAINER:
      {
        TestStepContainer testStepContainer = (TestStepContainer)theEObject;
        T result = caseTestStepContainer(testStepContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TEST_SETUP:
      {
        TestSetup testSetup = (TestSetup)theEObject;
        T result = caseTestSetup(testSetup);
        if (result == null) result = caseTestStepContainer(testSetup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TEST_CASE:
      {
        TestCase testCase = (TestCase)theEObject;
        T result = caseTestCase(testCase);
        if (result == null) result = caseTestStepContainer(testCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TEST_DATA:
      {
        TestData testData = (TestData)theEObject;
        T result = caseTestData(testData);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TEST_STEP:
      {
        TestStep testStep = (TestStep)theEObject;
        T result = caseTestStep(testStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.GIVEN:
      {
        Given given = (Given)theEObject;
        T result = caseGiven(given);
        if (result == null) result = caseTestStep(given);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.WHEN:
      {
        When when = (When)theEObject;
        T result = caseWhen(when);
        if (result == null) result = caseTestStep(when);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.THEN:
      {
        Then then = (Then)theEObject;
        T result = caseThen(then);
        if (result == null) result = caseTestStep(then);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.AND:
      {
        And and = (And)theEObject;
        T result = caseAnd(and);
        if (result == null) result = caseTestStep(and);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TEXT:
      {
        Text text = (Text)theEObject;
        T result = caseText(text);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.STATEMENT_LIST:
      {
        StatementList statementList = (StatementList)theEObject;
        T result = caseStatementList(statementList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.TABLE:
      {
        Table table = (Table)theEObject;
        T result = caseTable(table);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.ROW:
      {
        Row row = (Row)theEObject;
        T result = caseRow(row);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.CELL:
      {
        Cell cell = (Cell)theEObject;
        T result = caseCell(cell);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SheepDogPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Step Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Step Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStepObject(StepObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Step Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Step Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStepDefinition(StepDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Step Parameters</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Step Parameters</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStepParameters(StepParameters object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test Suite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test Suite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTestSuite(TestSuite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test Step Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test Step Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTestStepContainer(TestStepContainer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test Setup</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test Setup</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTestSetup(TestSetup object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTestCase(TestCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test Data</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test Data</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTestData(TestData object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test Step</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTestStep(TestStep object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Given</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Given</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGiven(Given object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>When</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>When</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhen(When object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Then</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Then</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThen(Then object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnd(And object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Text</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Text</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseText(Text object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatementList(StatementList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTable(Table object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Row</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Row</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRow(Row object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cell</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cell</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCell(Cell object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //SheepDogSwitch
