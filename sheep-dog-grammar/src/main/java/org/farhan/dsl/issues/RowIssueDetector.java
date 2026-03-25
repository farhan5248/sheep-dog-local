package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.slf4j.Logger;

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
        logger.debug("Entering validateCellListWorkspace for theRow: {}", theRow != null ? "non-null" : "null");
        String message = "";
        ITable table = SheepDogUtility.getTableParent(theRow);
        if (table != null && SheepDogUtility.getTestStepParent(table) != null) {
            ITestStep testStep = SheepDogUtility.getTestStepParent(table);
            ITestProject testProject = SheepDogUtility.getTestProjectParent(theRow);
            if (testProject != null) {
                String fullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
                IStepObject theStepObject = (IStepObject) SheepDogUtility.getTestDocument(testProject, fullName);
                if (theStepObject != null) {
                    String stepDefinitionName = testStep.getStepDefinitionName();
                    IStepDefinition theStepDefinition = SheepDogUtility.getStepDefinition(theStepObject, stepDefinitionName);
                    if (theStepDefinition != null) {
                        String rowCells = SheepDogUtility.getCellListAsString(theRow.getCellList());
                        boolean found = false;
                        for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
                            ITable paramsTable = stepParameters.getTable();
                            if (paramsTable != null && !paramsTable.getRowList().isEmpty()) {
                                String paramCells = SheepDogUtility.getCellListAsString(paramsTable.getRowList().get(0).getCellList());
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
        logger.debug("Exiting validateCellListWorkspace with result: {}", message);
        return message;
    }

}
