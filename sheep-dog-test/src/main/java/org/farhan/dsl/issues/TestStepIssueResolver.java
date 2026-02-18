package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
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
        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (!qualifiedName.isEmpty()) {
            IStepObject theStepObject = SheepDogBuilder.createStepObject(null, qualifiedName);
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            if (!stepDefinitionName.isEmpty()) {
                SheepDogBuilder.createStepDefinition(theStepObject, stepDefinitionName);
            }
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Generate " + theStepObject.getName() + " - " + theStepObject.getNameLong());
            proposal.setDescription(SheepDogUtility.getStatementListAsString(theStepObject.getStatementList()));
            proposal.setValue(theStepObject);
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
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (!stepDefinitionName.isEmpty()) {
            ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            IStepObject theStepObject = theProject.getStepObject(qualifiedName);
            if (theStepObject != null) {
                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                if (theStepDefinition == null) {
                    for (IStepDefinition existingStepDef : theStepObject.getStepDefinitionList()) {
                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                        proposal.setId(existingStepDef.getName());
                        proposal.setDescription(SheepDogUtility.getStatementListAsString(existingStepDef.getStatementList()));
                        proposal.setValue(existingStepDef.getName());
                        proposals.add(proposal);
                    }
                    SheepDogBuilder.createStepDefinition(theStepObject, stepDefinitionName);
                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                    proposal.setId("Generate " + stepDefinitionName);
                    proposal.setDescription(SheepDogUtility.getStatementListAsString(theStepObject.getStepDefinition(stepDefinitionName).getStatementList()));
                    proposal.setValue(theStepObject);
                    proposals.add(proposal);
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
            LinkedHashSet<String> seenIds = new LinkedHashSet<>();
            for (ITestSuite suite : theProject.getTestSuiteList()) {
                for (ITestStepContainer container : suite.getTestStepContainerList()) {
                    for (ITestStep step : container.getTestStepList()) {
                        if (step.equals(theTestStep)) {
                            continue;
                        }
                        String stepObjectName = step.getStepObjectName();
                        if (stepObjectName == null || stepObjectName.isEmpty()) {
                            continue;
                        }
                        String component = StepObjectRefFragments.getComponent(stepObjectName);
                        String object = StepObjectRefFragments.getObject(stepObjectName);
                        if (component.isEmpty() || object.isEmpty()) {
                            continue;
                        }
                        String fullStepName = stepObjectName + " " + step.getStepDefinitionName();
                        String description = "Referred in: " + fullStepName.trim();
                        String shortId = object;
                        if (!seenIds.contains(shortId)) {
                            seenIds.add(shortId);
                            SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
                            shortProposal.setId(shortId);
                            shortProposal.setValue("The " + object);
                            shortProposal.setDescription(description);
                            proposals.add(shortProposal);
                        }
                        String longId = component + "/" + object;
                        if (!seenIds.contains(longId)) {
                            seenIds.add(longId);
                            SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                            longProposal.setId(longId);
                            longProposal.setValue("The " + component + " " + object);
                            longProposal.setDescription(description);
                            proposals.add(longProposal);
                        }
                    }
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
