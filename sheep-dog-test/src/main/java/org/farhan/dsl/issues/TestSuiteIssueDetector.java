package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TestSuiteIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theTestSuite the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameOnly(ITestSuite theTestSuite) throws Exception {
        logger.debug("Entering validateNameOnly");
        String name = theTestSuite.getName();
        if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
            logger.debug("Exiting validateNameOnly");
            return TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description;
        }
        logger.debug("Exiting validateNameOnly");
        return "";
    }
}
