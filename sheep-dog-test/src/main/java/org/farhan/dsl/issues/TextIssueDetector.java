package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import org.slf4j.Logger;

public class TextIssueDetector {

	public static String validateContentWorkspace(IText theText, ITestProject testProject) {
		Logger logger = SheepDogLoggerFactory.getLogger(TextIssueDetector.class);
		logger.debug("Entering validateContentWorkspace");

		if (testProject == null || theText == null) {
			logger.debug("Exiting validateContentWorkspace - null inputs");
			return "";
		}

		// Navigate from Text -> TestStep
		ITestStep testStep = theText.getParent();
		if (testStep == null) {
			logger.debug("Exiting validateContentWorkspace - no parent test step");
			// When there's no parent test step, we can't determine which step definition to check against.
			// Return the error message indicating that step parameters don't exist.
			return TextIssueTypes.TEXT_CONTENT_WORKSPACE.description;
		}

		// Get the step object full name
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep, testProject);
		if (stepObjectFullName == null || stepObjectFullName.isEmpty()) {
			logger.debug("Exiting validateContentWorkspace - no step object name");
			return "";
		}

		// Check if the step object file exists in the workspace
		ITestDocument stepObjectDoc = testProject.getTestDocument(stepObjectFullName);
		if (stepObjectDoc == null) {
			logger.debug("Exiting validateContentWorkspace - step object file does not exist");
			return "";
		}

		// Check if the step object file is an IStepObject
		if (!(stepObjectDoc instanceof IStepObject)) {
			logger.debug("Exiting validateContentWorkspace - step object file is not an IStepObject");
			return "";
		}

		// Get the step definition name from the test step
		String stepDefinitionName = testStep.getStepDefinitionName();
		if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
			logger.debug("Exiting validateContentWorkspace - no step definition name");
			return "";
		}

		// Check if the step definition exists in the step object file
		IStepObject stepObject = (IStepObject) stepObjectDoc;
		IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
		if (stepDefinition == null) {
			logger.debug("Exiting validateContentWorkspace - step definition does not exist");
			return "";
		}

		// Check if any step parameter set has a "Content" cell
		java.util.List<IStepParameters> stepParametersList = stepDefinition.getStepParameterList();
		if (stepParametersList == null || stepParametersList.isEmpty()) {
			logger.debug("Exiting validateContentWorkspace - no step parameters");
			return TextIssueTypes.TEXT_CONTENT_WORKSPACE.description;
		}

		// For each step parameter set, check if it has a "Content" cell
		boolean foundContentParameter = false;
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
			if (paramCells == null || paramCells.isEmpty()) {
				continue;
			}

			// Check if any cell has the name "Content"
			for (ICell cell : paramCells) {
				if ("Content".equals(cell.getName())) {
					foundContentParameter = true;
					break;
				}
			}

			if (foundContentParameter) {
				break;
			}
		}

		if (foundContentParameter) {
			logger.debug("Exiting validateContentWorkspace - found Content parameter");
			return "";
		}

		logger.debug("Exiting validateContentWorkspace - no Content parameter found");
		return TextIssueTypes.TEXT_CONTENT_WORKSPACE.description;
	}
}
