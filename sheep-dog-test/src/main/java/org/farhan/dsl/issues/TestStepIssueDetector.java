package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.StepObjectRefFragments;

public class TestStepIssueDetector {

    public static String validateNameOnly(ITestStep theTestStep) {
        String stepObjectName = theTestStep.getStepObjectName();
        if (stepObjectName == null || stepObjectName.isEmpty()) {
            return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
        }
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
        }
        return "";
    }
}
