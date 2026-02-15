package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogIssueProposal;
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
     * Creates a proposal with the given id, value, and optional description.
     *
     * @param id the proposal ID
     * @param value the proposal value
     * @param description the proposal description (can be null or empty)
     * @return the created proposal
     */
    private static SheepDogIssueProposal createProposal(String id, Object value, String description) {
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId(id);
        proposal.setValue(value);
        if (description != null && !description.isEmpty()) {
            proposal.setDescription(description);
        }
        return proposal;
    }

    /**
     * Collects cell names from a row, excluding "Content" cells.
     *
     * @param row the row to extract cell names from
     * @return list of cell names (trimmed, excluding "Content")
     */
    private static ArrayList<String> collectCellNames(IRow row) {
        ArrayList<String> cellNames = new ArrayList<>();
        for (ICell cell : row.getCellList()) {
            String cellName = cell.getName();
            if (cellName != null && !cellName.isEmpty() && !"Content".equals(cellName)) {
                cellNames.add(cellName.trim());
            }
        }
        return cellNames;
    }

    /**
     * Gets the step definition for a test step by navigating the object hierarchy.
     *
     * @param theTestStep the test step to find the definition for
     * @return the step definition, or null if not found
     */
    private static IStepDefinition getStepDefinition(ITestStep theTestStep) {
        if (theTestStep == null || theTestStep.getStepObjectName() == null
                || theTestStep.getStepObjectName().isEmpty()) {
            return null;
        }

        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (qualifiedName == null || qualifiedName.isEmpty()) {
            return null;
        }

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            return null;
        }

        IStepObject stepObject = theProject.getStepObject(qualifiedName);
        if (stepObject == null) {
            return null;
        }

        String stepDefName = theTestStep.getStepDefinitionName();
        if (stepDefName == null || stepDefName.isEmpty()) {
            return null;
        }

        return stepObject.getStepDefinition(stepDefName);
    }

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
            Object value,
            String description) {
        if (!addedProposals.contains(id)) {
            SheepDogIssueProposal proposal = createProposal(id, value, description);
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
        HashSet<String> addedProposals = new HashSet<>();

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

        // Generate proposals from existing step definition parameter sets
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            ITable table = stepParameters.getTable();
            if (table != null) {
                for (IRow row : table.getRowList()) {
                    // Collect all cell names from this parameter set row
                    ArrayList<String> cellNames = collectCellNames(row);

                    // Create a single combined proposal for this parameter set
                    if (!cellNames.isEmpty()) {
                        String combinedValue = String.join(", ", cellNames);
                        addProposal(proposals, addedProposals, combinedValue, combinedValue, "");
                    }
                }
            }
        }

        // Collect new cell names from test step's table
        HashSet<String> existingCells = collectExistingCells(stepDefinition);
        HashSet<String> newCells = collectNewCells(theTestStep, existingCells);

        // Add "Generate" proposals for combined new cells
        if (!newCells.isEmpty()) {
            ArrayList<String> sortedNewCells = new ArrayList<>(newCells);
            Collections.sort(sortedNewCells);
            String combinedNewCells = String.join(", ", sortedNewCells);
            String generateId = "Generate " + combinedNewCells;

            // Clone the existing step object and add the new parameter set
            IStepObject proposalStepObject = SheepDogUtility.cloneStepObject(stepObject);

            // Get the step definition from the cloned object
            IStepDefinition proposalStepDefinition = proposalStepObject.getStepDefinition(stepDefName);

            // Create the new step parameters with the new cells
            IStepParameters newStepParameters = SheepDogBuilder.createStepParameters(proposalStepDefinition, combinedNewCells);
            ITable newTable = SheepDogBuilder.createTable(newStepParameters);
            IRow newRow = SheepDogBuilder.createRow(newTable);
            for (String cellName : sortedNewCells) {
                SheepDogBuilder.createCell(newRow, cellName);
            }

            addProposal(proposals, addedProposals, generateId, proposalStepObject, "");
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
    private static HashSet<String> collectExistingCells(IStepDefinition stepDefinition) {
        HashSet<String> existingCells = new HashSet<>();
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
    private static HashSet<String> collectNewCells(ITestStep theTestStep,
            HashSet<String> existingCells) {
        HashSet<String> newCells = new HashSet<>();
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

        // Guard clause - get step definition or return empty list
        IStepDefinition stepDefinition = getStepDefinition(theTestStep);
        if (stepDefinition == null) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Generate proposals from step definition parameters
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            ITable table = stepParameters.getTable();
            if (table != null) {
                for (IRow row : table.getRowList()) {
                    // Collect all cell names from the row, excluding "Content"
                    ArrayList<String> cellNames = collectCellNames(row);

                    // If we have cell names, create a single proposal with combined value
                    if (!cellNames.isEmpty()) {
                        String combinedValue = String.join(", ", cellNames);

                        // Get description from step parameters' statement list
                        String description = null;
                        if (stepParameters.getStatementList() != null
                                && !stepParameters.getStatementList().isEmpty()) {
                            description = stepParameters.getStatementList().get(0).getName();
                        }

                        SheepDogIssueProposal proposal = createProposal(combinedValue, combinedValue, description);
                        proposals.add(proposal);
                    }
                }
            }
        }

        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
