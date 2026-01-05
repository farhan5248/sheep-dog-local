package org.farhan.dsl.issues;

import org.farhan.dsl.lang.ITestSuite;
import org.slf4j.Logger;


public class TestSuiteIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestSuiteIssueDetector.class);

	// TODO make test for this
	public static String validateNameOnly(ITestSuite theTestSuite) throws Exception {
		logger.debug("Entering validateNameOnly for step: {}", theTestSuite != null ? theTestSuite.getName() : "null");
		if (!Character.isUpperCase(theTestSuite.getName().charAt(0))) {
			logger.debug("Exiting validateNameOnly");
			return TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description;
		}
		logger.debug("Exiting validateNameOnly");
		return "";
	}
}
