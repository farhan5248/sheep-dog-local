package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
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
        if (theTestStep != null && theTestStep.getStepObjectName() != null) {
            String stepObjectName = theTestStep.getStepObjectName();
            String object = StepObjectRefFragments.getObject(stepObjectName);

            // Check if object is empty or invalid
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
        if (theTestStep != null && theTestStep.getStepDefinitionName() != null) {
            String stepDefinitionName = theTestStep.getStepDefinitionName();

            // Check if step definition name is empty or doesn't have required parts
            if (stepDefinitionName.isEmpty()) {
                logger.debug("Exiting validateStepDefinitionNameOnly");
                return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
            }
        } else if (theTestStep != null && theTestStep.getStepDefinitionName() == null) {
            // Step definition name is null, which means it's missing
            logger.debug("Exiting validateStepDefinitionNameOnly");
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

        if (theTestStep != null && theTestStep.getStepObjectName() != null) {
            String stepObjectName = theTestStep.getStepObjectName();

            // Extract component and object from step object name
            String componentName = StepObjectRefFragments.getComponentName(stepObjectName);
            String componentType = StepObjectRefFragments.getComponentType(stepObjectName);
            String objectName = StepObjectRefFragments.getObjectName(stepObjectName);
            String objectType = StepObjectRefFragments.getObjectType(stepObjectName);

            // Build qualified name: "{component}/{object}.feature"
            String qualifiedName = "";
            if (!componentName.isEmpty() && !componentType.isEmpty()) {
                qualifiedName = componentName.trim() + " " + componentType.trim() + "/";
            }
            if (!objectName.isEmpty() && !objectType.trim().isEmpty()) {
                qualifiedName += objectName.trim() + " " + objectType.trim() + ".feature";
            }

            // Navigate up to get the test project
            ITestStepContainer container = theTestStep.getParent();
            if (container != null) {
                ITestSuite suite = container.getParent();
                if (suite != null) {
                    ITestProject project = suite.getParent();
                    if (project != null && !qualifiedName.isEmpty()) {
                        // Check if step object exists in workspace
                        IStepObject stepObject = project.getStepObject(qualifiedName);
                        if (stepObject == null) {
                            logger.debug("Step object not found: " + qualifiedName);
                            logger.debug("Exiting validateStepObjectNameWorkspace");
                            return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
                        }
                    }
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

        if (theTestStep != null && theTestStep.getStepObjectName() != null && theTestStep.getStepDefinitionName() != null) {
            String stepObjectName = theTestStep.getStepObjectName();
            String stepDefinitionName = theTestStep.getStepDefinitionName();

            // Extract component and object from step object name
            String componentName = StepObjectRefFragments.getComponentName(stepObjectName);
            String componentType = StepObjectRefFragments.getComponentType(stepObjectName);
            String objectName = StepObjectRefFragments.getObjectName(stepObjectName);
            String objectType = StepObjectRefFragments.getObjectType(stepObjectName);

            // Build qualified name: "{component}/{object}.feature"
            String qualifiedName = "";
            if (!componentName.isEmpty() && !componentType.isEmpty()) {
                qualifiedName = componentName.trim() + " " + componentType.trim() + "/";
            }
            if (!objectName.isEmpty() && !objectType.trim().isEmpty()) {
                qualifiedName += objectName.trim() + " " + objectType.trim() + ".feature";
            }

            // Navigate up to get the test project
            ITestStepContainer container = theTestStep.getParent();
            if (container != null) {
                ITestSuite suite = container.getParent();
                if (suite != null) {
                    ITestProject project = suite.getParent();
                    if (project != null && !qualifiedName.isEmpty()) {
                        // Check if step object exists in workspace
                        IStepObject stepObject = project.getStepObject(qualifiedName);
                        if (stepObject != null) {
                            // Step object exists, now check if step definition exists within it
                            if (stepObject.getStepDefinition(stepDefinitionName) == null) {
                                logger.debug("Step definition not found: " + stepDefinitionName + " in " + qualifiedName);
                                logger.debug("Exiting validateStepDefinitionNameWorkspace");
                                return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateStepDefinitionNameWorkspace");
        return "";
    }

}
