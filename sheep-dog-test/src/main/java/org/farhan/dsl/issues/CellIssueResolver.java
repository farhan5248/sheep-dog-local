package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class CellIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ICell theCell) throws Exception {
		logger.debug("Entry: correctNameOnly({})", theCell);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		String name = theCell.getName();
		if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Capitalize cell name");
			proposal.setDescription("Capitalize the first letter of the name");
			proposal.setValue(Character.toUpperCase(name.charAt(0)) + name.substring(1));
			proposals.add(proposal);
		}
		logger.debug("Exit: correctNameOnly({})", proposals);
		return proposals;
	}
}
