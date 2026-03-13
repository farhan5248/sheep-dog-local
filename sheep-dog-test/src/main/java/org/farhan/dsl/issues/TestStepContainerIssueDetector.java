package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestStepContainer;

public class TestStepContainerIssueDetector {

    public static String validateNameOnly(ITestStepContainer theTestStepContainer) {
        String name = theTestStepContainer.getName();
        if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
        }
        return "";
    }
}
