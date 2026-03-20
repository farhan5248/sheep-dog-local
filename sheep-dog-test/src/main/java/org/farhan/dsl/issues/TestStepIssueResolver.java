package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
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

	public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)
			throws Exception {
		logger.debug("Entry: suggestStepObjectNameWorkspace({})", theTestStep);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
		if (project == null) {
			logger.debug("Exit: suggestStepObjectNameWorkspace({})", proposals);
			return proposals;
		}
		for (IStepObject stepObject : SheepDogUtility.getStepObjectList(project)) {
			String stripped = stepObject.getFullName().replaceFirst("^stepdefs/", "").replaceAll("\\.asciidoc$", "");
			String[] parts = stripped.split("/");
			String objectName = parts[parts.length - 1];
			String value = parts.length > 1
					? "The " + stripped.substring(0, stripped.lastIndexOf("/")) + " " + objectName
					: "The " + objectName;
			String description = (stepObject.getDescription() != null)
					? SheepDogUtility.getLineListAsString(stepObject.getDescription().getLineList())
					: "";
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId(objectName);
			proposal.setValue(value);
			proposal.setDescription(description);
			proposals.add(proposal);
		}
		logger.debug("Exit: suggestStepObjectNameWorkspace({})", proposals);
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

	public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)
			throws Exception {
		logger.debug("Entry: suggestStepDefinitionNameWorkspace({})", theTestStep);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
		if (stepObjectFullName.isEmpty()) {
			logger.debug("Exit: suggestStepDefinitionNameWorkspace({})", proposals);
			return proposals;
		}
		ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
		if (project == null) {
			logger.debug("Exit: suggestStepDefinitionNameWorkspace({})", proposals);
			return proposals;
		}
		ITestDocument doc = project.getTestDocument(stepObjectFullName);
		if (!(doc instanceof IStepObject)) {
			logger.debug("Exit: suggestStepDefinitionNameWorkspace({})", proposals);
			return proposals;
		}
		IStepObject stepObject = (IStepObject) doc;
		for (IStepDefinition sd : stepObject.getStepDefinitionList()) {
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId(sd.getName());
			proposal.setValue(sd.getName());
			String description = (sd.getDescription() != null)
					? SheepDogUtility.getLineListAsString(sd.getDescription().getLineList())
					: "";
			proposal.setDescription(description);
			proposals.add(proposal);
		}
		logger.debug("Exit: suggestStepDefinitionNameWorkspace({})", proposals);
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> suggestStepParameterListWorkspace(ITestStep theTestStep)
			throws Exception {
		logger.debug("Entry: suggestStepParameterListWorkspace({})", theTestStep);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
		if (stepObjectFullName.isEmpty()) {
			logger.debug("Exit: suggestStepParameterListWorkspace({})", proposals);
			return proposals;
		}
		ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
		if (project == null) {
			logger.debug("Exit: suggestStepParameterListWorkspace({})", proposals);
			return proposals;
		}
		ITestDocument doc = project.getTestDocument(stepObjectFullName);
		if (!(doc instanceof IStepObject)) {
			logger.debug("Exit: suggestStepParameterListWorkspace({})", proposals);
			return proposals;
		}
		IStepObject stepObject = (IStepObject) doc;
		String stepDefName = theTestStep.getStepDefinitionName();
		if (stepDefName == null || stepDefName.isEmpty()) {
			logger.debug("Exit: suggestStepParameterListWorkspace({})", proposals);
			return proposals;
		}
		IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefName);
		if (stepDefinition == null) {
			logger.debug("Exit: suggestStepParameterListWorkspace({})", proposals);
			return proposals;
		}
		for (IStepParameters sp : stepDefinition.getStepParameterList()) {
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId(sp.getName());
			proposal.setValue(sp.getName());
			String description = (sp.getDescription() != null)
					? SheepDogUtility.getLineListAsString(sp.getDescription().getLineList())
					: "";
			proposal.setDescription(description);
			proposals.add(proposal);
		}
		logger.debug("Exit: suggestStepParameterListWorkspace({})", theTestStep);
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
