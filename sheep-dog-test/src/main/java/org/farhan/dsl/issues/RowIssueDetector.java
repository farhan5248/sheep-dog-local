package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class RowIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);

	public static String validateCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("Entry: validateCellListWorkspace({})", theRow);
		String message = "";
		IStepDefinition stepDef = SheepDogUtility.getStepDefinitionParentForRow(theRow);
		if (stepDef != null) {
			String rowCells = SheepDogUtility.getCellListAsString(theRow.getCellList());
			for (IStepParameters sp : stepDef.getStepParameterList()) {
				if (sp.getTable() != null && !sp.getTable().getRowList().isEmpty()) {
					IRow headerRow = sp.getTable().getRow(0);
					String paramCells = SheepDogUtility.getCellListAsString(headerRow.getCellList());
					if (rowCells.equals(paramCells)) {
						logger.debug("Exit: validateCellListWorkspace({})", message);
						return message;
					}
				}
			}
			message = RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
		}
		logger.debug("Exit: validateCellListWorkspace({})", message);
		return message;
	}
}
