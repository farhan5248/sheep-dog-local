package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class TextIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctContentWorkspace(IText theText) throws Exception {
		logger.debug("Entry: correctContentWorkspace({})", theText);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		SheepDogIssueProposal proposal = new SheepDogIssueProposal();
		proposal.setId("Generate Content");
		proposal.setDescription("");
		proposals.add(proposal);
		logger.debug("Exit: correctContentWorkspace({})", proposals);
		return proposals;
	}
}
