package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
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
        // If stepObjectName is empty, it means no valid object was extracted from the step name
        if (stepObjectName == null || stepObjectName.isEmpty()) {
            // No valid object found - this is an error
            logger.debug("Exiting validateStepObjectNameOnly with error");
            return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
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
        // If stepDefinitionName is empty, it means no valid definition was extracted from the step name
        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            // No valid definition found - this is an error
            logger.debug("Exiting validateStepDefinitionNameOnly with error");
            return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
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

        String message = "";
        String stepObjectName = theTestStep.getStepObjectName();

        if (stepObjectName != null && !stepObjectName.isEmpty()) {
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);

            if (!component.isEmpty() && !object.isEmpty()) {
                // Get the test project using utility method
                ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                if (theProject != null) {
                    // Construct the qualified name of the step object file
                    // component/object.asciidoc format
                    String fileExt = theProject.getFileExtension();
                    if (fileExt == null) {
                        fileExt = "";
                    }
                    String qualifiedName = component + "/" + object + fileExt;

                    // Check if the step object exists in the project
                    IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                    if (theStepObject == null) {
                        message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
                    }
                }
            }
        }

        logger.debug("Exiting validateStepObjectNameWorkspace");
        return message;
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

        String message = "";
        String stepObjectName = theTestStep.getStepObjectName();
        String stepDefinitionName = theTestStep.getStepDefinitionName();

        if (stepObjectName != null && !stepObjectName.isEmpty() &&
            stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);

            if (!component.isEmpty() && !object.isEmpty()) {
                // Get the test project using utility method
                ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                if (theProject != null) {
                    // Construct the qualified name of the step object file
                    // component/object.asciidoc format
                    String fileExt = theProject.getFileExtension();
                    if (fileExt == null) {
                        fileExt = "";
                    }
                    String qualifiedName = component + "/" + object + fileExt;

                    // Check if the step object exists in the project
                    IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                    if (theStepObject != null) {
                        // Step object exists, now check if the step definition exists
                        IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                        if (theStepDefinition == null) {
                            message = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateStepDefinitionNameWorkspace");
        return message;
    }

}
