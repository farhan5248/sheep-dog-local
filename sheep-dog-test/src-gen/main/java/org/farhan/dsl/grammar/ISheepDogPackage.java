/**
 */
package org.farhan.dsl.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.farhan.dsl.grammar.ISheepDogFactory
 * @model kind="package"
 * @generated
 */
public interface ISheepDogPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "grammar";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.farhan.org/dsl/sheepdog";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sheepDog";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ISheepDogPackage eINSTANCE = org.farhan.dsl.grammar.impl.SheepDogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestProjectImpl <em>Test Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestProjectImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestProject()
	 * @generated
	 */
	int TEST_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROJECT__FILE_EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Test Document List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROJECT__TEST_DOCUMENT_LIST = 2;

	/**
	 * The number of structural features of the '<em>Test Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROJECT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestDocumentImpl <em>Test Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestDocumentImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestDocument()
	 * @generated
	 */
	int TEST_DOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOCUMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOCUMENT__FULL_NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOCUMENT__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Test Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOCUMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.StepObjectImpl <em>Step Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.StepObjectImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getStepObject()
	 * @generated
	 */
	int STEP_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OBJECT__NAME = TEST_DOCUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OBJECT__FULL_NAME = TEST_DOCUMENT__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OBJECT__DESCRIPTION = TEST_DOCUMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Step Definition List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OBJECT__STEP_DEFINITION_LIST = TEST_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Step Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OBJECT_FEATURE_COUNT = TEST_DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.StepDefinitionImpl <em>Step Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.StepDefinitionImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getStepDefinition()
	 * @generated
	 */
	int STEP_DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_DEFINITION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Step Parameter List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_DEFINITION__STEP_PARAMETER_LIST = 2;

	/**
	 * The number of structural features of the '<em>Step Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.StepParametersImpl <em>Step Parameters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.StepParametersImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getStepParameters()
	 * @generated
	 */
	int STEP_PARAMETERS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_PARAMETERS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_PARAMETERS__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_PARAMETERS__TABLE = 2;

	/**
	 * The number of structural features of the '<em>Step Parameters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_PARAMETERS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestSuiteImpl <em>Test Suite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestSuiteImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestSuite()
	 * @generated
	 */
	int TEST_SUITE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__NAME = TEST_DOCUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__FULL_NAME = TEST_DOCUMENT__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__DESCRIPTION = TEST_DOCUMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Test Step Container List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__TEST_STEP_CONTAINER_LIST = TEST_DOCUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Suite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_FEATURE_COUNT = TEST_DOCUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestStepContainerImpl <em>Test Step Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestStepContainerImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestStepContainer()
	 * @generated
	 */
	int TEST_STEP_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_CONTAINER__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Test Step List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_CONTAINER__TEST_STEP_LIST = 2;

	/**
	 * The number of structural features of the '<em>Test Step Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_CONTAINER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestSetupImpl <em>Test Setup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestSetupImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestSetup()
	 * @generated
	 */
	int TEST_SETUP = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SETUP__NAME = TEST_STEP_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SETUP__DESCRIPTION = TEST_STEP_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Test Step List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SETUP__TEST_STEP_LIST = TEST_STEP_CONTAINER__TEST_STEP_LIST;

	/**
	 * The number of structural features of the '<em>Test Setup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SETUP_FEATURE_COUNT = TEST_STEP_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestCaseImpl <em>Test Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestCaseImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestCase()
	 * @generated
	 */
	int TEST_CASE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__NAME = TEST_STEP_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__DESCRIPTION = TEST_STEP_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Test Step List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__TEST_STEP_LIST = TEST_STEP_CONTAINER__TEST_STEP_LIST;

	/**
	 * The feature id for the '<em><b>Test Data List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__TEST_DATA_LIST = TEST_STEP_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_FEATURE_COUNT = TEST_STEP_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestDataImpl <em>Test Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestDataImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestData()
	 * @generated
	 */
	int TEST_DATA = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DATA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DATA__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DATA__TABLE = 2;

	/**
	 * The number of structural features of the '<em>Test Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DATA_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TestStepImpl <em>Test Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TestStepImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestStep()
	 * @generated
	 */
	int TEST_STEP = 10;

	/**
	 * The feature id for the '<em><b>Step Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__STEP_OBJECT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Step Definition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__STEP_DEFINITION_NAME = 1;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__FULL_NAME = 2;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__TABLE = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__TEXT = 4;

	/**
	 * The number of structural features of the '<em>Test Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.GivenImpl <em>Given</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.GivenImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getGiven()
	 * @generated
	 */
	int GIVEN = 11;

	/**
	 * The feature id for the '<em><b>Step Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIVEN__STEP_OBJECT_NAME = TEST_STEP__STEP_OBJECT_NAME;

	/**
	 * The feature id for the '<em><b>Step Definition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIVEN__STEP_DEFINITION_NAME = TEST_STEP__STEP_DEFINITION_NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIVEN__FULL_NAME = TEST_STEP__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIVEN__TABLE = TEST_STEP__TABLE;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIVEN__TEXT = TEST_STEP__TEXT;

	/**
	 * The number of structural features of the '<em>Given</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIVEN_FEATURE_COUNT = TEST_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.WhenImpl <em>When</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.WhenImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getWhen()
	 * @generated
	 */
	int WHEN = 12;

	/**
	 * The feature id for the '<em><b>Step Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN__STEP_OBJECT_NAME = TEST_STEP__STEP_OBJECT_NAME;

	/**
	 * The feature id for the '<em><b>Step Definition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN__STEP_DEFINITION_NAME = TEST_STEP__STEP_DEFINITION_NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN__FULL_NAME = TEST_STEP__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN__TABLE = TEST_STEP__TABLE;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN__TEXT = TEST_STEP__TEXT;

	/**
	 * The number of structural features of the '<em>When</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_FEATURE_COUNT = TEST_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.ThenImpl <em>Then</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.ThenImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getThen()
	 * @generated
	 */
	int THEN = 13;

	/**
	 * The feature id for the '<em><b>Step Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN__STEP_OBJECT_NAME = TEST_STEP__STEP_OBJECT_NAME;

	/**
	 * The feature id for the '<em><b>Step Definition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN__STEP_DEFINITION_NAME = TEST_STEP__STEP_DEFINITION_NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN__FULL_NAME = TEST_STEP__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN__TABLE = TEST_STEP__TABLE;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN__TEXT = TEST_STEP__TEXT;

	/**
	 * The number of structural features of the '<em>Then</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_FEATURE_COUNT = TEST_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.AndImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 14;

	/**
	 * The feature id for the '<em><b>Step Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__STEP_OBJECT_NAME = TEST_STEP__STEP_OBJECT_NAME;

	/**
	 * The feature id for the '<em><b>Step Definition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__STEP_DEFINITION_NAME = TEST_STEP__STEP_DEFINITION_NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__FULL_NAME = TEST_STEP__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__TABLE = TEST_STEP__TABLE;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__TEXT = TEST_STEP__TEXT;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = TEST_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TextImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 15;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.TableImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 16;

	/**
	 * The feature id for the '<em><b>Row List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ROW_LIST = 0;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.RowImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 17;

	/**
	 * The feature id for the '<em><b>Cell List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CELL_LIST = 0;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.CellImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.DescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.DescriptionImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getDescription()
	 * @generated
	 */
	int DESCRIPTION = 19;

	/**
	 * The feature id for the '<em><b>Line List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__LINE_LIST = 0;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.farhan.dsl.grammar.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.farhan.dsl.grammar.impl.LineImpl
	 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getLine()
	 * @generated
	 */
	int LINE = 20;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestProject <em>Test Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Project</em>'.
	 * @see org.farhan.dsl.grammar.ITestProject
	 * @generated
	 */
	EClass getTestProject();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestProject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestProject#getName()
	 * @see #getTestProject()
	 * @generated
	 */
	EAttribute getTestProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestProject#getFileExtension <em>File Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Extension</em>'.
	 * @see org.farhan.dsl.grammar.ITestProject#getFileExtension()
	 * @see #getTestProject()
	 * @generated
	 */
	EAttribute getTestProject_FileExtension();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.ITestProject#getTestDocumentList <em>Test Document List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Document List</em>'.
	 * @see org.farhan.dsl.grammar.ITestProject#getTestDocumentList()
	 * @see #getTestProject()
	 * @generated
	 */
	EReference getTestProject_TestDocumentList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestDocument <em>Test Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Document</em>'.
	 * @see org.farhan.dsl.grammar.ITestDocument
	 * @generated
	 */
	EClass getTestDocument();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestDocument#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestDocument#getName()
	 * @see #getTestDocument()
	 * @generated
	 */
	EAttribute getTestDocument_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestDocument#getFullName <em>Full Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestDocument#getFullName()
	 * @see #getTestDocument()
	 * @generated
	 */
	EAttribute getTestDocument_FullName();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.ITestDocument#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.farhan.dsl.grammar.ITestDocument#getDescription()
	 * @see #getTestDocument()
	 * @generated
	 */
	EReference getTestDocument_Description();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IStepObject <em>Step Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Object</em>'.
	 * @see org.farhan.dsl.grammar.IStepObject
	 * @generated
	 */
	EClass getStepObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.IStepObject#getStepDefinitionList <em>Step Definition List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Step Definition List</em>'.
	 * @see org.farhan.dsl.grammar.IStepObject#getStepDefinitionList()
	 * @see #getStepObject()
	 * @generated
	 */
	EReference getStepObject_StepDefinitionList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IStepDefinition <em>Step Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Definition</em>'.
	 * @see org.farhan.dsl.grammar.IStepDefinition
	 * @generated
	 */
	EClass getStepDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.IStepDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.farhan.dsl.grammar.IStepDefinition#getName()
	 * @see #getStepDefinition()
	 * @generated
	 */
	EAttribute getStepDefinition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.IStepDefinition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.farhan.dsl.grammar.IStepDefinition#getDescription()
	 * @see #getStepDefinition()
	 * @generated
	 */
	EReference getStepDefinition_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.IStepDefinition#getStepParameterList <em>Step Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Step Parameter List</em>'.
	 * @see org.farhan.dsl.grammar.IStepDefinition#getStepParameterList()
	 * @see #getStepDefinition()
	 * @generated
	 */
	EReference getStepDefinition_StepParameterList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IStepParameters <em>Step Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Parameters</em>'.
	 * @see org.farhan.dsl.grammar.IStepParameters
	 * @generated
	 */
	EClass getStepParameters();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.IStepParameters#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.farhan.dsl.grammar.IStepParameters#getName()
	 * @see #getStepParameters()
	 * @generated
	 */
	EAttribute getStepParameters_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.IStepParameters#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.farhan.dsl.grammar.IStepParameters#getDescription()
	 * @see #getStepParameters()
	 * @generated
	 */
	EReference getStepParameters_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.IStepParameters#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Table</em>'.
	 * @see org.farhan.dsl.grammar.IStepParameters#getTable()
	 * @see #getStepParameters()
	 * @generated
	 */
	EReference getStepParameters_Table();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestSuite <em>Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Suite</em>'.
	 * @see org.farhan.dsl.grammar.ITestSuite
	 * @generated
	 */
	EClass getTestSuite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.ITestSuite#getTestStepContainerList <em>Test Step Container List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Step Container List</em>'.
	 * @see org.farhan.dsl.grammar.ITestSuite#getTestStepContainerList()
	 * @see #getTestSuite()
	 * @generated
	 */
	EReference getTestSuite_TestStepContainerList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestStepContainer <em>Test Step Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Step Container</em>'.
	 * @see org.farhan.dsl.grammar.ITestStepContainer
	 * @generated
	 */
	EClass getTestStepContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestStepContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestStepContainer#getName()
	 * @see #getTestStepContainer()
	 * @generated
	 */
	EAttribute getTestStepContainer_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.ITestStepContainer#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.farhan.dsl.grammar.ITestStepContainer#getDescription()
	 * @see #getTestStepContainer()
	 * @generated
	 */
	EReference getTestStepContainer_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.ITestStepContainer#getTestStepList <em>Test Step List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Step List</em>'.
	 * @see org.farhan.dsl.grammar.ITestStepContainer#getTestStepList()
	 * @see #getTestStepContainer()
	 * @generated
	 */
	EReference getTestStepContainer_TestStepList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestSetup <em>Test Setup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Setup</em>'.
	 * @see org.farhan.dsl.grammar.ITestSetup
	 * @generated
	 */
	EClass getTestSetup();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case</em>'.
	 * @see org.farhan.dsl.grammar.ITestCase
	 * @generated
	 */
	EClass getTestCase();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.ITestCase#getTestDataList <em>Test Data List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Data List</em>'.
	 * @see org.farhan.dsl.grammar.ITestCase#getTestDataList()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_TestDataList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestData <em>Test Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Data</em>'.
	 * @see org.farhan.dsl.grammar.ITestData
	 * @generated
	 */
	EClass getTestData();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestData#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestData#getName()
	 * @see #getTestData()
	 * @generated
	 */
	EAttribute getTestData_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.ITestData#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.farhan.dsl.grammar.ITestData#getDescription()
	 * @see #getTestData()
	 * @generated
	 */
	EReference getTestData_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.ITestData#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Table</em>'.
	 * @see org.farhan.dsl.grammar.ITestData#getTable()
	 * @see #getTestData()
	 * @generated
	 */
	EReference getTestData_Table();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Step</em>'.
	 * @see org.farhan.dsl.grammar.ITestStep
	 * @generated
	 */
	EClass getTestStep();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestStep#getStepObjectName <em>Step Object Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Object Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestStep#getStepObjectName()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_StepObjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestStep#getStepDefinitionName <em>Step Definition Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Definition Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestStep#getStepDefinitionName()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_StepDefinitionName();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ITestStep#getFullName <em>Full Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Name</em>'.
	 * @see org.farhan.dsl.grammar.ITestStep#getFullName()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_FullName();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.ITestStep#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Table</em>'.
	 * @see org.farhan.dsl.grammar.ITestStep#getTable()
	 * @see #getTestStep()
	 * @generated
	 */
	EReference getTestStep_Table();

	/**
	 * Returns the meta object for the containment reference '{@link org.farhan.dsl.grammar.ITestStep#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text</em>'.
	 * @see org.farhan.dsl.grammar.ITestStep#getText()
	 * @see #getTestStep()
	 * @generated
	 */
	EReference getTestStep_Text();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IGiven <em>Given</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Given</em>'.
	 * @see org.farhan.dsl.grammar.IGiven
	 * @generated
	 */
	EClass getGiven();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>When</em>'.
	 * @see org.farhan.dsl.grammar.IWhen
	 * @generated
	 */
	EClass getWhen();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Then</em>'.
	 * @see org.farhan.dsl.grammar.IThen
	 * @generated
	 */
	EClass getThen();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IAnd <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see org.farhan.dsl.grammar.IAnd
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.farhan.dsl.grammar.IText
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.IText#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.farhan.dsl.grammar.IText#getContent()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Content();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ITable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.farhan.dsl.grammar.ITable
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.ITable#getRowList <em>Row List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row List</em>'.
	 * @see org.farhan.dsl.grammar.ITable#getRowList()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_RowList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see org.farhan.dsl.grammar.IRow
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.IRow#getCellList <em>Cell List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell List</em>'.
	 * @see org.farhan.dsl.grammar.IRow#getCellList()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_CellList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ICell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see org.farhan.dsl.grammar.ICell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ICell#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.farhan.dsl.grammar.ICell#getName()
	 * @see #getCell()
	 * @generated
	 */
	EAttribute getCell_Name();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.IDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see org.farhan.dsl.grammar.IDescription
	 * @generated
	 */
	EClass getDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link org.farhan.dsl.grammar.IDescription#getLineList <em>Line List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Line List</em>'.
	 * @see org.farhan.dsl.grammar.IDescription#getLineList()
	 * @see #getDescription()
	 * @generated
	 */
	EReference getDescription_LineList();

	/**
	 * Returns the meta object for class '{@link org.farhan.dsl.grammar.ILine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see org.farhan.dsl.grammar.ILine
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the attribute '{@link org.farhan.dsl.grammar.ILine#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.farhan.dsl.grammar.ILine#getContent()
	 * @see #getLine()
	 * @generated
	 */
	EAttribute getLine_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ISheepDogFactory getSheepDogFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestProjectImpl <em>Test Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestProjectImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestProject()
		 * @generated
		 */
		EClass TEST_PROJECT = eINSTANCE.getTestProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_PROJECT__NAME = eINSTANCE.getTestProject_Name();

		/**
		 * The meta object literal for the '<em><b>File Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_PROJECT__FILE_EXTENSION = eINSTANCE.getTestProject_FileExtension();

		/**
		 * The meta object literal for the '<em><b>Test Document List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_PROJECT__TEST_DOCUMENT_LIST = eINSTANCE.getTestProject_TestDocumentList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestDocumentImpl <em>Test Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestDocumentImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestDocument()
		 * @generated
		 */
		EClass TEST_DOCUMENT = eINSTANCE.getTestDocument();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_DOCUMENT__NAME = eINSTANCE.getTestDocument_Name();

		/**
		 * The meta object literal for the '<em><b>Full Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_DOCUMENT__FULL_NAME = eINSTANCE.getTestDocument_FullName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_DOCUMENT__DESCRIPTION = eINSTANCE.getTestDocument_Description();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.StepObjectImpl <em>Step Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.StepObjectImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getStepObject()
		 * @generated
		 */
		EClass STEP_OBJECT = eINSTANCE.getStepObject();

		/**
		 * The meta object literal for the '<em><b>Step Definition List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP_OBJECT__STEP_DEFINITION_LIST = eINSTANCE.getStepObject_StepDefinitionList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.StepDefinitionImpl <em>Step Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.StepDefinitionImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getStepDefinition()
		 * @generated
		 */
		EClass STEP_DEFINITION = eINSTANCE.getStepDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP_DEFINITION__NAME = eINSTANCE.getStepDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP_DEFINITION__DESCRIPTION = eINSTANCE.getStepDefinition_Description();

		/**
		 * The meta object literal for the '<em><b>Step Parameter List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP_DEFINITION__STEP_PARAMETER_LIST = eINSTANCE.getStepDefinition_StepParameterList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.StepParametersImpl <em>Step Parameters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.StepParametersImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getStepParameters()
		 * @generated
		 */
		EClass STEP_PARAMETERS = eINSTANCE.getStepParameters();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP_PARAMETERS__NAME = eINSTANCE.getStepParameters_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP_PARAMETERS__DESCRIPTION = eINSTANCE.getStepParameters_Description();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP_PARAMETERS__TABLE = eINSTANCE.getStepParameters_Table();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestSuiteImpl <em>Test Suite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestSuiteImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestSuite()
		 * @generated
		 */
		EClass TEST_SUITE = eINSTANCE.getTestSuite();

		/**
		 * The meta object literal for the '<em><b>Test Step Container List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE__TEST_STEP_CONTAINER_LIST = eINSTANCE.getTestSuite_TestStepContainerList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestStepContainerImpl <em>Test Step Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestStepContainerImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestStepContainer()
		 * @generated
		 */
		EClass TEST_STEP_CONTAINER = eINSTANCE.getTestStepContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP_CONTAINER__NAME = eINSTANCE.getTestStepContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP_CONTAINER__DESCRIPTION = eINSTANCE.getTestStepContainer_Description();

		/**
		 * The meta object literal for the '<em><b>Test Step List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP_CONTAINER__TEST_STEP_LIST = eINSTANCE.getTestStepContainer_TestStepList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestSetupImpl <em>Test Setup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestSetupImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestSetup()
		 * @generated
		 */
		EClass TEST_SETUP = eINSTANCE.getTestSetup();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestCaseImpl <em>Test Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestCaseImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestCase()
		 * @generated
		 */
		EClass TEST_CASE = eINSTANCE.getTestCase();

		/**
		 * The meta object literal for the '<em><b>Test Data List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE__TEST_DATA_LIST = eINSTANCE.getTestCase_TestDataList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestDataImpl <em>Test Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestDataImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestData()
		 * @generated
		 */
		EClass TEST_DATA = eINSTANCE.getTestData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_DATA__NAME = eINSTANCE.getTestData_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_DATA__DESCRIPTION = eINSTANCE.getTestData_Description();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_DATA__TABLE = eINSTANCE.getTestData_Table();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TestStepImpl <em>Test Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TestStepImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTestStep()
		 * @generated
		 */
		EClass TEST_STEP = eINSTANCE.getTestStep();

		/**
		 * The meta object literal for the '<em><b>Step Object Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP__STEP_OBJECT_NAME = eINSTANCE.getTestStep_StepObjectName();

		/**
		 * The meta object literal for the '<em><b>Step Definition Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP__STEP_DEFINITION_NAME = eINSTANCE.getTestStep_StepDefinitionName();

		/**
		 * The meta object literal for the '<em><b>Full Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP__FULL_NAME = eINSTANCE.getTestStep_FullName();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP__TABLE = eINSTANCE.getTestStep_Table();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP__TEXT = eINSTANCE.getTestStep_Text();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.GivenImpl <em>Given</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.GivenImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getGiven()
		 * @generated
		 */
		EClass GIVEN = eINSTANCE.getGiven();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.WhenImpl <em>When</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.WhenImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getWhen()
		 * @generated
		 */
		EClass WHEN = eINSTANCE.getWhen();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.ThenImpl <em>Then</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.ThenImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getThen()
		 * @generated
		 */
		EClass THEN = eINSTANCE.getThen();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.AndImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TextImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__CONTENT = eINSTANCE.getText_Content();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.TableImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Row List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__ROW_LIST = eINSTANCE.getTable_RowList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.RowImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Cell List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CELL_LIST = eINSTANCE.getRow_CellList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.CellImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL__NAME = eINSTANCE.getCell_Name();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.DescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.DescriptionImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getDescription()
		 * @generated
		 */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
		 * The meta object literal for the '<em><b>Line List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION__LINE_LIST = eINSTANCE.getDescription_LineList();

		/**
		 * The meta object literal for the '{@link org.farhan.dsl.grammar.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.farhan.dsl.grammar.impl.LineImpl
		 * @see org.farhan.dsl.grammar.impl.SheepDogPackageImpl#getLine()
		 * @generated
		 */
		EClass LINE = eINSTANCE.getLine();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE__CONTENT = eINSTANCE.getLine_Content();

	}

} //ISheepDogPackage
