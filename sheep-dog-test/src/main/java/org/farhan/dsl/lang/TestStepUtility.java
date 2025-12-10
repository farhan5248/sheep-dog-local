package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.farhan.dsl.types.TestStepAttachmentTypes;
import org.farhan.dsl.types.TestStepComponentTypes;
import org.farhan.dsl.types.TestStepDetailTypes;
import org.farhan.dsl.types.TestStepObjectEdgeTypes;
import org.farhan.dsl.types.TestStepObjectVertexTypes;
import org.farhan.dsl.types.TestStepStateModalityTypes;
import org.farhan.dsl.types.TestStepTimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepUtility {

	private static final Logger logger = LoggerFactory.getLogger(TestStepUtility.class);

	private static final String NAME_REGEX = "[^,]";
	private static final String COMPONENT_REGEX = "( " + NAME_REGEX + "+)"
			+ getRegexFromTypes(TestStepComponentTypes.values());
	private static final String OBJECT_REGEX = "(( " + NAME_REGEX + "+)("
			+ getRegexFromTypes(TestStepObjectVertexTypes.values()) + "|"
			+ getRegexFromTypes(TestStepObjectEdgeTypes.values()) + "))" + ",";
	private static final String DETAILS_REGEX = "( " + NAME_REGEX + "+)"
			+ getRegexFromTypes(TestStepDetailTypes.values());
	private static final String STATE_ATTR_REGEX = "( \\S+)";
	private static final String STATE_REGEX = "(" + getRegexFromTypes(TestStepStateModalityTypes.values())
			+ STATE_ATTR_REGEX + getRegexFromTypes(TestStepAttachmentTypes.values()) + "?)";
	private static final String TIME_REGEX = getRegexFromTypes(TestStepTimeTypes.values()) + " (.*)";
	private static final String PREDICATE_REGEX = "(" + "(" + DETAILS_REGEX + ")?" + STATE_REGEX + "(" + TIME_REGEX
			+ ")?" + ")";
	// TODO this whole regex needs to be refactored to reflect OBJECT_REGEX
	// PREDICATE_REGEX
	public static final String REGEX = "The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + PREDICATE_REGEX;

	// TODO combine has and get into one
	public static String getAttachment(String text) {
		return getGroup(REGEX, text, 16);
	}

	public static String getComponent(String text) {
		return getGroup("The" + "(" + COMPONENT_REGEX + ")", text, 1);
	}

	public static String getComponentName(String text) {
		return getGroup(REGEX, text, 2);
	}

	public static String getComponentType(String text) {
		return getGroup(REGEX, text, 3);
	}

	public static String getDetails(String text) {
		return getGroup(REGEX, text, 10);
	}

	public static String getDetailsName(String text) {
		return getGroup(REGEX, text, 11);
	}

	public static String getDetailsType(String text) {
		return getGroup(REGEX, text, 12);
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
		return getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX, text, 4).replace(",", "");
	}

	public static String getObjectName(String text) {
		return getGroup(REGEX, text, 5);
	}

	public static ArrayList<ITestStep> getPreviousSteps(ITestStep theTestStep, boolean reverse) {
		ArrayList<ITestStep> steps = new ArrayList<ITestStep>();
		for (ITestStep t : theTestStep.getParent().getTestStepList()) {

			// TODO make isElementEqual to force implementing the equals check
			// TODO make tests for this
			if (t.equals(theTestStep)) {
				break;
			} else {
				if (reverse) {
					steps.add(0, t);
				} else {
					steps.add(t);
				}
			}
		}
		return steps;

	}

	public static String getStepObjectQualifiedName(ITestStep theStep) {
		String stepNameLong = getNameLong(theStep);
		String component = getComponent(stepNameLong);
		String object = getObject(stepNameLong);
		String fileExt = theStep.getParent().getParent().getParent().getFileExtension();
		return component + "/" + object + fileExt;
	}

	public static String getNameLong(ITestStep theStep) {
		logger.debug("Entering getNameLong for step: {}", theStep != null ? theStep.getName() : "null");
		try {
			String stepNameLong = theStep.getName();
			String component = getComponent(stepNameLong);
			String object = getObject(stepNameLong);
			String objectName = getObjectName(stepNameLong);
			String objectType = getObjectType(stepNameLong);
			String predicate = getPredicate(stepNameLong);

			if (component.isEmpty() || !object.contains("/")) {
				ArrayList<ITestStep> previousSteps = getPreviousSteps(theStep, true);
				for (ITestStep previousStep : previousSteps) {
					// if the step has a matching object
					String previousObject = getObject(previousStep.getName());
					String previousComponent = getComponent(previousStep.getName());
					if (previousObject.endsWith("/" + objectName + " " + objectType)) {
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
					}
				}
				if (component.isEmpty()) {
					String lastComponent = "Unknown service";
					for (ITestStep aStep : previousSteps) {
						// keep track of the last component to assign to undeclared object components
						if (!getComponent(aStep.getName()).isEmpty()) {
							lastComponent = getComponent(aStep.getName());
							break;
						}
					}
					component = lastComponent;
				}
				stepNameLong = "The " + component + " " + object + ", " + predicate;
			}
			logger.debug("Exiting getNameLong with result: {}", stepNameLong);
			return stepNameLong;
		} catch (Exception e) {
			logger.error("Failed in getNameLong for step '{}': {}", theStep != null ? theStep.getName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static String getObjectType(String text) {
		return getGroup(REGEX, text, 6);
	}

	public static String getPredicate(String text) {
		return getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(.*)", text, 9);
	}

	private static String getRegexFromTypes(Enum<?>[] enumValues) {
		String regex = "(";
		for (Enum<?> enumValue : enumValues) {
			if (enumValue instanceof TestStepAttachmentTypes) {
				regex += " " + ((TestStepAttachmentTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepComponentTypes) {
				regex += " " + ((TestStepComponentTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepDetailTypes) {
				regex += " " + ((TestStepDetailTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepObjectEdgeTypes) {
				regex += " " + ((TestStepObjectEdgeTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepObjectVertexTypes) {
				regex += " " + ((TestStepObjectVertexTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepStateModalityTypes) {
				regex += " " + ((TestStepStateModalityTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepTimeTypes) {
				regex += ((TestStepTimeTypes) enumValue).value + "|";
			}
		}
		return regex.replaceAll("\\|$", ")");
	}

	public static String getState(String text) {
		return getGroup(REGEX, text, 13);
	}

	public static String getStateModality(String text) {
		return getGroup(REGEX, text, 14);
	}

	public static String getStateType(String text) {
		return getGroup(REGEX, text, 15);
	}

	public static String getTime(String text) {
		return getGroup(REGEX, text, 17);
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
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")?" + "("
				+ getRegexFromTypes(TestStepStateModalityTypes.values()) + STATE_ATTR_REGEX
				+ getRegexFromTypes(TestStepAttachmentTypes.values()) + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasStateAttribute(String text) {
		return !getGroup(
				"The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")?" + "("
						+ getRegexFromTypes(TestStepStateModalityTypes.values()) + STATE_ATTR_REGEX + ")" + ")",
				text, 0).isBlank();
	}

	public static boolean hasStateModality(String text) {
		return !getGroup("The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + "(" + DETAILS_REGEX + ")?" + "("
				+ getRegexFromTypes(TestStepStateModalityTypes.values()) + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasTime(String text) {
		return !getGroup(
				"The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + "(" + STATE_REGEX + "(" + TIME_REGEX + ")" + ")",
				text, 0).isBlank();
	}

	public static boolean isEdge(String text) {
		return !getGroup(REGEX, text, 8).isEmpty();
	}

	public static boolean isNegativeStep(String text) {
		return getGroup(REGEX, text, 14).contains("isn't") || getGroup(REGEX, text, 14).contains("won't be");
	}

	public static boolean isVertex(String text) {
		return !getGroup(REGEX, text, 7).isEmpty();
	}

}
