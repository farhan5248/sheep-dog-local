package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class TestStepIssueDetector {

	// Valid object ending words for test step validation
	private static final String[] OBJECT_ENDING_WORDS = {
		"page", "response", "file", "directory", "dialog", "popup",
		"annotation", "hover", "tooltip", "request", "goal", "job", "action"
	};

	// Valid state types for step definition name validation
	private static final String[] STATE_TYPES = {
		" is ", " isn't ", " will be ", " won't be "
	};

	public static String validateNameOnly(ITestStep theTestStep) {
		Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);
		logger.debug("Entering validateNameOnly");

		String fullName = theTestStep.getFullName();
		if (fullName == null || fullName.isEmpty()) {
			logger.debug("Exiting validateNameOnly - name is empty");
			return "";
		}

		// Check if the test step has a valid object name
		boolean hasValidObject = false;
		String lowerCaseName = fullName.toLowerCase();

		for (String objectWord : OBJECT_ENDING_WORDS) {
			if (lowerCaseName.contains(" " + objectWord + " ") ||
			    lowerCaseName.endsWith(" " + objectWord)) {
				hasValidObject = true;
				break;
			}
		}

		if (!hasValidObject) {
			logger.debug("Exiting validateNameOnly - no valid object name found");
			return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
		}

		// Check if the test step has a valid state
		boolean hasValidState = false;
		for (String state : STATE_TYPES) {
			if (lowerCaseName.contains(state)) {
				hasValidState = true;
				break;
			}
		}

		if (!hasValidState) {
			logger.debug("Exiting validateNameOnly - no valid state found");
			return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
		}

		logger.debug("Exiting validateNameOnly - validation passed");
		return "";
	}

	public static String validateStepObjectNameWorkspace(ITestStep theTestStep, ITestProject testProject) {
		Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);
		logger.debug("Entering validateStepObjectNameWorkspace");

		if (testProject == null) {
			logger.debug("Exiting validateStepObjectNameWorkspace - no test project");
			return "";
		}

		// Get the step object full name
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep, testProject);
		if (stepObjectFullName == null || stepObjectFullName.isEmpty()) {
			logger.debug("Exiting validateStepObjectNameWorkspace - no step object name");
			return "";
		}

		// Check if the step object file exists in the workspace
		ITestDocument stepObjectDoc = testProject.getTestDocument(stepObjectFullName);
		if (stepObjectDoc == null) {
			logger.debug("Exiting validateStepObjectNameWorkspace - step object file does not exist");
			return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
		}

		logger.debug("Exiting validateStepObjectNameWorkspace - validation passed");
		return "";
	}

	public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep, ITestProject testProject) {
		Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);
		logger.debug("Entering validateStepDefinitionNameWorkspace");

		if (testProject == null) {
			logger.debug("Exiting validateStepDefinitionNameWorkspace - no test project");
			return "";
		}

		// Get the step object full name
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep, testProject);
		if (stepObjectFullName == null || stepObjectFullName.isEmpty()) {
			logger.debug("Exiting validateStepDefinitionNameWorkspace - no step object name");
			return "";
		}

		// Check if the step object file exists in the workspace
		ITestDocument stepObjectDoc = testProject.getTestDocument(stepObjectFullName);
		if (stepObjectDoc == null) {
			logger.debug("Exiting validateStepDefinitionNameWorkspace - step object file does not exist");
			return "";
		}

		// Check if the step object file is an IStepObject
		if (!(stepObjectDoc instanceof IStepObject)) {
			logger.debug("Exiting validateStepDefinitionNameWorkspace - step object file is not an IStepObject");
			return "";
		}

		// Get the step definition name from the test step
		String stepDefinitionName = theTestStep.getStepDefinitionName();
		if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
			logger.debug("Exiting validateStepDefinitionNameWorkspace - no step definition name");
			return "";
		}

		// Check if the step definition exists in the step object file
		IStepObject stepObject = (IStepObject) stepObjectDoc;
		IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
		if (stepDefinition == null) {
			logger.debug("Exiting validateStepDefinitionNameWorkspace - step definition does not exist");
			return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
		}

		logger.debug("Exiting validateStepDefinitionNameWorkspace - validation passed");
		return "";
	}
}
