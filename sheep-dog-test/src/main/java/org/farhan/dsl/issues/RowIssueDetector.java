package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class RowIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);

    public static String validateCellListWorkspace(IRow theRow) {
        logger.debug("Entering validateCellListWorkspace for theRow: {}", theRow != null ? "non-null" : "null");
        ITestProject workspace = SheepDogUtility.getTestProjectParentForRow(theRow);
        if (workspace == null) {
            logger.debug("Exiting validateCellListWorkspace with result: {}", "");
            return "";
        }
        ITable table = theRow.getParent();
        Object tableParent = table.getParent();
        if (!(tableParent instanceof ITestStep)) {
            logger.debug("Exiting validateCellListWorkspace with result: {}", "");
            return "";
        }
        ITestStep testStep = (ITestStep) tableParent;
        if (table.getRowList().indexOf(theRow) != 0) {
            logger.debug("Exiting validateCellListWorkspace with result: {}", "");
            return "";
        }
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (stepObjectFullName.isEmpty() || workspace.getTestDocument(stepObjectFullName) == null) {
            logger.debug("Exiting validateCellListWorkspace with result: {}", "");
            return "";
        }
        IStepObject stepObject = (IStepObject) workspace.getTestDocument(stepObjectFullName);
        IStepDefinition stepDefinition = stepObject.getStepDefinition(testStep.getStepDefinitionName());
        if (stepDefinition == null) {
            logger.debug("Exiting validateCellListWorkspace with result: {}", "");
            return "";
        }
        String rowCellsAsString = SheepDogUtility.getCellListAsString(theRow.getCellList());
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            ITable stepParamTable = stepParameters.getTable();
            if (stepParamTable != null && !stepParamTable.getRowList().isEmpty()) {
                IRow headerRow = stepParamTable.getRow(0);
                String paramCellsAsString = SheepDogUtility.getCellListAsString(headerRow.getCellList());
                if (rowCellsAsString.equals(paramCellsAsString)) {
                    logger.debug("Exiting validateCellListWorkspace with result: {}", "");
                    return "";
                }
            }
        }
        String result = RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
        logger.debug("Exiting validateCellListWorkspace with result: {}", result);
        return result;
    }
}
