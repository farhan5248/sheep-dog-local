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
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TextIssueDetector {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueDetector.class);

    /**
     * Validates a specific grammar assignment at element-only, file, or workspace
     * scope, returning empty string if valid or error description if invalid.
     *
     * @param theText the element to validate
     * @return empty string if valid, error description otherwise
     * @throws Exception if validation fails
     */
    public static String validateNameWorkspace(IText theText) throws Exception {
        logger.debug("Entering validateNameWorkspace");

        if (theText != null) {
            ITestStep theTestStep = theText.getParent();
            if (theTestStep != null) {
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
                                // Check if step definition has text (Content) parameters
                                boolean hasTextParameters = false;
                                if (!stepDefinition.getStepParameterList().isEmpty()) {
                                    IStepParameters stepParameters = stepDefinition.getStepParameterList().get(0);
                                    // Text parameters are represented as a table with a "Content" cell
                                    ITable parameterTable = stepParameters.getTable();
                                    if (parameterTable != null && !parameterTable.getRowList().isEmpty()) {
                                        IRow headerRow = parameterTable.getRowList().get(0);
                                        for (ICell cell : headerRow.getCellList()) {
                                            if ("Content".equals(cell.getName())) {
                                                hasTextParameters = true;
                                                break;
                                            }
                                        }
                                    }
                                }

                                // If the test step has text but the step definition doesn't support text parameters,
                                // return error message
                                if (!hasTextParameters) {
                                    logger.debug("Exiting validateNameWorkspace");
                                    return TextIssueTypes.TEXT_NAME_WORKSPACE.description;
                                }
                            }
                        }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateNameWorkspace");
        return "";
    }
}
