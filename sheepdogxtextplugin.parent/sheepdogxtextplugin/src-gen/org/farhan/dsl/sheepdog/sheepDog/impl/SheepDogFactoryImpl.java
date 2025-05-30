/**
 * generated by Xtext 2.39.0.M1
 */
package org.farhan.dsl.sheepdog.sheepDog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.farhan.dsl.sheepdog.sheepDog.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SheepDogFactoryImpl extends EFactoryImpl implements SheepDogFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SheepDogFactory init()
  {
    try
    {
      SheepDogFactory theSheepDogFactory = (SheepDogFactory)EPackage.Registry.INSTANCE.getEFactory(SheepDogPackage.eNS_URI);
      if (theSheepDogFactory != null)
      {
        return theSheepDogFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SheepDogFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SheepDogFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SheepDogPackage.MODEL: return createModel();
      case SheepDogPackage.STEP_OBJECT: return createStepObject();
      case SheepDogPackage.STEP_DEFINITION: return createStepDefinition();
      case SheepDogPackage.STEP_PARAMETERS: return createStepParameters();
      case SheepDogPackage.TEST_SUITE: return createTestSuite();
      case SheepDogPackage.TEST_STEP_CONTAINER: return createTestStepContainer();
      case SheepDogPackage.TEST_SETUP: return createTestSetup();
      case SheepDogPackage.TEST_CASE: return createTestCase();
      case SheepDogPackage.TEST_DATA: return createTestData();
      case SheepDogPackage.TEST_STEP: return createTestStep();
      case SheepDogPackage.GIVEN: return createGiven();
      case SheepDogPackage.WHEN: return createWhen();
      case SheepDogPackage.THEN: return createThen();
      case SheepDogPackage.AND: return createAnd();
      case SheepDogPackage.TEXT: return createText();
      case SheepDogPackage.STATEMENT_LIST: return createStatementList();
      case SheepDogPackage.TABLE: return createTable();
      case SheepDogPackage.ROW: return createRow();
      case SheepDogPackage.CELL: return createCell();
      case SheepDogPackage.STATEMENT: return createStatement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StepObject createStepObject()
  {
    StepObjectImpl stepObject = new StepObjectImpl();
    return stepObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StepDefinition createStepDefinition()
  {
    StepDefinitionImpl stepDefinition = new StepDefinitionImpl();
    return stepDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StepParameters createStepParameters()
  {
    StepParametersImpl stepParameters = new StepParametersImpl();
    return stepParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestSuite createTestSuite()
  {
    TestSuiteImpl testSuite = new TestSuiteImpl();
    return testSuite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestStepContainer createTestStepContainer()
  {
    TestStepContainerImpl testStepContainer = new TestStepContainerImpl();
    return testStepContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestSetup createTestSetup()
  {
    TestSetupImpl testSetup = new TestSetupImpl();
    return testSetup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestCase createTestCase()
  {
    TestCaseImpl testCase = new TestCaseImpl();
    return testCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestData createTestData()
  {
    TestDataImpl testData = new TestDataImpl();
    return testData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestStep createTestStep()
  {
    TestStepImpl testStep = new TestStepImpl();
    return testStep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Given createGiven()
  {
    GivenImpl given = new GivenImpl();
    return given;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public When createWhen()
  {
    WhenImpl when = new WhenImpl();
    return when;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Then createThen()
  {
    ThenImpl then = new ThenImpl();
    return then;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public And createAnd()
  {
    AndImpl and = new AndImpl();
    return and;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Text createText()
  {
    TextImpl text = new TextImpl();
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StatementList createStatementList()
  {
    StatementListImpl statementList = new StatementListImpl();
    return statementList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Table createTable()
  {
    TableImpl table = new TableImpl();
    return table;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Row createRow()
  {
    RowImpl row = new RowImpl();
    return row;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Cell createCell()
  {
    CellImpl cell = new CellImpl();
    return cell;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SheepDogPackage getSheepDogPackage()
  {
    return (SheepDogPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SheepDogPackage getPackage()
  {
    return SheepDogPackage.eINSTANCE;
  }

} //SheepDogFactoryImpl
