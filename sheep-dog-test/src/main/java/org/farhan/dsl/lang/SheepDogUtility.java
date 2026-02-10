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
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
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
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param theStep the test step to process
     * @return qualified name string with component, object, and file extension
     */
    public static String getStepObjectNameLongForTestStep(ITestStep theStep) {
        String stepNameLong = SheepDogUtility.getTestStepNameLong(theStep);
        String component = StepObjectRefFragments.getComponent(stepNameLong);
        String object = StepObjectRefFragments.getObject(stepNameLong);
        String fileExt = theStep.getParent().getParent().getParent().getFileExtension();
        return component + "/" + object + fileExt;
    }

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
