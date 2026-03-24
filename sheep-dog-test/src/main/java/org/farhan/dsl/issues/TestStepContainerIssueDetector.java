package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.slf4j.Logger;

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
        logger.debug("Entering validateNameOnly for theTestStepContainer: {}", theTestStepContainer != null ? theTestStepContainer.getName() : "null");
        String name = theTestStepContainer.getName();
        if (name != null && !name.isEmpty()) {
            if (!Character.isUpperCase(name.charAt(0))) {
                logger.debug("Exiting validateNameOnly with result: {}", TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description);
                return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
            }
        }
        logger.debug("Exiting validateNameOnly with result: {}", "");
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
        logger.debug("Entering validateTestStepListFile for theTestStepContainer: {}", theTestStepContainer != null ? theTestStepContainer.getName() : "null");
        if (!theTestStepContainer.getTestStepList().isEmpty()) {
            ITestStep firstTestStep = theTestStepContainer.getTestStepList().get(0);
            String stepObjectName = firstTestStep.getStepObjectName();
            if (StepObjectRefFragments.getComponent(stepObjectName).isEmpty()) {
                logger.debug("Exiting validateTestStepListFile with result: {}", TestStepContainerIssueTypes.TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE.description);
                return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE.description;
            }
        }
        logger.debug("Exiting validateTestStepListFile with result: {}", "");
        return "";
    }

}
