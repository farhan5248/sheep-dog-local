package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class CellIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueDetector.class);

	public static String validateNameOnly(ICell theCell) throws Exception {
		logger.debug("validateNameOnly(theCell={})", theCell);
		String result = "";
		String name = theCell.getName();
		if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
			result = CellIssueTypes.CELL_NAME_ONLY.description;
		}
		logger.debug("validateNameOnly() = {}", result);
		return result;
	}
}
