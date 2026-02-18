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
                String stepDefinitionName = theTestStep.getStepDefinitionName();
                logger.debug("stepDefinitionName: {}", stepDefinitionName);
                if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                    SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                    generateProposal.setId("Generate " + stepDefinitionName);
                    if (stepObject != null) {
                        IStepDefinition newStepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
                                stepDefinitionName);
                        generateProposal.setValue(newStepDefinition);
                    }
                    proposals.add(generateProposal);
                    logger.debug("Added generate proposal: Generate {}", stepDefinitionName);
                }
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

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject != null) {
            for (IStepObject stepObject : theProject.getStepObjectList()) {
                String nameLong = stepObject.getNameLong();
                String objectName = stepObject.getName();
                String component = nameLong.contains("/") ? nameLong.substring(0, nameLong.lastIndexOf("/")) : "";
                logger.debug("workspace stepObject component: {}, name: {}", component, objectName);
                String id = objectName;
                String value = component.isEmpty() ? "The " + objectName : "The " + component + " " + objectName;
                if (proposals.stream().noneMatch(p -> p.getId().equals(id))) {
                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                    proposal.setId(id);
                    proposal.setValue(value);
                    proposal.setDescription(SheepDogUtility.getStatementListAsString(stepObject.getStatementList()));
                    proposals.add(proposal);
                    logger.debug("Added workspace proposal: {}", id);
                }
            }
        }

        ArrayList<ITestStep> previousSteps = SheepDogUtility.getTestStepListUpToTestStep(theTestStep);
        logger.debug("previousSteps count: {}", previousSteps.size());
        for (ITestStep previousStep : previousSteps) {
            String previousStepObjectName = previousStep.getStepObjectName();
            if (previousStepObjectName == null || previousStepObjectName.isEmpty()) {
                continue;
            }
            String component = StepObjectRefFragments.getComponent(previousStepObjectName);
            String object = StepObjectRefFragments.getObject(previousStepObjectName);
            logger.debug("previousStep component: {}, object: {}", component, object);
            if (object.isEmpty()) {
                continue;
            }
            String referredIn = "Referred in: " + SheepDogUtility.getTestStepNameLong(previousStep);

            // Short form: just the object name
            String shortId = object;
            String shortValue = "The " + object;
            if (proposals.stream().noneMatch(p -> p.getId().equals(shortId))) {
                SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
                shortProposal.setId(shortId);
                shortProposal.setValue(shortValue);
                shortProposal.setDescription(referredIn);
                proposals.add(shortProposal);
                logger.debug("Added short proposal: {}", shortId);
            }

            // Long form: component/object
            if (!component.isEmpty()) {
                String longId = component + "/" + object;
                String longValue = "The " + component + " " + object;
                if (proposals.stream().noneMatch(p -> p.getId().equals(longId))) {
                    SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                    longProposal.setId(longId);
                    longProposal.setValue(longValue);
                    longProposal.setDescription(referredIn);
                    proposals.add(longProposal);
                    logger.debug("Added long proposal: {}", longId);
                }
            }
        }

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
