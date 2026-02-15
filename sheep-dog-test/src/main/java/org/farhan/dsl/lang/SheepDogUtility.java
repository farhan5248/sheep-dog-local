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
     * Creates a deep clone of a step object without parent association.
     * <p>
     * Clones the step object and all its children (statements, step definitions,
     * step parameters, tables, rows, cells) to avoid side effects when modifying
     * the structure for proposal generation.
     * </p>
     *
     * @param original the step object to clone
     * @return a deep clone of the step object with null parent
     */
    public static IStepObject cloneStepObject(IStepObject original) {
        IStepObject clone = SheepDogBuilder.createStepObject(null, original.getNameLong());

        // Clone statements
        for (IStatement statement : original.getStatementList()) {
            SheepDogBuilder.createStatement(clone, statement.getName());
        }

        // Clone step definitions
        for (IStepDefinition stepDefinition : original.getStepDefinitionList()) {
            IStepDefinition clonedStepDef = SheepDogBuilder.createStepDefinition(clone, stepDefinition.getName());

            // Clone statements for step definition
            for (IStatement statement : stepDefinition.getStatementList()) {
                SheepDogBuilder.createStatement(clonedStepDef, statement.getName());
            }

            // Clone step parameters
            for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                IStepParameters clonedStepParams = SheepDogBuilder.createStepParameters(clonedStepDef, stepParameters.getName());

                // Clone statements for step parameters
                for (IStatement statement : stepParameters.getStatementList()) {
                    SheepDogBuilder.createStatement(clonedStepParams, statement.getName());
                }

                // Clone table
                if (stepParameters.getTable() != null) {
                    ITable clonedTable = SheepDogBuilder.createTable(clonedStepParams);

                    // Clone rows
                    for (IRow row : stepParameters.getTable().getRowList()) {
                        IRow clonedRow = SheepDogBuilder.createRow(clonedTable);

                        // Clone cells
                        for (ICell cell : row.getCellList()) {
                            SheepDogBuilder.createCell(clonedRow, cell.getName());
                        }
                    }
                }
            }
        }

        return clone;
    }

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
            ArrayList<ITestStep> previousSteps = getTestStepListUpToTestStep(theStep);
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

    /**
     * Gets a list of elements up to (but not including) the specified element.
     * Returns elements in reverse chronological order (most recent first) for context inference.
     * Includes background/setup steps when processing scenario/test case steps.
     *
     * @param theTestStep the current test step
     * @return list of test steps up to the specified step in reverse chronological order
     */
    public static ArrayList<ITestStep> getTestStepListUpToTestStep(ITestStep theTestStep) {
        ArrayList<ITestStep> steps = new ArrayList<ITestStep>();
        if (theTestStep != null && theTestStep.getParent() != null) {
            ITestStepContainer currentContainer = theTestStep.getParent();

            // First, add steps from current container up to theTestStep
            for (ITestStep t : currentContainer.getTestStepList()) {
                if (t.equals(theTestStep)) {
                    break;
                } else {
                    steps.add(0, t);
                }
            }

            // If current container is a TestCase, also include all steps from TestSetup (Background)
            if (currentContainer instanceof ITestCase) {
                ITestSuite suite = currentContainer.getParent();
                if (suite != null) {
                    for (ITestStepContainer container : suite.getTestStepContainerList()) {
                        if (container instanceof ITestSetup) {
                            // Add all background steps (in reverse order)
                            List<ITestStep> backgroundSteps = container.getTestStepList();
                            for (int i = backgroundSteps.size() - 1; i >= 0; i--) {
                                steps.add(0, backgroundSteps.get(i));
                            }
                        }
                    }
                }
            }
        }
        return steps;
    }

    // Future: getTestStepContainerListUpToTestCase(ITestCase theTestCase)
}
