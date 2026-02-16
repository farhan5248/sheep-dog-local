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
public class TestStepIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theTestStep the element needing corrections
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering correctStepObjectNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        logger.debug("Exiting correctStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theTestStep the element needing corrections
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering correctStepDefinitionNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        logger.debug("Exiting correctStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Generates proposals suggesting values when an assignment is missing or empty.
     *
     * @param theTestStep the element needing suggestions
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering suggestStepObjectNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (theTestStep != null) {
            // Get previous steps to extract object references
            java.util.ArrayList<org.farhan.dsl.lang.ITestStep> previousSteps =
                org.farhan.dsl.lang.SheepDogUtility.getTestStepListUpToTestStep(theTestStep);

            for (org.farhan.dsl.lang.ITestStep previousStep : previousSteps) {
                String stepObjectName = previousStep.getStepObjectName();
                if (stepObjectName != null && !stepObjectName.isEmpty()) {
                    // Parse the step object name to extract component and object
                    String component = org.farhan.dsl.lang.StepObjectRefFragments.getComponent(stepObjectName);
                    String object = org.farhan.dsl.lang.StepObjectRefFragments.getObject(stepObjectName);

                    if (!object.isEmpty()) {
                        // Extract the base object name and type from the full stepObjectName
                        String objectName = org.farhan.dsl.lang.StepObjectRefFragments.getObjectName(stepObjectName);
                        String objectType = org.farhan.dsl.lang.StepObjectRefFragments.getObjectType(stepObjectName);

                        if (!objectName.isEmpty() && !objectType.isEmpty()) {
                            String baseObjectName = (objectName + " " + objectType).trim();
                            String previousStepNameLong = org.farhan.dsl.lang.SheepDogUtility.getTestStepNameLong(previousStep);
                            String referenceText = "Referred in: " + previousStepNameLong;

                            // Proposal 1: Just the object name (without component)
                            org.farhan.dsl.lang.SheepDogIssueProposal proposal1 =
                                new org.farhan.dsl.lang.SheepDogIssueProposal();
                            proposal1.setId(baseObjectName);
                            proposal1.setValue("The " + baseObjectName);
                            proposal1.setDescription(referenceText);
                            proposals.add(proposal1);

                            // Proposal 2: Full component/object (if component exists)
                            if (!component.isEmpty()) {
                                org.farhan.dsl.lang.SheepDogIssueProposal proposal2 =
                                    new org.farhan.dsl.lang.SheepDogIssueProposal();
                                proposal2.setId((component + "/" + baseObjectName).trim());
                                proposal2.setValue("The " + component + " " + baseObjectName);
                                proposal2.setDescription(referenceText);
                                proposals.add(proposal2);
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting suggestStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Generates proposals suggesting values when an assignment is missing or empty.
     *
     * @param theTestStep the element needing suggestions
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering suggestStepDefinitionNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
