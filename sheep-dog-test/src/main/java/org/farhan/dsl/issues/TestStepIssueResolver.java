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
import org.farhan.dsl.lang.StatementUtility;
import org.farhan.dsl.lang.TestStepUtility;

public class TestStepIssueResolver {

	private static ArrayList<SheepDogIssueProposal> getComponentObjects(ITestStep theTestStep, String component,
			ITestProject theProject) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		for (IStepObject aStepObject : theProject.getStepObjectList(component)) {
			proposal = new SheepDogIssueProposal();
			proposal.setId(aStepObject.getQualifiedName().replaceFirst(component + "/", "")
					.replaceFirst(theProject.getFileExtension() + "$", ""));
			proposal.setDescription(StatementUtility.getStatementListAsString(aStepObject.getStatementList()));
			proposal.setValue("The " + component + ", " + proposal.getId());
			proposals.add(proposal);
		}
		return proposals;
	}

	private static Collection<SheepDogIssueProposal> getPreviousObjects(ITestStep theTestStep) {

		TreeMap<String, SheepDogIssueProposal> proposals = new TreeMap<String, SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		ArrayList<ITestStep> allSteps = new ArrayList<ITestStep>();
		ITestStepContainer testSetup = theTestStep.getParent().getParent().getTestStepContainer(0);
		if (testSetup != null && testSetup instanceof ITestSetup) {
			if (testSetup.getTestStepList() != null) {
				for (ITestStep t : testSetup.getTestStepList()) {
					allSteps.add(t);
				}
			}
		}

		allSteps.addAll(TestStepUtility.getPreviousSteps(theTestStep, false));

		for (ITestStep step : allSteps) {
			// TODO make tests for this if statement
			if (step.getName() == null) {
				continue;
			} else if (!step.getName().matches(TestStepUtility.REGEX)) {
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
			proposal = new SheepDogIssueProposal();
			proposal.setId(TestStepUtility.getObject(step.getName()));
			proposal.setDescription("Referred in: " + step.getName());
			proposal.setValue("The " + proposal.getId());
			proposals.put(proposal.getId(), proposal);
		}
		return proposals.values();
	}

	private static ArrayList<SheepDogIssueProposal> getProjectComponents(ITestStep theTestStep,
			ITestProject theProject) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		for (String componentName : theProject.getComponentList()) {
			proposal = new SheepDogIssueProposal();
			proposal.setId(componentName);
			proposal.setDescription(componentName);
			proposal.setValue("The " + componentName + ",");
			proposals.add(proposal);
		}
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> getStepDefinitions(ITestStep theTestStep, ITestProject theProject) {

		// TODO make public and rename to proposeStepDefinitions after splitting name
		// into component, object, predicate
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		String stepName = theTestStep.getName();
		String component = TestStepUtility.getComponent(stepName);
		String object = TestStepUtility.getObject(stepName);
		IStepObject stepObject = theProject.getStepObject(TestStepUtility.getStepObjectQualifiedName(theTestStep));
		if (stepObject != null) {
			for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
				proposal = new SheepDogIssueProposal();
				proposal.setId(stepDefinition.getName());
				proposal.setDescription(StatementUtility.getStatementListAsString(stepDefinition.getStatementList()));
				if (component.isEmpty()) {
					proposal.setValue("The " + object + " " + proposal.getId());
				} else {
					proposal.setValue("The " + component + ", " + object + " " + proposal.getId());
				}
				proposals.add(proposal);
			}
		}
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> proposeNameObjectInvalid(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		String component = "";
		String object = "";
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		if (theTestStep.getName() != null) {
			component = TestStepUtility.getComponent(theTestStep.getName());
			object = TestStepUtility.getObject(theTestStep.getName());
		}
		if (object.isEmpty()) {
			if (component.isEmpty()) {
				for (SheepDogIssueProposal proposal : getProjectComponents(theTestStep, theProject)) {
					proposals.add(proposal);
				}
			} else {
				for (SheepDogIssueProposal proposal : getComponentObjects(theTestStep, component, theProject)) {
					proposals.add(proposal);
				}
			}
			for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
				proposals.add(proposal);
			}
		}
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> proposeNamePredicateWorkspace(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		if (theTestStep.getName() != null) {
			if (!theTestStep.getName().matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.getObject(theTestStep.getName()).isEmpty()) {
					ITestProject theProject = theTestStep.getParent().getParent().getParent();
					for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep, theProject)) {
						proposals.add(proposal);
					}
				}
			}
		}
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> proposeNameObjectWorkspace(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		// TODO review whether the interface methods should return null vs empty strings
		String name = theTestStep.getName() != null ? theTestStep.getName() : "";
		if (name != null) {
			if (name.matches(TestStepUtility.REGEX)) {
				proposals.addAll(proposeNameObjectValid(theTestStep));
			} else {
				proposals.addAll(proposeNameObjectInvalid(theTestStep));
			}
		}
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> proposeNameObjectValid(ITestStep theTestStep) {

		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		// TODO check if the step name is valid first
		String stepNameLong = TestStepUtility.getNameLong(theTestStep);
		String component = TestStepUtility.getComponent(stepNameLong);
		String object = TestStepUtility.getObject(stepNameLong);
		String objectName = TestStepUtility.getObjectName(stepNameLong);
		String objectType = TestStepUtility.getObjectType(stepNameLong);
		String extension = theTestStep.getParent().getParent().getParent().getFileExtension();
		for (IStepObject aStepObject : theTestStep.getParent().getParent().getParent().getStepObjectList(component)) {
			if (aStepObject.getName().contentEquals(objectName + " " + objectType)) {
				String alternateName = aStepObject.getQualifiedName().replaceFirst(component + "/", "")
						.replaceFirst(extension + "$", "");
				proposal = new SheepDogIssueProposal();
				proposal.setId(aStepObject.getQualifiedName().replaceFirst(component + "/", "")
						.replaceFirst(extension + "$", ""));
				proposal.setDescription("Rename the object to an existing one");
				proposal.setValue(theTestStep.getName().replace(object, alternateName));
				proposals.add(proposal);
			}
		}
		return proposals;
	}

}
