package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class RowIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theRow the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateCellListWorkspace(IRow theRow) throws Exception {
        logger.debug("Entering validateCellListWorkspace");
        String message = "";
        ITable table = theRow.getParent();
        if (table != null && table.getParent() instanceof ITestStep) {
            ITestStep testStep = (ITestStep) table.getParent();
            ITestProject testProject = SheepDogUtility.getTestProjectParentForRow(theRow);
            if (testProject != null) {
                String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(testStep);
                IStepObject theStepObject = testProject.getStepObject(qualifiedName);
                if (theStepObject != null) {
                    String stepDefinitionName = testStep.getStepDefinitionName();
                    IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                    if (theStepDefinition != null) {
                        String rowCells = SheepDogUtility.getCellListAsString(theRow.getCellList());
                        boolean found = false;
                        for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
                            ITable paramsTable = stepParameters.getTable();
                            if (paramsTable != null && !paramsTable.getRowList().isEmpty()) {
                                String paramCells = SheepDogUtility.getCellListAsString(paramsTable.getRow(0).getCellList());
                                if (rowCells.equals(paramCells)) {
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (!found) {
                            message = RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
                        }
                    }
                }
            }
        }
        logger.debug("Exiting validateCellListWorkspace");
        return message;
    }

}
