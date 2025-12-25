package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogFactory;
import org.farhan.dsl.lang.StatementUtility;
import org.farhan.dsl.lang.TestProjectUtility;
import org.farhan.dsl.lang.TestStepUtility;

public class TestStepIssueResolver {

	public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)
			throws Exception {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		if (!theTestStep.getStepObjectName().isEmpty()) {
			// suggest other component objects
			String component = TestStepUtility.getComponent(theTestStep.getNameLong());
			proposals.addAll(getComponentObjects(theTestStep, component));

			// or create a new one
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = SheepDogFactory.instance.createStepObject(qualifiedName);
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Generate " + theStepObject.getName() + " - " + theStepObject.getNameLong());
			proposal.setDescription(StatementUtility.getStatementListAsString(theStepObject.getStatementList()));
			proposal.setValue(theStepObject.getContent());
			proposal.setQualifiedName(theStepObject.getNameLong());
			proposals.add(proposal);
		}
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)
			throws Exception {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		String stepDefinitionName = TestStepUtility.getStepDefinitionName(theTestStep.getName());
		if (stepDefinitionName.isEmpty()) {
			// the step definition name is invalid
			for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
				proposals.add(proposal);
			}
		} else {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			IStepObject theStepObject = theProject
					.getStepObject(TestStepUtility.getStepObjectQualifiedName(theTestStep));
			if (theStepObject != null) {
				IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
				if (theStepDefinition == null) {
					// the step definition name is valid but doesn't exist
					for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
						proposals.add(proposal);
					}
					theStepDefinition = SheepDogBuilder.createStepDefinition(theStepObject, stepDefinitionName);
					SheepDogIssueProposal proposal = new SheepDogIssueProposal();
					proposal.setId("Generate " + theStepDefinition.getName());
					proposal.setDescription(
							StatementUtility.getStatementListAsString(theStepDefinition.getStatementList()));
					proposal.setValue(theStepObject.getContent());
					proposal.setQualifiedName(theStepObject.getNameLong());
					proposals.add(proposal);
				}
			}
		}
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> getComponentObjects(ITestStep theTestStep, String component) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		for (IStepObject aStepObject : TestProjectUtility.getStepObjectList(theProject, component)) {
			proposal = new SheepDogIssueProposal();
			proposal.setId(aStepObject.getNameLong().replaceFirst(component + "/", "")
					.replaceFirst(theProject.getFileExtension() + "$", ""));
			proposal.setDescription(StatementUtility.getStatementListAsString(aStepObject.getStatementList()));
			proposal.setValue("The " + component + " " + proposal.getId());
			proposals.add(proposal);
		}
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> getStepDefinitions(ITestStep theTestStep) {

		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		IStepObject stepObject = theProject.getStepObject(TestStepUtility.getStepObjectQualifiedName(theTestStep));
		if (stepObject != null) {
			for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
				proposal = new SheepDogIssueProposal();
				proposal.setId(stepDefinition.getName());
				proposal.setDescription(StatementUtility.getStatementListAsString(stepDefinition.getStatementList()));
				proposal.setValue(proposal.getId());
				proposals.add(proposal);
			}
		}
		return proposals;
	}

	private static ArrayList<ITestStep> getPreviousSteps(ITestStep theTestStep) {
		ArrayList<ITestStep> steps = new ArrayList<ITestStep>();
		ITestStepContainer testSetup = theTestStep.getParent().getParent().getTestStepContainer(0);
		if (testSetup != null && testSetup instanceof ITestSetup) {
			if (testSetup.getTestStepList() != null) {
				for (ITestStep t : testSetup.getTestStepList()) {
					steps.add(t);
				}
			}
		}

		for (ITestStep t : theTestStep.getParent().getTestStepList()) {
			if (t.equals(theTestStep)) {
				break;
			} else {
				steps.add(t);
			}
		}
		return steps;
	}

	private static Collection<SheepDogIssueProposal> getPreviousObjects(ITestStep theTestStep) {

		TreeMap<String, SheepDogIssueProposal> proposals = new TreeMap<String, SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;

		for (ITestStep step : getPreviousSteps(theTestStep)) {
			// TODO make test for this
			if (step.getName() == null) {
				continue;
			} else if (!TestStepUtility.isValid(step.getName())) {
				continue;
			}
			String[] objectParts = TestStepUtility.getObject(step.getName()).split("/");
			String name = objectParts[objectParts.length - 1];
			// This suggestion is to make referring to the last fully qualified name less
			// tedious. However it can only refer to the last object.
			proposal = new SheepDogIssueProposal();
			proposal.setId(name);
			proposal.setDescription("Referred in: " + step.getName());
			proposal.setValue("The " + proposal.getId());
			proposals.put(proposal.getId(), proposal);

			// This proposal is to list the fully qualified name of an object in case two
			// objects with the same simple name have different paths like a batch job file
			// being moved between directories
			// TODO if the value doesn't differ between the two, then don't add this
			proposal = new SheepDogIssueProposal();
			proposal.setId(TestStepUtility.getObject(step.getName()));
			proposal.setDescription("Referred in: " + step.getName());
			proposal.setValue("The " + proposal.getId());
			proposals.put(proposal.getId(), proposal);
		}
		return proposals.values();
	}

	public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)
			throws Exception {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		for (String componentName : TestProjectUtility.getComponentList(theProject)) {
			proposals.addAll(getComponentObjects(theTestStep, componentName));
		}
		for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
			proposals.add(proposal);
		}
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)
			throws Exception {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
			proposals.add(proposal);
		}
		return proposals;
	}

}
