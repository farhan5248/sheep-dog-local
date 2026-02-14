package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.slf4j.Logger;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TestStepContainerIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueResolver.class);

	/**
	 * Generates proposals correcting values when an assignment exists but is
	 * invalid.
	 *
	 * @param theTestStepContainer the element needing corrections
	 * @return list of quick fix proposals
	 */
	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestStepContainer theTestStepContainer) {
		logger.debug("Entering correctNameOnly");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

		String name = theTestStepContainer.getName();
		if (name != null && !name.isEmpty()) {
			// Capitalize first letter
			String correctedName = name.substring(0, 1).toUpperCase() + name.substring(1);

			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Capitalize test step container name");
			proposal.setDescription("Capitalize the first letter of the name");
			proposal.setValue(correctedName);
			proposals.add(proposal);
		}

		logger.debug("Exiting correctNameOnly with {} proposals", proposals.size());
		return proposals;
	}

}
