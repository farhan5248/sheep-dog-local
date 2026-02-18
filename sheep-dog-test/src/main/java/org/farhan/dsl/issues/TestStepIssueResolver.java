package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
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

        String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        logger.debug("stepObjectNameLong: {}", stepObjectNameLong);
        if (!stepObjectNameLong.isEmpty()) {
            String object = StepObjectRefFragments.getObject(theTestStep.getStepObjectName());
            logger.debug("object: {}", object);
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Generate " + object + " - " + stepObjectNameLong);
            IStepObject stepObject = SheepDogBuilder.createStepObject(null, stepObjectNameLong);
            proposal.setValue(stepObject);
            proposals.add(proposal);
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

        String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        logger.debug("stepObjectNameLong: {}", stepObjectNameLong);
        if (!stepObjectNameLong.isEmpty()) {
            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (project != null) {
                IStepObject stepObject = project.getStepObject(stepObjectNameLong);
                logger.debug("stepObject: {}", stepObject != null ? stepObject.getName() : "null");
                if (stepObject != null) {
                    for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                        proposal.setId(stepDefinition.getName());
                        proposal.setValue(stepDefinition.getName());
                        proposals.add(proposal);
                        logger.debug("Added existing step definition proposal: {}", stepDefinition.getName());
                    }
                }
            }
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            logger.debug("stepDefinitionName: {}", stepDefinitionName);
            if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                generateProposal.setId("Generate " + stepDefinitionName);
                proposals.add(generateProposal);
                logger.debug("Added generate proposal: Generate {}", stepDefinitionName);
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

        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
