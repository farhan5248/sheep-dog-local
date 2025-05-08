package org.farhan.dsl.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class LanguageHelper {

	public static Object[] getAlternateObjects(ILanguageAccess la) throws Exception {

		String qualifiedName = getStepObjectQualifiedName(la);
		String[] nameParts = qualifiedName.split("/");
		String objectName = TestStepNameHelper.getObject(la.getStepName());
		ArrayList<String> alternateNames = new ArrayList<String>();
		for (String alternateName : la.getFilesRecursively(nameParts[0])) {
			if (!alternateName.contentEquals(qualifiedName)
					&& alternateName.endsWith(nameParts[nameParts.length - 1])) {
				alternateName = alternateName.replaceFirst(la.getFileExtension() + "$", "");
				alternateName = alternateName.replaceFirst(nameParts[0] + "/", "");
				alternateNames.add(la.getStepName().replace(objectName, alternateName));
			}
		}
		return alternateNames.toArray();
	}

	private static Object createStepDefinition(Object stepObject, ILanguageAccess la) {
		String predicate = TestStepNameHelper.getPredicate(la.getStepName());
		Object stepDef = getStepDefinition(stepObject, predicate, la);
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

	public static void generate(ILanguageAccess la, Map<Object, Object> options) throws Exception {
		Object stepObject = la.createStepObject(getStepObjectQualifiedName(la));
		Object stepDefinition = createStepDefinition(stepObject, la);
		createStepParameters(stepDefinition, la);
		la.saveObject(stepObject, options);
	}

	private static ArrayList<Proposal> getComponentCompletions(ILanguageAccess la) {

		ArrayList<Proposal> proposals = new ArrayList<Proposal>();
		if (la.getStepName() != null) {
			if (la.getStepName().startsWith("The ")) {
				Proposal proposal;
				TreeMap<String, String> types = TestStepNameHelper.getComponentTypes();
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
				types = TestStepNameHelper.getObjectVertexTypes();
				for (String type : types.keySet()) {
					proposals.add(new Proposal(la.getStepName().replaceFirst(".*, ", "") + " " + type, types.get(type),
							la.getStepName() + " " + type));
				}
				types = TestStepNameHelper.getObjectEdgeTypes();
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
			if (!TestStepNameHelper.hasState(la.getStepName())) {
				if (!TestStepNameHelper.hasStateModality(la.getStepName())) {
					if (!TestStepNameHelper.hasDetails(la.getStepName())) {
						types = TestStepNameHelper.getDetailTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
						types = TestStepNameHelper.getStateModalityTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
					} else {
						types = TestStepNameHelper.getStateModalityTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
					}
				} else {
					if (!TestStepNameHelper.hasStateAttachment(la.getStepName())) {
						types = TestStepNameHelper.getAttachmentTypes();
						for (String type : types.keySet()) {
							proposals.add(new Proposal(type, types.get(type), la.getStepName() + " " + type));
						}
					}
					// TODO suggest state attribute from list of existing keywords in that object
				}
			} else {
				if (!TestStepNameHelper.hasStateAttachment(la.getStepName())) {
					types = TestStepNameHelper.getAttachmentTypes();
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
		String objectQualifiedName = getStepObjectQualifiedName(la);
		String component = TestStepNameHelper.getComponent(la.getStepName());
		String object = TestStepNameHelper.getObject(la.getStepName());
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
			} else if (!TestStepNameHelper.isValid(la.getStepName(step))) {
				continue;
			}
			String[] objectParts = TestStepNameHelper.getObject(la.getStepName(step)).split("/");
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
			proposal.setDisplay(TestStepNameHelper.getObject(la.getStepName(step)));
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

	private static Object getStepDefinition(Object stepObject, String predicate, ILanguageAccess la) {
		for (Object stepDef : la.getStepDefinitions(stepObject)) {
			if (la.getStepDefinitionName((Object) stepDef).contentEquals(predicate)) {
				return (Object) stepDef;
			}
		}
		return null;
	}

	public static String getStepObjectQualifiedName(ILanguageAccess la) {
		String component = TestStepNameHelper.getComponent(la.getStepName());
		String object = TestStepNameHelper.getObject(la.getStepName());

		// if there is a component and the object has a /, we're done
		if (!component.isEmpty() && object.contains("/")) {
			return component + "/" + object + la.getFileExtension();
		}
		// Create a list of previous steps in reverse order
		ArrayList<String> previousSteps = new ArrayList<String>();
		String lastComponent = "Unknown service";
		// TODO test that this checks previous steps in the test setup
		for (Object aStep : la.getPreviousSteps()) {
			previousSteps.add(0, la.getStepName(aStep));
			// keep track of the last component to assign to undeclared object components
			if (!TestStepNameHelper.getComponent(la.getStepName(aStep)).isEmpty()) {
				lastComponent = TestStepNameHelper.getComponent(la.getStepName(aStep));
			}
		}
		// search all previous steps for a more complete object path. While doing so,
		// if the component is empty, set it
		String[] objectParts = object.split("/");
		String objectKey = objectParts[objectParts.length - 1];
		for (String previousStep : previousSteps) {
			// if the step has a matching object
			String previousObject = TestStepNameHelper.getObject(previousStep);
			String previousComponent = TestStepNameHelper.getComponent(previousStep);
			if (previousObject.endsWith(objectKey)) {

				// if the object doesn't have / and the matching object does. Set it
				if (!object.contains("/") && previousObject.contains("/")) {
					object = previousObject;
				}
				// if the component is empty and the matching component isn't. Set it
				if (component.isEmpty() && !previousComponent.isEmpty()) {
					component = previousComponent;
				}
				// if we have both, we're done
				if (!component.isEmpty() && object.contains("/")) {
					break;
				}
			} else {
			}
		}
		if (component.isEmpty()) {
			return lastComponent + "/" + object + la.getFileExtension();
		} else {
			return component + "/" + object + la.getFileExtension();
		}
	}

	public static TreeMap<String, Proposal> proposeStepParameters(ILanguageAccess la) throws Exception {
		TreeMap<String, Proposal> proposals = new TreeMap<String, Proposal>();
		Proposal proposal;

		if (TestStepNameHelper.isValid(la.getStepName())) {
			String objectQualifiedName = getStepObjectQualifiedName(la);
			Object stepObject = la.getStepObject(objectQualifiedName);
			if (stepObject != null) {
				Object stepDefinition = getStepDefinition(stepObject, TestStepNameHelper.getPredicate(la.getStepName()),
						la);
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
		return proposals;
	}

	public static TreeMap<String, Proposal> proposeTestStepName(ILanguageAccess la) throws Exception {
		TreeMap<String, Proposal> proposals = new TreeMap<String, Proposal>();
		String component = "";
		String object = "";
		if (la.getStepName() != null) {
			component = TestStepNameHelper.getComponent(la.getStepName());
			object = TestStepNameHelper.getObject(la.getStepName());
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
		return proposals;
	}

	public static String validateError(ILanguageAccess la) throws Exception {

		if (!TestStepNameHelper.isValid(la.getStepName())) {
			return TestStepNameHelper.getErrorMessage(la.getStepName());
		} else {
			if (la.getAllSteps().getFirst().equals(la.getStep())) {
				if (TestStepNameHelper.getComponent(la.getStepName()).isEmpty()) {
					return "The first step must have a component";
				}
			}
		}
		return "";
	}

	public static String validateWarning(ILanguageAccess la) throws Exception {

		String stepObjectQualifiedName = getStepObjectQualifiedName(la);
		if (la.getStepObject(stepObjectQualifiedName) == null) {
			return stepObjectQualifiedName + " doesn't exist in src/test/resources/asciidoc/stepdefs/";
		}
		// check if the keyword exists
		Object stepObject = la.createStepObject(stepObjectQualifiedName);
		String predicate = TestStepNameHelper.getPredicate(la.getStepName());
		Object theStepDef = getStepDefinition(stepObject, predicate, la);
		if (theStepDef == null) {
			return predicate + " doesn't exist in " + stepObjectQualifiedName;
		}
		// check if the parameters exist
		if (la.hasParameters(theStepDef)) {
			String headersString = la.getStepParametersString();
			for (Object parameters : la.getStepDefinitionParameters(theStepDef)) {
				String paramSetString = la.getStepDefinitionParametersString((Object) parameters);
				if (headersString.contentEquals(paramSetString)) {
					return "";
				}
			}

			return headersString + " doesn't exist in " + stepObjectQualifiedName + " for " + predicate;
		}
		return "";
	}

}
