package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueResolver.class);

	private static ArrayList<TestStepIssueProposal> getComponentCompletions(ILanguageAccess la) {

		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		if (la.getStepName() != null) {
			if (la.getStepName().startsWith("The ")) {
				TestStepIssueProposal proposal;
				for (TestStepComponentTypes type : TestStepComponentTypes.values()) {
					proposal = new TestStepIssueProposal(la.getStepName() + " " + type.value, type.description,
							la.getStepName() + " " + type.value + ",");
					proposals.add(proposal);
				}
			}
		}
		return proposals;
	}

	private static ArrayList<TestStepIssueProposal> getComponentObjects(ILanguageAccess la, String component)
			throws Exception {

		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		TestStepIssueProposal proposal;
		for (String fileName : la.getFilesRecursively(component)) {
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(fileName.replace(component + "/", "").replaceFirst(la.getFileExtension() + "$", ""));
			proposal.setDocumentation(la.getStepObjectDescription(fileName));
			proposal.setReplacement("The " + component + ", " + proposal.getDisplay());
			proposals.add(proposal);
		}
		return proposals;
	}

	private static ArrayList<TestStepIssueProposal> getObjectCompletion(ILanguageAccess la) {
		TreeMap<String, String> types;
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		if (la.getStepName() != null) {
			if (!la.getStepName().replaceFirst(".*,", "").isBlank()) {
				for (TestStepObjectVertexTypes type : TestStepObjectVertexTypes.values()) {
					proposals
							.add(new TestStepIssueProposal(la.getStepName().replaceFirst(".*, ", "") + " " + type.value,
									type.description, la.getStepName() + " " + type.value));
				}
				for (TestStepObjectEdgeTypes type : TestStepObjectEdgeTypes.values()) {
					proposals
							.add(new TestStepIssueProposal(la.getStepName().replaceFirst(".*, ", "") + " " + type.value,
									type.description, la.getStepName() + " " + type.value));
				}
			}
		}
		return proposals;
	}

	private static ArrayList<TestStepIssueProposal> getObjectDefinitionCompletion(ILanguageAccess la) {
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		if (la.getStepName() != null) {
			if (!TestStepUtility.hasState(la.getStepName())) {
				if (!TestStepUtility.hasStateModality(la.getStepName())) {
					if (!TestStepUtility.hasDetails(la.getStepName())) {
						for (TestStepDetailTypes type : TestStepDetailTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									la.getStepName() + " " + type.value));
						}
						for (TestStepStateModalityTypes type : TestStepStateModalityTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									la.getStepName() + " " + type.value));
						}
					} else {
						for (TestStepStateModalityTypes type : TestStepStateModalityTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									la.getStepName() + " " + type.value));
						}
					}
				} else {
					if (!TestStepUtility.hasStateAttachment(la.getStepName())) {
						for (TestStepAttachmentTypes type : TestStepAttachmentTypes.values()) {
							proposals.add(new TestStepIssueProposal(type.value, type.description,
									la.getStepName() + " " + type.value));
						}
					}
					// TODO suggest state attribute from list of existing keywords in that object
				}
			} else {
				if (!TestStepUtility.hasStateAttachment(la.getStepName())) {
					for (TestStepAttachmentTypes type : TestStepAttachmentTypes.values()) {
						proposals.add(new TestStepIssueProposal(type.value, type.description,
								la.getStepName() + " " + type.value));
					}
				}
				// TODO suggest time
			}
		}
		return proposals;
	}

	private static ArrayList<TestStepIssueProposal> getObjectDefinitions(ILanguageAccess la) throws Exception {
		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		TestStepIssueProposal proposal;
		String objectQualifiedName = TestStepUtility.getObjectQualifiedName(la);
		String component = TestStepUtility.getComponent(la.getStepName());
		String object = TestStepUtility.getObject(la.getStepName());
		if (la.getStepObject(objectQualifiedName) != null) {
			Object stepObject = la.getStepObject(objectQualifiedName);
			for (Object stepDef : la.getStepDefinitions(stepObject)) {
				proposal = new TestStepIssueProposal();
				proposal.setDisplay(la.getStepDefinitionName((Object) stepDef));
				proposal.setDocumentation(la.getStepDefinitionDescription((Object) stepDef));
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

	private static Collection<TestStepIssueProposal> getPreviousObjects(ILanguageAccess la) {

		TreeMap<String, TestStepIssueProposal> proposals = new TreeMap<String, TestStepIssueProposal>();
		TestStepIssueProposal proposal;
		ArrayList<Object> allSteps = new ArrayList<Object>();
		allSteps.addAll(la.getBackgroundSteps());
		allSteps.addAll(la.getPreviousSteps());

		for (Object step : allSteps) {
			// TODO make tests for this if statement
			if (la.getStepName(step) == null) {
				continue;
			} else if (!TestStepIssueDetector.isValid(la.getStepName(step))) {
				continue;
			}
			String[] objectParts = TestStepUtility.getObject(la.getStepName(step)).split("/");
			String name = objectParts[objectParts.length - 1];
			// This suggestion is to make referring to the last fully qualified name less
			// tedious. However it can only refer to the last object.
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(name);
			proposal.setDocumentation("Referred in: " + la.getStepName(step));
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);

			// This proposal is to list the fully qualified name of an object in case two
			// objects with the same simple name have different paths like a batch job file
			// being moved between directories
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(TestStepUtility.getObject(la.getStepName(step)));
			proposal.setDocumentation("Referred in: " + la.getStepName(step));
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);
		}
		return proposals.values();
	}

	private static ArrayList<TestStepIssueProposal> getProjectComponents(ILanguageAccess la) throws Exception {

		ArrayList<TestStepIssueProposal> proposals = new ArrayList<TestStepIssueProposal>();
		TestStepIssueProposal proposal;
		for (String fileName : la.getFiles()) {
			proposal = new TestStepIssueProposal();
			proposal.setDisplay(fileName);
			proposal.setDocumentation(fileName);
			proposal.setReplacement("The " + fileName + ",");
			proposals.add(proposal);
		}
		return proposals;
	}

	private static Object getStepDefinition(Object stepObject, String predicate, ILanguageAccess la) {
		for (Object stepDef : la.getStepDefinitions(stepObject)) {
			if (la.getStepDefinitionName((Object) stepDef).contentEquals(predicate)) {
				return (Object) stepDef;
			}
		}
		return null;
	}

	public static TreeMap<String, TestStepIssueProposal> proposeName(ILanguageAccess la) throws Exception {
		logger.debug("Entering proposeName for step: {}", la != null ? la.getStepName() : "null");
		try {
			TreeMap<String, TestStepIssueProposal> proposals = new TreeMap<String, TestStepIssueProposal>();
			String component = "";
			String object = "";
			if (la.getStepName() != null) {
				component = TestStepUtility.getComponent(la.getStepName());
				object = TestStepUtility.getObject(la.getStepName());
			}
			if (object.isEmpty()) {
				if (component.isEmpty()) {
					for (TestStepIssueProposal proposal : getProjectComponents(la)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
					for (TestStepIssueProposal proposal : getComponentCompletions(la)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				} else {
					for (TestStepIssueProposal proposal : getComponentObjects(la, component)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				}
				for (TestStepIssueProposal proposal : getPreviousObjects(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (TestStepIssueProposal proposal : getObjectCompletion(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
			} else {
				for (TestStepIssueProposal proposal : getObjectDefinitions(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (TestStepIssueProposal proposal : getObjectDefinitionCompletion(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
			}
			logger.debug("Exiting proposeName with {} proposals", proposals.size());
			return proposals;
		} catch (Exception e) {
			logger.error("Failed in proposeName for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static Object[] proposeStepObject(ILanguageAccess la) throws Exception {
		logger.debug("Entering proposeStepObject for step: {}", la != null ? la.getStepName() : "null");
		try {
			String qualifiedName = TestStepUtility.getObjectQualifiedName(la);
			String[] nameParts = qualifiedName.split("/");
			String objectName = TestStepUtility.getObject(la.getStepName());
			ArrayList<String> alternateNames = new ArrayList<String>();
			for (String alternateName : la.getFilesRecursively(nameParts[0])) {
				if (!alternateName.contentEquals(qualifiedName)
						&& alternateName.endsWith(nameParts[nameParts.length - 1])) {
					alternateName = alternateName.replaceFirst(la.getFileExtension() + "$", "");
					alternateName = alternateName.replaceFirst(nameParts[0] + "/", "");
					alternateNames.add(la.getStepName().replace(objectName, alternateName));
				}
			}
			logger.debug("Exiting proposeStepObject");
			return alternateNames.toArray();
		} catch (Exception e) {
			logger.error("Failed in proposeStepObject for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static TreeMap<String, TestStepIssueProposal> proposeStepParameters(ILanguageAccess la) throws Exception {
		logger.debug("Entering proposeStepParameters for step: {}", la != null ? la.getStepName() : "null");
		try {
			TreeMap<String, TestStepIssueProposal> proposals = new TreeMap<String, TestStepIssueProposal>();
			TestStepIssueProposal proposal;

			if (TestStepIssueDetector.isValid(la.getStepName())) {
				String objectQualifiedName = TestStepUtility.getObjectQualifiedName(la);
				Object stepObject = la.getStepObject(objectQualifiedName);
				if (stepObject != null) {
					Object stepDefinition = getStepDefinition(stepObject,
							TestStepUtility.getPredicate(la.getStepName()), la);
					if (stepDefinition != null) {
						for (Object parameters : la.getStepDefinitionParameters(stepDefinition)) {
							String paramSetString = la.getStepDefinitionParametersString((Object) parameters);
							proposal = new TestStepIssueProposal();
							proposal.setDisplay(paramSetString);
							// TODO make a test for getStepDefinitionParametersDocumentation
							proposal.setDocumentation(la.getStepDefinitionParametersDocumentation((Object) parameters));
							proposal.setReplacement(paramSetString);
							proposals.put(proposal.getReplacement(), proposal);
						}
					}
				}
			}
			logger.debug("Exiting proposeStepParameters with {} proposals", proposals.size());
			return proposals;
		} catch (Exception e) {
			logger.error("Failed in proposeStepParameters for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

}
