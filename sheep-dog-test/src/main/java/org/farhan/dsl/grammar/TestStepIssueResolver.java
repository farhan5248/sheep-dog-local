package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

public class TestStepIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("suggestStepObjectNameWorkspace(theTestStep={})", theTestStep);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        ITestStepContainer parent = theTestStep.getParent();
        if (parent == null) {
            logger.debug("suggestStepObjectNameWorkspace() = {}", proposals);
            return proposals;
        }
        if (!(parent instanceof ITestSetup) && parent.getParent() != null) {
            ITestSuite suite = parent.getParent();
            for (ITestStepContainer container : suite.getTestStepContainerList()) {
                if (container instanceof ITestSetup) {
                    addProposalsFromSteps(container.getTestStepList(), proposals);
                }
            }
        }
        addProposalsFromSteps(SheepDogUtility.getTestStepListUpToTestStep(theTestStep), proposals);
        addProposalsFromStepDefs(SheepDogUtility.getTestProjectParentForTestStep(theTestStep), proposals);
        logger.debug("suggestStepObjectNameWorkspace() = {}", proposals);
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("suggestCellListWorkspace(theTestStep={})", theTestStep);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepObjectName = theTestStep.getStepObjectName();
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (stepObjectName == null || stepObjectName.isEmpty() || stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            logger.debug("suggestCellListWorkspace() = {}", proposals);
            return proposals;
        }
        ITestProject workspace = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (workspace == null) {
            logger.debug("suggestCellListWorkspace() = {}", proposals);
            return proposals;
        }
        String component = StepObjectRefFragments.getComponent(stepObjectName);
        String objectName = StepObjectRefFragments.getObject(stepObjectName);
        for (ITestDocument doc : workspace.getTestDocumentList()) {
            if (!(doc instanceof IStepObject)) continue;
            IStepObject stepObject = (IStepObject) doc;
            if (!stepObject.getName().equals(objectName)) continue;
            String fullName = stepObject.getFullName();
            String[] parts = fullName.split("/");
            if (parts.length < 3) continue;
            String docComponent = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
            if (!component.isEmpty() && !docComponent.equals(component)) continue;
            IStepDefinition stepDef = stepObject.getStepDefinition(stepDefinitionName);
            if (stepDef == null) continue;
            for (IStepParameters stepParams : stepDef.getStepParameterList()) {
                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                proposal.setValue(stepParams.getName());
                proposal.setId(stepParams.getName());
                String descContent = "";
                IDescription desc = stepParams.getDescription();
                if (desc != null && !desc.getLineList().isEmpty()) {
                    descContent = desc.getLine(0).getName();
                }
                proposal.setDescription(descContent);
                proposals.add(proposal);
            }
        }
        logger.debug("suggestCellListWorkspace() = {}", proposals);
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("suggestStepDefinitionNameWorkspace(theTestStep={})", theTestStep);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String fullName = theTestStep.getFullName();
        if (fullName == null || fullName.isEmpty()) {
            logger.debug("suggestStepDefinitionNameWorkspace() = {}", proposals);
            return proposals;
        }
        String component = StepObjectRefFragments.getComponent(fullName);
        String objectName = StepObjectRefFragments.getObject(fullName);
        if (objectName.isEmpty()) {
            logger.debug("suggestStepDefinitionNameWorkspace() = {}", proposals);
            return proposals;
        }
        ITestProject workspace = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (workspace == null) {
            logger.debug("suggestStepDefinitionNameWorkspace() = {}", proposals);
            return proposals;
        }
        for (ITestDocument doc : workspace.getTestDocumentList()) {
            if (!(doc instanceof IStepObject)) continue;
            IStepObject stepObject = (IStepObject) doc;
            if (!stepObject.getName().equals(objectName)) continue;
            String stepObjectFullName = stepObject.getFullName();
            String[] parts = stepObjectFullName.split("/");
            if (parts.length < 3) continue;
            String docComponent = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
            if (!component.isEmpty() && !docComponent.equals(component)) continue;
            for (IStepDefinition stepDef : stepObject.getStepDefinitionList()) {
                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                proposal.setValue(stepDef.getName());
                proposal.setId(stepDef.getName());
                String descContent = "";
                IDescription desc = stepDef.getDescription();
                if (desc != null && !desc.getLineList().isEmpty()) {
                    descContent = desc.getLine(0).getName();
                }
                proposal.setDescription(descContent);
                proposals.add(proposal);
            }
        }
        logger.debug("suggestStepDefinitionNameWorkspace() = {}", proposals);
        return proposals;
    }

    private static void addProposalsFromSteps(List<ITestStep> steps, ArrayList<SheepDogIssueProposal> proposals) {
        for (ITestStep step : steps) {
            String stepObjectName = step.getStepObjectName();
            if (stepObjectName == null || stepObjectName.isEmpty()) continue;
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);
            String description = "Referred in: " + step.getFullName();
            SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
            shortProposal.setValue("The " + object);
            shortProposal.setId(object);
            shortProposal.setDescription(description);
            proposals.add(shortProposal);
            if (!component.isEmpty()) {
                SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                longProposal.setValue(stepObjectName);
                longProposal.setId(component + "/" + object);
                longProposal.setDescription(description);
                proposals.add(longProposal);
            }
        }
    }

    private static void addProposalsFromStepDefs(ITestProject workspace,
            ArrayList<SheepDogIssueProposal> proposals) {
        if (workspace == null) return;
        Set<String> components = new HashSet<>();
        for (SheepDogIssueProposal p : proposals) {
            String id = p.getId();
            if (id != null && id.contains("/")) {
                components.add(id.substring(0, id.lastIndexOf("/")));
            }
        }
        for (ITestDocument doc : workspace.getTestDocumentList()) {
            if (!(doc instanceof IStepObject)) continue;
            IStepObject stepObject = (IStepObject) doc;
            String fullName = stepObject.getFullName();
            String[] parts = fullName.split("/");
            if (parts.length < 3) continue;
            String component = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
            if (!components.isEmpty() && !components.contains(component)) continue;
            String objectName = stepObject.getName();
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setValue("The " + component + " " + objectName);
            proposal.setId(objectName);
            if (components.isEmpty()) {
                String descContent = "";
                IDescription desc = stepObject.getDescription();
                if (desc != null && !desc.getLineList().isEmpty()) {
                    descContent = desc.getLine(0).getName();
                }
                proposal.setDescription(descContent);
            } else {
                proposal.setDescription("Referred in: " + fullName);
            }
            proposals.add(proposal);
        }
    }
}
