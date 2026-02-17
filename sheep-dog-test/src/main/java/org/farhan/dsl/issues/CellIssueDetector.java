package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class CellIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theCell the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameOnly(ICell theCell) throws Exception {
        logger.debug("Entering validateNameOnly");

        String name = theCell.getName();
        if (name != null && !name.isEmpty()) {
            // Check if the cell is in the header row (first row)
            org.farhan.dsl.lang.IRow parentRow = theCell.getParent();
            if (parentRow != null && parentRow.getParent() != null) {
                org.farhan.dsl.lang.ITable table = parentRow.getParent();
                org.farhan.dsl.lang.IRow headerRow = table.getRow(0);

                // Only validate that header row cells start with capital letter
                if (parentRow == headerRow && !Character.isUpperCase(name.charAt(0))) {
                    logger.debug("Exiting validateNameOnly with error");
                    return "Name should start with a capital";
                }
            }
        }

        logger.debug("Exiting validateNameOnly");
        return "";
    }
}
