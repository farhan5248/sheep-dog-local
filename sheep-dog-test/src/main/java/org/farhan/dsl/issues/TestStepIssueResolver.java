package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.slf4j.Logger;

public class TestStepIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep) {
        logger.debug("Entering suggestStepObjectNameWorkspace for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (!stepObjectFullName.isEmpty()) {
            String stepFullName = SheepDogUtility.getTestStepFullName(theTestStep);
            String objectName = StepObjectRefFragments.getObject(stepFullName);
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Generate " + objectName + " - " + stepObjectFullName);
            proposal.setDescription("");
            proposals.add(proposal);
        }
        logger.debug("Exiting suggestStepObjectNameWorkspace with result: {} proposals", proposals.size());
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameTestCase(ITestStep theTestStep) {
        logger.debug("Entering suggestStepObjectNameTestCase for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        ArrayList<ITestStep> previousSteps = SheepDogUtility.getTestStepListUpToTestStep(theTestStep);
        for (ITestStep previousStep : previousSteps) {
            String stepObjectName = previousStep.getStepObjectName();
            if (stepObjectName != null && !stepObjectName.isEmpty()) {
                String componentName = StepObjectRefFragments.getComponent(stepObjectName);
                String objectName = StepObjectRefFragments.getObject(stepObjectName);
                String description = "Referred in: " + previousStep.getFullName();
                SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
                shortProposal.setId(objectName);
                shortProposal.setValue("The " + objectName);
                shortProposal.setDescription(description);
                proposals.add(shortProposal);
                if (!componentName.isEmpty()) {
                    SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                    longProposal.setId(componentName + "/" + objectName);
                    longProposal.setValue("The " + componentName + " " + objectName);
                    longProposal.setDescription(description);
                    proposals.add(longProposal);
                }
            }
        }
        ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (project != null) {
            addProposalsFromStepObjects(project, project.getFileExtension(), proposals);
        }
        logger.debug("Exiting suggestStepObjectNameTestCase with result: {} proposals", proposals.size());
        return proposals;
    }

    private static void addProposalsFromStepObjects(ITestProject project, String fileExt,
            ArrayList<SheepDogIssueProposal> proposals) {
        for (ITestDocument doc : project.getTestDocumentList()) {
            if (!(doc instanceof IStepObject)) {
                continue;
            }
            IStepObject stepObject = (IStepObject) doc;
            String fullName = stepObject.getFullName();
            String stripped = fullName.startsWith("stepdefs/") ? fullName.substring("stepdefs/".length()) : fullName;
            if (fileExt != null && stripped.endsWith(fileExt)) {
                stripped = stripped.substring(0, stripped.length() - fileExt.length());
            }
            int lastSlash = stripped.lastIndexOf('/');
            if (lastSlash < 0) {
                continue;
            }
            String componentName = stripped.substring(0, lastSlash);
            String objectName = stripped.substring(lastSlash + 1);
            String description = "";
            if (stepObject.getDescription() != null) {
                description = SheepDogUtility.getLineListAsString(stepObject.getDescription().getLineList());
            }
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(objectName);
            proposal.setValue("The " + componentName + " " + objectName);
            proposal.setDescription(description);
            proposals.add(proposal);
        }
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameTestCase(ITestStep theTestStep) {
        logger.debug("Entering suggestStepDefinitionNameTestCase for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (!stepObjectFullName.isEmpty()) {
            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (project != null) {
                ITestDocument doc = project.getTestDocument(stepObjectFullName);
                if (doc instanceof IStepObject) {
                    addStepDefinitionsFromStepObject((IStepObject) doc, true, proposals);
                }
            }
        }
        logger.debug("Exiting suggestStepDefinitionNameTestCase with result: {} proposals", proposals.size());
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep) {
        logger.debug("Entering suggestStepDefinitionNameWorkspace for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (!stepObjectFullName.isEmpty()) {
            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (project != null) {
                ITestDocument doc = project.getTestDocument(stepObjectFullName);
                if (doc instanceof IStepObject) {
                    addStepDefinitionsFromStepObject((IStepObject) doc, false, proposals);
                }
            }
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
            generateProposal.setId("Generate " + stepDefinitionName);
            generateProposal.setDescription("");
            proposals.add(generateProposal);
        }
        logger.debug("Exiting suggestStepDefinitionNameWorkspace with result: {} proposals", proposals.size());
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepParameterListTestCase(ITestStep theTestStep) {
        logger.debug("Entering suggestStepParameterListTestCase for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (!stepObjectFullName.isEmpty()) {
            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (project != null) {
                ITestDocument doc = project.getTestDocument(stepObjectFullName);
                if (doc instanceof IStepObject) {
                    IStepObject stepObject = (IStepObject) doc;
                    IStepDefinition stepDef = stepObject.getStepDefinition(theTestStep.getStepDefinitionName());
                    if (stepDef != null) {
                        for (IStepParameters stepParams : stepDef.getStepParameterList()) {
                            String name = stepParams.getName();
                            if (name != null && !name.equals("Content")) {
                                String description = "";
                                if (stepParams.getDescription() != null) {
                                    description = SheepDogUtility.getLineListAsString(stepParams.getDescription().getLineList());
                                }
                                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                                proposal.setId(name);
                                proposal.setValue(name);
                                proposal.setDescription(description);
                                proposals.add(proposal);
                            }
                        }
                    }
                }
            }
        }
        logger.debug("Exiting suggestStepParameterListTestCase with result: {} proposals", proposals.size());
        return proposals;
    }

    private static void addStepDefinitionsFromStepObject(IStepObject stepObject, boolean includeDescription,
            ArrayList<SheepDogIssueProposal> proposals) {
        for (IStepDefinition stepDef : stepObject.getStepDefinitionList()) {
            String description = "";
            if (includeDescription && stepDef.getDescription() != null) {
                description = SheepDogUtility.getLineListAsString(stepDef.getDescription().getLineList());
            }
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(stepDef.getName());
            proposal.setValue(stepDef.getName());
            proposal.setDescription(description);
            proposals.add(proposal);
        }
    }
}
