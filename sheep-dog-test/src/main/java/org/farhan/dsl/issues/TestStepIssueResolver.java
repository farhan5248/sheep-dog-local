package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepObjectRefFragments;
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
            // Get previous steps in the test case
            ArrayList<ITestStep> previousSteps = SheepDogUtility.getTestStepListUpToTestStep(theTestStep);

            // Track unique objects we've already added to avoid duplicates
            ArrayList<String> addedObjects = new ArrayList<>();

            for (ITestStep previousStep : previousSteps) {
                String stepObjectName = previousStep.getStepObjectName();
                if (stepObjectName != null && !stepObjectName.isEmpty()) {
                    String component = StepObjectRefFragments.getComponent(stepObjectName);
                    String object = StepObjectRefFragments.getObject(stepObjectName);

                    if (!object.isEmpty()) {
                        // Proposal 1: Just the object (e.g., "The Output file")
                        String shortValue = "The " + object.trim();
                        String shortId = object.trim();
                        if (!addedObjects.contains(shortId)) {
                            SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
                            shortProposal.setId(shortId);
                            shortProposal.setValue(shortValue);
                            shortProposal.setDescription("Referred in: " + SheepDogUtility.getTestStepNameLong(previousStep));
                            proposals.add(shortProposal);
                            addedObjects.add(shortId);
                            logger.debug("Added short proposal: {} = {}", shortId, shortValue);
                        }

                        // Proposal 2: Component + object (e.g., "The daily batchjob Output file")
                        if (!component.isEmpty()) {
                            String longValue = "The " + component.trim() + " " + object.trim();
                            String longId = component.trim() + "/" + object.trim();
                            if (!addedObjects.contains(longId)) {
                                SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                                longProposal.setId(longId);
                                longProposal.setValue(longValue);
                                longProposal.setDescription("Referred in: " + SheepDogUtility.getTestStepNameLong(previousStep));
                                proposals.add(longProposal);
                                addedObjects.add(longId);
                                logger.debug("Added long proposal: {} = {}", longId, longValue);
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
