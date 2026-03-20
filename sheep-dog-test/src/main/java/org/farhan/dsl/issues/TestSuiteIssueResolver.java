package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class TestSuiteIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestSuiteIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestSuite theTestSuite) throws Exception {
		logger.debug("Entry: correctNameOnly({})", theTestSuite);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		String name = theTestSuite.getName();
		if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Capitalize test suite name");
			proposal.setDescription("Capitalize the first letter of the name");
			proposal.setValue(Character.toUpperCase(name.charAt(0)) + name.substring(1));
			proposals.add(proposal);
		}
		logger.debug("Exit: correctNameOnly({})", proposals);
		return proposals;
	}
}
