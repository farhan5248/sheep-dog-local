package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogUtility;

public class TextIssueDetector {

    public static String validateWorkspace(IText theText, ITestProject workspace) {
        ITestStep testStep = theText.getParent();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (stepObjectFullName.isEmpty() || workspace.getTestDocument(stepObjectFullName) == null) {
            return "";
        }
        IStepObject stepObject = (IStepObject) workspace.getTestDocument(stepObjectFullName);
        IStepDefinition stepDefinition = stepObject.getStepDefinition(testStep.getStepDefinitionName());
        if (stepDefinition == null) {
            return "";
        }
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            if ("Content".equals(stepParameters.getName())) {
                return "";
            }
        }
        return TextIssueTypes.TEXT_CONTENT_WORKSPACE.description;
    }
}
