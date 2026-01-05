package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SheepDogBuilder {

	private static final Logger logger = LoggerFactory.getLogger(SheepDogBuilder.class);

	public static IStepObject createTestStepReferencedElements(ITestStep theTestStep) throws Exception {
		// I need to figure out a better name for this or a pattern for claude to
		// recognise
		logger.debug("Entering createTestStepReferencedElements for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
		IStepObject theStepObject = theProject.getStepObject(qualifiedName);
		if (theStepObject == null) {
			theStepObject = SheepDogFactory.instance.createStepObject(qualifiedName);
		}
		String stepDefinitonName = TestStepUtility.getStepDefinitionName(theTestStep.getName());
		IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitonName);
		if (theStepDefinition == null) {
			theStepDefinition = createStepDefinition(theStepObject, stepDefinitonName);
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
	}

	public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
		logger.debug("Entering createStepDefinition for name: {}", name);
		IStepDefinition stepDefinition = parent.getStepDefinition(name);
		if (stepDefinition == null) {
			stepDefinition = SheepDogFactory.instance.createStepDefinition(name);
			parent.addStepDefinition(stepDefinition);
		}
		logger.debug("Exiting createStepDefinition");
		return stepDefinition;
	}

	public static IStepObject createStepObject(ITestProject parent, String qualifiedName) {
		logger.debug("Entering createStepObject for qualifiedName: {}", qualifiedName);
		IStepObject stepObject = parent.getStepObject(qualifiedName);
		if (stepObject == null) {
			stepObject = SheepDogFactory.instance.createStepObject(qualifiedName);
			parent.addStepObject(stepObject);
		}
		logger.debug("Exiting createStepObject");
		return stepObject;
	}

	public static IStepParameters createStepParameters(IStepDefinition parent, IRow header) {
		logger.debug("Entering createStepParameters for IRow");
		IStepParameters stepParameters = parent.getStepParameters(header);
		if (stepParameters == null) {
			stepParameters = SheepDogFactory.instance.createStepParameters(header);
			parent.addStepParameters(stepParameters);
		}
		logger.debug("Exiting createStepParameters");
		return stepParameters;
	}

	public static IStepParameters createStepParameters(IStepDefinition parent, IText header) {
		logger.debug("Entering createStepParameters for IText");
		IStepParameters stepParameters = parent.getStepParameters(header);
		if (stepParameters == null) {
			stepParameters = SheepDogFactory.instance.createStepParameters(header);
			parent.addStepParameters(stepParameters);
		}
		logger.debug("Exiting createStepParameters");
		return stepParameters;
	}

	public static ITestCase createTestCase(ITestSuite parent, String name) {
		logger.debug("Entering createTestCase for name: {}", name);
		ITestCase testCase = (ITestCase) parent.getTestStepContainer(name);
		if (testCase == null) {
			testCase = SheepDogFactory.instance.createTestCase(name);
			parent.addTestCase(testCase);
		}
		logger.debug("Exiting createTestCase");
		return testCase;
	}

	public static ITestSetup createTestSetup(ITestSuite parent, String name) {
		logger.debug("Entering createTestSetup for name: {}", name);
		ITestSetup testSetup = (ITestSetup) parent.getTestStepContainer(name);
		if (testSetup == null) {
			testSetup = SheepDogFactory.instance.createTestSetup(name);
			parent.addTestSetup(testSetup);
		}
		logger.debug("Exiting createTestSetup");
		return testSetup;
	}

	public static ITestStep createTestStep(ITestStepContainer parent, String name) {
		logger.debug("Entering createTestStep for name: {}", name);
		// No need to check if step exists, because a test case can have multiple steps
		ITestStep testStep = SheepDogFactory.instance.createTestStep(name);
		parent.addTestStep(testStep);
		logger.debug("Exiting createTestStep");
		return testStep;
	}

	public static ITestSuite createTestSuite(ITestProject parent, String qualifiedName) {
		logger.debug("Entering createTestSuite for qualifiedName: {}", qualifiedName);
		ITestSuite testSuite = parent.getTestSuite(qualifiedName);
		if (testSuite == null) {
			testSuite = SheepDogFactory.instance.createTestSuite(qualifiedName);
			parent.addTestSuite(testSuite);
		}
		logger.debug("Exiting createTestSuite");
		return testSuite;
	}

}
