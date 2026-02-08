package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ITestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TestSuiteIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TestSuiteIssueResolver.class);

	/**
	 * Generates proposals correcting values when an assignment exists but is
	 * invalid.
	 *
	 * @param theTestSuite the element needing corrections
	 * @return list of quick fix proposals
	 */
	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestSuite theTestSuite) {
		logger.debug("Entering proposeNameOnly for test suite: {}", theTestSuite != null ? theTestSuite.getName() : "null");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		proposal = new SheepDogIssueProposal();
		proposal.setId("Capitalize test suite name");
		proposal.setDescription("Capitalize the first letter of the name");
		proposal.setValue(theTestSuite.getName().substring(0, 1).toUpperCase() + theTestSuite.getName().substring(1));
		proposals.add(proposal);
		logger.debug("Exiting proposeNameOnly with {} proposals", proposals.size());
		return proposals;
	}

}
