package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CellIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(CellIssueDetector.class);

	// TODO make test for this
	public static String validateName(ICell theCell) {
		logger.debug("Entering validateName for step: {}", theCell != null ? theCell.getName() : "null");
		try {
			IRow row = theCell.getParent();
			if (row.getParent().getRowList().getFirst() == row) {
				if (!Character.isUpperCase(theCell.getName().charAt(0))) {
					logger.debug("Exiting validateName");
					return CellIssueTypes.CELL_NAME.description;
				}
			}

			logger.debug("Exiting validateName");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateName for step '{}': {}", theCell != null ? theCell.getName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}
}
