package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SheepDogBuilder {

	private static final Logger logger = LoggerFactory.getLogger(SheepDogBuilder.class);

	public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
		IStepDefinition stepDefinition = parent.getStepDefinition(name);
		if (stepDefinition == null) {
			stepDefinition = SheepDogFactory.instance.createStepDefinition(name);
			stepDefinition.setParent(parent);
			parent.getStepDefinitionList().add(stepDefinition);
		}
		return stepDefinition;
	}

	public static IStepDefinition createStepDefinition(ITestStep theTestStep) throws Exception {
		logger.debug("Entering createStepDefinition for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject != null) {
				String predicate = TestStepUtility.getPredicate(theTestStep.getName());
				IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
				if (theStepDefinition == null) {
					theStepDefinition = createStepDefinition(theStepObject, predicate);
				}
				return theStepDefinition;
			}
			logger.debug("Exiting createStepDefinition");
			return null;
		} catch (Exception e) {
			logger.error("Failed in createStepDefinition for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static IStepObject createStepObject(ITestProject parent, String qualifiedName) {
		// TODO bad design of test code. The only reason this null check is needed is
		// because this create method is blindly called without checking if the object
		// exists first. Update the test code to check first.
		IStepObject stepObject = parent.getStepObject(qualifiedName);
		if (stepObject == null) {
			stepObject = SheepDogFactory.instance.createStepObject(qualifiedName);
			stepObject.setParent(parent);
			parent.getStepObjectList().add(stepObject);
		}
		return stepObject;
	}

	public static IStepObject createStepObject(ITestStep theTestStep) throws Exception {
		logger.debug("Entering createStepObject for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject == null) {
				theStepObject = createStepObject(theProject, qualifiedName);
			}
			logger.debug("Exiting createStepObject");
			return theStepObject;
		} catch (Exception e) {
			logger.error("Failed in createStepObject for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static IStepParameters createStepParameters(IStepDefinition parent, IRow row) {
		IStepParameters stepParameters = parent.getStepParameters(row);
		if (stepParameters == null) {
			stepParameters = SheepDogFactory.instance.createStepParameters(row);
			stepParameters.setParent(parent);
			parent.getStepParameterList().add(stepParameters);
		}
		return stepParameters;
	}

	public static IStepParameters createStepParameters(IStepDefinition parent, IText value) {
		IStepParameters stepParameters = parent.getStepParameters(value);
		if (stepParameters == null) {
			stepParameters = SheepDogFactory.instance.createStepParameters(value);
			stepParameters.setParent(parent);
			parent.getStepParameterList().add(stepParameters);
		}
		return stepParameters;
	}

	public static IStepParameters createStepParameters(ITestStep theTestStep) throws Exception {
		logger.debug("Entering createStepParameters for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			IStepParameters theStepParameters = null;
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject != null) {
				String predicate = TestStepUtility.getPredicate(theTestStep.getName());
				IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
				if (theStepDefinition != null) {
					if (theTestStep.getTable() != null) {
						if (!theTestStep.getTable().getRowList().isEmpty()) {
							if (theStepDefinition
									.getStepParameters(theTestStep.getTable().getRowList().getFirst()) == null) {
								theStepParameters = createStepParameters(theStepDefinition,
										theTestStep.getTable().getRowList().getFirst());
							}
						}
					}
					if (theTestStep.getText() != null) {
						IText theText = theTestStep.getText();
						if (!theText.getName().isEmpty()) {
							if (theStepDefinition.getStepParameters(theText) == null) {
								theStepParameters = createStepParameters(theStepDefinition, theText);
							}
						}
					}
				}
			}
			logger.debug("Exiting createStepParameters");
			return theStepParameters;
		} catch (Exception e) {
			logger.error("Failed in createStepParameters for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static ITestCase createTestCase(ITestSuite parent, String value) {
		ITestCase testCase = SheepDogFactory.instance.createTestCase(value);
		testCase.setParent(parent);
		parent.getTestStepContainerList().add(testCase);
		return testCase;
	}

	public static ITestSetup createTestSetup(ITestSuite parent, String name) {
		ITestSetup testSetup = SheepDogFactory.instance.createTestSetup(name);
		testSetup.setParent(parent);
		parent.getTestStepContainerList().add(testSetup);
		return testSetup;
	}

	public static ITestStep createTestStep(ITestStepContainer parent, String value) {
		ITestStep testStep = SheepDogFactory.instance.createTestStep(value);
		testStep.setParent(parent);
		parent.getTestStepList().add(testStep);
		return testStep;
	}

	public static ITestSuite createTestSuite(ITestProject parent, String qualifiedName) {
		ITestSuite testSuite = parent.getTestSuite(qualifiedName);
		if (testSuite == null) {
			testSuite = SheepDogFactory.instance.createTestSuite(qualifiedName);
			testSuite.setParent(parent);
			parent.getTestSuiteList().add(testSuite);
		}
		return testSuite;
	}

}
