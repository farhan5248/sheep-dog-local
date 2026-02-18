package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
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

        String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        logger.debug("stepObjectNameLong: {}", stepObjectNameLong);
        if (!stepObjectNameLong.isEmpty()) {
            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (project != null) {
                IStepObject stepObject = project.getStepObject(stepObjectNameLong);
                logger.debug("stepObject: {}", stepObject != null ? stepObject.getName() : "null");
                if (stepObject != null) {
                    String stepDefinitionName = theTestStep.getStepDefinitionName();
                    logger.debug("stepDefinitionName: {}", stepDefinitionName);
                    IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                    logger.debug("stepDefinition: {}", stepDefinition != null ? stepDefinition.getName() : "null");
                    if (stepDefinition != null) {
                        for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                            proposal.setId(stepParameters.getName());
                            proposal.setValue(stepParameters.getName());
                            proposals.add(proposal);
                            logger.debug("Added existing step parameters proposal: {}", stepParameters.getName());
                        }
                    }
                }
            }
            String rowCellsAsString = SheepDogUtility.getCellListAsString(
                    theTestStep.getTable().getRowList().getFirst().getCellList());
            logger.debug("rowCellsAsString: {}", rowCellsAsString);
            if (!rowCellsAsString.isEmpty()) {
                SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                generateProposal.setId("Generate " + rowCellsAsString);
                proposals.add(generateProposal);
                logger.debug("Added generate proposal: Generate {}", rowCellsAsString);
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

        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
