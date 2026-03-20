package org.farhan.dsl.issues;

import java.util.List;

import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.StepObjectRefFragments;
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

	public static String validateTestStepListFile(ITestStepContainer theTestStepContainer) throws Exception {
		logger.debug("Entry: validateTestStepListFile({})", theTestStepContainer);
		String message = "";
		List<ITestStep> steps = theTestStepContainer.getTestStepList();
		if (steps != null && !steps.isEmpty()) {
			ITestStep firstStep = steps.get(0);
			String text = firstStep.getFullName();
			if (text != null && !text.isEmpty()) {
				if (StepObjectRefFragments.getComponent(text).isEmpty()) {
					message = TestStepContainerIssueTypes.TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE.description;
				}
			}
		}
		logger.debug("Exit: validateTestStepListFile({})", message);
		return message;
	}
}
