package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogIssueProposal;

public class TestSuiteIssueResolver {

    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestSuite theTestSuite) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String name = theTestSuite.getName();
        if (name != null && !name.isEmpty()) {
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Capitalize test suite name");
            proposal.setDescription("Capitalize the first letter of the name");
            proposal.setValue(Character.toUpperCase(name.charAt(0)) + name.substring(1));
            proposals.add(proposal);
        }
        return proposals;
    }
}
