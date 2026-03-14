package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class TextIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> suggestContentWorkspace(IText theText) {
        logger.debug("Entering suggestContentWorkspace for theText: {}", theText != null ? "non-null" : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
        generateProposal.setId("Generate Content");
        generateProposal.setDescription("");
        proposals.add(generateProposal);
        logger.debug("Exiting suggestContentWorkspace with result: {} proposals", proposals.size());
        return proposals;
    }
}
