package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.StepObjectRefFragments;

public class TestStepIssueDetector {

    public static String validateWorkspace(ITestStep theTestStep, ITestProject workspace) {
        String nameOnlyResult = validateNameOnly(theTestStep);
        if (!nameOnlyResult.isEmpty()) {
            return nameOnlyResult;
        }
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (stepObjectFullName.isEmpty() || workspace.getTestDocument(stepObjectFullName) == null) {
            return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
        }
        IStepObject stepObject = (IStepObject) workspace.getTestDocument(stepObjectFullName);
        if (stepObject.getStepDefinition(theTestStep.getStepDefinitionName()) == null) {
            return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
        }
        return "";
    }

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
