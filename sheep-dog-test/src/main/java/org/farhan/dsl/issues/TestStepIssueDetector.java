package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueDetector.class);

	public static boolean isValid(String text) {
		return text.matches(TestStepUtility.REGEX);
	}

	// TODO make tests for all of these documenting the message content
	// TODO instead of returning strings, return the enum alone, including enum for
	// no error
	public static String validateName(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateName for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {
			String text = theTestStep.getName();
			if (!isValid(text)) {
				logger.debug("Exiting validateName");
				if (text == null) {
					return TestStepIssueTypes.TESTSTEP_NAME_COMPONENT.description;
				}

				if (!TestStepUtility.hasObject(text)) {
					if (!TestStepUtility.hasComponent(text)) {
						return TestStepIssueTypes.TESTSTEP_NAME_COMPONENT.description + "\n\n"
								+ TestStepIssueTypes.TESTSTEP_NAME_OBJECT.description;
					} else {
						return TestStepIssueTypes.TESTSTEP_NAME_OBJECT.description;
					}
				} else {
					// There can't be a predicate since it's invalid so is there at least state
					if (!TestStepUtility.hasState(text)) {
						if (!TestStepUtility.hasDetails(text)) {
							return TestStepIssueTypes.TESTSTEP_NAME_STATE.description + "\n\n"
									+ TestStepIssueTypes.TESTSTEP_NAME_DETAILS.description;
						} else {
							return TestStepIssueTypes.TESTSTEP_NAME_STATE.description;
						}
					} else {
						// if there's a state but it's still invalid, the only part after that is time
						// or "is as" which passes for "is present" etc
						if (!TestStepUtility.hasTime(text)) {
							return TestStepIssueTypes.TESTSTEP_NAME_TIME.description;
						} else {
							// put all the error messages because there's something weird
							return TestStepIssueTypes.TESTSTEP_NAME_COMPONENT.description + "\n\n"
									+ TestStepIssueTypes.TESTSTEP_NAME_OBJECT.description + "\n\n"
									+ TestStepIssueTypes.TESTSTEP_NAME_DETAILS.description + "\n\n"
									+ TestStepIssueTypes.TESTSTEP_NAME_STATE.description + "\n\n"
									+ TestStepIssueTypes.TESTSTEP_NAME_TIME.description;
						}
					}
				}
			}
			logger.debug("Exiting validateName");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateName for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static String validateReference(ITestStep theTestStep) throws Exception {
		// TODO instead of returning strings, return the enum alone, including enum for
		// no error
		logger.debug("Entering validateReference for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {

			ArrayList<ITestStep> testStepList = theTestStep.getParent().getTestStepList();
			if (testStepList != null) {
				if (!testStepList.isEmpty()) {
					if (TestStepUtility.getComponent(testStepList.getFirst().getName()).isEmpty()) {
						logger.debug("Exiting validateReference");
						return TestStepIssueTypes.TESTSTEP_REFERENCE_COMPONENT.description;
					}
				}
			}
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			if (theStepObject == null) {
				logger.debug("Exiting validateReference");
				return TestStepIssueTypes.TESTSTEP_REFERENCE_STEP_OBJECT.description;
			}
			IStepDefinition theStepDefinition = theStepObject
					.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
			if (theStepDefinition == null) {
				logger.debug("Exiting validateReference");
				return TestStepIssueTypes.TESTSTEP_REFERENCE_STEP_DEFINITION.description;
			}
			
			if (theTestStep.getText() != null) {
				if (!theTestStep.getText().getName().isEmpty()) {
					ArrayList<String> headers = new ArrayList<String>();
					headers.add("Content");
					if (theStepDefinition.getStepParametersTmp(headers) == null) {
						logger.debug("Exiting validateReference");
						return RowIssueTypes.ROW_REFERENCE_CELL_LIST.description;
					}
				}
			}
			logger.debug("Exiting validateReference");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateReference for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
