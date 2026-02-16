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
import org.farhan.dsl.lang.StepDefinitionRefFragments;

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
        ITable theTable = theRow.getParent();
        if (theTable != null) {
            Object tableParent = theTable.getParent();
            if (tableParent instanceof ITestStep) {
                ITestStep theTestStep = (ITestStep) tableParent;
                String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
                if (!qualifiedName.isEmpty()) {
                    ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
                    if (theProject != null) {
                        IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                        if (theStepObject != null) {
                            String stepDefinitionName = StepDefinitionRefFragments.getAll(theTestStep.getStepDefinitionName());
                            IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                            if (theStepDefinition != null) {
                                String headers = SheepDogUtility.getCellListAsString(theRow.getCellList());
                                IStepParameters theStepParameters = theStepDefinition.getStepParameters(headers);
                                if (theStepParameters == null) {
                                    logger.debug("Exiting validateCellListWorkspace with error");
                                    return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
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
