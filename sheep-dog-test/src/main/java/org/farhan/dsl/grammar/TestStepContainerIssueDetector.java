package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class TestStepContainerIssueDetector {

	public static String validateNameOnly(ITestStepContainer theTestStepContainer) {
		Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueDetector.class);
		logger.debug("Entering validateNameOnly");

		String name = theTestStepContainer.getName();
		if (name == null || name.isEmpty()) {
			logger.debug("Exiting validateNameOnly - name is empty");
			return "";
		}

		// Check if name starts with a capital letter
		if (!Character.isUpperCase(name.charAt(0))) {
			logger.debug("Exiting validateNameOnly - name doesn't start with capital");
			return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
		}

		logger.debug("Exiting validateNameOnly - validation passed");
		return "";
	}
}
