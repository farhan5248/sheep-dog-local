package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
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

        if (theTestStep != null) {
            String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            String stepDefinitionName = theTestStep.getStepDefinitionName();

            if (stepObjectNameLong != null && !stepObjectNameLong.isEmpty()
                    && stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
                if (project != null) {
                    IStepObject stepObject = project.getStepObject(stepObjectNameLong);
                    if (stepObject != null) {
                        stepObject = SheepDogUtility.cloneStepObject(stepObject);
                        IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                        if (stepDefinition != null) {
                            for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                                String cellListAsString = SheepDogUtility
                                        .getCellListAsString(stepParameters.getTable().getRowList().getFirst().getCellList());
                                if (cellListAsString != null && !cellListAsString.isEmpty()) {
                                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                                    proposal.setId(cellListAsString);
                                    proposal.setValue(cellListAsString);
                                    proposals.add(proposal);
                                    logger.debug("Added cell list proposal: {}", cellListAsString);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (theTestStep != null) {
            if (theTestStep.getTable() != null && theTestStep.getTable().getRowList() != null
                    && !theTestStep.getTable().getRowList().isEmpty()) {
                String cellListAsString = SheepDogUtility
                        .getCellListAsString(theTestStep.getTable().getRowList().getFirst().getCellList());
                if (cellListAsString != null && !cellListAsString.isEmpty()) {
                    IStepParameters newStepParameters = SheepDogBuilder.createStepParameters(null, cellListAsString);
                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                    proposal.setId("Generate " + cellListAsString);
                    proposal.setValue(newStepParameters);
                    proposal.setDescription("");
                    proposals.add(proposal);
                    logger.debug("Added generate cell list proposal: Generate {}", cellListAsString);
                }
            }
        }

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
        logger.debug("Entering suggestCellListWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (theTestStep != null) {
            String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            logger.debug("Looking for step object: {} with definition: {}", stepObjectNameLong, stepDefinitionName);

            if (stepObjectNameLong != null && !stepObjectNameLong.isEmpty()
                    && stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
                if (project != null) {
                    for (IStepObject stepObject : project.getStepObjectList()) {
                        if (stepObjectNameLong.equals(stepObject.getNameLong())) {
                            IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                            if (stepDefinition != null) {
                                for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                                    String name = stepParameters.getName();
                                    if (name != null && !name.isEmpty() && !name.equals("Content")) {
                                        String description = SheepDogUtility
                                                .getStatementListAsString(stepParameters.getStatementList());
                                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                                        proposal.setId(name);
                                        proposal.setValue(name);
                                        proposal.setDescription(description);
                                        proposals.add(proposal);
                                        logger.debug("Added parameter proposal: {}", name);
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
