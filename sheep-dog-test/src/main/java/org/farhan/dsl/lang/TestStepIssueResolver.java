package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueResolver {
	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueResolver.class);

	public static TreeMap<String, Proposal> proposeNameForTestStep(ILanguageAccess la) throws Exception {
		logger.debug("Entering proposeTestStepName for step: {}", la != null ? la.getStepName() : "null");
		try {
			TreeMap<String, Proposal> proposals = new TreeMap<String, Proposal>();
			String component = "";
			String object = "";
			if (la.getStepName() != null) {
				component = TestStepUtility.getComponent(la.getStepName());
				object = TestStepUtility.getObject(la.getStepName());
			}
			if (object.isEmpty()) {
				if (component.isEmpty()) {
					for (Proposal proposal : getProjectComponents(la)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
					for (Proposal proposal : getComponentCompletions(la)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				} else {
					for (Proposal proposal : getComponentObjects(la, component)) {
						proposals.put(proposal.getReplacement(), proposal);
					}
				}
				for (Proposal proposal : getPreviousObjects(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (Proposal proposal : getObjectCompletion(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
			} else {
				for (Proposal proposal : getObjectDefinitions(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
				for (Proposal proposal : getObjectDefinitionCompletion(la)) {
					proposals.put(proposal.getReplacement(), proposal);
				}
			}
			logger.debug("Exiting proposeTestStepName with {} proposals", proposals.size());
			return proposals;
		} catch (Exception e) {
			logger.error("Failed in proposeTestStepName for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static Object[] proposeStepObjectForTestStep(ILanguageAccess la) throws Exception {
		logger.debug("Entering getAlternateObjects for step: {}", la != null ? la.getStepName() : "null");
		try {
			String qualifiedName = TestStepUtility.getStepObjectQualifiedNameForTestStep(la);
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
			logger.debug("Exiting getAlternateObjects");
			return alternateNames.toArray();
		} catch (Exception e) {
			logger.error("Failed in getAlternateObjects for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static TreeMap<String, Proposal> proposeStepParametersForTestStep(ILanguageAccess la) throws Exception {
		logger.debug("Entering proposeStepParameters for step: {}", la != null ? la.getStepName() : "null");
		try {
			TreeMap<String, Proposal> proposals = new TreeMap<String, Proposal>();
			Proposal proposal;

			if (TestStepValidator.isValid(la.getStepName())) {
				String objectQualifiedName = TestStepUtility.getStepObjectQualifiedNameForTestStep(la);
				Object stepObject = la.getStepObject(objectQualifiedName);
				if (stepObject != null) {
					Object stepDefinition = TestStepUtility.getStepDefinition(stepObject,
							TestStepUtility.getPredicate(la.getStepName()), la);
					if (stepDefinition != null) {
						for (Object parameters : la.getStepDefinitionParameters(stepDefinition)) {
							String paramSetString = la.getStepDefinitionParametersString((Object) parameters);
							proposal = new Proposal();
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

	private static Object createStepDefinition(Object stepObject, ILanguageAccess la) {
		String predicate = TestStepUtility.getPredicate(la.getStepName());
		Object stepDef = TestStepUtility.getStepDefinition(stepObject, predicate, la);
		if (stepDef == null) {
			return la.createStepDefinition(stepObject, predicate);
		} else {
			return stepDef;
		}
	}

	private static void createStepParameters(Object theStepDef, ILanguageAccess la) {
		if (la.hasParameters(theStepDef)) {
			String headersString = la.getStepParametersString();
			for (Object parameters : la.getStepDefinitionParameters(theStepDef)) {
				String paramSetString = la.getStepDefinitionParametersString((Object) parameters);
				if (headersString.contentEquals(paramSetString)) {
					return;
				}
			}
			la.createStepDefinitionParameters(theStepDef);
		}
	}

	public static void generateStepDefinitionForTestStep(ILanguageAccess la, Map<Object, Object> options)
			throws Exception {
		logger.debug("Entering generate for step: {}", la != null ? la.getStepName() : "null");
		try {
			Object stepObject = la.createStepObject(TestStepUtility.getStepObjectQualifiedNameForTestStep(la));
			Object stepDefinition = createStepDefinition(stepObject, la);
			createStepParameters(stepDefinition, la);
			la.saveObject(stepObject, options);
			logger.debug("Exiting generate");
		} catch (Exception e) {
			logger.error("Failed in generate for step '{}': {}", la != null ? la.getStepName() : "null", e.getMessage(),
					e);
			throw e;
		}
	}

	private static ArrayList<Proposal> getComponentCompletions(ILanguageAccess la) {

		ArrayList<Proposal> proposals = new ArrayList<Proposal>();
		if (la.getStepName() != null) {
			if (la.getStepName().startsWith("The ")) {
				Proposal proposal;
				TreeMap<String, String> types = TestStepUtility.getComponentTypes();
				for (String type : types.keySet()) {
					proposal = new Proposal(la.getStepName() + " " + type, types.get(type),
							la.getStepName() + " " + type + ",");
					proposals.add(proposal);
				}
			}
		}
		return proposals;
	}

	private static ArrayList<Proposal> getComponentObjects(ILanguageAccess la, String component) throws Exception {

		ArrayList<Proposal> proposals = new ArrayList<Proposal>();
		Proposal proposal;
		for (String fileName : la.getFilesRecursively(component)) {
			proposal = new Proposal();
			proposal.setDisplay(fileName.replace(component + "/", "").replaceFirst(la.getFileExtension() + "$", ""));
			proposal.setDocumentation(la.getStepObjectDescription(fileName));
			proposal.setReplacement("The " + component + ", " + proposal.getDisplay());
			proposals.add(proposal);
		}
		return proposals;
	}

	private static ArrayList<Proposal> getObjectCompletion(ILanguageAccess la) {
		TreeMap<String, String> types;
		ArrayList<Proposal> proposals = new ArrayList<Proposal>();
		if (la.getStepName() != null) {
			if (!la.getStepName().replaceFirst(".*,", "").isBlank()) {
				types = TestStepUtility.getObjectVertexTypes();
				for (String type : types.keySet()) {
					proposals.add(new Proposal(la.getStepName().replaceFirst(".*, ", "") + " " + type, types.get(type),
							la.getStepName() + " " + type));
				}
				types = TestStepUtility.getObjectEdgeTypes();
				for (String type : types.keySet()) {
					proposals.add(new Proposal(la.getStepName().replaceFirst(".*, ", "") + " " + type, types.get(type),
							la.getStepName() + " " + type));
				}
			}
		}
		return proposals;
	}

	private static ArrayList<Proposal> getObjectDefinitionCompletion(ILanguageAccess la) {
		TreeMap<String, String> types;
		ArrayList<Proposal> proposals = new ArrayList<Proposal>();
		if (la.getStepName() != null) {
			if (!TestStepUtility.hasState(la.getStepName())) {
				if (!TestStepUtility.hasStateModality(la.getStepName())) {
					if (!TestStepUtility.hasDetails(la.getStepName())) {
						types = TestStepUtility.getDetailTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
						types = TestStepUtility.getStateModalityTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
					} else {
						types = TestStepUtility.getStateModalityTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
					}
				} else {
					if (!TestStepUtility.hasStateAttachment(la.getStepName())) {
						types = TestStepUtility.getAttachmentTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
					}
					// TODO suggest state attribute from list of existing keywords in that object
				}
			} else {
				if (!TestStepUtility.hasStateAttachment(la.getStepName())) {
					types = TestStepUtility.getAttachmentTypes();
					for (String type : types.keySet()) {
						proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
					}
				}
				// TODO suggest time
			}
		}
		return proposals;
	}

	private static ArrayList<Proposal> getObjectDefinitions(ILanguageAccess la) throws Exception {
		ArrayList<Proposal> proposals = new ArrayList<Proposal>();
		Proposal proposal;
		String objectQualifiedName = TestStepUtility.getStepObjectQualifiedNameForTestStep(la);
		String component = TestStepUtility.getComponent(la.getStepName());
		String object = TestStepUtility.getObject(la.getStepName());
		if (la.getStepObject(objectQualifiedName) != null) {
			Object stepObject = la.getStepObject(objectQualifiedName);
			for (Object stepDef : la.getStepDefinitions(stepObject)) {
				proposal = new Proposal();
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

	private static Collection<Proposal> getPreviousObjects(ILanguageAccess la) {

		TreeMap<String, Proposal> proposals = new TreeMap<String, Proposal>();
		Proposal proposal;
		ArrayList<Object> allSteps = new ArrayList<Object>();
		allSteps.addAll(la.getBackgroundSteps());
		allSteps.addAll(la.getPreviousSteps());

		for (Object step : allSteps) {
			// TODO make tests for this if statement
			if (la.getStepName(step) == null) {
				continue;
			} else if (!TestStepValidator.isValid(la.getStepName(step))) {
				continue;
			}
			String[] objectParts = TestStepUtility.getObject(la.getStepName(step)).split("/");
			String name = objectParts[objectParts.length - 1];
			// This suggestion is to make referring to the last fully qualified name less
			// tedious. However it can only refer to the last object.
			proposal = new Proposal();
			proposal.setDisplay(name);
			proposal.setDocumentation("Referred in: " + la.getStepName(step));
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);

			// This proposal is to list the fully qualified name of an object in case two
			// objects with the same simple name have different paths like a batch job file
			// being moved between directories
			proposal = new Proposal();
			proposal.setDisplay(TestStepUtility.getObject(la.getStepName(step)));
			proposal.setDocumentation("Referred in: " + la.getStepName(step));
			proposal.setReplacement("The " + proposal.getDisplay());
			proposals.put(proposal.getDisplay(), proposal);
		}
		return proposals.values();
	}

	private static ArrayList<Proposal> getProjectComponents(ILanguageAccess la) throws Exception {

		ArrayList<Proposal> proposals = new ArrayList<Proposal>();
		Proposal proposal;
		for (String fileName : la.getFiles()) {
			proposal = new Proposal();
			proposal.setDisplay(fileName);
			proposal.setDocumentation(fileName);
			proposal.setReplacement("The " + fileName + ",");
			proposals.add(proposal);
		}
		return proposals;
	}

}
