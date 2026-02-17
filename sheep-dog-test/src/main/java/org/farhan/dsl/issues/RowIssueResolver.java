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

        if (theTestStep == null) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (qualifiedName.isEmpty()) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        IStepObject theStepObject = theProject.getStepObject(qualifiedName);
        if (theStepObject == null) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String stepDefinitionName = theTestStep.getStepDefinitionName();
        IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
        if (theStepDefinition == null) {
            logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
            String name = stepParameters.getName();
            if (name.equals("Content")) {
                continue;
            }
            String description = SheepDogUtility.getStatementListAsString(stepParameters.getStatementList());
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(name);
            proposal.setValue(name);
            proposal.setDescription(description);
            proposals.add(proposal);
        }

        logger.debug("Exiting suggestCellListWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
