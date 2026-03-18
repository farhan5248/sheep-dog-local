package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class TestSuiteIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctCapitalizeNameOnly(ITestSuite theTestSuite) {
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
            proposals.add(SheepDogUtility.createProposal(
                "Capitalize test suite name",
                "Capitalize the first letter of the name",
                SheepDogUtility.capitalizeFirstLetter(testSuiteName)
            ));
        }

        logger.debug("Exiting correctCapitalizeNameOnly with " + proposals.size() + " proposals");
        return proposals;
    }
}
