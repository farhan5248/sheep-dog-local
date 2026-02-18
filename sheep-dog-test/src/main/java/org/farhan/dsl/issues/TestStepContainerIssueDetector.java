package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

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
        String name = theTestStepContainer.getName();
        if (name != null && !name.isEmpty()) {
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

        logger.debug("Exiting validateTestStepListFile");
        return "";
    }

}
