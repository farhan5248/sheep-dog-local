package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.List;
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
        logger.debug("Entering correctCellListWorkspace for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (!stepDefinitionName.isEmpty()) {
            ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            IStepObject theStepObject = theProject.getStepObject(qualifiedName);
            if (theStepObject != null) {
                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                if (theStepDefinition != null) {
                    List<ICell> firstRowCells = theTestStep.getTable().getRowList().getFirst().getCellList();
                    String specCellList = SheepDogUtility.getCellListAsString(firstRowCells);
                    boolean matchFound = false;
                    for (IStepParameters existingParams : theStepDefinition.getStepParameterList()) {
                        if (existingParams.getName().contentEquals(specCellList)) {
                            matchFound = true;
                            break;
                        }
                    }
                    if (!matchFound) {
                        for (IStepParameters existingParams : theStepDefinition.getStepParameterList()) {
                            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                            proposal.setId(existingParams.getName());
                            proposal.setDescription(SheepDogUtility.getStatementListAsString(existingParams.getStatementList()));
                            proposal.setValue(existingParams.getName());
                            proposals.add(proposal);
                        }
                        IStepObject clonedStepObject = SheepDogUtility.cloneStepObject(theStepObject);
                        IStepDefinition clonedStepDefinition = clonedStepObject.getStepDefinition(theStepDefinition.getName());
                        IStepParameters newStepParameters = SheepDogBuilder.createStepParameters(clonedStepDefinition, specCellList);
                        ITable newTable = SheepDogBuilder.createTable(newStepParameters);
                        IRow newRow = SheepDogBuilder.createRow(newTable);
                        for (ICell cell : firstRowCells) {
                            SheepDogBuilder.createCell(newRow, cell.getName());
                        }
                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                        proposal.setId("Generate " + specCellList);
                        proposal.setDescription("");
                        proposal.setValue(clonedStepObject);
                        proposals.add(proposal);
                    }
                }
            }
        }
        logger.debug("Exiting correctCellListWorkspace with result: {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Generates proposals suggesting values when an assignment is missing or empty.
     *
     * @param theTestStep the element needing suggestions
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering suggestCellListWorkspace for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (!stepDefinitionName.isEmpty()) {
            ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            IStepObject theStepObject = theProject.getStepObject(qualifiedName);
            if (theStepObject != null) {
                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                if (theStepDefinition != null) {
                    for (IStepParameters existingParams : theStepDefinition.getStepParameterList()) {
                        if ("Content".equals(existingParams.getName())) {
                            continue;
                        }
                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                        proposal.setId(existingParams.getName());
                        proposal.setDescription(SheepDogUtility.getStatementListAsString(existingParams.getStatementList()));
                        proposal.setValue(existingParams.getName());
                        proposals.add(proposal);
                    }
                }
            }
        }
        logger.debug("Exiting suggestCellListWorkspace with result: {} proposals", proposals.size());
        return proposals;
    }

}
