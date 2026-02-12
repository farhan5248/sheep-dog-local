package org.farhan.dsl.issues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.farhan.dsl.lang.ICell;

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
		logger.debug("Entering validateNameOnly");
		if (theCell != null && theCell.getName() != null && !theCell.getName().isEmpty()) {
			String name = theCell.getName();
			if (!Character.isUpperCase(name.charAt(0))) {
				logger.debug("Exiting validateNameOnly");
				return CellIssueTypes.CELL_NAME_ONLY.description;
			}
		}
		logger.debug("Exiting validateNameOnly");
		return "";
	}
}
