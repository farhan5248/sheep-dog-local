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
}
