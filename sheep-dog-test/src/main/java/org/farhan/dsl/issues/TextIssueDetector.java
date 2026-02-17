package org.farhan.dsl.issues;

import java.util.List;

import org.slf4j.Logger;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
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

        // Get the parent test step
        ITestStep theTestStep = theText.getParent();
        if (theTestStep != null) {
            String stepDefinitionName = theTestStep.getStepDefinitionName();

            if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                // Get the step object
                String stepObjectName = theTestStep.getStepObjectName();
                if (stepObjectName != null && !stepObjectName.isEmpty()) {
                    String component = StepObjectRefFragments.getComponent(stepObjectName);
                    String object = StepObjectRefFragments.getObject(stepObjectName);

                    if (!component.isEmpty() && !object.isEmpty()) {
                        // Get the test project using utility method
                        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                        if (theProject != null) {
                            // Construct the qualified name of the step object file
                            String fileExt = theProject.getFileExtension();
                            if (fileExt == null) {
                                fileExt = "";
                            }
                            String qualifiedName = component + "/" + object + fileExt;

                            // Check if the step object exists in the project
                            IStepObject theStepObject = theProject.getStepObject(qualifiedName);
                            if (theStepObject != null) {
                                // Step object exists, now check if the step definition exists
                                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                                if (theStepDefinition != null) {
                                    // Step definition exists, check if it has step parameters
                                    List<IStepParameters> stepParameterList = theStepDefinition.getStepParameterList();
                                    if (stepParameterList == null || stepParameterList.isEmpty()) {
                                        message = TextIssueTypes.TEXT_NAME_WORKSPACE.description;
                                    }
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
