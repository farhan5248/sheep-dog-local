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
	public static String validateNameOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateNameOnly for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {
			String text = theTestStep.getName();
			if (!isValid(text)) {
				logger.debug("Exiting validateNameOnly");
				if (text == null) {
					return TestStepIssueTypes.TEST_STEP_NAME_COMPONENT_ONLY.description;
				}

				if (!TestStepUtility.hasObject(text)) {
					if (!TestStepUtility.hasComponent(text)) {
						return TestStepIssueTypes.TEST_STEP_NAME_COMPONENT_ONLY.description + "\n\n"
								+ TestStepIssueTypes.TEST_STEP_NAME_OBJECT_ONLY.description;
					} else {
						return TestStepIssueTypes.TEST_STEP_NAME_OBJECT_ONLY.description;
					}
				} else {
					// There can't be a predicate since it's invalid so is there at least state
					if (!TestStepUtility.hasState(text)) {
						if (!TestStepUtility.hasDetails(text)) {
							return TestStepIssueTypes.TEST_STEP_NAME_STATE_ONLY.description + "\n\n"
									+ TestStepIssueTypes.TEST_STEP_NAME_DETAILS_ONLY.description;
						} else {
							return TestStepIssueTypes.TEST_STEP_NAME_STATE_ONLY.description;
						}
					} else {
						// if there's a state but it's still invalid, the only part after that is time
						// or "is as" which passes for "is present" etc
						if (!TestStepUtility.hasTime(text)) {
							return TestStepIssueTypes.TEST_STEP_NAME_TIME_ONLY.description;
						} else {
							// put all the error messages because there's something weird
							return TestStepIssueTypes.TEST_STEP_NAME_COMPONENT_ONLY.description + "\n\n"
									+ TestStepIssueTypes.TEST_STEP_NAME_OBJECT_ONLY.description + "\n\n"
									+ TestStepIssueTypes.TEST_STEP_NAME_DETAILS_ONLY.description + "\n\n"
									+ TestStepIssueTypes.TEST_STEP_NAME_STATE_ONLY.description + "\n\n"
									+ TestStepIssueTypes.TEST_STEP_NAME_TIME_ONLY.description;
						}
					}
				}
			}
			logger.debug("Exiting validateNameOnly");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNameOnly for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static String validateNameWorkspace(ITestStep theTestStep) throws Exception {
		// TODO instead of returning strings, return the enum alone, including enum for
		// no error
		logger.debug("Entering validateNameWorkspace for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {

			ArrayList<ITestStep> testStepList = theTestStep.getParent().getTestStepList();
			if (testStepList != null) {
				if (!testStepList.isEmpty()) {
					if (TestStepUtility.getComponent(testStepList.getFirst().getName()).isEmpty()) {
						logger.debug("Exiting validateNameWorkspace");
						return TestStepIssueTypes.TEST_STEP_NAME_COMPONENT_WORKSPACE.description;
					}
				}
			}
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			if (theStepObject == null) {
				logger.debug("Exiting validateNameWorkspace");
				return TestStepIssueTypes.TEST_STEP_NAME_STEP_OBJECT_WORKSPACE.description;
			}
			IStepDefinition theStepDefinition = theStepObject
					.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
			if (theStepDefinition == null) {
				logger.debug("Exiting validateNameWorkspace");
				return TestStepIssueTypes.TEST_STEP_NAME_STEP_DEFINITION_WORKSPACE.description;
			}
			
			if (theTestStep.getText() != null) {
				if (!theTestStep.getText().getName().isEmpty()) {
					ArrayList<String> headers = new ArrayList<String>();
					headers.add("Content");
					if (theStepDefinition.getStepParametersTmp(headers) == null) {
						logger.debug("Exiting validateNameWorkspace");
						return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
					}
				}
			}
			logger.debug("Exiting validateNameWorkspace");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNameWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
