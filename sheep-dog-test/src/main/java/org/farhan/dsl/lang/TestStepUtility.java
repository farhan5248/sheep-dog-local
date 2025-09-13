package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepUtility {

	private static final Logger logger = LoggerFactory.getLogger(TestStepUtility.class);

	private static final String NAME_REGEX = "[^,]";
	private static final String COMPONENT_REGEX = "( " + NAME_REGEX + "+)" + getComponentRegex() + ",";
	private static final String OBJECT_REGEX = "(( " + NAME_REGEX + "+)(" + getObjectVertexRegex() + "|"
			+ getObjectEdgeRegex() + "))";
	private static final String DETAILS_REGEX = "( " + NAME_REGEX + "+)" + getDetailRegex();
	private static final String STATE_REGEX = "(" + getStateModalityRegex() + getStateAttributeRegex()
			+ getAttachmentRegex() + "?)";
	private static final String TIME_REGEX = " early| late| on time|( at| before| after| in| on)(.*)";
	private static final String PREDICATE_REGEX = "(" + "(" + DETAILS_REGEX + ")?" + STATE_REGEX + "(" + TIME_REGEX
			+ ")?" + ")";
	public static final String REGEX = "The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + PREDICATE_REGEX;

	public static String getAttachment(String text) {
		return getGroup(text, 16);
	}

	private static String getAttachmentRegex() {
		return getRegexFromTypes(getAttachmentTypes());
	}

	public static TreeMap<String, String> getAttachmentTypes() {
		TreeMap<String, String> types = new TreeMap<>();
		types.put("with", "Used to specify plugin parameters");
		types.put("as follows", "Used to specify data on a page or in a file");
		return types;
	}

	public static String getComponent(String text) {
		return getGroup("The" + "(" + COMPONENT_REGEX + ")", text, 1).replace(",", "");
	}

	public static String getComponentName(String text) {
		return getGroup(text, 2);
	}

	private static String getComponentRegex() {
		return getRegexFromTypes(getComponentTypes());
	}

	public static String getComponentType(String text) {
		return getGroup(text, 3);
	}

	public static TreeMap<String, String> getComponentTypes() {
		TreeMap<String, String> types = new TreeMap<>();
		types.put("application", "GUI web application");
		types.put("service", "RESTful or SOAP webservice");
		types.put("plugin", "Maven or Eclipse plugin");
		types.put("batchjob", "EOD or ETL batchjob");
		types.put("project", "Collection of files such as a Maven project");
		return types;
	}

	private static String getDetailRegex() {
		return getRegexFromTypes(getDetailTypes());
	}

	public static String getDetails(String text) {
		return getGroup(text, 10);
	}

	public static String getDetailsName(String text) {
		return getGroup(text, 11);
	}

	public static String getDetailsType(String text) {
		return getGroup(text, 12);
	}

	public static TreeMap<String, String> getDetailTypes() {
		TreeMap<String, String> types = new TreeMap<>();
		types.put("section", "Used to specify a part in a document");
		types.put("fragment", "Used to specify a part in some code");
		types.put("table", "Table in a document");
		types.put("snippet", "Same as fragment");
		types.put("list", "Same as table");
		return types;
	}

	public static String getGroup(String text, int group) {
		return getGroup(REGEX, text, group);
	}

	public static String getGroup(String regex, String text, int group) {
		Matcher m = Pattern.compile(regex).matcher(text);
		if (m.find()) {
			String temp = m.group(group);
			if (temp != null) {
				return temp.trim();
			} else {
				return "";
			}
		}
		return "";
	}

	public static String getObject(String text) {
		return getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX, text, 4);
	}

	private static String getObjectEdgeRegex() {
		return getRegexFromTypes(getObjectEdgeTypes());
	}

	public static TreeMap<String, String> getObjectEdgeTypes() {
		TreeMap<String, String> types = new TreeMap<>();
		types.put("request", "Web-service request");
		types.put("goal", "Maven plugin goal");
		types.put("job", "EOD or ETL batchjob");
		types.put("action", "Eclipse plugin action");
		return types;
	}

	public static String getObjectName(String text) {
		return getGroup(text, 5);
	}

	public static String getObjectType(String text) {
		return getGroup(text, 6);
	}

	private static String getObjectVertexRegex() {
		return getRegexFromTypes(getObjectVertexTypes());
	}

	public static TreeMap<String, String> getObjectVertexTypes() {
		TreeMap<String, String> types = new TreeMap<>();
		types.put("file", "Any sort of file");
		types.put("page", "Web page");
		types.put("response", "Web service response");
		types.put("dialog", "Window dialog box");
		types.put("directory", "File directory");
		return types;
	}

	public static String getPredicate(String text) {
		return getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(.*)", text, 9);
	}

	private static String getRegexFromTypes(TreeMap<String, String> types) {
		String regex = "(";
		for (String componentType : types.keySet()) {
			regex += " " + componentType + "|";
		}
		return regex.replaceAll("\\|$", ")");
	}

	public static String getState(String text) {
		return getGroup(text, 13);
	}

	private static String getStateAttributeRegex() {
		return "( \\S+)";
	}

	public static String getStateModality(String text) {
		return getGroup(text, 14);
	}

	private static String getStateModalityRegex() {
		return getRegexFromTypes(getStateModalityTypes());
	}

	public static TreeMap<String, String> getStateModalityTypes() {
		TreeMap<String, String> types = new TreeMap<>();
		types.put("is", "Maps to setter method");
		types.put("isn't", "Maps to setter method but used to remove something");
		types.put("will be", "Maps to assertion method");
		types.put("won't be", "Maps to assertion method for negative testing");
		return types;
	}

	public static String getStateType(String text) {
		return getGroup(text, 15);
	}

	public static String getTime(String text) {
		return getGroup(text, 17);
	}

	public static boolean hasComponent(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")", text, 0).isBlank();
	}

	public static boolean hasDetails(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")" + ")",
				text, 0).isBlank();
	}

	public static boolean hasObject(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX, text, 0).isBlank();
	}

	public static boolean hasPredicate(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + PREDICATE_REGEX, text, 0).isBlank();
	}

	public static boolean hasState(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")?"
				+ STATE_REGEX + ")", text, 0).isBlank();
	}

	public static boolean hasStateAttachment(String text) {
		return !getGroup(
				"The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")?" + "("
						+ getStateModalityRegex() + getStateAttributeRegex() + getAttachmentRegex() + ")" + ")",
				text, 0).isBlank();
	}

	public static boolean hasStateAttribute(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")?" + "("
				+ getStateModalityRegex() + getStateAttributeRegex() + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasStateModality(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")?" + "("
				+ getStateModalityRegex() + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasTime(String text) {
		return !getGroup(
				"The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + STATE_REGEX + "(" + TIME_REGEX + ")" + ")",
				text, 0).isBlank();
	}

	public static boolean isEdge(String text) {
		return !getGroup(text, 8).isEmpty();
	}

	public static boolean isNegativeStep(String text) {
		return getGroup(text, 14).contains("isn't") || getGroup(text, 14).contains("won't be");
	}

	public static boolean isVertex(String text) {
		return !getGroup(text, 7).isEmpty();
	}

	public static String getStepObjectQualifiedNameForTestStep(ILanguageAccess la) {
		logger.debug("Entering getStepObjectQualifiedName for step: {}", la != null ? la.getStepName() : "null");
		try {
			String component = getComponent(la.getStepName());
			String object = getObject(la.getStepName());

			// if there is a component and the object has a /, we're done
			if (!component.isEmpty() && object.contains("/")) {
				String result = component + "/" + object + la.getFileExtension();
				logger.debug("Exiting getStepObjectQualifiedName with result: {}", result);
				return result;
			}
			// Create a list of previous steps in reverse order
			ArrayList<String> previousSteps = new ArrayList<String>();
			String lastComponent = "Unknown service";
			// TODO test that this checks previous steps in the test setup
			for (Object aStep : la.getPreviousSteps()) {
				previousSteps.add(0, la.getStepName(aStep));
				// keep track of the last component to assign to undeclared object components
				if (!getComponent(la.getStepName(aStep)).isEmpty()) {
					lastComponent = getComponent(la.getStepName(aStep));
				}
			}
			// search all previous steps for a more complete object path. While doing so,
			// if the component is empty, set it
			String[] objectParts = object.split("/");
			String objectKey = objectParts[objectParts.length - 1];
			for (String previousStep : previousSteps) {
				// if the step has a matching object
				String previousObject = getObject(previousStep);
				String previousComponent = getComponent(previousStep);
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
				String result = lastComponent + "/" + object + la.getFileExtension();
				logger.debug("Exiting getStepObjectQualifiedName with result: {}", result);
				return result;
			} else {
				String result = component + "/" + object + la.getFileExtension();
				logger.debug("Exiting getStepObjectQualifiedName with result: {}", result);
				return result;
			}
		} catch (Exception e) {
			logger.error("Failed in getStepObjectQualifiedName for step '{}': {}",
					la != null ? la.getStepName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static Object getStepDefinition(Object stepObject, String predicate, ILanguageAccess la) {
		for (Object stepDef : la.getStepDefinitions(stepObject)) {
			if (la.getStepDefinitionName((Object) stepDef).contentEquals(predicate)) {
				return (Object) stepDef;
			}
		}
		return null;
	}

}
