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
            // Only validate cells in header row (first row)
            if (isHeaderRowCell(theCell)) {
                char firstChar = name.charAt(0);
                if (!Character.isUpperCase(firstChar)) {
                    logger.debug("Exiting validateNameOnly");
                    return CellIssueTypes.CELL_NAME_ONLY.description;
                }
            }
        }
        logger.debug("Exiting validateNameOnly");
        return "";
    }

    private static boolean isHeaderRowCell(ICell theCell) {
        logger.debug("Entering isHeaderRowCell");
        IRow parentRow = theCell.getParent();
        if (parentRow != null && parentRow.getParent() != null) {
            IRow firstRow = parentRow.getParent().getRow(0);
            boolean isHeader = parentRow == firstRow;
            logger.debug("Exiting isHeaderRowCell");
            return isHeader;
        }
        logger.debug("Exiting isHeaderRowCell");
        return false;
    }
}
