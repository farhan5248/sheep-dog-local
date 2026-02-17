package org.farhan.dsl.issues;

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
import org.farhan.dsl.lang.StepObjectRefFragments;

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

        // Get the table parent
        ITable table = theRow.getParent();
        if (table == null) {
            logger.debug("Exiting validateCellListWorkspace");
            return "";
        }

        // Get the test step parent
        Object tableParent = table.getParent();
        if (!(tableParent instanceof ITestStep)) {
            logger.debug("Exiting validateCellListWorkspace");
            return "";
        }

        ITestStep testStep = (ITestStep) tableParent;

        // Get the row's parameter headers as a string
        StringBuilder rowHeaders = new StringBuilder();
        for (ICell cell : theRow.getCellList()) {
            if (rowHeaders.length() > 0) {
                rowHeaders.append("|");
            }
            rowHeaders.append(cell.getName());
        }
        String rowParametersKey = rowHeaders.toString();

        // Get the test project using utility method
        ITestProject testProject = SheepDogUtility.getTestProjectParentForRow(theRow);
        if (testProject == null) {
            logger.debug("Exiting validateCellListWorkspace");
            return "";
        }

        // Try to get the step object and step definition
        String stepObjectName = testStep.getStepObjectName();

        // Extract component and object from the step object name
        String component = StepObjectRefFragments.getComponent(stepObjectName);
        String object = StepObjectRefFragments.getObject(stepObjectName);

        IStepObject stepObject = null;

        if (!component.isEmpty() && !object.isEmpty()) {
            // Construct the qualified name with file extension
            String fileExt = testProject.getFileExtension();
            if (fileExt == null) {
                fileExt = "";
            }
            String qualifiedName = component + "/" + object + fileExt;

            stepObject = testProject.getStepObject(qualifiedName);
        }

        if (stepObject != null) {
            IStepDefinition stepDefinition = stepObject.getStepDefinition(testStep.getStepDefinitionName());
            if (stepDefinition != null) {
                // Check if the row parameters match any of the step definition's parameter sets
                for (IStepParameters stepParams : stepDefinition.getStepParameterList()) {
                    if (stepParams.getName().equals(rowParametersKey)) {
                        // Found a match
                        logger.debug("Exiting validateCellListWorkspace");
                        return "";
                    }
                }
                // No match found
                logger.debug("Exiting validateCellListWorkspace");
                return TextIssueTypes.TEXT_NAME_WORKSPACE.description;
            }
        }

        logger.debug("Exiting validateCellListWorkspace");
        return "";
    }

}
