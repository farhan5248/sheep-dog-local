package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;
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
        // Only validate header row cells (first row)
        IRow parentRow = theCell.getParent();
        ITable parentTable = parentRow.getParent();

        // Check if this cell is in the first row (header row)
        boolean isHeaderRow = parentTable.getRowList().indexOf(parentRow) == 0;

        if (isHeaderRow && name != null && !name.isEmpty() && Character.isLowerCase(name.charAt(0))) {
            logger.debug("Exiting validateNameOnly with error");
            return CellIssueTypes.CELL_NAME_ONLY.description;
        }

        logger.debug("Exiting validateNameOnly");
        return "";
    }
}
