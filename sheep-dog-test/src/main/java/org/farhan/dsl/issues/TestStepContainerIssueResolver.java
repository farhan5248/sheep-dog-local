package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class TestStepContainerIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctCapitalizeNameOnly(ITestStepContainer theTestStepContainer) {
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
            proposals.add(SheepDogUtility.createProposal(
                "Capitalize test step container name",
                "Capitalize the first letter of the name",
                SheepDogUtility.capitalizeFirstLetter(testStepContainerName)
            ));
        }

        logger.debug("Exiting correctCapitalizeNameOnly with " + proposals.size() + " proposals");
        return proposals;
    }
}
