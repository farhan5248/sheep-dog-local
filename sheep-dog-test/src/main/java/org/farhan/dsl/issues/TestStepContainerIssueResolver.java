package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestStepContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepContainerIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TestStepContainerIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> proposeNameOnly(ITestStepContainer theTestStepContainer) {
		// TODO shouldn't this take a TestStepContainer as a parameter
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
