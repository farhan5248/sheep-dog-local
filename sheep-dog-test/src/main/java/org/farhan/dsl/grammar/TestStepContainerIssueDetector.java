package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class TestStepContainerIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueDetector.class);

	public static String validateNameOnly(ITestStepContainer theTestStepContainer) throws Exception {
		logger.debug("validateNameOnly(theTestStepContainer={})", theTestStepContainer);
		String result = "";
		String name = theTestStepContainer.getName();
		if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
			result = TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY;
		}
		logger.debug("validateNameOnly() = {}", result);
		return result;
	}
}
