package org.farhan.dsl.issues;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CellIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(CellIssueDetector.class);

	// TODO make test for this
	public static String validateNameOnly(ICell theCell) {
		logger.debug("Entering validateNameOnly for step: {}", theCell != null ? theCell.getName() : "null");
		try {
			IRow row = theCell.getParent();
			if (row.getParent().getRowList().getFirst().equals(row)) {
				if (!Character.isUpperCase(theCell.getName().charAt(0))) {
					logger.debug("Exiting validateNameOnly");
					return CellIssueTypes.CELL_NAME_ONLY.description;
				}
			}

			logger.debug("Exiting validateNameOnly");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNameOnly for step '{}': {}", theCell != null ? theCell.getName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}
}
