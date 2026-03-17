package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class TestSuiteIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueDetector.class);

	public static String validateNameOnly(ITestSuite theTestSuite) throws Exception {
		logger.debug("validateNameOnly(theTestSuite={})", theTestSuite);
		String result = "";
		String name = theTestSuite.getName();
		if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
			result = TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description;
		}
		logger.debug("validateNameOnly() = {}", result);
		return result;
	}
}
