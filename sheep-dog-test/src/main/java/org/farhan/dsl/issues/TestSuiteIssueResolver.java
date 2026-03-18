package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;

import org.slf4j.Logger;

public class TestSuiteIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestSuite theTestSuite) throws Exception {
        logger.debug("correctNameOnly(theTestSuite={})", theTestSuite);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String name = theTestSuite.getName();
        if (name == null || name.isEmpty()) {
            logger.debug("correctNameOnly() = {}", proposals);
            return proposals;
        }
        String capitalized = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId("Capitalize test suite name");
        proposal.setDescription("Capitalize the first letter of the name");
        proposal.setValue(capitalized);
        proposals.add(proposal);
        logger.debug("correctNameOnly() = {}", proposals);
        return proposals;
    }
}
