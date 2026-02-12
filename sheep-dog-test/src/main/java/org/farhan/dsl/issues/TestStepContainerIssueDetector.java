package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.StepObjectRefFragments;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TestStepContainerIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStepContainer the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameOnly(ITestStepContainer theTestStepContainer) throws Exception {
        logger.debug("Entering validateNameOnly");
        if (theTestStepContainer != null && theTestStepContainer.getName() != null && !theTestStepContainer.getName().isEmpty()) {
            String name = theTestStepContainer.getName();
            if (!Character.isUpperCase(name.charAt(0))) {
                logger.debug("Exiting validateNameOnly");
                return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
            }
        }
        logger.debug("Exiting validateNameOnly");
        return "";
    }

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStepContainer the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateTestStepListFile(ITestStepContainer theTestStepContainer) throws Exception {
        logger.debug("Entering validateTestStepListFile");
        if (theTestStepContainer != null && theTestStepContainer.getTestStepList() != null
                && !theTestStepContainer.getTestStepList().isEmpty()) {
            ITestStep firstStep = theTestStepContainer.getTestStepList().get(0);
            if (firstStep != null && firstStep.getStepObjectName() != null) {
                String stepObjectName = firstStep.getStepObjectName();
                String component = StepObjectRefFragments.getComponent(stepObjectName);

                // Check if component is empty
                if (component == null || component.isEmpty()) {
                    logger.debug("Exiting validateTestStepListFile");
                    return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE.description;
                }
            }
        }
        logger.debug("Exiting validateTestStepListFile");
        return "";
    }

}
