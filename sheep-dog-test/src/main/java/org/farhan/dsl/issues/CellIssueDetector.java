package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class CellIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueDetector.class);

	public static String validateNameOnly(ICell theCell) throws Exception {
		logger.debug("Entry: validateNameOnly({})", theCell);
		String message = "";
		IRow row = theCell.getParent();
		ITable table = row.getParent();
		if (table.getRowList().get(0) == row) {
			String name = theCell.getName();
			if (name != null && !name.isEmpty()) {
				if (!Character.isUpperCase(name.charAt(0))) {
					message = CellIssueTypes.CELL_NAME_ONLY.description;
				}
			}
		}
		logger.debug("Exit: validateNameOnly({})", message);
		return message;
	}
}
