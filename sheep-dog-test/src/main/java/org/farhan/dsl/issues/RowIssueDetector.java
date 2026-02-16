package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

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

        // Navigate from Row to TestStep: Row -> Table -> TestStep
        if (theRow.getParent() != null) {
            Object tableParent = theRow.getParent().getParent();
            if (tableParent instanceof org.farhan.dsl.lang.ITestStep) {
                org.farhan.dsl.lang.ITestStep theTestStep = (org.farhan.dsl.lang.ITestStep) tableParent;

                // Get the step object and step definition from the workspace
                String qualifiedName = org.farhan.dsl.lang.SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
                if (!qualifiedName.isEmpty()) {
                    org.farhan.dsl.lang.ITestProject theProject = org.farhan.dsl.lang.SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
                    if (theProject != null) {
                        org.farhan.dsl.lang.IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                        if (theStepObject != null) {
                            // Get the step definition - use the full step definition name directly
                            String stepDefinitionName = theTestStep.getStepDefinitionName();
                            if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                                org.farhan.dsl.lang.IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                                if (theStepDefinition != null) {
                                    // Build the header string from the row's cells using the same method as getStepParameters
                                    String headers = org.farhan.dsl.lang.SheepDogUtility.getCellListAsString(theRow.getCellList());

                                    // Check if step parameters with these headers exist
                                    org.farhan.dsl.lang.IStepParameters stepParams = theStepDefinition.getStepParameters(headers);
                                    if (stepParams == null) {
                                        message = RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateCellListWorkspace");
        return message;
    }

}
