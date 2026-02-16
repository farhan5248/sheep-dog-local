package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
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
        // Check if the step object name is missing or doesn't contain a valid object
        if (stepObjectName == null || stepObjectName.isEmpty()) {
            // Step has no object name - this is an error if step definition exists
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                logger.debug("Exiting validateStepObjectNameOnly");
                return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
            }
        } else {
            // Step object name exists but check if it's valid (has object type)
            String object = StepObjectRefFragments.getObject(stepObjectName);
            if (object.isEmpty()) {
                logger.debug("Exiting validateStepObjectNameOnly");
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
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        // Check if the step definition name is missing or doesn't contain a valid state
        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            // Step has no definition name - this is an error if step object name exists
            String stepObjectName = theTestStep.getStepObjectName();
            if (stepObjectName != null && !stepObjectName.isEmpty()) {
                // Check if step object name has a valid object
                String object = StepObjectRefFragments.getObject(stepObjectName);
                if (!object.isEmpty()) {
                    logger.debug("Exiting validateStepDefinitionNameOnly");
                    return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
                }
            }
        } else {
            // Step definition name exists but check if it's valid (has state)
            String state = StepDefinitionRefFragments.getState(stepDefinitionName);
            if (state.isEmpty()) {
                logger.debug("Exiting validateStepDefinitionNameOnly");
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

        logger.debug("Exiting validateStepDefinitionNameWorkspace");
        return "";
    }

}
