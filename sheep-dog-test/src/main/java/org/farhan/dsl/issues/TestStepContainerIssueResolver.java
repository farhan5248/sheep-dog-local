package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.slf4j.Logger;

public class TestStepContainerIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepContainerIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestStepContainer theTestStepContainer)
			throws Exception {
		logger.debug("Entry: correctNameOnly({})", theTestStepContainer);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		String name = theTestStepContainer.getName();
		if (name != null && !name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Capitalize test step container name");
			proposal.setDescription("Capitalize the first letter of the name");
			proposal.setValue(Character.toUpperCase(name.charAt(0)) + name.substring(1));
			proposals.add(proposal);
		}
		logger.debug("Exit: correctNameOnly({})", proposals);
		return proposals;
	}
}
