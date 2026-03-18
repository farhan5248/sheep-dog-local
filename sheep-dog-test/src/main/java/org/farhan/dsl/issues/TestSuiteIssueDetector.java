package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import org.slf4j.Logger;

public class TestSuiteIssueDetector {

	public static String validateNameOnly(ITestSuite theTestSuite) {
		Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueDetector.class);
		logger.debug("Entering validateNameOnly");

		String name = theTestSuite.getName();
		if (name == null || name.isEmpty()) {
			logger.debug("Exiting validateNameOnly - name is empty");
			return "";
		}

		// Check if name starts with a capital letter
		if (!SheepDogUtility.startsWithCapital(name)) {
			logger.debug("Exiting validateNameOnly - name doesn't start with capital");
			return TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description;
		}

		logger.debug("Exiting validateNameOnly - validation passed");
		return "";
	}
}
