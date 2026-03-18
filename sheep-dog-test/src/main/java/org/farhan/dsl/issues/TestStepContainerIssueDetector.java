package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.List;

import org.slf4j.Logger;

public class TestStepContainerIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueDetector.class);

	public static String validateNameOnly(ITestStepContainer theTestStepContainer) throws Exception {
		logger.debug("validateNameOnly(theTestStepContainer={})", theTestStepContainer);
		String result = "";
		String name = theTestStepContainer.getName();
		if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
			result = TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
		} else {
			List<ITestStep> steps = theTestStepContainer.getTestStepList();
			if (!steps.isEmpty()) {
				ITestStep firstStep = steps.get(0);
				String component = StepObjectRefFragments.getComponent(firstStep.getFullName());
				if (component.isEmpty()) {
					result = TestStepContainerIssueTypes.TEST_STEP_CONTAINER_STEP_OBJECT_NAME_ONLY.description;
				}
			}
		}
		logger.debug("validateNameOnly() = {}", result);
		return result;
	}
}
