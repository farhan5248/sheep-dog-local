package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Static helper methods for grammar element operations.
 * <p>
 * Separates utility operations from grammar model classes, keeping interfaces
 * focused on data access.
 * </p>
 */
public class SheepDogUtility {

    /**
     * Converts a list of grammar elements into a formatted string representation
     * for display or comparison purposes.
     *
     * @param list the list of cells to convert
     * @return formatted string representation of the cell list
     */
    public static String getCellListAsString(List<ICell> list) {
        String cellsAsString = "";
        List<String> theList = new ArrayList<String>();
        for (ICell cell : list) {
            theList.add(cell.getName());
        }
        Collections.sort(theList);
        for (String cell : theList) {
            cellsAsString += ", " + cell;
        }
        return cellsAsString.replaceFirst(", ", "").trim();
    }

    /**
     * Converts a list of grammar elements into a formatted string representation
     * for display or comparison purposes.
     *
     * @param statementList the list of statements to convert
     * @return String concatenation of all statement names
     */
    public static String getStatementListAsString(List<IStatement> statementList) {
        String documentation = "";
        for (IStatement s : statementList) {
            documentation += s.getName();
        }
        return documentation;
    }

    /**
     * Constructs fully qualified or long-form names for grammar elements by
     * combining components, objects, and contextual information from parent
     * elements.
     *
     * @param theStep the test step to process
     * @return qualified name string with component, object, and file extension
     */
    public static String getStepObjectNameLongForTestStep(ITestStep theStep) {
        if (theStep != null) {
            String stepNameLong = SheepDogUtility.getTestStepNameLong(theStep);
            if (stepNameLong != null && !stepNameLong.isEmpty()) {
                String component = StepObjectRefFragments.getComponent(stepNameLong);
                String object = StepObjectRefFragments.getObject(stepNameLong);

                if (!component.isEmpty() && !object.isEmpty()) {
                    // Use the new utility method to navigate to project
                    ITestProject project = getTestProjectParentForTestStep(theStep);
                    if (project != null) {
                        String fileExt = project.getFileExtension();
                        if (fileExt != null && !fileExt.isEmpty()) {
                            return component + "/" + object + fileExt;
                        }
                    }
                }
            }
        }
        return "";
    }

    /**
     * Constructs fully qualified or long-form names for grammar elements by
     * combining components, objects, and contextual information from parent
     * elements.
     *
     * @param theStep the test step to process
     * @return the long-form name of the test step
     */
    public static String getTestStepNameLong(ITestStep theStep) {

        String component = StepObjectRefFragments.getComponent(theStep.getStepObjectName());
        String object = StepObjectRefFragments.getObject(theStep.getStepObjectName());

        if (component.isEmpty() || !object.contains("/")) {
            ArrayList<ITestStep> previousSteps = getPreviousSteps(theStep);
            for (ITestStep previousStep : previousSteps) {
                // if the step has a matching object
                String previousObject = StepObjectRefFragments.getObject(previousStep.getStepObjectName());
                String previousComponent = StepObjectRefFragments.getComponent(previousStep.getStepObjectName());
                if (previousObject.endsWith("/" + object)) {
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
                    if (!StepObjectRefFragments.getComponent(aStep.getStepObjectName()).isEmpty()) {
                        lastComponent = StepObjectRefFragments.getComponent(aStep.getStepObjectName());
                        break;
                    }
                }
                component = lastComponent;
            }
        }
        return "The " + component + " " + object + " " + theStep.getStepDefinitionName();
    }

    /**
     * Gets the grand parent or great grand parent etc for a type. Navigates the
     * parent hierarchy to reach the TestProject from a Text element.
     *
     * @param theText the text element to navigate from
     * @return the TestProject parent, or null if not found
     */
    public static ITestProject getTestProjectParentForText(IText theText) {
        if (theText != null) {
            ITestStep testStep = theText.getParent();
            if (testStep != null) {
                ITestStepContainer container = testStep.getParent();
                if (container != null) {
                    ITestSuite suite = container.getParent();
                    if (suite != null) {
                        return suite.getParent();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Gets the grand parent or great grand parent etc for a type. Navigates the
     * parent hierarchy to reach the TestProject from a TestStep element.
     *
     * @param theTestStep the test step element to navigate from
     * @return the TestProject parent, or null if not found
     */
    public static ITestProject getTestProjectParentForTestStep(ITestStep theTestStep) {
        if (theTestStep != null) {
            ITestStepContainer container = theTestStep.getParent();
            if (container != null) {
                ITestSuite suite = container.getParent();
                if (suite != null) {
                    return suite.getParent();
                }
            }
        }
        return null;
    }

    private static ArrayList<ITestStep> getPreviousSteps(ITestStep theTestStep) {
        ArrayList<ITestStep> steps = new ArrayList<ITestStep>();
        for (ITestStep t : theTestStep.getParent().getTestStepList()) {
            // TODO make tests for this
            if (t.equals(theTestStep)) {
                break;
            } else {
                steps.add(0, t);
            }
        }
        return steps;

    }
}
