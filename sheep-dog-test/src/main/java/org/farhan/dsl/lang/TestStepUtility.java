package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.farhan.dsl.types.TestStepAttachmentTypes;
import org.farhan.dsl.types.TestStepComponentTypes;
import org.farhan.dsl.types.TestStepPartTypes;
import org.farhan.dsl.types.TestStepObjectEdgeTypes;
import org.farhan.dsl.types.TestStepObjectVertexTypes;
import org.farhan.dsl.types.TestStepStateModalityTypes;
import org.farhan.dsl.types.TestStepTimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepUtility {

	private static final Logger logger = LoggerFactory.getLogger(TestStepUtility.class);

	private static final String WORD = ".";
	private static final String TITLE = "( " + WORD + "+)";

	private static final String COMPONENT_NAME = "( " + "[^/]" + "+)";
	private static final String COMPONENT_TYPE = getRegexFromTypes(TestStepComponentTypes.values());
	private static final String COMPONENT = "(" + COMPONENT_NAME + COMPONENT_TYPE + ")";

	private static final String OBJECT_NAME = TITLE;
	private static final String OBJECT_TYPE = "(" + getRegexFromTypes(TestStepObjectVertexTypes.values()) + "|"
			+ getRegexFromTypes(TestStepObjectEdgeTypes.values()) + ")";
	private static final String OBJECT = "(" + OBJECT_NAME + OBJECT_TYPE + ")";

	private static final String PART_DESC = TITLE;
	private static final String PART_TYPE = getRegexFromTypes(TestStepPartTypes.values());
	private static final String PART = "(" + PART_DESC + PART_TYPE + ")";

	private static final String STATE_DESC = "( \\S+)";
	private static final String STATE_TYPE = getRegexFromTypes(TestStepStateModalityTypes.values());
	private static final String STATE = "(" + STATE_TYPE + STATE_DESC + ")";

	private static final String TIME_DESC = TITLE;
	private static final String TIME_TYPE = getRegexFromTypes(TestStepTimeTypes.values());
	private static final String TIME = "(" + TIME_TYPE + TIME_DESC + ")";

	private static final String ATTACHMENT = getRegexFromTypes(TestStepAttachmentTypes.values());

	private static final String STEP_OBJECT_NAME = "(The" + COMPONENT + "?" + OBJECT + ")";
	private static final String STEP_DEFINITION_NAME = "(" + PART + "?" + STATE + TIME + "?" + ATTACHMENT + "?" + ")";
	public static final String REGEX = STEP_OBJECT_NAME + STEP_DEFINITION_NAME;

	// TODO combine has and get into one
	public static String getAttachment(String text) {
		return getGroup(REGEX, text, 20);
	}

	public static String getComponent(String text) {
		return getGroup("(The" + COMPONENT + ")", text, 2);
	}

	public static String getComponentName(String text) {
		return getGroup(REGEX, text, 3);
	}

	public static String getComponentType(String text) {
		return getGroup(REGEX, text, 4);
	}

	public static String getDetails(String text) {
		return getGroup(REGEX, text, 11);
	}

	public static String getDetailsName(String text) {
		return getGroup(REGEX, text, 12);
	}

	public static String getDetailsType(String text) {
		return getGroup(REGEX, text, 13);
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
				stepNameLong = "The " + component + " " + object + " " + predicate;
			}
			logger.debug("Exiting getNameLong with result: {}", stepNameLong);
			return stepNameLong;
		} catch (Exception e) {
			logger.error("Failed in getNameLong for step '{}': {}", theStep != null ? theStep.getName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static String getObject(String text) {
		return getGroup(STEP_OBJECT_NAME, text, 5);
	}

	public static String getObjectName(String text) {
		return getGroup(REGEX, text, 6);
	}

	public static String getObjectType(String text) {
		return getGroup(REGEX, text, 7);
	}

	public static String getPredicate(String text) {
		return getGroup(REGEX, text, 10);
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

	private static String getRegexFromTypes(Enum<?>[] enumValues) {
		String regex = "(";
		for (Enum<?> enumValue : enumValues) {
			if (enumValue instanceof TestStepAttachmentTypes) {
				regex += " " + ((TestStepAttachmentTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepComponentTypes) {
				regex += " " + ((TestStepComponentTypes) enumValue).value + "|";
			} else if (enumValue instanceof TestStepPartTypes) {
				regex += " " + ((TestStepPartTypes) enumValue).value + "|";
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
		return getGroup(REGEX, text, 14);
	}

	public static String getStateModality(String text) {
		return getGroup(REGEX, text, 15);
	}

	public static String getStateType(String text) {
		return getGroup(REGEX, text, 16);
	}

	public static String getStepObjectQualifiedName(ITestStep theStep) {
		String stepNameLong = getNameLong(theStep);
		String component = getComponent(stepNameLong);
		String object = getObject(stepNameLong);
		String fileExt = theStep.getParent().getParent().getParent().getFileExtension();
		return component + "/" + object + fileExt;
	}

	public static String getTime(String text) {
		return getGroup(REGEX, text, 17);
	}

	public static boolean hasComponent(String text) {
		return !getGroup("The" + "(" + COMPONENT + ")", text, 0).isBlank();
	}

	public static boolean hasDetails(String text) {
		return !getGroup("The" + "(" + COMPONENT + ")?" + OBJECT + "(" + "(" + PART + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasObject(String text) {
		return !getGroup(STEP_OBJECT_NAME, text, 0).isBlank();
	}

	public static boolean hasPredicate(String text) {
		return !getGroup(REGEX, text, 0).isBlank();
	}

	public static boolean hasState(String text) {
		return !getGroup("The" + "(" + COMPONENT + ")?" + OBJECT + "(" + "(" + PART + ")?" + STATE + ")", text, 0)
				.isBlank();
	}

	public static boolean hasStateAttachment(String text) {
		return !getGroup("The" + "(" + COMPONENT + ")?" + OBJECT + "(" + "(" + PART + ")?" + "("
				+ getRegexFromTypes(TestStepStateModalityTypes.values()) + STATE_DESC
				+ getRegexFromTypes(TestStepAttachmentTypes.values()) + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasStateAttribute(String text) {
		return !getGroup("The" + "(" + COMPONENT + ")?" + OBJECT + "(" + "(" + PART + ")?" + "("
				+ getRegexFromTypes(TestStepStateModalityTypes.values()) + STATE_DESC + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasStateModality(String text) {
		return !getGroup("The" + "(" + COMPONENT + ")?" + OBJECT + "(" + "(" + PART + ")?" + "("
				+ getRegexFromTypes(TestStepStateModalityTypes.values()) + ")" + ")", text, 0).isBlank();
	}

	public static boolean hasTime(String text) {
		return !getGroup("The" + "(" + COMPONENT + ")?" + OBJECT + "(" + STATE + "(" + TIME + ")" + ")", text, 0)
				.isBlank();
	}

	public static boolean isEdge(String text) {
		return !getGroup(REGEX, text, 9).isEmpty();
	}

	public static boolean isNegativeStep(String text) {
		return getGroup(REGEX, text, 14).contains("isn't") || getGroup(REGEX, text, 14).contains("won't be");
	}

	public static boolean isVertex(String text) {
		return !getGroup(REGEX, text, 7).isEmpty();
	}

}
