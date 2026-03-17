package org.farhan.dsl.grammar;

import java.util.ArrayList;

import org.slf4j.Logger;

public class TextIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctStepParameterListWorkspace(IText text) throws Exception {
        logger.debug("correctStepParameterListWorkspace(text={})", text);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        ITestStep testStep = text.getParent();
        if (testStep == null) {
            logger.debug("correctStepParameterListWorkspace() = {}", proposals);
            return proposals;
        }
        String stepDefinitionName = testStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            logger.debug("correctStepParameterListWorkspace() = {}", proposals);
            return proposals;
        }
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId("Generate Content");
        proposal.setDescription("");
        proposal.setValue("Content");
        proposals.add(proposal);
        logger.debug("correctStepParameterListWorkspace() = {}", proposals);
        return proposals;
    }
}
