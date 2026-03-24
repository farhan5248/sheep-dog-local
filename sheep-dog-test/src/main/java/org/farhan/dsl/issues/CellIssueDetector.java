package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;
import org.slf4j.Logger;

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
     */
    public static String validateNameOnly(ICell theCell) {
        logger.debug("Entering validateNameOnly for theCell: {}", theCell != null ? theCell.getName() : "null");
        IRow parentRow = (IRow) theCell.eContainer();
        ITable parentTable = (ITable) parentRow.eContainer();
        boolean isHeaderRow = parentTable.getRowList().indexOf(parentRow) == 0;
        if (isHeaderRow) {
            String name = theCell.getName();
            if (name != null && !name.isEmpty()) {
                if (!Character.isUpperCase(name.charAt(0))) {
                    logger.debug("Exiting validateNameOnly with result: {}", CellIssueTypes.CELL_NAME_ONLY.description);
                    return CellIssueTypes.CELL_NAME_ONLY.description;
                }
            }
        }
        logger.debug("Exiting validateNameOnly with result: {}", "");
        return "";
    }
}
