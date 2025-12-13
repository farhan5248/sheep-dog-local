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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueResolver {
	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctNameObjectWorkspace(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();

		try {
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = SheepDogFactory.instance.createStepObject(qualifiedName);
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId("Generate " + theStepObject.getName() + " - " + theStepObject.getQualifiedName());
			proposal.setDescription(StatementUtility.getStatementListAsString(theStepObject.getStatementList()));
			proposal.setValue(theStepObject.getContent());
			proposal.setQualifiedName(theStepObject.getQualifiedName());
			proposals.add(proposal);
		} catch (Exception e) {
			logger.error("Failed in correctNameObjectWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
		}
		proposals.addAll(suggestNameObjectWorkspace(theTestStep));
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> correctNamePredicateWorkspace(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject != null) {
				String predicate = TestStepUtility.getStepDefinitionName(theTestStep.getName());
				IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
				if (theStepDefinition == null) {
					theStepDefinition = SheepDogBuilder.createStepDefinition(theStepObject, predicate);
					SheepDogIssueProposal proposal = new SheepDogIssueProposal();
					proposal.setId("Generate " + theStepDefinition.getName());
					proposal.setDescription(
							StatementUtility.getStatementListAsString(theStepDefinition.getStatementList()));
					proposal.setValue(theStepObject.getContent());
					proposal.setQualifiedName(theStepObject.getQualifiedName());
					proposals.add(proposal);
				}
			}
		} catch (Exception e) {
			logger.error("Failed in correctNameObjectWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
		}
		proposals.addAll(suggestNamePredicateWorkspace(theTestStep));
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> getComponentObjects(ITestStep theTestStep, String component,
			ITestProject theProject) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		for (IStepObject aStepObject : TestProjectUtility.getStepObjectList(theProject, component)) {
			proposal = new SheepDogIssueProposal();
			proposal.setId(aStepObject.getQualifiedName().replaceFirst(component + "/", "")
					.replaceFirst(theProject.getFileExtension() + "$", ""));
			proposal.setDescription(StatementUtility.getStatementListAsString(aStepObject.getStatementList()));
			proposal.setValue("The " + component + " " + proposal.getId());
			proposals.add(proposal);
		}
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> getObjectPredicates(ITestStep theTestStep,
			ITestProject theProject) {

		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
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
			// TODO make test for this
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
		for (String componentName : TestProjectUtility.getComponentList(theProject)) {
			proposal = new SheepDogIssueProposal();
			proposal.setId(componentName);
			proposal.setDescription(componentName);
			proposal.setValue("The " + componentName);
			proposals.add(proposal);
		}
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> suggestNameObjectWorkspace(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		String name = theTestStep.getName() != null ? theTestStep.getName() : "";
		if (name != null) {
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
		}
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> suggestNamePredicateWorkspace(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		if (theTestStep.getName() != null) {
			if (!theTestStep.getName().matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.getObject(theTestStep.getName()).isEmpty()) {
					ITestProject theProject = theTestStep.getParent().getParent().getParent();
					for (SheepDogIssueProposal proposal : getObjectPredicates(theTestStep, theProject)) {
						proposals.add(proposal);
					}
				}
			}
		}
		return proposals;
	}

}
