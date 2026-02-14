package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TestStepContainerIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TestStepContainerIssueResolver.class);

	/**
	 * Generates proposals correcting values when an assignment exists but is
	 * invalid.
	 *
	 * @param theTestStepContainer the element needing corrections
	 * @return list of quick fix proposals
	 */
	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestStepContainer theTestStepContainer) {
		logger.debug("Entering proposeNameOnly for test step container: {}", theTestStepContainer != null ? theTestStepContainer.getName() : "null");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		proposal = new SheepDogIssueProposal();
		proposal.setId("Capitalize test step container name");
		proposal.setDescription("Capitalize the first letter of the name");
		proposal.setValue(theTestStepContainer.getName().substring(0, 1).toUpperCase() + theTestStepContainer.getName().substring(1));
		proposals.add(proposal);
		logger.debug("Exiting proposeNameOnly with {} proposals", proposals.size());
		return proposals;
	}

}
