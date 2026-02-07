package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStepUtility {
    // TODO think about the following
    // 1. Delete this class and move all the grammar to the xtext file
    // 2. getQualifiedName or getNameLong should be move to the implementing
    // classes? But if so, then each jar would have to implement the same logic. In
    // this case then, even after moving out the grammar, the only class using the
    // utility is the Impl classes. In which case, instead of an interface, would
    // abstract classes be better? Make a decision only after updating the spring
    // boot service code. For now meta attributes should use methods here to get
    // their value. They have no setters in the interfaces, just getters

    private static final String WORD = ".";
    private static final String TITLE = "( " + WORD + "+)";

    private static final String COMPONENT_NAME = "( " + "[^/]" + "+)";
    private static final String COMPONENT_TYPE = getRegexFromTypes(TestStepComponentTypes.values());
    private static final String COMPONENT = "(" + COMPONENT_NAME + COMPONENT_TYPE + ")";

    private static final String OBJECT_NAME = TITLE;
    private static final String OBJECT_TYPE_VERTEX = getRegexFromTypes(TestStepObjectVertexTypes.values());
    private static final String OBJECT_TYPE_EDGE = getRegexFromTypes(TestStepObjectEdgeTypes.values());
    private static final String OBJECT_TYPE = "(" + OBJECT_TYPE_VERTEX + "|" + OBJECT_TYPE_EDGE + ")";
    private static final String OBJECT = "(" + OBJECT_NAME + OBJECT_TYPE + ")";

    private static final String PART_DESC = TITLE;
    private static final String PART_TYPE = getRegexFromTypes(TestStepPartTypes.values());
    private static final String PART = "(" + PART_DESC + PART_TYPE + ")";

    private static final String STATE_DESC = "( \\S+)";
    private static final String STATE_TYPE = getRegexFromTypes(TestStepStateTypes.values());
    private static final String STATE = "(" + STATE_TYPE + STATE_DESC + ")";

    private static final String TIME_DESC = TITLE;
    private static final String TIME_TYPE = getRegexFromTypes(TestStepTimeTypes.values());
    private static final String TIME = "(" + TIME_TYPE + TIME_DESC + ")";

    private static final String ATTACHMENT = getRegexFromTypes(TestStepAttachmentTypes.values());

    private static final String STEP_OBJECT_NAME = "(The" + COMPONENT + "?" + OBJECT + ")";
    private static final String STEP_DEFINITION_NAME = "(" + PART + "?" + STATE + TIME + "?" + ATTACHMENT + "?" + ")";
    public static final String REGEX = STEP_OBJECT_NAME + STEP_DEFINITION_NAME;

    private static String getGroup(String regex, String text, int group) {
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
        String stepNameLong = theStep.getName();
        String component = getComponent(stepNameLong);
        String object = getObject(stepNameLong);
        String objectName = getObjectName(stepNameLong);
        String objectType = getObjectType(stepNameLong);
        String stepDefinitonName = getStepDefinitionName(stepNameLong);

        if (component.isEmpty() || !object.contains("/")) {
            ArrayList<ITestStep> previousSteps = getPreviousSteps(theStep);
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
            stepNameLong = "The " + component + " " + object + " " + stepDefinitonName;
        }
        return stepNameLong;
    }

    private static ArrayList<ITestStep> getPreviousSteps(ITestStep theTestStep) {
        ArrayList<ITestStep> steps = new ArrayList<ITestStep>();
        for (ITestStep t : theTestStep.getParent().getTestStepList()) {
            // TODO make isElementEqual to force implementing the equals check
            // TODO make tests for this
            if (t.equals(theTestStep)) {
                break;
            } else {
                steps.add(0, t);
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
            } else if (enumValue instanceof TestStepStateTypes) {
                regex += " " + ((TestStepStateTypes) enumValue).value + "|";
            } else if (enumValue instanceof TestStepTimeTypes) {
                regex += ((TestStepTimeTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }

    public static String getStepObjectQualifiedName(ITestStep theStep) {
        String stepNameLong = getNameLong(theStep);
        String component = getComponent(stepNameLong);
        String object = getObject(stepNameLong);
        // TODO maybe in the future, the file extension shouldn't be referenced in this
        // utility class.
        String fileExt = theStep.getParent().getParent().getParent().getFileExtension();
        return component + "/" + object + fileExt;
    }

    public static String getStepObjectName(String text) {
        return getGroup(STEP_OBJECT_NAME, text, 0);
    }

    public static String getComponent(String text) {
        return getGroup("(The" + COMPONENT + "?" + ")", text, 2);
    }

    public static String getComponentName(String text) {
        return getGroup("(The" + COMPONENT + "?" + ")", text, 3);
    }

    public static String getComponentType(String text) {
        return getGroup("(The" + COMPONENT + "?" + ")", text, 4);
    }

    public static String getObject(String text) {
        return getGroup(STEP_OBJECT_NAME, text, 5);
    }

    public static String getObjectName(String text) {
        return getGroup(STEP_OBJECT_NAME, text, 6);
    }

    public static String getObjectType(String text) {
        return getGroup(STEP_OBJECT_NAME, text, 7);
    }

    public static String getObjectVertexType(String text) {
        return getGroup(STEP_OBJECT_NAME, text, 8);
    }

    public static String getObjectEdgeType(String text) {
        return getGroup(STEP_OBJECT_NAME, text, 9);
    }

    public static String getStepDefinitionName(String text) {
        return getGroup(REGEX, text, 10);
    }

    public static String getPart(String text) {
        return getGroup(REGEX, text, 11);
    }

    public static String getPartDesc(String text) {
        return getGroup(REGEX, text, 12);
    }

    public static String getPartType(String text) {
        return getGroup(REGEX, text, 13);
    }

    public static String getState(String text) {
        return getGroup(REGEX, text, 14);
    }

    public static String getStateDesc(String text) {
        return getGroup(REGEX, text, 15);
    }

    public static String getStateType(String text) {
        return getGroup(REGEX, text, 16);
    }

    public static String getTime(String text) {
        return getGroup(REGEX, text, 17);
    }

    public static String getTimeType(String text) {
        return getGroup(REGEX, text, 18);
    }

    public static String getTimeDesc(String text) {
        return getGroup(REGEX, text, 19);
    }

    public static String getAttachment(String text) {
        return getGroup(REGEX, text, 20);
    }

    public static boolean isEdge(String text) {
        return !getObjectEdgeType(text).isEmpty();
    }

    public static boolean isNegativeStep(String text) {
        return getState(text).contains("isn't") || getState(text).contains("won't be");
    }

    public static boolean isVertex(String text) {
        return !getObjectVertexType(text).isEmpty();
    }

    public static boolean isValid(String text) {
        return !getGroup(REGEX, text, 0).isEmpty();
    }
}
