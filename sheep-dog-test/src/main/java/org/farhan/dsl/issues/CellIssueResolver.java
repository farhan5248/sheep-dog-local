package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ICell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CellIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(CellIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> proposeNameOnly(ICell theCell) {
		// TODO shouldn't this take a Cell as a parameter
		logger.debug("Entering proposeNameOnly for cell: {}", theCell != null ? theCell.getName() : "null");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		proposal = new SheepDogIssueProposal();
		proposal.setId("Capitalize cell name");
		proposal.setDescription("Capitalize the first letter of the name");
		proposal.setValue(theCell.getName().substring(0, 1).toUpperCase() + theCell.getName().substring(1));
		proposals.add(proposal);
		logger.debug("Exiting proposeNameOnly with {} proposals", proposals.size());
		return proposals;
	}

}
