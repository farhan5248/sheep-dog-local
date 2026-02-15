package org.farhan.dsl.issues;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ICell;
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

        if (theRow != null) {
            ITable table = theRow.getParent();
            if (table != null) {
                Object tableParent = table.getParent();
                if (tableParent instanceof ITestStep) {
                    ITestStep theTestStep = (ITestStep) tableParent;
                    String stepObjectName = theTestStep.getStepObjectName();
                    String stepDefinitionName = theTestStep.getStepDefinitionName();

                    if (stepObjectName != null && stepDefinitionName != null) {
                        // Get the qualified name using utility method
                        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);

                        if (qualifiedName != null && !qualifiedName.isEmpty()) {
                            // Get the test project
                            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
                            if (project != null) {
                                    // Check if step object exists in workspace
                                    IStepObject stepObject = project.getStepObject(qualifiedName);
                                    if (stepObject != null) {
                                        // Get step definition
                                        IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                                        if (stepDefinition != null) {
                                            // Get step parameters (table-based parameters)
                                            if (!stepDefinition.getStepParameterList().isEmpty()) {
                                                IStepParameters stepParameters = stepDefinition.getStepParameterList().get(0);
                                                ITable parameterTable = stepParameters.getTable();
                                                if (parameterTable != null && !parameterTable.getRowList().isEmpty()) {
                                                    // Get header row (first row)
                                                    IRow headerRow = parameterTable.getRowList().get(0);

                                                    // Build set of expected parameter names
                                                    Set<String> expectedParams = new HashSet<>();
                                                    for (ICell cell : headerRow.getCellList()) {
                                                        expectedParams.add(cell.getName());
                                                    }

                                                    // Build set of actual parameter names from theRow
                                                    Set<String> actualParams = new HashSet<>();
                                                    for (ICell cell : theRow.getCellList()) {
                                                        actualParams.add(cell.getName());
                                                    }

                                                    // Compare the sets
                                                    if (!expectedParams.equals(actualParams)) {
                                                        String expectedParamsStr = SheepDogUtility.getCellListAsString(headerRow.getCellList());
                                                        String actualParamsStr = SheepDogUtility.getCellListAsString(theRow.getCellList());
                                                        logger.error("Cell mismatch - Expected: [{}], Actual: [{}]", expectedParamsStr, actualParamsStr);
                                                        logger.debug("Exiting validateCellListWorkspace");
                                                        return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                }
            }
        }

        logger.debug("Exiting validateCellListWorkspace");
        return "";
    }

}
