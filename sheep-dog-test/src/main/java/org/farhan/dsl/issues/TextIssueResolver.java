package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.StatementUtility;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;

public class TextIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TextIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctNameWorkspace(ITestStep theTestStep) throws Exception {
		logger.debug("Entering correctNameWorkspace");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();

		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
		IStepObject theStepObject = theProject.getStepObject(qualifiedName);
		if (theStepObject != null) {
			String stepDefinitonName = TestStepUtility.getStepDefinitionName(theTestStep.getName());
			IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitonName);
			if (theStepDefinition != null) {
				// This assumes that the step is valid but the parameters don't exist
				IText theText = theTestStep.getText();
				IStepParameters theStepParameters = theStepDefinition.getStepParameters(theText);
				if (theStepParameters == null) {
					theStepParameters = SheepDogBuilder.createStepParameters(theStepDefinition, theText);
					SheepDogIssueProposal proposal = new SheepDogIssueProposal();
					proposal.setId("Generate | Content");
					proposal.setDescription(
							StatementUtility.getStatementListAsString(theStepParameters.getStatementList()));
					proposal.setValue(theStepObject.getContent());
					proposal.setQualifiedName(theStepObject.getNameLong());
					proposals.add(proposal);
				}
			}
		}
		logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
		return proposals;
	}

}
