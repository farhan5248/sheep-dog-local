package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ITestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSuiteIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TestSuiteIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> proposeNameOnly(ITestSuite theTestSuite) {
		// TODO shouldn't this take a TestSuite as a parameter
		logger.debug("Entering proposeNameOnly for test suite: {}", theTestSuite != null ? theTestSuite.getName() : "null");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		proposal = new SheepDogIssueProposal();
		proposal.setId("Capitalize test step container name");
		proposal.setDescription("Capitalize the first letter of the name");
		proposal.setValue(theTestSuite.getName().substring(0, 1).toUpperCase() + theTestSuite.getName().substring(1));
		proposals.add(proposal);
		logger.debug("Exiting proposeNameOnly with {} proposals", proposals.size());
		return proposals;
	}

}
