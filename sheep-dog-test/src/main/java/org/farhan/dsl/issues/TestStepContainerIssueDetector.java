package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.StepObjectRefFragments;

public class TestStepContainerIssueDetector {

    public static String validateNameOnly(ITestStepContainer theTestStepContainer) {
        String name = theTestStepContainer.getName();
        if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
        }
        if (!theTestStepContainer.getTestStepList().isEmpty()) {
            ITestStep firstStep = theTestStepContainer.getTestStepList().get(0);
            String component = StepObjectRefFragments.getComponent(firstStep.getFullName());
            if (component == null || component.isEmpty()) {
                return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_FIRST_STEP_COMPONENT.description;
            }
        }
        return "";
    }
}
