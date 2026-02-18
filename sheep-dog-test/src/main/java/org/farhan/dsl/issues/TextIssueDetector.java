package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.ICell;
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
        String message = "";
        ITestStep testStep = theText.getParent();
        ITestProject testProject = SheepDogUtility.getTestProjectParentForText(theText);
        if (testProject != null) {
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(testStep);
            IStepObject theStepObject = testProject.getStepObject(qualifiedName);
            if (theStepObject != null) {
                String stepDefinitionName = testStep.getStepDefinitionName();
                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                if (theStepDefinition != null) {
                    boolean found = false;
                    for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
                        ITable paramsTable = stepParameters.getTable();
                        if (paramsTable != null && !paramsTable.getRowList().isEmpty()) {
                            for (ICell cell : paramsTable.getRow(0).getCellList()) {
                                if ("Content".equals(cell.getName())) {
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        message = TextIssueTypes.TEXT_NAME_WORKSPACE.description;
                    }
                }
            }
        }
        logger.debug("Exiting validateNameWorkspace");
        return message;
    }
}
