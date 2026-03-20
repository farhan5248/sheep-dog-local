package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.slf4j.Logger;

public class TestStepIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)
			throws Exception {
		logger.debug("Entry: correctStepObjectNameWorkspace({})", theTestStep);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
		if (!stepObjectFullName.isEmpty()) {
			String object = StepObjectRefFragments.getObject(theTestStep.getStepObjectName());
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Generate " + object + " - " + stepObjectFullName);
			proposal.setDescription("");
			proposals.add(proposal);
		}
		logger.debug("Exit: correctStepObjectNameWorkspace({})", proposals);
		return proposals;
	}
}
