package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

public class TestStepIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameOnly(ITestStep theTestStep) throws Exception {
        logger.debug("suggestStepObjectNameOnly(theTestStep={})", theTestStep);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        ITestStepContainer parent = theTestStep.getParent();
        if (parent == null) {
            logger.debug("suggestStepObjectNameOnly() = {}", proposals);
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
        logger.debug("suggestStepObjectNameOnly() = {}", proposals);
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
}
