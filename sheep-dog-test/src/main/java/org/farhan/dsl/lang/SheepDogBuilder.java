package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SheepDogBuilder {

	private static final Logger logger = LoggerFactory.getLogger(SheepDogBuilder.class);

	public static IStepObject createTestStepReferencedElements(ITestStep theTestStep) {
		// I need to figure out a better name for this or a pattern for claude to
		// recognise
		logger.debug("Entering createTestStepReferencedElements for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject == null) {
				theStepObject = SheepDogFactory.instance.createStepObject(qualifiedName);
			}
			String predicate = TestStepUtility.getStepDefinitionName(theTestStep.getName());
			IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
			if (theStepDefinition == null) {
				theStepDefinition = createStepDefinition(theStepObject, predicate);
			}
			if (theTestStep.getTable() != null) {
				if (!theTestStep.getTable().getRowList().isEmpty()) {
					IRow header = theTestStep.getTable().getRowList().getFirst();
					if (theStepDefinition.getStepParameters(header) == null) {
						createStepParameters(theStepDefinition, header);
					}
				}
			}
			if (theTestStep.getText() != null) {
				IText theText = theTestStep.getText();
				if (!theText.getName().isEmpty()) {
					if (theStepDefinition.getStepParameters(theText) == null) {
						createStepParameters(theStepDefinition, theText);
					}
				}
			}
			theProject.addStepObject(theStepObject);
			logger.debug("Exiting createTestStepReferencedElements");
			return theStepObject;
		} catch (Exception e) {
			logger.error("Failed in createTestStepReferencedElements for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
		}
		return null;
	}

	public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
		IStepDefinition stepDefinition = parent.getStepDefinition(name);
		if (stepDefinition == null) {
			stepDefinition = SheepDogFactory.instance.createStepDefinition(name);
			parent.addStepDefinition(stepDefinition);
		}
		return stepDefinition;
	}

	public static IStepObject createStepObject(ITestProject parent, String qualifiedName) {
		IStepObject stepObject = parent.getStepObject(qualifiedName);
		if (stepObject == null) {
			stepObject = SheepDogFactory.instance.createStepObject(qualifiedName);
			parent.addStepObject(stepObject);
		}
		return stepObject;
	}

	public static IStepParameters createStepParameters(IStepDefinition parent, IRow header) {
		IStepParameters stepParameters = parent.getStepParameters(header);
		if (stepParameters == null) {
			stepParameters = SheepDogFactory.instance.createStepParameters(header);
			parent.addStepParameters(stepParameters);
		}
		return stepParameters;
	}

	public static IStepParameters createStepParameters(IStepDefinition parent, IText header) {
		IStepParameters stepParameters = parent.getStepParameters(header);
		if (stepParameters == null) {
			stepParameters = SheepDogFactory.instance.createStepParameters(header);
			parent.addStepParameters(stepParameters);
		}
		return stepParameters;
	}

	public static ITestCase createTestCase(ITestSuite parent, String name) {
		ITestCase testCase = (ITestCase) parent.getTestStepContainer(name);
		if (testCase == null) {
			testCase = SheepDogFactory.instance.createTestCase(name);
			parent.addTestCase(testCase);
		}
		return testCase;
	}

	public static ITestSetup createTestSetup(ITestSuite parent, String name) {
		ITestSetup testSetup = (ITestSetup) parent.getTestStepContainer(name);
		if (testSetup == null) {
			testSetup = SheepDogFactory.instance.createTestSetup(name);
			parent.addTestSetup(testSetup);
		}
		return testSetup;
	}

	public static ITestStep createTestStep(ITestStepContainer parent, String name) {
		// No need to check if step exists, because a test case can have multiple steps
		ITestStep testStep = SheepDogFactory.instance.createTestStep(name);
		parent.addTestStep(testStep);
		return testStep;
	}

	public static ITestSuite createTestSuite(ITestProject parent, String qualifiedName) {
		ITestSuite testSuite = parent.getTestSuite(qualifiedName);
		if (testSuite == null) {
			testSuite = SheepDogFactory.instance.createTestSuite(qualifiedName);
			parent.addTestSuite(testSuite);
		}
		return testSuite;
	}

}
