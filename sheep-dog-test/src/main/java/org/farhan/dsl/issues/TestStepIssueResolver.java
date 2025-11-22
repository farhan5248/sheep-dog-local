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
import org.farhan.dsl.types.TestStepAttachmentTypes;
import org.farhan.dsl.types.TestStepComponentTypes;
import org.farhan.dsl.types.TestStepDetailTypes;
import org.farhan.dsl.types.TestStepObjectEdgeTypes;
import org.farhan.dsl.types.TestStepObjectVertexTypes;
import org.farhan.dsl.types.TestStepStateModalityTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueResolver {

	// TODO for each propose method here, there's two use cases
	// 1. empty token which needs a list of possibilities proposed
	// 2. non-empty token with issues that can be resolved, testStepObjectWorkspace
	// For some issues, there's no resolution such as invalid object type. The error
	// message can list valid types
	// 3. non-empty token with issues that can't be resolved, testStepObjectOnly

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueResolver.class);

	private static ArrayList<SheepDogIssueProposal> getComponentCompletions(ITestStep theTestStep) {

		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		if (theTestStep.getName() != null) {
			if (theTestStep.getName().startsWith("The ")) {
				SheepDogIssueProposal proposal;
				for (TestStepComponentTypes type : TestStepComponentTypes.values()) {
					proposal = new SheepDogIssueProposal(theTestStep.getName() + " " + type.value, type.description,
							theTestStep.getName() + " " + type.value + ",");
					proposals.add(proposal);
				}
			}
		}
		return proposals;
	}

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

	private static ArrayList<SheepDogIssueProposal> getObjectCompletion(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		if (theTestStep.getName() != null) {
			if (!theTestStep.getName().replaceFirst(".*,", "").isBlank()) {
				for (TestStepObjectVertexTypes type : TestStepObjectVertexTypes.values()) {
					proposals.add(
							new SheepDogIssueProposal(theTestStep.getName().replaceFirst(".*, ", "") + " " + type.value,
									type.description, theTestStep.getName() + " " + type.value));
				}
				for (TestStepObjectEdgeTypes type : TestStepObjectEdgeTypes.values()) {
					proposals.add(
							new SheepDogIssueProposal(theTestStep.getName().replaceFirst(".*, ", "") + " " + type.value,
									type.description, theTestStep.getName() + " " + type.value));
				}
			}
		}
		return proposals;
	}

	private static ArrayList<SheepDogIssueProposal> getStepDefinitionCompletion(ITestStep theTestStep) {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		if (theTestStep.getName() != null) {
			if (!TestStepUtility.hasState(theTestStep.getName())) {
				if (!TestStepUtility.hasStateModality(theTestStep.getName())) {
					if (!TestStepUtility.hasDetails(theTestStep.getName())) {
						for (TestStepDetailTypes type : TestStepDetailTypes.values()) {
							proposals.add(new SheepDogIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
						for (TestStepStateModalityTypes type : TestStepStateModalityTypes.values()) {
							proposals.add(new SheepDogIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
					} else {
						for (TestStepStateModalityTypes type : TestStepStateModalityTypes.values()) {
							proposals.add(new SheepDogIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
					}
				} else {
					if (!TestStepUtility.hasStateAttachment(theTestStep.getName())) {
						for (TestStepAttachmentTypes type : TestStepAttachmentTypes.values()) {
							proposals.add(new SheepDogIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
					}
					// TODO suggest state attribute from list of existing keywords in that object
				}
			} else {
				if (!TestStepUtility.hasStateAttachment(theTestStep.getName())) {
					for (TestStepAttachmentTypes type : TestStepAttachmentTypes.values()) {
						proposals.add(new SheepDogIssueProposal(type.value, type.description,
								theTestStep.getName() + " " + type.value));
					}
				}
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
			// TODO make tests for this if statement
			if (step.getName() == null) {
				continue;
			} else if (!TestStepIssueDetector.isValid(step.getName())) {
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

	public static ArrayList<SheepDogIssueProposal> proposeNameOnly(ITestStep theTestStep) {
		// TODO move out logic from here and delete metho
		// Completions need to be moved into the issue detector. The error message
		// should list all the completions with examples
		// getComponents/Objects should be merged into proposeNameWorkspace. If the
		// syntax is correct but the object doesn't exist, either generate it or suggest
		// alternatives
		logger.debug("Entering proposeNameOnly for step: {}", theTestStep != null ? theTestStep.getName() : "null");
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
				for (SheepDogIssueProposal proposal : getComponentCompletions(theTestStep)) {
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
			for (SheepDogIssueProposal proposal : getObjectCompletion(theTestStep)) {
				proposals.add(proposal);
			}
		} else {
			for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep, theProject)) {
				proposals.add(proposal);
			}
			for (SheepDogIssueProposal proposal : getStepDefinitionCompletion(theTestStep)) {
				proposals.add(proposal);
			}
		}
		logger.debug("Exiting proposeNameOnly with {} proposals", proposals.size());
		return proposals;
	}

	public static ArrayList<SheepDogIssueProposal> proposeNameWorkspace(ITestStep theTestStep) {
		logger.debug("Entering proposeNameWorkspace for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");

		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
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
		logger.debug("Exiting proposeNameWorkspace");
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

}
