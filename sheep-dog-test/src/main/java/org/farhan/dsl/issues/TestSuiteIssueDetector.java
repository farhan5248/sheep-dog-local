package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class TestSuiteIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueDetector.class);

	public static String validateNameOnly(ITestSuite theTestSuite) throws Exception {
		logger.debug("Entry: validateNameOnly({})", theTestSuite);
		String message = "";
		String name = theTestSuite.getName();
		if (name != null && !name.isEmpty()) {
			if (!Character.isUpperCase(name.charAt(0))) {
				message = TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description;
			}
		}
		logger.debug("Exit: validateNameOnly({})", message);
		return message;
	}
}
