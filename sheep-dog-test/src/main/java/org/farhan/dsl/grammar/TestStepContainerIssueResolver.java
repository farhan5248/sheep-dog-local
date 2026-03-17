package org.farhan.dsl.grammar;

import java.util.ArrayList;

import org.slf4j.Logger;

public class TestStepContainerIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestStepContainer theTestStepContainer)
            throws Exception {
        logger.debug("correctNameOnly(theTestStepContainer={})", theTestStepContainer);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String name = theTestStepContainer.getName();
        if (name == null || name.isEmpty()) {
            logger.debug("correctNameOnly() = {}", proposals);
            return proposals;
        }
        String capitalized = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId("Capitalize test step container name");
        proposal.setDescription("Capitalize the first letter of the name");
        proposal.setValue(capitalized);
        proposals.add(proposal);
        logger.debug("correctNameOnly() = {}", proposals);
        return proposals;
    }
}
