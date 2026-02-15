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
import org.farhan.dsl.lang.SheepDogUtility;
import org.slf4j.Logger;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

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
        logger.debug("Entering correctCellListWorkspace");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();

        ITestProject theProject = theTestStep.getParent().getParent().getParent();
        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        IStepObject theStepObject = theProject.getStepObject(qualifiedName);
        if (theStepObject != null) {
            theStepObject = SheepDogUtility.cloneStepObject(theStepObject);
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
            if (theStepDefinition != null) {
                // This assumes that the step is valid but the parameters don't exist
                String name = SheepDogUtility.getCellListAsString(theTestStep.getTable().getRowList().getFirst().getCellList());
                IStepParameters theStepParameters = theStepDefinition.getStepParameters(name);
                if (theStepParameters == null) {
                    theStepParameters = SheepDogBuilder.createStepParameters(theStepDefinition, name);
                    ITable table = SheepDogBuilder.createTable(theStepParameters);
                    IRow row = SheepDogBuilder.createRow(table);
                    for (ICell h : theTestStep.getTable().getRowList().getFirst().getCellList()) {
                        SheepDogBuilder.createCell(row, h.getName());
                    }
                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                    proposal.setId("Generate " + name);
                    proposal.setDescription(
                            SheepDogUtility.getStatementListAsString(theStepParameters.getStatementList()));
                    proposal.setValue(theStepObject);
                    proposals.add(proposal);
                }
            }
        }
        proposals.addAll(suggestCellListWorkspace(theTestStep));
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
        logger.debug("Entering suggestCellListWorkspace");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
        SheepDogIssueProposal proposal;

        if (TestStepIssueDetector.validateStepObjectNameOnly(theTestStep).isEmpty()
                && TestStepIssueDetector.validateStepDefinitionNameOnly(theTestStep).isEmpty()) {
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
            if (theStepObject != null) {
                IStepDefinition stepDefinition = theStepObject
                        .getStepDefinition(theTestStep.getStepDefinitionName());
                if (stepDefinition != null) {
                    for (IStepParameters parameters : stepDefinition.getStepParameterList()) {
                        proposal = new SheepDogIssueProposal();
                        proposal.setId(SheepDogUtility.getCellListAsString(parameters.getTable().getRowList().getFirst().getCellList()));
                        proposal.setDescription(
                                SheepDogUtility.getStatementListAsString(parameters.getStatementList()));
                        if (!proposal.getId().contentEquals("Content")) {
                            proposal.setValue(proposal.getId());
                            proposals.add(proposal);
                        }
                    }
                }
            }
        }
        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
