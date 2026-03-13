package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class TestStepIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

    public static String validateStepObjectNameWorkspace(ITestStep theTestStep) {
        logger.debug("Entering validateStepObjectNameWorkspace for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        String nameOnlyResult = validateNameOnly(theTestStep);
        if (!nameOnlyResult.isEmpty()) {
            logger.debug("Exiting validateStepObjectNameWorkspace with result: {}", nameOnlyResult);
            return nameOnlyResult;
        }
        ITestProject workspace = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (workspace == null) {
            logger.debug("Exiting validateStepObjectNameWorkspace with result: {}", "");
            return "";
        }
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (stepObjectFullName.isEmpty() || workspace.getTestDocument(stepObjectFullName) == null) {
            String result = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
            logger.debug("Exiting validateStepObjectNameWorkspace with result: {}", result);
            return result;
        }
        logger.debug("Exiting validateStepObjectNameWorkspace with result: {}", "");
        return "";
    }

    public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep) {
        logger.debug("Entering validateStepDefinitionNameWorkspace for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ITestProject workspace = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (workspace == null) {
            logger.debug("Exiting validateStepDefinitionNameWorkspace with result: {}", "");
            return "";
        }
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (stepObjectFullName.isEmpty() || workspace.getTestDocument(stepObjectFullName) == null) {
            logger.debug("Exiting validateStepDefinitionNameWorkspace with result: {}", "");
            return "";
        }
        IStepObject stepObject = (IStepObject) workspace.getTestDocument(stepObjectFullName);
        if (stepObject.getStepDefinition(theTestStep.getStepDefinitionName()) == null) {
            String result = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
            logger.debug("Exiting validateStepDefinitionNameWorkspace with result: {}", result);
            return result;
        }
        logger.debug("Exiting validateStepDefinitionNameWorkspace with result: {}", "");
        return "";
    }

    public static String validateNameOnly(ITestStep theTestStep) {
        logger.debug("Entering validateNameOnly for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        String stepObjectName = theTestStep.getStepObjectName();
        if (stepObjectName == null || stepObjectName.isEmpty()) {
            String result = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
            logger.debug("Exiting validateNameOnly with result: {}", result);
            return result;
        }
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            String result = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
            logger.debug("Exiting validateNameOnly with result: {}", result);
            return result;
        }
        logger.debug("Exiting validateNameOnly with result: {}", "");
        return "";
    }
}
