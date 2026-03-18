package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class TestStepContainerIssueResolver {

    public static ArrayList<SheepDogIssueProposal> correctCapitalizeNameOnly(ITestStepContainer theTestStepContainer) {
        Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueResolver.class);
        logger.debug("Entering correctCapitalizeNameOnly");

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (theTestStepContainer == null) {
            logger.debug("Exiting correctCapitalizeNameOnly - test step container is null");
            return proposals;
        }

        String testStepContainerName = theTestStepContainer.getName();
        if (testStepContainerName == null || testStepContainerName.isEmpty()) {
            logger.debug("Exiting correctCapitalizeNameOnly - test step container name is null or empty");
            return proposals;
        }

        // Check if the name starts with a lowercase letter
        if (!SheepDogUtility.startsWithCapital(testStepContainerName)) {
            // Create a proposal to capitalize the first letter
            String capitalizedName = Character.toUpperCase(testStepContainerName.charAt(0)) + testStepContainerName.substring(1);

            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Capitalize test step container name");
            proposal.setDescription("Capitalize the first letter of the name");
            proposal.setValue(capitalizedName);
            proposals.add(proposal);
        }

        logger.debug("Exiting correctCapitalizeNameOnly with " + proposals.size() + " proposals");
        return proposals;
    }
}
