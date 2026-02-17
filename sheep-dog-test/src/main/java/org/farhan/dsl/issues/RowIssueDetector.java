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
        ITestStep theTestStep = (ITestStep) tableParent;
        ITestProject testProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (testProject == null) {
            logger.debug("Exiting validateCellListWorkspace - no test project found");
            return "";
        }
        String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (stepObjectNameLong.isEmpty()) {
            logger.debug("Exiting validateCellListWorkspace - no step object name");
            return "";
        }
        IStepObject theStepObject = testProject.getStepObject(stepObjectNameLong);
        if (theStepObject == null) {
            logger.debug("Exiting validateCellListWorkspace - step object not found");
            return "";
        }
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            logger.debug("Exiting validateCellListWorkspace - no step definition name");
            return "";
        }
        IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
        if (theStepDefinition == null) {
            logger.debug("Exiting validateCellListWorkspace - step definition not found");
            return "";
        }
        String rowCellsAsString = SheepDogUtility.getCellListAsString(theRow.getCellList());
        for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
            ITable stepParamsTable = stepParameters.getTable();
            if (stepParamsTable != null && !stepParamsTable.getRowList().isEmpty()) {
                IRow headerRow = stepParamsTable.getRow(0);
                String headerCellsAsString = SheepDogUtility.getCellListAsString(headerRow.getCellList());
                if (rowCellsAsString.equals(headerCellsAsString)) {
                    logger.debug("Exiting validateCellListWorkspace - cells match step parameters");
                    return "";
                }
            }
        }
        logger.debug("Exiting validateCellListWorkspace with error");
        return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
    }

}
