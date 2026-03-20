package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class RowIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);

	public static String validateCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("Entry: validateCellListWorkspace({})", theRow);
		String message = "";
		ITable table = theRow.getParent();
		if (table == null) {
			logger.debug("Exit: validateCellListWorkspace({})", message);
			return message;
		}
		Object tableParent = table.getParent();
		if (!(tableParent instanceof ITestStep)) {
			logger.debug("Exit: validateCellListWorkspace({})", message);
			return message;
		}
		ITestStep testStep = (ITestStep) tableParent;
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
		if (stepObjectFullName.isEmpty()) {
			logger.debug("Exit: validateCellListWorkspace({})", message);
			return message;
		}
		ITestProject project = SheepDogUtility.getTestProjectParentForRow(theRow);
		if (project == null) {
			logger.debug("Exit: validateCellListWorkspace({})", message);
			return message;
		}
		ITestDocument stepObjectDoc = project.getTestDocument(stepObjectFullName);
		if (!(stepObjectDoc instanceof IStepObject)) {
			logger.debug("Exit: validateCellListWorkspace({})", message);
			return message;
		}
		IStepObject stepObject = (IStepObject) stepObjectDoc;
		String stepDefName = testStep.getStepDefinitionName();
		if (stepDefName == null || stepDefName.isEmpty()) {
			logger.debug("Exit: validateCellListWorkspace({})", message);
			return message;
		}
		IStepDefinition stepDef = stepObject.getStepDefinition(stepDefName);
		if (stepDef == null) {
			logger.debug("Exit: validateCellListWorkspace({})", message);
			return message;
		}
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
		logger.debug("Exit: validateCellListWorkspace({})", message);
		return message;
	}
}
