package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.HashSet;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
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
     * Helper method to create and add a proposal if it doesn't already exist.
     *
     * @param proposals the list to add the proposal to
     * @param addedProposals set tracking already-added proposals
     * @param id the proposal ID
     * @param value the proposal value
     * @param description the proposal description (can be null or empty)
     */
    private static void addProposal(
            ArrayList<SheepDogIssueProposal> proposals,
            HashSet<String> addedProposals,
            String id,
            String value,
            String description) {
        String key = id + "|" + value;
        if (!addedProposals.contains(key)) {
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(id);
            proposal.setValue(value);
            if (description != null && !description.isEmpty()) {
                proposal.setDescription(description);
            }
            proposals.add(proposal);
            addedProposals.add(key);
        }
    }

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
        HashSet<String> addedProposals = new HashSet<>();

        if (theTestStep != null && theTestStep.getStepObjectName() != null
                && !theTestStep.getStepObjectName().isEmpty()) {
            // Get component and object from step object name
            String stepObjectName = theTestStep.getStepObjectName();
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);

            if (!component.isEmpty() && !object.isEmpty()) {
                // Create proposal to generate the missing step object file
                // Format: "Generate {Object} - {component}/{object}.feature"
                String proposalId = "Generate " + object + " - " + component + "/" + object + ".feature";
                String proposalValue = proposalId;
                String description = "";

                addProposal(proposals, addedProposals, proposalId, proposalValue, description);
            }
        }

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
        HashSet<String> addedProposals = new HashSet<>();

        if (theTestStep != null && theTestStep.getStepObjectName() != null
                && !theTestStep.getStepObjectName().isEmpty()) {
            // Get the qualified name of the step object
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);

            if (qualifiedName != null && !qualifiedName.isEmpty()) {
                // Get the test project
                ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                if (theProject != null) {
                    // Get the step object from the project
                    IStepObject stepObject = theProject.getStepObject(qualifiedName);

                    if (stepObject != null) {
                        // Add proposals for existing step definitions from the step object
                        for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                            String stepDefName = stepDefinition.getName();
                            if (stepDefName != null && !stepDefName.isEmpty()) {
                                // Skip step definitions that have "Content" parameters
                                if (!hasContentParameter(stepDefinition)) {
                                    // Get description from statements
                                    String description = SheepDogUtility.getStatementListAsString(
                                            stepDefinition.getStatementList());

                                    addProposal(proposals, addedProposals, stepDefName, stepDefName, description);
                                }
                            }
                        }
                    }

                    // Add proposal to generate the missing step definition
                    String stepDefinitionName = theTestStep.getStepDefinitionName();
                    if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                        String proposalId = "Generate " + stepDefinitionName;
                        String proposalValue = proposalId;
                        String description = "";

                        addProposal(proposals, addedProposals, proposalId, proposalValue, description);
                    }
                }
            }
        }

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
        HashSet<String> addedProposals = new HashSet<>();

        // Get context
        ArrayList<ITestStep> previousSteps = SheepDogUtility.getTestStepListUpToTestStep(theTestStep);
        HashSet<String> previousComponents = getPreviousComponents(previousSteps);
        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

        // Add proposals from workspace and previous steps
        addWorkspaceProposals(proposals, addedProposals, theProject, previousComponents);
        addPreviousStepProposals(proposals, addedProposals, previousSteps, theProject);

        logger.debug("Exiting suggestStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Checks if a step definition has a "Content" parameter.
     * Content parameters are for text blocks, not for table rows.
     *
     * @param stepDefinition the step definition to check
     * @return true if the step definition has a "Content" parameter
     */
    private static boolean hasContentParameter(IStepDefinition stepDefinition) {
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            ITable table = stepParameters.getTable();
            if (table != null) {
                for (IRow row : table.getRowList()) {
                    for (ICell cell : row.getCellList()) {
                        if ("Content".equals(cell.getName())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if a step object only has step definitions with "Content" parameters.
     * If all step definitions have Content parameters, the step object shouldn't be suggested.
     *
     * @param stepObject the step object to check
     * @return true if the object has step definitions AND ALL of them have "Content" parameters
     */
    private static boolean hasOnlyContentParameters(IStepObject stepObject) {
        java.util.List<IStepDefinition> stepDefinitions = stepObject.getStepDefinitionList();
        if (stepDefinitions.isEmpty()) {
            return false; // No step definitions, still suggest (might be work in progress or just documentation)
        }

        for (IStepDefinition stepDefinition : stepDefinitions) {
            if (!hasContentParameter(stepDefinition)) {
                return false; // Found at least one step definition without Content parameter
            }
        }
        return true; // All step definitions have Content parameters
    }

    /**
     * Collects components referenced in previous steps.
     *
     * @param previousSteps list of test steps before the current step
     * @return set of component names
     */
    private static HashSet<String> getPreviousComponents(ArrayList<ITestStep> previousSteps) {
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
        return previousComponents;
    }

    /**
     * Adds proposals from workspace objects that match previously-used components.
     *
     * @param proposals the list to add proposals to
     * @param addedProposals set tracking already-added proposals
     * @param theProject the test project containing step objects
     * @param previousComponents set of components from previous steps
     */
    private static void addWorkspaceProposals(
            ArrayList<SheepDogIssueProposal> proposals,
            HashSet<String> addedProposals,
            ITestProject theProject,
            HashSet<String> previousComponents) {
        if (theProject != null) {
            for (IStepObject stepObject : theProject.getStepObjectList()) {
                // Skip step objects that only have Content parameters
                if (hasOnlyContentParameters(stepObject)) {
                    continue;
                }

                String qualifiedName = stepObject.getNameLong();
                if (qualifiedName != null && !qualifiedName.isEmpty()) {
                    // Parse qualified name (e.g., "daily batchjob/Input file.feature")
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
                        object = nameWithoutExt;
                    }

                    if (!object.isEmpty() && !component.isEmpty()) {
                        // Only suggest if component was used in previous steps (or no components exist yet)
                        if (previousComponents.isEmpty() || previousComponents.contains(component)) {
                            String shortId = object;
                            String longValue = "The " + component + " " + object;
                            String description = SheepDogUtility.getStatementListAsString(
                                    stepObject.getStatementList());
                            addProposal(proposals, addedProposals, shortId, longValue, description);
                        }
                    }
                }
            }
        }
    }

    /**
     * Adds proposals from objects referenced in previous steps.
     *
     * @param proposals the list to add proposals to
     * @param addedProposals set tracking already-added proposals
     * @param previousSteps list of test steps before the current step
     * @param theProject the test project (used to get descriptions)
     */
    private static void addPreviousStepProposals(
            ArrayList<SheepDogIssueProposal> proposals,
            HashSet<String> addedProposals,
            ArrayList<ITestStep> previousSteps,
            ITestProject theProject) {
        for (ITestStep previousStep : previousSteps) {
            String stepObjectName = previousStep.getStepObjectName();
            if (stepObjectName != null && !stepObjectName.isEmpty()) {
                String component = StepObjectRefFragments.getComponent(stepObjectName);
                String object = StepObjectRefFragments.getObject(stepObjectName);

                // Check if step object only has Content parameters
                String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(previousStep);
                if (qualifiedName != null && !qualifiedName.isEmpty() && theProject != null) {
                    IStepObject stepObject = theProject.getStepObject(qualifiedName);
                    if (stepObject != null && hasOnlyContentParameters(stepObject)) {
                        continue; // Skip step objects with only Content parameters
                    }
                }

                // Get description from workspace or fallback to "Referred in:" message
                String description = "";
                if (qualifiedName != null && !qualifiedName.isEmpty() && theProject != null) {
                    IStepObject stepObject = theProject.getStepObject(qualifiedName);
                    if (stepObject != null) {
                        description = SheepDogUtility.getStatementListAsString(stepObject.getStatementList());
                    } else {
                        description = "Referred in: " + previousStep.toString();
                    }
                }

                if (!object.isEmpty()) {
                    // Add short form proposal
                    addProposal(proposals, addedProposals, object, "The " + object, description);

                    // Add long form proposal if component exists
                    if (!component.isEmpty()) {
                        String longId = component + "/" + object;
                        String longValue = "The " + component + " " + object;
                        addProposal(proposals, addedProposals, longId, longValue, description);
                    }
                }
            }
        }
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
        HashSet<String> addedProposals = new HashSet<>();

        if (theTestStep != null && theTestStep.getStepObjectName() != null
                && !theTestStep.getStepObjectName().isEmpty()) {
            // Get the qualified name of the step object
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);

            if (qualifiedName != null && !qualifiedName.isEmpty()) {
                // Get the test project
                ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                if (theProject != null) {
                    // Get the step object from the project
                    IStepObject stepObject = theProject.getStepObject(qualifiedName);

                    if (stepObject != null) {
                        // Get all step definitions from the step object
                        for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                            String stepDefName = stepDefinition.getName();
                            if (stepDefName != null && !stepDefName.isEmpty()) {
                                // Skip step definitions that have "Content" parameters
                                // Content parameters are for text blocks, not for table rows
                                if (!hasContentParameter(stepDefinition)) {
                                    // Get description from statements
                                    String description = SheepDogUtility.getStatementListAsString(
                                            stepDefinition.getStatementList());

                                    addProposal(proposals, addedProposals, stepDefName, stepDefName, description);
                                }
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
