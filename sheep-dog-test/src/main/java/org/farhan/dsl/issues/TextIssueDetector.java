package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TextIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theText the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameWorkspace(IText theText) throws Exception {
        logger.debug("Entering validateNameWorkspace");

        logger.debug("Exiting validateNameWorkspace");
        return "";
    }
}
