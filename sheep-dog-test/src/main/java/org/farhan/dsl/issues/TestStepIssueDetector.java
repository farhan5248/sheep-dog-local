package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepObjectRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TestStepIssueDetector {

    private static final Logger logger = LoggerFactory.getLogger(TestStepIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStep the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
        logger.debug("Entering validateStepObjectNameOnly for step: {}",
                theTestStep != null ? theTestStep.getName() : "null");
        String text = theTestStep.getName();
        if (text != null) {
            if (StepObjectRef.getStepObjectName(text).isEmpty()) {
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
    public static String validateStepDefinitionNameOnly(ITestStep theTestStep) throws Exception {

        logger.debug("Entering validateStepDefinitionNameOnly for step: {}",
                theTestStep != null ? theTestStep.getName() : "null");
        if (theTestStep.getStepDefinitionName() != null) {
            if (theTestStep.getStepDefinitionName().isEmpty()) {
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
        logger.debug("Entering validateStepObjectNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.getName() : "null");
        String message = "";
        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
        if (theStepObject == null) {
            message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
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
        // validates for a good name if the reference is valid
        logger.debug("Entering validateStepDefinitionNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.getName() : "null");
        String message = "";
        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        ITestProject theProject = theTestStep.getParent().getParent().getParent();
        IStepObject theStepObject = theProject.getStepObject(qualifiedName);
        if (theStepObject != null) {
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            if (!stepDefinitionName.isEmpty()) {
                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                if (theStepDefinition == null) {
                    message = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
                }
            }
        }
        logger.debug("Exiting validateStepDefinitionNameWorkspace");
        return message;
    }

}
