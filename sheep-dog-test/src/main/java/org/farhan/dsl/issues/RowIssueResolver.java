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

        if (theTestStep == null || theTestStep.getTable() == null) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Get the cell list from the test step's table (first row is the header)
        String testStepCellList = getCellListAsString(theTestStep);
        logger.debug("Test step cell list: {}", testStepCellList);

        if (testStepCellList.isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Get the qualified name of the step object for this test step
        String stepObjectQualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        logger.debug("Step object qualified name: {}", stepObjectQualifiedName);

        if (stepObjectQualifiedName == null || stepObjectQualifiedName.isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Get the test project to access workspace step objects
        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Find the step object with this qualified name
        IStepObject stepObject = theProject.getStepObject(stepObjectQualifiedName);
        if (stepObject == null) {
            logger.debug("Step object not found: {}", stepObjectQualifiedName);
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }
        logger.debug("Found step object: {}", stepObject.getNameLong());

        // Get the step definition name from the test step
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        logger.debug("Looking for step definition: {}", stepDefinitionName);

        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Find the step definition in the step object
        IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
        if (stepDefinition == null) {
            logger.debug("Step definition not found: {}", stepDefinitionName);
            logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }
        logger.debug("Found step definition: {}", stepDefinition.getName());

        // Get all step parameters from the step definition
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            String parametersName = stepParameters.getName();

            // Skip Content parameters - they are for text blocks, not table rows
            if ("Content".equals(parametersName)) {
                logger.debug("Skipping Content parameter as it's for text blocks, not table rows");
                continue;
            }

            // Only add existing parameters that don't match the test step's cell list
            if (!parametersName.equals(testStepCellList)) {
                String parametersDescription = SheepDogUtility.getStatementListAsString(stepParameters.getStatementList());

                logger.debug("Adding existing step parameters proposal: name={}, description={}", parametersName, parametersDescription);

                // Create proposal with id=name, value=name, description=description
                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                proposal.setId(parametersName);
                proposal.setValue(parametersName);
                proposal.setDescription(parametersDescription);
                proposals.add(proposal);
            }
        }

        // Check if this parameter set already exists
        IStepParameters existingStepParameters = stepDefinition.getStepParameters(testStepCellList);
        if (existingStepParameters == null) {
            // Create a proposal to generate the missing parameter set
            IStepObject clonedStepObject = SheepDogUtility.cloneStepObject(stepObject);
            IStepDefinition clonedStepDefinition = clonedStepObject.getStepDefinition(stepDefinitionName);

            if (clonedStepDefinition != null) {
                IStepParameters stepParameters = SheepDogBuilder.createStepParameters(clonedStepDefinition, testStepCellList);
                ITable table = SheepDogBuilder.createTable(stepParameters);
                IRow row = SheepDogBuilder.createRow(table);
                for (String cellName : testStepCellList.split(", ")) {
                    SheepDogBuilder.createCell(row, cellName.trim());
                }

                SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                generateProposal.setId("Generate " + testStepCellList);
                generateProposal.setDescription(SheepDogUtility.getStatementListAsString(clonedStepDefinition.getStatementList()));
                generateProposal.setValue(clonedStepObject);
                proposals.add(generateProposal);

                logger.debug("Created proposal to generate step parameters: {}", testStepCellList);
            }
        }

        logger.debug("Exiting correctCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Helper method to get cell list as a comma-separated string from the first row of the table.
     */
    private static String getCellListAsString(ITestStep theTestStep) {
        if (theTestStep == null || theTestStep.getTable() == null) {
            return "";
        }

        ITable table = theTestStep.getTable();
        if (table.getRowList().isEmpty()) {
            return "";
        }

        // Get the first row (header row)
        IRow row = table.getRow(0);
        StringBuilder cellList = new StringBuilder();

        for (ICell cell : row.getCellList()) {
            if (cellList.length() > 0) {
                cellList.append(", ");
            }
            cellList.append(cell.getName());
        }

        return cellList.toString();
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

        if (theTestStep == null) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Get the qualified name of the step object for this test step
        String stepObjectQualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        logger.debug("Step object qualified name: {}", stepObjectQualifiedName);

        if (stepObjectQualifiedName == null || stepObjectQualifiedName.isEmpty()) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Get the test project to access workspace step objects
        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Find the step object with this qualified name
        IStepObject stepObject = theProject.getStepObject(stepObjectQualifiedName);
        if (stepObject == null) {
            logger.debug("Step object not found: {}", stepObjectQualifiedName);
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }
        logger.debug("Found step object: {}", stepObject.getNameLong());

        // Get the step definition name from the test step
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        logger.debug("Looking for step definition: {}", stepDefinitionName);

        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Find the step definition in the step object
        IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
        if (stepDefinition == null) {
            logger.debug("Step definition not found: {}", stepDefinitionName);
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }
        logger.debug("Found step definition: {}", stepDefinition.getName());

        // Get all step parameters from the step definition
        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
            String parametersName = stepParameters.getName();

            // Skip Content parameters - they are for text blocks, not table rows
            if ("Content".equals(parametersName)) {
                logger.debug("Skipping Content parameter as it's for text blocks, not table rows");
                continue;
            }

            String parametersDescription = SheepDogUtility.getStatementListAsString(stepParameters.getStatementList());

            logger.debug("Adding step parameters proposal: name={}, description={}", parametersName, parametersDescription);

            // Create proposal with id=name, value=name, description=description
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(parametersName);
            proposal.setValue(parametersName);
            proposal.setDescription(parametersDescription);
            proposals.add(proposal);
        }

        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
