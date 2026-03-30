/**
 */
package org.farhan.dsl.grammar.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.farhan.dsl.grammar.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.farhan.dsl.grammar.ISheepDogPackage
 * @generated
 */
public class SheepDogAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ISheepDogPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SheepDogAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ISheepDogPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SheepDogSwitch<Adapter> modelSwitch =
		new SheepDogSwitch<Adapter>()
		{
			@Override
			public Adapter caseTestProject(ITestProject object)
			{
				return createTestProjectAdapter();
			}
			@Override
			public Adapter caseTestDocument(ITestDocument object)
			{
				return createTestDocumentAdapter();
			}
			@Override
			public Adapter caseStepObject(IStepObject object)
			{
				return createStepObjectAdapter();
			}
			@Override
			public Adapter caseStepDefinition(IStepDefinition object)
			{
				return createStepDefinitionAdapter();
			}
			@Override
			public Adapter caseStepParameters(IStepParameters object)
			{
				return createStepParametersAdapter();
			}
			@Override
			public Adapter caseTestSuite(ITestSuite object)
			{
				return createTestSuiteAdapter();
			}
			@Override
			public Adapter caseTestStepContainer(ITestStepContainer object)
			{
				return createTestStepContainerAdapter();
			}
			@Override
			public Adapter caseTestSetup(ITestSetup object)
			{
				return createTestSetupAdapter();
			}
			@Override
			public Adapter caseTestCase(ITestCase object)
			{
				return createTestCaseAdapter();
			}
			@Override
			public Adapter caseTestData(ITestData object)
			{
				return createTestDataAdapter();
			}
			@Override
			public Adapter caseTestStep(ITestStep object)
			{
				return createTestStepAdapter();
			}
			@Override
			public Adapter caseGiven(IGiven object)
			{
				return createGivenAdapter();
			}
			@Override
			public Adapter caseWhen(IWhen object)
			{
				return createWhenAdapter();
			}
			@Override
			public Adapter caseThen(IThen object)
			{
				return createThenAdapter();
			}
			@Override
			public Adapter caseAnd(IAnd object)
			{
				return createAndAdapter();
			}
			@Override
			public Adapter caseText(IText object)
			{
				return createTextAdapter();
			}
			@Override
			public Adapter caseTable(ITable object)
			{
				return createTableAdapter();
			}
			@Override
			public Adapter caseRow(IRow object)
			{
				return createRowAdapter();
			}
			@Override
			public Adapter caseCell(ICell object)
			{
				return createCellAdapter();
			}
			@Override
			public Adapter caseDescription(IDescription object)
			{
				return createDescriptionAdapter();
			}
			@Override
			public Adapter caseLine(ILine object)
			{
				return createLineAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestProject <em>Test Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestProject
	 * @generated
	 */
	public Adapter createTestProjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestDocument <em>Test Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestDocument
	 * @generated
	 */
	public Adapter createTestDocumentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IStepObject <em>Step Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IStepObject
	 * @generated
	 */
	public Adapter createStepObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IStepDefinition <em>Step Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IStepDefinition
	 * @generated
	 */
	public Adapter createStepDefinitionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IStepParameters <em>Step Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IStepParameters
	 * @generated
	 */
	public Adapter createStepParametersAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestSuite <em>Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestSuite
	 * @generated
	 */
	public Adapter createTestSuiteAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestStepContainer <em>Test Step Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestStepContainer
	 * @generated
	 */
	public Adapter createTestStepContainerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestSetup <em>Test Setup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestSetup
	 * @generated
	 */
	public Adapter createTestSetupAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestCase
	 * @generated
	 */
	public Adapter createTestCaseAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestData <em>Test Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestData
	 * @generated
	 */
	public Adapter createTestDataAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITestStep
	 * @generated
	 */
	public Adapter createTestStepAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IGiven <em>Given</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IGiven
	 * @generated
	 */
	public Adapter createGivenAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IWhen
	 * @generated
	 */
	public Adapter createWhenAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IThen
	 * @generated
	 */
	public Adapter createThenAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IAnd <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IAnd
	 * @generated
	 */
	public Adapter createAndAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IText
	 * @generated
	 */
	public Adapter createTextAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ITable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ITable
	 * @generated
	 */
	public Adapter createTableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IRow
	 * @generated
	 */
	public Adapter createRowAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ICell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ICell
	 * @generated
	 */
	public Adapter createCellAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.IDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.IDescription
	 * @generated
	 */
	public Adapter createDescriptionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.farhan.dsl.grammar.ILine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.farhan.dsl.grammar.ILine
	 * @generated
	 */
	public Adapter createLineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //SheepDogAdapterFactory
