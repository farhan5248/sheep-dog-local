package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.StatementUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TextIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctNameWorkspace(ITestStep theTestStep) {
		logger.debug("Entering correctNameWorkspace");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		try {
			IStepParameters theStepParameters = SheepDogBuilder.buildStepParameters(theTestStep);
			IStepObject theStepObject = theStepParameters.getParent().getParent();
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Generate | Content");
			proposal.setDescription(StatementUtility.getStatementListAsString(theStepParameters.getStatementList()));
			proposal.setValue(theStepObject.toString());
			proposal.setQualifiedName(theStepObject.getQualifiedName());
			proposals.add(proposal);
		} catch (Exception e) {
			logger.error("Failed in correctCellListWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
		}
		logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
		return proposals;
	}

}
