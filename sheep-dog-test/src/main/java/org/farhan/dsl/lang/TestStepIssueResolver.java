package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueResolver {

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
			ITestProject theProject) throws Exception {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		for (IStepObject fileName : theProject.getStepObjectList(component)) {
			proposal = new SheepDogIssueProposal();
			proposal.setDisplay(fileName.getQualifiedName().replace(component + "/", "")
					.replaceFirst(theProject.getFileExtension() + "$", ""));
			proposal.setDocumentation(StatementUtility.getStatementListAsString(fileName.getStatementList()));
			proposal.setReplacement("The " + component + ", " + proposal.getDisplay());
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
		ITestSetup testSetup = theTestStep.getParent().getParent().getTestSetup();
		if (testSetup != null) {
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
			proposal.setDisplay(name);
			proposal.setDocumentation("Referred in: " + step.getName());
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);

			// This proposal is to list the fully qualified name of an object in case two
			// objects with the same simple name have different paths like a batch job file
			// being moved between directories
			proposal = new SheepDogIssueProposal();
			proposal.setDisplay(TestStepUtility.getObject(step.getName()));
			proposal.setDocumentation("Referred in: " + step.getName());
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);
		}
		return proposals.values();
	}

	private static ArrayList<SheepDogIssueProposal> getProjectComponents(ITestStep theTestStep, ITestProject theProject)
			throws Exception {
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;
		for (String componentName : theProject.getComponentList()) {
			proposal = new SheepDogIssueProposal();
			proposal.setDisplay(componentName);
			proposal.setDocumentation(componentName);
			proposal.setReplacement("The " + componentName + ",");
			proposals.add(proposal);
		}
		return proposals;
	}

	public static TreeMap<String, SheepDogIssueProposal> proposeName(ITestStep theTestStep, ITestProject theProject)
			throws Exception {
		logger.debug("Entering proposeName for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		// TODO this is doing invalid step quickfixes and incomplete step name proposals
		try {
			TreeMap<String, SheepDogIssueProposal> proposals = new TreeMap<String, SheepDogIssueProposal>();
			String component = "";
			String object = "";
			if (theTestStep.getName() != null) {
				component = TestStepUtility.getComponent(theTestStep.getName());
				object = TestStepUtility.getObject(theTestStep.getName());
			}
			if (object.isEmpty()) {
				if (component.isEmpty()) {
					for (SheepDogIssueProposal proposal : getProjectComponents(theTestStep, theProject)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
					for (SheepDogIssueProposal proposal : getComponentCompletions(theTestStep)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				} else {
					for (SheepDogIssueProposal proposal : getComponentObjects(theTestStep, component, theProject)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				}
				for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (SheepDogIssueProposal proposal : getObjectCompletion(theTestStep)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
			} else {
				for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep, theProject)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (SheepDogIssueProposal proposal : getStepDefinitionCompletion(theTestStep)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
			}
			logger.debug("Exiting proposeName with {} proposals", proposals.size());
			return proposals;
		} catch (Exception e) {
			logger.error("Failed in proposeName for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static Object[] proposeStepObject(ITestStep theTestStep) throws Exception {
		// this method is used to suggest alternates in case a step object is specified
		// but doesn't exist. the proposeName methods suggests alternates in case a step
		// object isn't
		// specified after breaking up name into component, object, predicate etc, only
		// this
		// method will be used.

		// TODO return TreeMap<String, TestStepIssueProposal> or
		// ArrayList<TestStepIssueProposal> for everything
		logger.debug("Entering proposeStepObject for step: {}", theTestStep != null ? theTestStep.getName() : "null");

		// TODO split into two
		// 1 if object specified and syntax is valid then suggest generation or similar
		// objects
		// 2 if object not specified then suggest from all previous objects etc.
		// Implement this after breaking up name into component, object, predicate
		try {
			String stepNameLong = TestStepUtility.getNameLong(theTestStep);
			String component = TestStepUtility.getComponent(stepNameLong);
			String object = TestStepUtility.getObject(stepNameLong);
			String objectName = TestStepUtility.getObjectName(stepNameLong);
			String objectType = TestStepUtility.getObjectType(stepNameLong);
			ArrayList<String> alternateNames = new ArrayList<String>();
			for (IStepObject aStepObject : theTestStep.getParent().getParent().getParent()
					.getStepObjectList(component)) {
				if (aStepObject.getName().contentEquals(objectName + " " + objectType)) {
					String testStepName = theTestStep.getName();
					String alternateName = aStepObject.getQualifiedName().replaceFirst(component + "/", "")
							.replaceFirst(theTestStep.getParent().getParent().getParent().getFileExtension() + "$", "");
					alternateNames.add(testStepName.replace(object, alternateName));
				}
			}
			logger.debug("Exiting proposeStepObject");
			return alternateNames.toArray();
		} catch (Exception e) {
			logger.error("Failed in proposeStepObject for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	private static ArrayList<SheepDogIssueProposal> getStepDefinitions(ITestStep theTestStep, ITestProject theProject)
			throws Exception {

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
				proposal.setDisplay(stepDefinition.getName());
				proposal.setDocumentation(StatementUtility.getStatementListAsString(stepDefinition.getStatementList()));
				if (component.isEmpty()) {
					proposal.setReplacement("The " + object + " " + proposal.getDisplay());
				} else {
					proposal.setReplacement("The " + component + ", " + object + " " + proposal.getDisplay());
				}
				proposals.add(proposal);
			}
		}
		return proposals;
	}

	private static String cellsToString(List<String> cells) {
		// TODO this should be a csv list, think about it from the perspective of the
		// test case, \| is ugly
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (String cell : cells) {
			sortedCells.add(cell);
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}

	public static TreeMap<String, SheepDogIssueProposal> proposeStepParameters(ITestStep theTestStep,
			ITestProject theProject) throws Exception {
		logger.debug("Entering proposeStepParameters for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			TreeMap<String, SheepDogIssueProposal> proposals = new TreeMap<String, SheepDogIssueProposal>();
			SheepDogIssueProposal proposal;

			if (TestStepIssueDetector.isValid(theTestStep.getName())) {

				String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
				IStepObject theStepObject = theProject.getStepObject(qualifiedName);
				if (theStepObject != null) {
					IStepDefinition stepDefinition = theStepObject
							.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
					if (stepDefinition != null) {
						for (IStepParameters parameters : stepDefinition.getStepParameterList()) {
							proposal = new SheepDogIssueProposal();
							proposal.setDisplay(cellsToString(parameters.getTable().getFirst()));
							// TODO make a test for getStepDefinitionParametersDocumentation
							proposal.setDocumentation(
									StatementUtility.getStatementListAsString(parameters.getStatementList()));
							proposal.setReplacement(cellsToString(parameters.getTable().getFirst()));
							proposals.put(proposal.getReplacement(), proposal);
						}
					}
				}
			}
			logger.debug("Exiting proposeStepParameters with {} proposals", proposals.size());
			return proposals;
		} catch (Exception e) {
			logger.error("Failed in proposeStepParameters for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
