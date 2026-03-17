package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class CellIssueDetector {

	public static String validateNameOnly(ICell theCell) {
		Logger logger = SheepDogLoggerFactory.getLogger(CellIssueDetector.class);
		logger.debug("Entering validateNameOnly");

		String name = theCell.getName();
		if (name == null || name.isEmpty()) {
			logger.debug("Exiting validateNameOnly - name is empty");
			return "";
		}

		// Only validate header row (first row) cells
		IRow parentRow = theCell.getParent();
		if (parentRow != null) {
			ITable parentTable = parentRow.getParent();
			if (parentTable != null && parentTable.getRowList() != null) {
				int rowIndex = parentTable.getRowList().indexOf(parentRow);
				if (rowIndex != 0) {
					// Not a header row, skip validation
					logger.debug("Exiting validateNameOnly - not a header row");
					return "";
				}
			}
		}

		// Check if name starts with a capital letter
		if (!SheepDogUtility.startsWithCapital(name)) {
			logger.debug("Exiting validateNameOnly - name doesn't start with capital");
			return CellIssueTypes.CELL_NAME_ONLY.description;
		}

		logger.debug("Exiting validateNameOnly - validation passed");
		return "";
	}
}
