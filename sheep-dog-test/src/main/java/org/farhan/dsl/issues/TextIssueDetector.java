package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class TextIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueDetector.class);

    public static String validateContentWorkspace(IText theText) {
        logger.debug("Entering validateContentWorkspace for theText: {}", theText != null ? theText.getName() : "null");
        ITestProject workspace = SheepDogUtility.getTestProjectParentForText(theText);
        if (workspace == null) {
            logger.debug("Exiting validateContentWorkspace with result: {}", "");
            return "";
        }
        ITestStep testStep = theText.getParent();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (stepObjectFullName.isEmpty() || workspace.getTestDocument(stepObjectFullName) == null) {
            logger.debug("Exiting validateContentWorkspace with result: {}", "");
            return "";
        }
        IStepObject stepObject = (IStepObject) workspace.getTestDocument(stepObjectFullName);
        IStepDefinition stepDefinition = stepObject.getStepDefinition(testStep.getStepDefinitionName());
        if (stepDefinition == null) {
            logger.debug("Exiting validateContentWorkspace with result: {}", "");
            return "";
        }
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            if ("Content".equals(stepParameters.getName())) {
                logger.debug("Exiting validateContentWorkspace with result: {}", "");
                return "";
            }
        }
        String result = TextIssueTypes.TEXT_CONTENT_WORKSPACE.description;
        logger.debug("Exiting validateContentWorkspace with result: {}", result);
        return result;
    }
}
