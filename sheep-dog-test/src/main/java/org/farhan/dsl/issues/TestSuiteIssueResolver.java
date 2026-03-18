package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class TestSuiteIssueResolver {

    public static ArrayList<SheepDogIssueProposal> correctCapitalizeNameOnly(ITestSuite theTestSuite) {
        Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueResolver.class);
        logger.debug("Entering correctCapitalizeNameOnly");

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (theTestSuite == null) {
            logger.debug("Exiting correctCapitalizeNameOnly - test suite is null");
            return proposals;
        }

        String testSuiteName = theTestSuite.getName();
        if (testSuiteName == null || testSuiteName.isEmpty()) {
            logger.debug("Exiting correctCapitalizeNameOnly - test suite name is null or empty");
            return proposals;
        }

        // Check if the name starts with a lowercase letter
        if (!SheepDogUtility.startsWithCapital(testSuiteName)) {
            // Create a proposal to capitalize the first letter
            String capitalizedName = Character.toUpperCase(testSuiteName.charAt(0)) + testSuiteName.substring(1);

            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Capitalize test suite name");
            proposal.setDescription("Capitalize the first letter of the name");
            proposal.setValue(capitalizedName);
            proposals.add(proposal);
        }

        logger.debug("Exiting correctCapitalizeNameOnly with " + proposals.size() + " proposals");
        return proposals;
    }
}
