package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;
import org.slf4j.Logger;

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
        logger.debug("Entering validateNameWorkspace for theText: {}", theText != null ? theText.getContent() : "null");
        String message = "";
        ITestStep testStep = SheepDogUtility.getTestStepParent(theText);
        ITestProject testProject = SheepDogUtility.getTestProjectParent(theText);
        if (testProject != null) {
            String fullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
            IStepObject theStepObject = (IStepObject) SheepDogUtility.getTestDocument(testProject, fullName);
            if (theStepObject != null) {
                String stepDefinitionName = testStep.getStepDefinitionName();
                IStepDefinition theStepDefinition = SheepDogUtility.getStepDefinition(theStepObject, stepDefinitionName);
                if (theStepDefinition != null) {
                    boolean found = false;
                    for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
                        ITable paramsTable = stepParameters.getTable();
                        if (paramsTable != null && !paramsTable.getRowList().isEmpty()) {
                            for (ICell cell : paramsTable.getRowList().get(0).getCellList()) {
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
        logger.debug("Exiting validateNameWorkspace with result: {}", message);
        return message;
    }
}
