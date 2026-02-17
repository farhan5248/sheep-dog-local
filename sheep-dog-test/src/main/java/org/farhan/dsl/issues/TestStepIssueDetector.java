package org.farhan.dsl.issues;

import org.slf4j.Logger;

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
    public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepObjectNameOnly");
        String text = theTestStep.getStepObjectName();
        if (text != null && text.isEmpty()) {
            logger.debug("Exiting validateStepObjectNameOnly with error");
            return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
        }
        if (text != null && !text.isEmpty()) {
            if (StepObjectRefFragments.getObject(text).isEmpty()) {
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
    public static String validateStepDefinitionNameOnly(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepDefinitionNameOnly");
        String text = theTestStep.getStepDefinitionName();
        if (text != null && text.isEmpty()) {
            logger.debug("Exiting validateStepDefinitionNameOnly with error");
            return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
        }
        if (text != null && !text.isEmpty()) {
            if (StepDefinitionRefFragments.getState(text).isEmpty()) {
                logger.debug("Exiting validateStepDefinitionNameOnly with error");
                return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
            }
        }
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
        ITestProject testProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (testProject != null) {
            String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            if (!stepObjectNameLong.isEmpty() && testProject.getStepObject(stepObjectNameLong) == null) {
                logger.debug("Exiting validateStepObjectNameWorkspace with error");
                return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
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
        ITestProject testProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (testProject != null) {
            String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            if (!stepObjectNameLong.isEmpty()) {
                IStepObject theStepObject = testProject.getStepObject(stepObjectNameLong);
                if (theStepObject != null) {
                    String stepDefinitionName = theTestStep.getStepDefinitionName();
                    if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                        if (theStepObject.getStepDefinition(stepDefinitionName) == null) {
                            logger.debug("Exiting validateStepDefinitionNameWorkspace with error");
                            return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
                        }
                    }
                }
            }
        }
        logger.debug("Exiting validateStepDefinitionNameWorkspace");
        return "";
    }

}
