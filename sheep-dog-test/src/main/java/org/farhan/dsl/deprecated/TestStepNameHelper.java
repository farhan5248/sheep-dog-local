package org.farhan.dsl.deprecated;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStepNameHelper {

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
	private static final String REGEX = "The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + PREDICATE_REGEX;

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

	private static String getErrorMessage() {
		return getErrorMessageComponent() + "\n\n" + getErrorMessageObject() + "\n\n" + getErrorMessageDetails()
				+ "\n\n" + getErrorMessageState() + "\n\n" + getErrorMessageTime();
	}

	public static String getErrorMessage(String text) {
		// TODO make tests for all of these documenting the message content

		if (text == null) {
			return getErrorMessage();
		}

		if (!hasObject(text)) {
			if (!hasComponent(text)) {
				return getErrorMessageComponent() + "\n\n" + getErrorMessageObject();
			} else {
				return getErrorMessageObject();
			}
		} else {
			// There can't be a predicate since it's invalid so is there at least state
			if (!hasState(text)) {
				if (!hasDetails(text)) {
					return getErrorMessageState() + "\n\n" + getErrorMessageDetails();
				} else {
					return getErrorMessageState();
				}
			} else {
				// if there's a state but it's still invalid, the only part after that is time
				// or
				// "is as" which passes for "is present" etc
				if (!hasTime(text)) {
					return getErrorMessageTime();
				} else {
					// put all the error messages because there's something weird
					return getErrorMessage();
				}
			}
		}
	}

	private static String getErrorMessageComponent() {
		return "Every test case must have at least one component specified."
				+ "\nThis should be the first part of the test step name."
				+ "\nThe component is optional, but if it is present, it must be followed by a comma."
				+ "\n\nThe component regex is: " + COMPONENT_REGEX
				+ "\nComponent ending words are: application, service, plugin, batchjob, project."
				+ "\nExamples are: \"The something application,\" or \"The something service,\"";
	}

	private static String getErrorMessageDetails() {
		return "After specifying the object, a predicate is specified."
				+ "\nIt has 3 parts, details, state and time; details is optional."
				+ "\nThis is used to specify a part in a document, like the header or body."
				+ "\n\nThe details regex is: " + DETAILS_REGEX
				+ "\nThe details ending words are: section, fragment, table, snippet, list."
				+ "\nExamples are: \"Customer details section\" or \"Order History table\"";
	}

	private static String getErrorMessageObject() {
		return "Every test step must have the object specified." + "\nThe object can have the complete path or not."
				+ "\n\nThe object regex is: " + OBJECT_REGEX
				+ "\nObject ending words are: file, page, response, dialog, directory, request, goal, job, action."
				+ "\nExamples are: \"src/test/resources/file.txt file\" or \"Home page\"";
	}

	private static String getErrorMessageState() {
		return "After specifying the object, a predicate is specified."
				+ "\nIt has 3 parts, details, state and time; state is mandatory."
				+ "\nThis part begins with words like is or isn't which get converted to setters or assertions in the test automation."
				+ "\nNext it's followed by the state attribute which is optional and can be any word."
				+ "\nThe last part is the attachment which is optional." + "\n\nThe state regex is: " + STATE_REGEX
				+ "\nThe state starting words are: is, isn't, will be, won't be."
				+ "\nExamples are: \"is present\" or \"will be created as follows\"";
	}

	private static String getErrorMessageTime() {
		return "After specifying the object, a predicate is specified."
				+ "\nIt has 3 parts, details, state and time; time is optional."
				+ "\nA test step can end with the time specified."
				+ "\nThis was useful running describing a sequence of steps like submitting an order before 5pm."
				+ "\n\nThe time regex is: " + TIME_REGEX + "\nExamples are: \"after the next day\" or \"on time\""
				+ "\nThe time endings are: early, late, on time, at, before, after, in, on.";
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

	public static boolean isValid(String text) {
		return text.matches(REGEX);
	}

	public static boolean isVertex(String text) {
		return !getGroup(text, 7).isEmpty();
	}

}
