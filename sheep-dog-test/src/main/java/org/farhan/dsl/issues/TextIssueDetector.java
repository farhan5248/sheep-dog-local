package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TextIssueDetector {

    private static final Logger logger = LoggerFactory.getLogger(TextIssueDetector.class);

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
                    // Extract component and object from step object name
                    String componentName = StepObjectRefFragments.getComponentName(stepObjectName);
                    String componentType = StepObjectRefFragments.getComponentType(stepObjectName);
                    String objectName = StepObjectRefFragments.getObjectName(stepObjectName);
                    String objectType = StepObjectRefFragments.getObjectType(stepObjectName);

                    // Build qualified name: "{component}/{object}.feature"
                    String qualifiedName = "";
                    if (!componentName.isEmpty() && !componentType.isEmpty()) {
                        qualifiedName = componentName.trim() + " " + componentType.trim() + "/";
                    }
                    if (!objectName.isEmpty() && !objectType.trim().isEmpty()) {
                        qualifiedName += objectName.trim() + " " + objectType.trim() + ".feature";
                    }

                    // Navigate up to get the test project
                    ITestStepContainer container = theTestStep.getParent();
                    if (container != null) {
                        ITestSuite suite = container.getParent();
                        if (suite != null) {
                            ITestProject project = suite.getParent();
                            if (project != null && !qualifiedName.isEmpty()) {
                                // Check if step object exists in workspace
                                IStepObject stepObject = project.getStepObject(qualifiedName);
                                if (stepObject != null) {
                                    // Get step definition
                                    IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                                    if (stepDefinition != null) {
                                        // Check if step definition has text (statement-based) parameters
                                        boolean hasTextParameters = false;
                                        if (!stepDefinition.getStepParameterList().isEmpty()) {
                                            IStepParameters stepParameters = stepDefinition.getStepParameterList().get(0);
                                            // Text parameters are represented as statements
                                            if (!stepParameters.getStatementList().isEmpty()) {
                                                hasTextParameters = true;
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
        }

        logger.debug("Exiting validateNameWorkspace");
        return "";
    }
}
