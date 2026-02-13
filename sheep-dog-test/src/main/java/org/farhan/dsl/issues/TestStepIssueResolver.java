package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.HashSet;

import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
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
        logger.debug("Exiting correctStepObjectNameWorkspace");
        return null;
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
        logger.debug("Exiting correctStepDefinitionNameWorkspace");
        return null;
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

        // Use HashSet to avoid duplicates
        HashSet<String> addedProposals = new HashSet<>();

        // First, collect components from previous steps
        ArrayList<ITestStep> previousSteps = SheepDogUtility.getTestStepListUpToTestStep(theTestStep);
        HashSet<String> previousComponents = new HashSet<>();

        for (ITestStep previousStep : previousSteps) {
            String stepObjectName = previousStep.getStepObjectName();
            if (stepObjectName != null && !stepObjectName.isEmpty()) {
                String component = StepObjectRefFragments.getComponent(stepObjectName);
                if (!component.isEmpty()) {
                    previousComponents.add(component);
                }
            }
        }

        // Get the test project to access all step objects in workspace
        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

        // Suggest objects from workspace that match components from previous steps
        if (theProject != null) {
            for (IStepObject stepObject : theProject.getStepObjectList()) {
                String qualifiedName = stepObject.getNameLong();
                if (qualifiedName != null && !qualifiedName.isEmpty()) {
                    // Parse qualified name (e.g., "daily batchjob/Input file.feature")
                    // Remove file extension first
                    String nameWithoutExt = qualifiedName;
                    int lastDot = qualifiedName.lastIndexOf('.');
                    if (lastDot > 0) {
                        nameWithoutExt = qualifiedName.substring(0, lastDot);
                    }

                    // Split by "/" to get component and object
                    String component = "";
                    String object = "";
                    int slashIndex = nameWithoutExt.indexOf('/');
                    if (slashIndex > 0) {
                        component = nameWithoutExt.substring(0, slashIndex);
                        object = nameWithoutExt.substring(slashIndex + 1);
                    } else {
                        // No component, just object
                        object = nameWithoutExt;
                    }

                    if (!object.isEmpty() && !component.isEmpty()) {
                        // Only suggest if component was used in previous steps
                        if (previousComponents.contains(component)) {
                            // Create proposal with short ID and long value
                            String shortId = object;
                            String longValue = "The " + component + " " + object;

                            if (!addedProposals.contains(shortId + "|" + longValue)) {
                                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                                proposal.setId(shortId);
                                proposal.setValue(longValue);
                                proposals.add(proposal);
                                addedProposals.add(shortId + "|" + longValue);
                            }
                        }
                    }
                }
            }
        }

        // Suggest objects from previous steps
        for (ITestStep previousStep : previousSteps) {
            String stepObjectName = previousStep.getStepObjectName();
            if (stepObjectName != null && !stepObjectName.isEmpty()) {
                String component = StepObjectRefFragments.getComponent(stepObjectName);
                String object = StepObjectRefFragments.getObject(stepObjectName);

                if (!object.isEmpty()) {
                    // Create short form proposal (just object)
                    String shortId = object;
                    String shortValue = "The " + object;

                    if (!addedProposals.contains(shortId + "|" + shortValue)) {
                        SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
                        shortProposal.setId(shortId);
                        shortProposal.setValue(shortValue);
                        proposals.add(shortProposal);
                        addedProposals.add(shortId + "|" + shortValue);
                    }

                    // Create long form proposal (component/object) if component exists
                    if (!component.isEmpty()) {
                        String longId = component + "/" + object;
                        String longValue = "The " + component + " " + object;

                        if (!addedProposals.contains(longId + "|" + longValue)) {
                            SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                            longProposal.setId(longId);
                            longProposal.setValue(longValue);
                            proposals.add(longProposal);
                            addedProposals.add(longId + "|" + longValue);
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
        // For now, return empty list as we don't have step definitions to suggest
        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
