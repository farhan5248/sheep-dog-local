package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
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

        // Navigate from Row -> Table -> TestStep
        ITable table = theRow.getParent();
        if (table != null) {
            Object parent = table.getParent();
            if (parent instanceof ITestStep) {
                ITestStep testStep = (ITestStep) parent;

                // Get the step object qualified name
                String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(testStep);
                if (stepObjectNameLong != null && !stepObjectNameLong.isEmpty()) {
                    // Get the project
                    ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(testStep);
                    if (project != null) {
                        // Get the step object
                        IStepObject stepObject = project.getStepObject(stepObjectNameLong);
                        if (stepObject != null) {
                            // Get the step definition
                            String stepDefinitionName = testStep.getStepDefinitionName();
                            if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                                IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                                if (stepDefinition != null) {
                                    // Get the cell names from the row
                                    String cellNames = SheepDogUtility.getCellListAsString(theRow.getCellList());

                                    // Check if step parameters exist for these cells
                                    IStepParameters stepParameters = stepDefinition.getStepParameters(cellNames);
                                    if (stepParameters == null) {
                                        logger.debug("Exiting validateCellListWorkspace with error");
                                        return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
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
