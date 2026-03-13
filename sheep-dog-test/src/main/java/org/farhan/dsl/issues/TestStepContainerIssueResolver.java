package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.SheepDogIssueProposal;

public class TestStepContainerIssueResolver {

    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestStepContainer theTestStepContainer) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String name = theTestStepContainer.getName();
        if (name != null && !name.isEmpty()) {
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Capitalize test step container name");
            proposal.setDescription("Capitalize the first letter of the name");
            proposal.setValue(Character.toUpperCase(name.charAt(0)) + name.substring(1));
            proposals.add(proposal);
        }
        return proposals;
    }
}
