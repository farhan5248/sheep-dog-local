package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.SheepDogIssueProposal;

public class CellIssueResolver {

    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ICell theCell) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String name = theCell.getName();
        if (name != null && !name.isEmpty()) {
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Capitalize cell name");
            proposal.setDescription("Capitalize the first letter of the name");
            proposal.setValue(Character.toUpperCase(name.charAt(0)) + name.substring(1));
            proposals.add(proposal);
        }
        return proposals;
    }
}
