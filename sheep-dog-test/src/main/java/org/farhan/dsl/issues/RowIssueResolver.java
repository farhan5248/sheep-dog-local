package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.slf4j.Logger;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class RowIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueResolver.class);

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theTestStep the element needing corrections
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering correctCellListWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Generates proposals suggesting values when an assignment is missing or empty.
     *
     * @param theTestStep the element needing suggestions
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering suggestCellListWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (theTestStep != null) {
            // Get the qualified name of the step object for this test step
            String stepObjectQualifiedName = org.farhan.dsl.lang.SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            logger.debug("Step object qualified name: {}", stepObjectQualifiedName);

            if (stepObjectQualifiedName != null && !stepObjectQualifiedName.isEmpty()) {
                // Get the test project to access workspace step objects
                org.farhan.dsl.lang.ITestProject theProject = org.farhan.dsl.lang.SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                if (theProject != null) {
                    // Find the step object with this qualified name
                    org.farhan.dsl.lang.IStepObject stepObject = theProject.getStepObject(stepObjectQualifiedName);

                    if (stepObject != null) {
                        logger.debug("Found step object: {}", stepObject.getNameLong());

                        // Get the step definition name from the test step
                        String stepDefinitionName = theTestStep.getStepDefinitionName();
                        logger.debug("Looking for step definition: {}", stepDefinitionName);

                        if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                            // Find the step definition in the step object
                            org.farhan.dsl.lang.IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);

                            if (stepDefinition != null) {
                                logger.debug("Found step definition: {}", stepDefinition.getName());

                                // Get all step parameters from the step definition
                                for (org.farhan.dsl.lang.IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                                    String parametersName = stepParameters.getName();

                                    // Skip Content parameters - they are for text blocks, not table rows
                                    if ("Content".equals(parametersName)) {
                                        logger.debug("Skipping Content parameter as it's for text blocks, not table rows");
                                        continue;
                                    }

                                    String parametersDescription = org.farhan.dsl.lang.SheepDogUtility.getStatementListAsString(stepParameters.getStatementList());

                                    logger.debug("Adding step parameters proposal: name={}, description={}", parametersName, parametersDescription);

                                    // Create proposal with id=name, value=name, description=description
                                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                                    proposal.setId(parametersName);
                                    proposal.setValue(parametersName);
                                    proposal.setDescription(parametersDescription);
                                    proposals.add(proposal);
                                }
                            } else {
                                logger.debug("Step definition not found: {}", stepDefinitionName);
                            }
                        }
                    } else {
                        logger.debug("Step object not found: {}", stepObjectQualifiedName);
                    }
                }
            }
        }

        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
