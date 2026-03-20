package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.slf4j.Logger;

public class TestStepIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

	public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entry: validateStepObjectNameOnly({})", theTestStep);
		String message = "";
		String text = theTestStep.getFullName();
		if (text != null && !text.isEmpty()) {
			if (StepObjectRefFragments.getObject(text).isEmpty()) {
				message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
			}
		}
		logger.debug("Exit: validateStepObjectNameOnly({})", message);
		return message;
	}
}
