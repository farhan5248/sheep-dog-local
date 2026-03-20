package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogBuilder;
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
			IStepObject stepObject = SheepDogBuilder.createStepObject(null, stepObjectFullName);
			SheepDogBuilder.createStepDefinition(stepObject, theTestStep.getStepDefinitionName());
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Generate " + object + " - " + stepObjectFullName);
			proposal.setValue(stepObject);
			proposals.add(proposal);
		}
		logger.debug("Exit: correctStepObjectNameWorkspace({})", proposals);
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameFile(ITestStep theTestStep)
			throws Exception {
		logger.debug("Entry: suggestStepObjectNameFile({})", theTestStep);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		for (ITestStep step : SheepDogUtility.getTestStepListUpToTestStep(theTestStep)) {
			String stepObjectName = step.getStepObjectName();
			if (stepObjectName != null && !stepObjectName.isEmpty()) {
				String object = StepObjectRefFragments.getObject(stepObjectName);
				String component = StepObjectRefFragments.getComponent(stepObjectName);
				if (!object.isEmpty()) {
					SheepDogIssueProposal p1 = new SheepDogIssueProposal();
					p1.setId(object);
					p1.setValue("The " + object);
					p1.setDescription("Referred in: " + step.getFullName());
					proposals.add(p1);
					if (!component.isEmpty()) {
						SheepDogIssueProposal p2 = new SheepDogIssueProposal();
						p2.setId(component + "/" + object);
						p2.setValue(stepObjectName);
						p2.setDescription("Referred in: " + step.getFullName());
						proposals.add(p2);
					}
				}
			}
		}
		logger.debug("Exit: suggestStepObjectNameFile({})", proposals);
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)
			throws Exception {
		logger.debug("Entry: correctStepDefinitionNameWorkspace({})", theTestStep);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
		if (stepObjectFullName.isEmpty()) {
			logger.debug("Exit: correctStepDefinitionNameWorkspace({})", proposals);
			return proposals;
		}
		ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
		if (project != null) {
			ITestDocument doc = project.getTestDocument(stepObjectFullName);
			if (doc instanceof IStepObject) {
				IStepObject stepObject = (IStepObject) doc;
				for (IStepDefinition sd : stepObject.getStepDefinitionList()) {
					SheepDogIssueProposal proposal = new SheepDogIssueProposal();
					proposal.setId(sd.getName());
					proposal.setValue(sd.getName());
					proposals.add(proposal);
				}
			}
		}
		SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
		generateProposal.setId("Generate " + theTestStep.getStepDefinitionName());
		proposals.add(generateProposal);
		logger.debug("Exit: correctStepDefinitionNameWorkspace({})", proposals);
		return proposals;
	}
}
