package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

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

        // Navigate from Text to TestStep: Text -> TestStep
        if (theText.getParent() != null) {
            org.farhan.dsl.lang.ITestStep theTestStep = theText.getParent();

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
                                // Check if step parameters with "Content" header exist
                                org.farhan.dsl.lang.IStepParameters stepParams = theStepDefinition.getStepParameters("Content");
                                if (stepParams == null) {
                                    message = TextIssueTypes.TEXT_NAME_WORKSPACE.description;
                                }
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting validateNameWorkspace");
        return message;
    }
}
