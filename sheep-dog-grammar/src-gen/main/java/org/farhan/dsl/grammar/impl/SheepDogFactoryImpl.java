/**
 */
package org.farhan.dsl.grammar.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.farhan.dsl.grammar.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SheepDogFactoryImpl extends EFactoryImpl implements ISheepDogFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ISheepDogFactory init()
	{
		try
		{
			ISheepDogFactory theSheepDogFactory = (ISheepDogFactory)EPackage.Registry.INSTANCE.getEFactory(ISheepDogPackage.eNS_URI);
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
			case ISheepDogPackage.TEST_PROJECT: return (EObject)createTestProject();
			case ISheepDogPackage.STEP_OBJECT: return (EObject)createStepObject();
			case ISheepDogPackage.STEP_DEFINITION: return (EObject)createStepDefinition();
			case ISheepDogPackage.STEP_PARAMETERS: return (EObject)createStepParameters();
			case ISheepDogPackage.TEST_SUITE: return (EObject)createTestSuite();
			case ISheepDogPackage.TEST_STEP_CONTAINER: return (EObject)createTestStepContainer();
			case ISheepDogPackage.TEST_SETUP: return (EObject)createTestSetup();
			case ISheepDogPackage.TEST_CASE: return (EObject)createTestCase();
			case ISheepDogPackage.TEST_DATA: return (EObject)createTestData();
			case ISheepDogPackage.TEST_STEP: return (EObject)createTestStep();
			case ISheepDogPackage.GIVEN: return (EObject)createGiven();
			case ISheepDogPackage.WHEN: return (EObject)createWhen();
			case ISheepDogPackage.THEN: return (EObject)createThen();
			case ISheepDogPackage.AND: return (EObject)createAnd();
			case ISheepDogPackage.TEXT: return (EObject)createText();
			case ISheepDogPackage.TABLE: return (EObject)createTable();
			case ISheepDogPackage.ROW: return (EObject)createRow();
			case ISheepDogPackage.CELL: return (EObject)createCell();
			case ISheepDogPackage.DESCRIPTION: return (EObject)createDescription();
			case ISheepDogPackage.LINE: return (EObject)createLine();
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
	public ITestProject createTestProject()
	{
		TestProjectImpl testProject = new TestProjectImpl();
		return testProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IStepObject createStepObject()
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
	public IStepDefinition createStepDefinition()
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
	public IStepParameters createStepParameters()
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
	public ITestSuite createTestSuite()
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
	public ITestStepContainer createTestStepContainer()
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
	public ITestSetup createTestSetup()
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
	public ITestCase createTestCase()
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
	public ITestData createTestData()
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
	public ITestStep createTestStep()
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
	public IGiven createGiven()
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
	public IWhen createWhen()
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
	public IThen createThen()
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
	public IAnd createAnd()
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
	public IText createText()
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
	public ITable createTable()
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
	public IRow createRow()
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
	public ICell createCell()
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
	public IDescription createDescription()
	{
		DescriptionImpl description = new DescriptionImpl();
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ILine createLine()
	{
		LineImpl line = new LineImpl();
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ISheepDogPackage getSheepDogPackage()
	{
		return (ISheepDogPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ISheepDogPackage getPackage()
	{
		return ISheepDogPackage.eINSTANCE;
	}

} //SheepDogFactoryImpl
