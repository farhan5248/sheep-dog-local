package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
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
        ITestStep theTestStep = theText.getParent();
        if (theTestStep != null) {
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            if (!qualifiedName.isEmpty()) {
                ITestProject theProject = SheepDogUtility.getTestProjectParentForText(theText);
                if (theProject != null) {
                    IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                    if (theStepObject != null) {
                        String stepDefinitionName = StepDefinitionRefFragments.getAll(theTestStep.getStepDefinitionName());
                        IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                        if (theStepDefinition != null) {
                            IStepParameters theStepParameters = theStepDefinition.getStepParameters("Content");
                            if (theStepParameters == null) {
                                logger.debug("Exiting validateNameWorkspace with error");
                                return TextIssueTypes.TEXT_NAME_WORKSPACE.description;
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
