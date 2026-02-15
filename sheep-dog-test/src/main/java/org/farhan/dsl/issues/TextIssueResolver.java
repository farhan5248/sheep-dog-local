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
public class TextIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueResolver.class);

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theTestStep the element needing corrections
     * @return list of quick fix proposals
     */
    /**
     * Helper method to check if a step definition has a Content parameter.
     *
     * @param stepDefinition the step definition to check
     * @return true if Content parameter exists, false otherwise
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

    public static ArrayList<SheepDogIssueProposal> correctNameWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering correctNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        // Guard clauses - early returns to reduce nesting
        if (theTestStep == null || theTestStep.getStepObjectName() == null
                || theTestStep.getStepObjectName().isEmpty()) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (qualifiedName == null || qualifiedName.isEmpty()) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        IStepObject stepObject = theProject.getStepObject(qualifiedName);
        if (stepObject == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String stepDefName = theTestStep.getStepDefinitionName();
        if (stepDefName == null || stepDefName.isEmpty()) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefName);
        if (stepDefinition == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Check if "Content" parameter exists in step definition
        boolean contentParameterExists = hasContentParameter(stepDefinition);

        // If test step has text and step definition doesn't have Content parameter,
        // suggest "Generate Content"
        if (!contentParameterExists && theTestStep.getText() != null) {
            // Clone the existing step object and add the new parameter set
            IStepObject proposalStepObject = SheepDogUtility.cloneStepObject(stepObject);

            // Get the step definition from the cloned object
            IStepDefinition proposalStepDefinition = proposalStepObject.getStepDefinition(stepDefName);

            // Create the new step parameters with "Content"
            IStepParameters newStepParameters = SheepDogBuilder.createStepParameters(proposalStepDefinition,
                    "Content");
            ITable newTable = SheepDogBuilder.createTable(newStepParameters);
            IRow newRow = SheepDogBuilder.createRow(newTable);
            SheepDogBuilder.createCell(newRow, "Content");

            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Generate Content");
            proposal.setValue(proposalStepObject);
            proposal.setDescription("");
            proposals.add(proposal);
        }

        logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
