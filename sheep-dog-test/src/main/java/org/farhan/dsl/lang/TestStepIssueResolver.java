package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueResolver.class);

	private static ArrayList<TestStepIssueProposal> getComponentCompletions(ITestStep theTestStep) {

		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		if (theTestStep.getName() != null) {
			if (theTestStep.getName().startsWith("The ")) {
				TestStepIssueProposal proposal;
				for (TestStepComponentTypes type : TestStepComponentTypes.values()) {
					proposal = new TestStepIssueProposal(theTestStep.getName() + " " + type.value, type.description,
							theTestStep.getName() + " " + type.value + ",");
					proposals.add(proposal);
				}
			}
		}
		return proposals;
	}

	private static ArrayList<TestStepIssueProposal> getComponentObjects(ITestStep theTestStep, String component)
			throws Exception {
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		TestStepIssueProposal proposal;
		for (IStepObject fileName : theProject.getStepObjectList(component)) {
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(fileName.getQualifiedName().replace(component + "/", "")
					.replaceFirst(theProject.getFileExtension() + "$", ""));
			proposal.setDocumentation(StatementUtility.getStatementListAsString(fileName.getStatementList()));
			proposal.setReplacement("The " + component + ", " + proposal.getDisplay());
			proposals.add(proposal);
		}
		return proposals;
	}

	private static ArrayList<TestStepIssueProposal> getObjectCompletion(ITestStep theTestStep) {
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		if (theTestStep.getName() != null) {
			if (!theTestStep.getName().replaceFirst(".*,", "").isBlank()) {
				for (TestStepObjectVertexTypes type : TestStepObjectVertexTypes.values()) {
					proposals.add(
							new TestStepIssueProposal(theTestStep.getName().replaceFirst(".*, ", "") + " " + type.value,
									type.description, theTestStep.getName() + " " + type.value));
				}
				for (TestStepObjectEdgeTypes type : TestStepObjectEdgeTypes.values()) {
					proposals.add(
							new TestStepIssueProposal(theTestStep.getName().replaceFirst(".*, ", "") + " " + type.value,
									type.description, theTestStep.getName() + " " + type.value));
				}
			}
		}
		return proposals;
	}

	private static ArrayList<TestStepIssueProposal> getObjectDefinitionCompletion(ITestStep theTestStep) {
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		if (theTestStep.getName() != null) {
			if (!TestStepUtility.hasState(theTestStep.getName())) {
				if (!TestStepUtility.hasStateModality(theTestStep.getName())) {
					if (!TestStepUtility.hasDetails(theTestStep.getName())) {
						for (TestStepDetailTypes type : TestStepDetailTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
						for (TestStepStateModalityTypes type : TestStepStateModalityTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
					} else {
						for (TestStepStateModalityTypes type : TestStepStateModalityTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
					}
				} else {
					if (!TestStepUtility.hasStateAttachment(theTestStep.getName())) {
						for (TestStepAttachmentTypes type : TestStepAttachmentTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									theTestStep.getName() + " " + type.value));
						}
					}
					// TODO suggest state attribute from list of existing keywords in that object
				}
			} else {
				if (!TestStepUtility.hasStateAttachment(theTestStep.getName())) {
					for (TestStepAttachmentTypes type : TestStepAttachmentTypes.values()) {
						proposals.add(new TestStepIssueProposal(type.value, type.description,
								theTestStep.getName() + " " + type.value));
					}
				}
				// TODO suggest time
			}
		}
		return proposals;
	}

	private static Collection<TestStepIssueProposal> getPreviousObjects(ITestStep theTestStep) {

		TreeMap<String, TestStepIssueProposal> proposals = new TreeMap<String, TestStepIssueProposal>();
		TestStepIssueProposal proposal;
		ArrayList<ITestStep> allSteps = new ArrayList<ITestStep>();
		ITestSetup testSetup = theTestStep.getParent().getParent().getTestSetup();
		if (testSetup != null) {
			if (testSetup.getTestStepList() != null) {
				for (ITestStep t : testSetup.getTestStepList()) {
					allSteps.add(t);
				}
			}
		}

		allSteps.addAll(TestStepUtility.getPreviousSteps(theTestStep));

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
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(name);
			proposal.setDocumentation("Referred in: " + step.getName());
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);

			// This proposal is to list the fully qualified name of an object in case two
			// objects with the same simple name have different paths like a batch job file
			// being moved between directories
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(TestStepUtility.getObject(step.getName()));
			proposal.setDocumentation("Referred in: " + step.getName());
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);
		}
		return proposals.values();
	}

	private static ArrayList<TestStepIssueProposal> getProjectComponents(ITestStep theTestStep) throws Exception {
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		TestStepIssueProposal proposal;
		for (String componentName : theProject.getComponentList()) {
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(componentName);
			proposal.setDocumentation(componentName);
			proposal.setReplacement("The " + componentName + ",");
			proposals.add(proposal);
		}
		return proposals;
	}

	public static TreeMap<String, TestStepIssueProposal> proposeName(ITestStep theTestStep) throws Exception {
		logger.debug("Entering proposeName for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {
			TreeMap<String, TestStepIssueProposal> proposals = new TreeMap<String, TestStepIssueProposal>();
			String component = "";
			String object = "";
			if (theTestStep.getName() != null) {
				component = TestStepUtility.getComponent(theTestStep.getName());
				object = TestStepUtility.getObject(theTestStep.getName());
			}
			if (object.isEmpty()) {
				if (component.isEmpty()) {
					for (TestStepIssueProposal proposal : getProjectComponents(theTestStep)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
					for (TestStepIssueProposal proposal : getComponentCompletions(theTestStep)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				} else {
					for (TestStepIssueProposal proposal : getComponentObjects(theTestStep, component)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				}
				for (TestStepIssueProposal proposal : getPreviousObjects(theTestStep)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (TestStepIssueProposal proposal : getObjectCompletion(theTestStep)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
			} else {
				for (TestStepIssueProposal proposal : getObjectDefinitions(theTestStep)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (TestStepIssueProposal proposal : getObjectDefinitionCompletion(theTestStep)) {
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
		// TODO return TreeMap<String, TestStepIssueProposal> or
		// ArrayList<TestStepIssueProposal> for everything
		logger.debug("Entering proposeStepObject for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getObjectQualifiedName(theTestStep);
			String[] nameParts = qualifiedName.replaceFirst(theProject.getFileExtension() + "$", "").split("/");
			ArrayList<String> alternateNames = new ArrayList<String>();
			for (IStepObject aStepObject : theProject.getStepObjectList(nameParts[0])) {
				if (aStepObject.getName().contentEquals(nameParts[nameParts.length - 1])) {
					alternateNames
							.add(aStepObject.getQualifiedName().replaceFirst(theProject.getFileExtension() + "$", "")
									.replaceFirst(nameParts[0] + "/", ""));
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

	private static ArrayList<TestStepIssueProposal> getObjectDefinitions(ITestStep theTestStep) throws Exception {
		ITestProject theProject = theTestStep.getParent().getParent().getParent();
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		TestStepIssueProposal proposal;

		if (TestStepIssueDetector.isValid(theTestStep.getName())) {
			IStepObject stepObject = theProject.getStepObject(TestStepUtility.getObjectQualifiedName(theTestStep));
			if (stepObject != null) {
				IStepDefinition stepDefinition = stepObject
						.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
				if (stepDefinition != null) {
					proposal = new TestStepIssueProposal();
					proposal.setDisplay(stepDefinition.getName());
					proposal.setDocumentation(
							StatementUtility.getStatementListAsString(stepDefinition.getStatementList()));
					String component = TestStepUtility.getComponent(theTestStep.getName());
					String object = TestStepUtility.getObject(theTestStep.getName());
					if (component.isEmpty()) {
						proposal.setReplacement("The " + object + " " + proposal.getDisplay());
					} else {
						proposal.setReplacement("The " + component + ", " + object + " " + proposal.getDisplay());
					}
					proposals.add(proposal);
				}
			}
		}
		return proposals;
	}

	public static TreeMap<String, TestStepIssueProposal> proposeStepParameters(ITestStep theTestStep) throws Exception {
		logger.debug("Entering proposeStepParameters for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			TreeMap<String, TestStepIssueProposal> proposals = new TreeMap<String, TestStepIssueProposal>();
			TestStepIssueProposal proposal;

			if (TestStepIssueDetector.isValid(theTestStep.getName())) {
				IStepObject stepObject = theProject.getStepObject(TestStepUtility.getObjectQualifiedName(theTestStep));
				if (stepObject != null) {
					IStepDefinition stepDefinition = stepObject
							.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
					if (stepDefinition != null) {
						for (IStepParameters parameters : stepDefinition.getStepParameterList()) {
							proposal = new TestStepIssueProposal();
							proposal.setDisplay(parameters.toString());
							// TODO make a test for getStepDefinitionParametersDocumentation
							proposal.setDocumentation(
									StatementUtility.getStatementListAsString(parameters.getStatementList()));
							proposal.setReplacement(parameters.toString());
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
