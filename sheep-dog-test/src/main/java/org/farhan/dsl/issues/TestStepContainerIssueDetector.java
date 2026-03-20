package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class TestStepContainerIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueDetector.class);

	public static String validateNameOnly(ITestStepContainer theTestStepContainer) throws Exception {
		logger.debug("Entry: validateNameOnly({})", theTestStepContainer);
		String message = "";
		String name = theTestStepContainer.getName();
		if (name != null && !name.isEmpty()) {
			if (!Character.isUpperCase(name.charAt(0))) {
				message = TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
			}
		}
		logger.debug("Exit: validateNameOnly({})", message);
		return message;
	}
}
