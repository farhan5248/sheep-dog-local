package org.farhan.dsl.issues;

import java.util.List;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TestStepContainerIssueDetector {

    private static final Logger logger = LoggerFactory.getLogger(TestStepContainerIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestStepContainer the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameOnly(ITestStepContainer theTestStepContainer) {
        logger.debug("Entering validateNameOnly for step: {}",
                theTestStepContainer != null ? theTestStepContainer.getName() : "null");
        if (!Character.isUpperCase(theTestStepContainer.getName().charAt(0))) {
            logger.debug("Exiting validateNameOnly");
            return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description;
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
    public static String validateTestStepListFile(ITestStepContainer theTestStepContainer) {
        logger.debug("Entering validateTestStepListFile for container: {}",
                theTestStepContainer != null ? theTestStepContainer.getName() : "null");
        List<ITestStep> testStepList = theTestStepContainer.getTestStepList();
        if (testStepList != null) {
            if (!testStepList.isEmpty()) {
                if (StepObjectRefFragments.getComponent(testStepList.getFirst().getStepObjectName()).isEmpty()) {
                    logger.debug("Exiting validateTestStepListFile");
                    return TestStepContainerIssueTypes.TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE.description;
                }
            }
        }
        logger.debug("Exiting validateTestStepListFile");
        return "";
    }

}
