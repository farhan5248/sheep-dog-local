package org.farhan.dsl.issues;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class CellIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(CellIssueDetector.class);

	/**
	 * Validates a specific grammar assignment at element-only, file, or workspace
	 * scope, returning empty string if valid or error description if invalid.
	 *
	 * @param theCell the element to validate
	 * @return empty string if valid, error description otherwise
	 * @throws Exception if validation fails
	 */
	public static String validateNameOnly(ICell theCell) throws Exception {
		logger.debug("Entering validateNameOnly for cell: {}", theCell != null ? theCell.getName() : "null");
		IRow row = theCell.getParent();
		if (row.getParent().getRowList().getFirst().equals(row)) {
			if (!Character.isUpperCase(theCell.getName().charAt(0))) {
				logger.debug("Exiting validateNameOnly");
				return CellIssueTypes.CELL_NAME_ONLY.description;
			}
		}
		logger.debug("Exiting validateNameOnly");
		return "";
	}
}
