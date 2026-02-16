package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepDefinitionRefFragments;
import org.farhan.dsl.lang.StepObjectRefFragments;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TestStepIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepObjectNameOnly(ITestStep theTestStep) {
        logger.debug("Entering validateStepObjectNameOnly");
        String stepObjectName = theTestStep.getStepObjectName();
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        // If there's a step definition but no step object, the step is malformed
        if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
            if (stepObjectName == null || stepObjectName.isEmpty()) {
                logger.debug("Exiting validateStepObjectNameOnly with error");
                return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
            }
            // Also check if the step object doesn't have a valid object type
            String object = StepObjectRefFragments.getObject(stepObjectName);
            if (object.isEmpty()) {
                logger.debug("Exiting validateStepObjectNameOnly with error");
                return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
            }
        }
        logger.debug("Exiting validateStepObjectNameOnly");
        return "";
    }

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepDefinitionNameOnly(ITestStep theTestStep) {
        logger.debug("Entering validateStepDefinitionNameOnly");

        logger.debug("Exiting validateStepDefinitionNameOnly");
        return "";
    }

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepObjectNameWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepObjectNameWorkspace");
        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (!qualifiedName.isEmpty()) {
            ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (theProject != null) {
                IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                if (theStepObject == null) {
                    logger.debug("Exiting validateStepObjectNameWorkspace with error");
                    return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
                }
            }
        }
        logger.debug("Exiting validateStepObjectNameWorkspace");
        return "";
    }

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepDefinitionNameWorkspace");
        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (!qualifiedName.isEmpty()) {
            ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (theProject != null) {
                IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                if (theStepObject != null) {
                    String stepDefinitionName = StepDefinitionRefFragments.getAll(theTestStep.getStepDefinitionName());
                    IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                    if (theStepDefinition == null) {
                        logger.debug("Exiting validateStepDefinitionNameWorkspace with error");
                        return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
                    }
                }
            }
        }
        logger.debug("Exiting validateStepDefinitionNameWorkspace");
        return "";
    }

}
