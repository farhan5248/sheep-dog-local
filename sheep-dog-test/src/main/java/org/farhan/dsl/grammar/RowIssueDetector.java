package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class RowIssueDetector {

	public static String validateCellListWorkspace(IRow theRow, ITestProject testProject) {
		Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);
		logger.debug("Entering validateCellListWorkspace");

		if (testProject == null || theRow == null) {
			logger.debug("Exiting validateCellListWorkspace - null inputs");
			return "";
		}

		// Navigate from Row -> Table -> TestStep
		ITable table = theRow.getParent();
		if (table == null) {
			logger.debug("Exiting validateCellListWorkspace - no parent table");
			return "";
		}

		Object tableParent = table.getParent();
		if (!(tableParent instanceof ITestStep)) {
			logger.debug("Exiting validateCellListWorkspace - table parent is not a TestStep");
			return "";
		}

		ITestStep testStep = (ITestStep) tableParent;

		// Get the step object full name
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep, testProject);
		if (stepObjectFullName == null || stepObjectFullName.isEmpty()) {
			logger.debug("Exiting validateCellListWorkspace - no step object name");
			return "";
		}

		// Check if the step object file exists in the workspace
		ITestDocument stepObjectDoc = testProject.getTestDocument(stepObjectFullName);
		if (stepObjectDoc == null) {
			logger.debug("Exiting validateCellListWorkspace - step object file does not exist");
			return "";
		}

		// Check if the step object file is an IStepObject
		if (!(stepObjectDoc instanceof IStepObject)) {
			logger.debug("Exiting validateCellListWorkspace - step object file is not an IStepObject");
			return "";
		}

		// Get the step definition name from the test step
		String stepDefinitionName = testStep.getStepDefinitionName();
		if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
			logger.debug("Exiting validateCellListWorkspace - no step definition name");
			return "";
		}

		// Check if the step definition exists in the step object file
		IStepObject stepObject = (IStepObject) stepObjectDoc;
		IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
		if (stepDefinition == null) {
			logger.debug("Exiting validateCellListWorkspace - step definition does not exist");
			return "";
		}

		// Check if this is the header row (first row in the table)
		if (table.getRow(0) != theRow) {
			logger.debug("Exiting validateCellListWorkspace - not a header row");
			return "";
		}

		// Get the cell names from the header row
		java.util.List<ICell> rowCells = theRow.getCellList();
		if (rowCells == null || rowCells.isEmpty()) {
			logger.debug("Exiting validateCellListWorkspace - no cells in row");
			return "";
		}

		// Check if any step parameter set matches the header row cells
		java.util.List<IStepParameters> stepParametersList = stepDefinition.getStepParameterList();
		if (stepParametersList == null || stepParametersList.isEmpty()) {
			logger.debug("Exiting validateCellListWorkspace - no step parameters");
			return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
		}

		// For each step parameter set, check if the cells match
		for (IStepParameters stepParams : stepParametersList) {
			ITable paramTable = stepParams.getTable();
			if (paramTable == null) {
				continue;
			}

			java.util.List<IRow> paramRows = paramTable.getRowList();
			if (paramRows == null || paramRows.isEmpty()) {
				continue;
			}

			// Get the first row (header row) from the parameter table
			IRow paramHeaderRow = paramRows.get(0);
			java.util.List<ICell> paramCells = paramHeaderRow.getCellList();
			if (paramCells == null || paramCells.size() != rowCells.size()) {
				continue;
			}

			// Check if all cell names match
			boolean allMatch = true;
			for (int i = 0; i < rowCells.size(); i++) {
				String rowCellName = rowCells.get(i).getName();
				String paramCellName = paramCells.get(i).getName();
				if (!rowCellName.equals(paramCellName)) {
					allMatch = false;
					break;
				}
			}

			if (allMatch) {
				logger.debug("Exiting validateCellListWorkspace - found matching parameter set");
				return "";
			}
		}

		logger.debug("Exiting validateCellListWorkspace - no matching parameter set found");
		return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
	}
}
