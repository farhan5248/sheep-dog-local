package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueDetector.class);

	public static String getErrorMessage(String text) {
		// TODO make tests for all of these documenting the message content

		if (text == null) {
			return TestStepIssueTypes.NAME_COMPONENT.value;
		}

		if (!TestStepUtility.hasObject(text)) {
			if (!TestStepUtility.hasComponent(text)) {
				return TestStepIssueTypes.NAME_COMPONENT.value + "\n\n" + TestStepIssueTypes.NAME_OBJECT.value;
			} else {
				return TestStepIssueTypes.NAME_OBJECT.value;
			}
		} else {
			// There can't be a predicate since it's invalid so is there at least state
			if (!TestStepUtility.hasState(text)) {
				if (!TestStepUtility.hasDetails(text)) {
					return TestStepIssueTypes.NAME_STATE.value + "\n\n" + TestStepIssueTypes.NAME_DETAILS.value;
				} else {
					return TestStepIssueTypes.NAME_STATE.value;
				}
			} else {
				// if there's a state but it's still invalid, the only part after that is time
				// or
				// "is as" which passes for "is present" etc
				if (!TestStepUtility.hasTime(text)) {
					return TestStepIssueTypes.NAME_TIME.value;
				} else {
					// put all the error messages because there's something weird
					return TestStepIssueTypes.NAME_COMPONENT.value + "\n\n" + TestStepIssueTypes.NAME_OBJECT.value
							+ "\n\n" + TestStepIssueTypes.NAME_DETAILS.value + "\n\n"
							+ TestStepIssueTypes.NAME_STATE.value + "\n\n" + TestStepIssueTypes.NAME_TIME.value;
				}
			}
		}
	}

	public static boolean isValid(String text) {
		return text.matches(TestStepUtility.REGEX);
	}

	public static String getErrorMessage(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateError for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {
			if (!isValid(theTestStep.getName())) {
				logger.debug("Exiting validateError");
				return getErrorMessage(theTestStep.getName());
			} else {
				if (theTestStep.getParent().getTestStepList().getFirst().equals(theTestStep)) {
					if (TestStepUtility.getComponent(theTestStep.getName()).isEmpty()) {
						logger.debug("Exiting validateError");
						return TestStepIssueTypes.FIRST_STEP_COMPONENT.value;
					}
				}
				logger.debug("Exiting validateError");
				return "";
			}
		} catch (Exception e) {
			logger.error("Failed in validateError for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static String getWarningMessage(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateWarning for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {

			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			IStepObject theStepObject = theProject.getStepObject(TestStepUtility.getObjectQualifiedName(theTestStep));
			if (theStepObject == null) {
				return TestStepIssueTypes.STEP_OBJECT_NOT_FOUND.value;
			}
			IStepDefinition theStepDefinition = theStepObject
					.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
			if (theStepDefinition == null) {
				return TestStepIssueTypes.PREDICATE_NOT_FOUND.value;
			}
			if (theTestStep.getTable() != null) {
				if (!theTestStep.getTable().isEmpty()) {
					if (theStepDefinition.getStepParameters(theTestStep.getTable().getFirst()) == null) {
						return TestStepIssueTypes.PARAMETERS_NOT_FOUND.value;
					}
				}
			}
			if (theTestStep.getText() != null) {
				if (!theTestStep.getText().isEmpty()) {
					if (theStepDefinition.getStepParameters(theTestStep.getText()) == null) {
						return TestStepIssueTypes.PARAMETERS_NOT_FOUND.value;
					}
				}
			}
			logger.debug("Exiting validateWarning");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateWarning for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
