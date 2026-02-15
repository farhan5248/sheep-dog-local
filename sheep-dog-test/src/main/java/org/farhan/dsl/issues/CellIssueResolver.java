package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.slf4j.Logger;
import org.farhan.dsl.lang.SheepDogLoggerFactory;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class CellIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueResolver.class);

	/**
	 * Generates proposals correcting values when an assignment exists but is
	 * invalid.
	 *
	 * @param theCell the element needing corrections
	 * @return list of quick fix proposals
	 */
	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ICell theCell) {
		logger.debug("Entering correctNameOnly for cell: {}", theCell != null ? theCell.getName() : "null");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		proposal = new SheepDogIssueProposal();
		proposal.setId("Capitalize cell name");
		proposal.setDescription("Capitalize the first letter of the name");
		proposal.setValue(theCell.getName().substring(0, 1).toUpperCase() + theCell.getName().substring(1));
		proposals.add(proposal);
		logger.debug("Exiting correctNameOnly with {} proposals", proposals.size());
		return proposals;
	}

}
