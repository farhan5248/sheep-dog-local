package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
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
            // Only validate header row cells (first row, index 0)
            IRow parentRow = theCell.getParent();
            if (parentRow != null && parentRow.getParent() != null) {
                int rowIndex = parentRow.getParent().getRowList().indexOf(parentRow);
                if (rowIndex == 0) {
                    // Header row - cell names should start with a capital letter
                    char firstChar = name.charAt(0);
                    if (Character.isLetter(firstChar) && !Character.isUpperCase(firstChar)) {
                        logger.debug("Exiting validateNameOnly with error");
                        return CellIssueTypes.CELL_NAME_ONLY.description;
                    }
                }
            }
        }
        logger.debug("Exiting validateNameOnly");
        return "";
    }
}
