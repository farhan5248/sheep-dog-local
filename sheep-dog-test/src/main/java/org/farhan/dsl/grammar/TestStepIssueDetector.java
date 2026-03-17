package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class TestStepIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

	public static String validateNameOnly(ITestStep theTestStep) throws Exception {
		logger.debug("validateNameOnly(theTestStep={})", theTestStep);
		String result = "";
		String fullName = theTestStep.getFullName();
		if (fullName != null && !fullName.isEmpty()) {
			String object = StepObjectRefFragments.getObject(fullName);
			if (object.isEmpty()) {
				result = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY;
			} else if (StepObjectRefFragments.getAll(fullName).isEmpty()) {
				result = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY;
			}
		}
		logger.debug("validateNameOnly() = {}", result);
		return result;
	}
}
