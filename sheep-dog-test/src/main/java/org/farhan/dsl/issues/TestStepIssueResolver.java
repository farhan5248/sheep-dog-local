package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepDefinitionRefFragments;
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

        if (theTestStep != null && !theTestStep.getStepObjectName().isEmpty()) {
            // Get the qualified name for the step object (e.g., "daily batchjob/Input file.feature")
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            logger.debug("Step object qualified name: {}", qualifiedName);

            if (qualifiedName != null && !qualifiedName.isEmpty()) {
                // Create a new step object for the quickfix proposal
                org.farhan.dsl.lang.IStepObject theStepObject = org.farhan.dsl.lang.SheepDogBuilder.createStepObject(null, qualifiedName);

                // Create the proposal to generate the missing step object file
                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                proposal.setId("Generate " + theStepObject.getName() + " - " + theStepObject.getNameLong());
                proposal.setDescription(SheepDogUtility.getStatementListAsString(theStepObject.getStatementList()));
                proposal.setValue(theStepObject.getContent());
                proposals.add(proposal);

                logger.debug("Created proposal to generate step object: {}", theStepObject.getNameLong());
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

        if (theTestStep != null) {
            // Get the qualified name of the step object for this test step
            String stepObjectQualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            logger.debug("Step object qualified name: {}", stepObjectQualifiedName);

            if (stepObjectQualifiedName != null && !stepObjectQualifiedName.isEmpty()) {
                // Get the test project to access workspace step objects
                org.farhan.dsl.lang.ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                if (theProject != null) {
                    // Find the step object with this qualified name
                    org.farhan.dsl.lang.IStepObject stepObject = theProject.getStepObject(stepObjectQualifiedName);

                    if (stepObject != null) {
                        logger.debug("Found step object: {}", stepObject.getNameLong());

                        // Add all existing step definitions as quickfix options
                        for (org.farhan.dsl.lang.IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                            String stepDefName = stepDefinition.getName();
                            String stepDefDescription = SheepDogUtility.getStatementListAsString(stepDefinition.getStatementList());

                            logger.debug("Adding existing step definition proposal: name={}, description={}", stepDefName, stepDefDescription);

                            // Create proposal with id=name, value=name, description=description
                            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                            proposal.setId(stepDefName);
                            proposal.setValue(stepDefName);
                            proposal.setDescription(stepDefDescription);
                            proposals.add(proposal);
                        }

                        // Also create a proposal to generate the missing step definition
                        String stepDefinitionName = StepDefinitionRefFragments.getState(theTestStep.getStepDefinitionName());
                        if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                            // Check if this step definition already exists
                            org.farhan.dsl.lang.IStepDefinition existingStepDef = stepObject.getStepDefinition(stepDefinitionName);

                            if (existingStepDef == null) {
                                // Create a new step definition for the quickfix proposal
                                org.farhan.dsl.lang.IStepObject clonedStepObject = SheepDogUtility.cloneStepObject(stepObject);
                                org.farhan.dsl.lang.IStepDefinition newStepDefinition = org.farhan.dsl.lang.SheepDogBuilder.createStepDefinition(clonedStepObject, stepDefinitionName);

                                SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                                generateProposal.setId("Generate " + stepDefinitionName);
                                generateProposal.setDescription(SheepDogUtility.getStatementListAsString(newStepDefinition.getStatementList()));
                                generateProposal.setValue(clonedStepObject.getContent());
                                proposals.add(generateProposal);

                                logger.debug("Created proposal to generate step definition: {}", stepDefinitionName);
                            }
                        }
                    } else {
                        logger.debug("Step object not found: {}", stepObjectQualifiedName);
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

        if (theTestStep != null) {
            // Get the test project to access workspace step objects
            org.farhan.dsl.lang.ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (theProject != null) {
                // Get all step objects from the workspace
                for (org.farhan.dsl.lang.IStepObject stepObject : theProject.getStepObjectList()) {
                    // Get the step object qualified name (e.g., "daily batchjob/Input file.feature")
                    String qualifiedName = stepObject.getNameLong();
                    if (qualifiedName != null && !qualifiedName.isEmpty()) {
                        // Parse the qualified name to extract component and object
                        // Remove the file extension (.feature, .asciidoc, etc.)
                        String nameWithoutExt = qualifiedName.replaceAll("\\.[^.]+$", "");

                        // Split by "/" to get component and object
                        String component = "";
                        String object = "";
                        if (nameWithoutExt.contains("/")) {
                            String[] parts = nameWithoutExt.split("/", 2);
                            component = parts[0];
                            object = parts[1];
                        } else {
                            object = nameWithoutExt;
                        }

                        if (!object.isEmpty()) {
                            // Get the step object description from statements
                            String description = SheepDogUtility.getStatementListAsString(stepObject.getStatementList());

                            // Proposal: Full component/object (if component exists)
                            if (!component.isEmpty()) {
                                addProposal(proposals, object,
                                    "The " + component + " " + object, description);
                            }
                        }
                    }
                }
            }

            // Get previous steps to extract object references
            ArrayList<ITestStep> previousSteps = SheepDogUtility.getTestStepListUpToTestStep(theTestStep);

            for (ITestStep previousStep : previousSteps) {
                String stepObjectName = previousStep.getStepObjectName();
                if (stepObjectName != null && !stepObjectName.isEmpty()) {
                    // Parse the step object name to extract component and object
                    String component = StepObjectRefFragments.getComponent(stepObjectName);
                    String object = StepObjectRefFragments.getObject(stepObjectName);

                    if (!object.isEmpty()) {
                        // Extract the base object name and type from the full stepObjectName
                        String objectName = StepObjectRefFragments.getObjectName(stepObjectName);
                        String objectType = StepObjectRefFragments.getObjectType(stepObjectName);

                        if (!objectName.isEmpty() && !objectType.isEmpty()) {
                            String baseObjectName = (objectName + " " + objectType).trim();
                            String previousStepNameLong = SheepDogUtility.getTestStepNameLong(previousStep);
                            String referenceText = "Referred in: " + previousStepNameLong;

                            // Proposal 1: Just the object name (without component)
                            addProposal(proposals, baseObjectName, "The " + baseObjectName, referenceText);

                            // Proposal 2: Full component/object (if component exists)
                            if (!component.isEmpty()) {
                                addProposal(proposals, (component + "/" + baseObjectName).trim(),
                                    "The " + component + " " + baseObjectName, referenceText);
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

        if (theTestStep != null) {
            // Get the qualified name of the step object for this test step
            String stepObjectQualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            logger.debug("Step object qualified name: {}", stepObjectQualifiedName);

            if (stepObjectQualifiedName != null && !stepObjectQualifiedName.isEmpty()) {
                // Get the test project to access workspace step objects
                org.farhan.dsl.lang.ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);

                if (theProject != null) {
                    // Find the step object with this qualified name
                    org.farhan.dsl.lang.IStepObject stepObject = theProject.getStepObject(stepObjectQualifiedName);

                    if (stepObject != null) {
                        logger.debug("Found step object: {}", stepObject.getNameLong());

                        // Get all step definitions from the step object
                        for (org.farhan.dsl.lang.IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                            String stepDefName = stepDefinition.getName();
                            String stepDefDescription = SheepDogUtility.getStatementListAsString(stepDefinition.getStatementList());

                            logger.debug("Adding step definition proposal: name={}, description={}", stepDefName, stepDefDescription);

                            // Create proposal with id=name, value=name, description=description
                            addProposal(proposals, stepDefName, stepDefName, stepDefDescription);
                        }
                    } else {
                        logger.debug("Step object not found: {}", stepObjectQualifiedName);
                    }
                }
            }
        }

        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    private static void addProposal(ArrayList<SheepDogIssueProposal> proposals, String id, String value,
            String description) {
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId(id);
        proposal.setValue(value);
        proposal.setDescription(description);
        proposals.add(proposal);
    }

}
