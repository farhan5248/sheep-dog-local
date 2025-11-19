package org.farhan.dsl.issues;

import org.farhan.dsl.lang.ITestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSuiteIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestSuiteIssueDetector.class);

	// TODO make test for this
	public static String validateName(ITestSuite theTestSuite) {
		logger.debug("Entering validateName for step: {}", theTestSuite != null ? theTestSuite.getName() : "null");
		try {
			if (!Character.isUpperCase(theTestSuite.getName().charAt(0))) {
				logger.debug("Exiting validateName");
				return TestSuiteIssueTypes.TEST_SUITE_NAME.description;
			}
			logger.debug("Exiting validateName");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateName for step '{}': {}",
					theTestSuite != null ? theTestSuite.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}
}
