package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepContainerIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestStepContainerIssueDetector.class);

	// TODO make test for this
	public static String validateNameOnly(ITestStepContainer theTestStepContainer) {
		logger.debug("Entering validateNameOnly for step: {}",
				theTestStepContainer != null ? theTestStepContainer.getName() : "null");
		if (!Character.isUpperCase(theTestStepContainer.getName().charAt(0))) {
			logger.debug("Exiting validateNameOnly");
			return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
		}
		logger.debug("Exiting validateNameOnly");
		return "";
	}

	public static String validateTestStepListFile(ITestStepContainer theTestStepContainer) {
		ArrayList<ITestStep> testStepList = theTestStepContainer.getTestStepList();
		if (testStepList != null) {
			if (!testStepList.isEmpty()) {
				if (TestStepUtility.getComponent(testStepList.getFirst().getName()).isEmpty()) {
					return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_TEST_STEP_FILE_LIST_FILE.description;
				}
			}
		}
		return "";
	}

}
