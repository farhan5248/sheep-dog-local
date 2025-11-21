package org.farhan.dsl.issues;

import org.farhan.dsl.lang.ITestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSuiteIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestSuiteIssueDetector.class);

	// TODO make test for this
	public static String validateNameOnly(ITestSuite theTestSuite) {
		logger.debug("Entering validateNameOnly for step: {}", theTestSuite != null ? theTestSuite.getName() : "null");
		try {
			if (!Character.isUpperCase(theTestSuite.getName().charAt(0))) {
				logger.debug("Exiting validateNameOnly");
				return TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description;
			}
			logger.debug("Exiting validateNameOnly");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNameOnly for step '{}': {}",
					theTestSuite != null ? theTestSuite.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}
}
