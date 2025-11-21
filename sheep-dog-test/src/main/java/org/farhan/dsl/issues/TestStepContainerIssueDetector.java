package org.farhan.dsl.issues;

import org.farhan.dsl.lang.ITestStepContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepContainerIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestStepContainerIssueDetector.class);

	// TODO make test for this
	public static String validateNameOnly(ITestStepContainer theTestStepContainer) {
		logger.debug("Entering validateNameOnly for step: {}",
				theTestStepContainer != null ? theTestStepContainer.getName() : "null");
		try {
			if (!Character.isUpperCase(theTestStepContainer.getName().charAt(0))) {
				logger.debug("Exiting validateNameOnly");
				return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
			}
			logger.debug("Exiting validateNameOnly");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNameOnly for step '{}': {}",
					theTestStepContainer != null ? theTestStepContainer.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
