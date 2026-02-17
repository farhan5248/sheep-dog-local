package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.slf4j.Logger;

public class TestStepIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering correctStepObjectNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        logger.debug("Exiting correctStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering correctStepDefinitionNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        logger.debug("Exiting correctStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering suggestStepObjectNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        String stepObjectName = theTestStep != null ? theTestStep.getStepObjectName() : null;
        if (stepObjectName != null && !stepObjectName.isEmpty()) {
            logger.debug("Exiting suggestStepObjectNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        for (SheepDogIssueProposal proposal : getWorkspaceObjects(theProject)) {
            proposals.add(proposal);
        }

        for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
            proposals.add(proposal);
        }

        logger.debug("Exiting suggestStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    private static ArrayList<SheepDogIssueProposal> getPreviousObjects(ITestStep theTestStep) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        for (ITestStep previousStep : SheepDogUtility.getTestStepListUpToTestStep(theTestStep)) {
            String stepObjectName = previousStep.getStepObjectName();
            if (stepObjectName == null || stepObjectName.isEmpty()) {
                continue;
            }
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);
            if (object.isEmpty()) {
                continue;
            }
            String referredIn = "Referred in: " + previousStep.toString();

            SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
            shortProposal.setId(object);
            shortProposal.setValue("The " + object);
            shortProposal.setDescription(referredIn);
            proposals.add(shortProposal);

            if (!component.isEmpty()) {
                SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                longProposal.setId(component + "/" + object);
                longProposal.setValue("The " + component + " " + object);
                longProposal.setDescription(referredIn);
                proposals.add(longProposal);
            }
        }
        return proposals;
    }

    private static ArrayList<SheepDogIssueProposal> getWorkspaceObjects(ITestProject theProject) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        if (theProject == null) {
            return proposals;
        }
        for (IStepObject stepObject : theProject.getStepObjectList()) {
            String nameLong = stepObject.getNameLong();
            if (nameLong == null || nameLong.isEmpty()) {
                continue;
            }
            String objectName = stepObject.getName();
            int lastSlash = nameLong.lastIndexOf('/');
            String component = lastSlash > 0 ? nameLong.substring(0, lastSlash) : "";
            String description = SheepDogUtility.getStatementListAsString(stepObject.getStatementList());

            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(objectName);
            proposal.setValue("The " + (component.isEmpty() ? "" : component + " ") + objectName);
            proposal.setDescription(description);
            proposals.add(proposal);
        }
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering suggestStepDefinitionNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        String stepObjectName = theTestStep != null ? theTestStep.getStepObjectName() : null;
        if (stepObjectName == null || stepObjectName.isEmpty()) {
            logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (qualifiedName.isEmpty()) {
            logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        IStepObject theStepObject = theProject.getStepObject(qualifiedName);
        if (theStepObject == null) {
            logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        for (IStepDefinition stepDefinition : theStepObject.getStepDefinitionList()) {
            String defName = stepDefinition.getName();
            String defDescription = SheepDogUtility.getStatementListAsString(stepDefinition.getStatementList());
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(defName);
            proposal.setValue(defName);
            proposal.setDescription(defDescription);
            proposals.add(proposal);
        }

        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
