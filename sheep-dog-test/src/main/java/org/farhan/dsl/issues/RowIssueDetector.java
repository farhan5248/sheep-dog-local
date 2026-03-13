package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogUtility;

public class RowIssueDetector {

    public static String validateWorkspace(IRow theRow, ITestProject workspace) {
        ITable table = theRow.getParent();
        Object tableParent = table.getParent();
        if (!(tableParent instanceof ITestStep)) {
            return "";
        }
        ITestStep testStep = (ITestStep) tableParent;
        if (table.getRowList().indexOf(theRow) != 0) {
            return "";
        }
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (stepObjectFullName.isEmpty() || workspace.getTestDocument(stepObjectFullName) == null) {
            return "";
        }
        IStepObject stepObject = (IStepObject) workspace.getTestDocument(stepObjectFullName);
        IStepDefinition stepDefinition = stepObject.getStepDefinition(testStep.getStepDefinitionName());
        if (stepDefinition == null) {
            return "";
        }
        String rowCellsAsString = SheepDogUtility.getCellListAsString(theRow.getCellList());
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            ITable stepParamTable = stepParameters.getTable();
            if (stepParamTable != null && !stepParamTable.getRowList().isEmpty()) {
                IRow headerRow = stepParamTable.getRow(0);
                String paramCellsAsString = SheepDogUtility.getCellListAsString(headerRow.getCellList());
                if (rowCellsAsString.equals(paramCellsAsString)) {
                    return "";
                }
            }
        }
        return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
    }
}
