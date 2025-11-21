package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ICell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CellIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(CellIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> proposeName(ICell theCell) {
		// TODO shouldn't this take a Cell as a parameter
		logger.debug("Entering proposeName for cell: {}", theCell != null ? theCell.getName() : "null");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();

		logger.debug("Exiting proposeName with {} proposals", proposals.size());
		return proposals;
	}

}
