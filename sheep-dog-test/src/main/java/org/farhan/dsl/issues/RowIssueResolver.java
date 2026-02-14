package org.farhan.dsl.issues;

import java.util.ArrayList;

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
            java.util.HashSet<String> addedProposals,
            String id,
            String value,
            String description) {
        if (!addedProposals.contains(id)) {
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(id);
            proposal.setValue(value);
            if (description != null && !description.isEmpty()) {
                proposal.setDescription(description);
            }
            proposals.add(proposal);
            addedProposals.add(id);
        }
    }

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
        java.util.HashSet<String> addedProposals = new java.util.HashSet<>();

        // Guard clauses - early returns to reduce nesting
        if (theTestStep == null || theTestStep.getStepObjectName() == null
                || theTestStep.getStepObjectName().isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (qualifiedName == null || qualifiedName.isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        IStepObject stepObject = theProject.getStepObject(qualifiedName);
        if (stepObject == null) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String stepDefName = theTestStep.getStepDefinitionName();
        if (stepDefName == null || stepDefName.isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefName);
        if (stepDefinition == null) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Collect existing cell names from step definition parameters
        java.util.HashSet<String> existingCells = collectExistingCells(stepDefinition);

        // Collect new cell names from test step's table
        java.util.HashSet<String> newCells = collectNewCells(theTestStep, existingCells);

        // Add proposals for existing cells
        for (String cellName : existingCells) {
            addProposal(proposals, addedProposals, cellName, cellName, "");
        }

        // Add proposals for new cells
        for (String cellName : newCells) {
            addProposal(proposals, addedProposals, cellName, cellName, "");
        }

        // Add "Generate" proposals for new cells
        for (String cellName : newCells) {
            String generateId = "Generate " + cellName;
            addProposal(proposals, addedProposals, generateId, generateId, "");
        }

        logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Collects existing cell names from step definition parameters.
     *
     * @param stepDefinition the step definition to extract cells from
     * @return set of existing cell names
     */
    private static java.util.HashSet<String> collectExistingCells(IStepDefinition stepDefinition) {
        java.util.HashSet<String> existingCells = new java.util.HashSet<>();
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            ITable table = stepParameters.getTable();
            if (table != null) {
                for (IRow row : table.getRowList()) {
                    for (ICell cell : row.getCellList()) {
                        String cellName = cell.getName();
                        if (cellName != null && !cellName.isEmpty()
                                && !"Content".equals(cellName)) {
                            existingCells.add(cellName.trim());
                        }
                    }
                }
            }
        }
        return existingCells;
    }

    /**
     * Collects new cell names from test step's table that don't exist in step definition.
     *
     * @param theTestStep the test step to extract cells from
     * @param existingCells set of existing cell names to filter against
     * @return set of new cell names
     */
    private static java.util.HashSet<String> collectNewCells(ITestStep theTestStep,
            java.util.HashSet<String> existingCells) {
        java.util.HashSet<String> newCells = new java.util.HashSet<>();
        if (theTestStep.getTable() != null) {
            for (IRow row : theTestStep.getTable().getRowList()) {
                for (ICell cell : row.getCellList()) {
                    String cellName = cell.getName();
                    if (cellName != null && !cellName.isEmpty()
                            && !existingCells.contains(cellName.trim())) {
                        newCells.add(cellName.trim());
                    }
                }
            }
        }
        return newCells;
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
                        // Get the step definition name from the test step
                        String stepDefName = theTestStep.getStepDefinitionName();

                        if (stepDefName != null && !stepDefName.isEmpty()) {
                            // Find the step definition
                            IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefName);

                            if (stepDefinition != null) {
                                // Get all step parameters from the step definition
                                for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                                    ITable table = stepParameters.getTable();
                                    if (table != null) {
                                        // Get all rows from the table
                                        for (IRow row : table.getRowList()) {
                                            // Collect all cell names from the row, excluding "Content"
                                            ArrayList<String> cellNames = new ArrayList<>();
                                            for (ICell cell : row.getCellList()) {
                                                String cellName = cell.getName();
                                                if (cellName != null && !cellName.isEmpty()) {
                                                    // Skip "Content" parameters as they are for text blocks, not table rows
                                                    if (!"Content".equals(cellName)) {
                                                        cellNames.add(cellName.trim());
                                                    }
                                                }
                                            }

                                            // If we have cell names, create a single proposal with combined value
                                            if (!cellNames.isEmpty()) {
                                                String combinedValue = String.join(", ", cellNames);
                                                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                                                proposal.setId(combinedValue);
                                                proposal.setValue(combinedValue);

                                                // Set the description from step parameters' statement list
                                                if (stepParameters.getStatementList() != null
                                                        && !stepParameters.getStatementList().isEmpty()) {
                                                    String description = stepParameters.getStatementList().get(0).getName();
                                                    if (description != null && !description.isEmpty()) {
                                                        proposal.setDescription(description);
                                                    }
                                                }

                                                proposals.add(proposal);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
