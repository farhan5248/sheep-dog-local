package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.farhan.dsl.grammar.IDescription;

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
