package org.farhan.dsl.grammar;

import java.util.List;
import org.slf4j.Logger;

public class TestStepContainerIssueDetector {

	public static String validateNameOnly(ITestStepContainer theTestStepContainer) {
		Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueDetector.class);
		logger.debug("Entering validateNameOnly");

		String name = theTestStepContainer.getName();
		if (name == null || name.isEmpty()) {
			logger.debug("Exiting validateNameOnly - name is empty");
			return "";
		}

		// Check if name starts with a capital letter
		if (!SheepDogUtility.startsWithCapital(name)) {
			logger.debug("Exiting validateNameOnly - name doesn't start with capital");
			return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
		}

		// Check if first test step has a component
		List<ITestStep> testSteps = theTestStepContainer.getTestStepList();
		if (testSteps != null && !testSteps.isEmpty()) {
			ITestStep firstStep = testSteps.get(0);
			String firstStepFullName = firstStep.getFullName();
			if (firstStepFullName != null && !firstStepFullName.isEmpty()) {
				String component = StepObjectRefFragments.getComponent(firstStepFullName);
				if (component.isEmpty()) {
					logger.debug("Exiting validateNameOnly - first step doesn't have a component");
					return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_FIRST_STEP_COMPONENT.description;
				}
			}
		}

		logger.debug("Exiting validateNameOnly - validation passed");
		return "";
	}
}
