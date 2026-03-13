package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogIssueProposal;

public class TextIssueResolver {

    public static ArrayList<SheepDogIssueProposal> suggestContentNameWorkspace(IText theText) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
        generateProposal.setId("Generate Content");
        generateProposal.setDescription("");
        proposals.add(generateProposal);
        return proposals;
    }
}
