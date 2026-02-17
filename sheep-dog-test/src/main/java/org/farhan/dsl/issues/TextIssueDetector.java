package org.farhan.dsl.issues;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
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

        ITestStep theTestStep = theText.getParent();
        if (theTestStep == null) {
            logger.debug("Exiting validateNameWorkspace - no parent test step");
            return "";
        }
        ITestProject testProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (testProject == null) {
            logger.debug("Exiting validateNameWorkspace - no test project found");
            return "";
        }
        String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (stepObjectNameLong.isEmpty()) {
            logger.debug("Exiting validateNameWorkspace - no step object name");
            return "";
        }
        IStepObject theStepObject = testProject.getStepObject(stepObjectNameLong);
        if (theStepObject == null) {
            logger.debug("Exiting validateNameWorkspace - step object not found");
            return "";
        }
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            logger.debug("Exiting validateNameWorkspace - no step definition name");
            return "";
        }
        IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
        if (theStepDefinition == null) {
            logger.debug("Exiting validateNameWorkspace - step definition not found");
            return "";
        }
        if (theStepDefinition.getStepParameters("Content") != null) {
            logger.debug("Exiting validateNameWorkspace - Content parameter found");
            return "";
        }
        logger.debug("Exiting validateNameWorkspace with error");
        return TextIssueTypes.TEXT_NAME_WORKSPACE.description;
    }
}
