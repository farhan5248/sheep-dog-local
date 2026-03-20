package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;

/**
 * Static helper methods for grammar element operations.
 * <p>
 * Separates utility operations from grammar model classes, keeping interfaces
 * focused on data access.
 * </p>
 */
public class SheepDogUtility {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(SheepDogUtility.class);

    /**
     * Returns all StepObjects from a project's unified TestDocumentList.
     *
     * @param project the test project to filter
     * @return list of IStepObject instances from the project's document list
     */
    public static List<IStepObject> getStepObjectList(ITestProject project) {
        logger.debug("Entering getStepObjectList for project: {}", project != null ? "non-null" : "null");
        List<IStepObject> result = new ArrayList<>();
        for (ITestDocument doc : project.getTestDocumentList()) {
            if (doc instanceof IStepObject) {
                result.add((IStepObject) doc);
            }
        }
        logger.debug("Exiting getStepObjectList with result: {} items", result.size());
        return result;
    }

    /**
     * Returns all TestSuites from a project's unified TestDocumentList.
     *
     * @param project the test project to filter
     * @return list of ITestSuite instances from the project's document list
     */
    public static List<ITestSuite> getTestSuiteList(ITestProject project) {
        logger.debug("Entering getTestSuiteList for project: {}", project != null ? "non-null" : "null");
        List<ITestSuite> result = new ArrayList<>();
        for (ITestDocument doc : project.getTestDocumentList()) {
            if (doc instanceof ITestSuite) {
                result.add((ITestSuite) doc);
            }
        }
        logger.debug("Exiting getTestSuiteList with result: {} items", result.size());
        return result;
    }

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
        logger.debug("Entering cloneStepObject for original: {}", original != null ? original.getFullName() : "null");
        IStepObject clone = SheepDogBuilder.createStepObject(null, original.getFullName());

        // Clone lines
        if (original.getDescription() != null) {
            IDescription clonedDescription = SheepDogBuilder.createDescription(clone);
            for (ILine line : original.getDescription().getLineList()) {
                SheepDogBuilder.createLine(clonedDescription, line.getName());
            }
        }

        // Clone step definitions
        for (IStepDefinition stepDefinition : original.getStepDefinitionList()) {
            IStepDefinition clonedStepDef = SheepDogBuilder.createStepDefinition(clone, stepDefinition.getName());

            // Clone lines for step definition
            if (stepDefinition.getDescription() != null) {
                IDescription clonedStepDefDescription = SheepDogBuilder.createDescription(clonedStepDef);
                for (ILine line : stepDefinition.getDescription().getLineList()) {
                    SheepDogBuilder.createLine(clonedStepDefDescription, line.getName());
                }
            }

            // Clone step parameters
            for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                IStepParameters clonedStepParams = SheepDogBuilder.createStepParameters(clonedStepDef,
                        stepParameters.getName());

                // Clone lines for step parameters
                if (stepParameters.getDescription() != null) {
                    IDescription clonedDescription = SheepDogBuilder.createDescription(clonedStepParams);
                    for (ILine line : stepParameters.getDescription().getLineList()) {
                        SheepDogBuilder.createLine(clonedDescription, line.getName());
                    }
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

        logger.debug("Exiting cloneStepObject with result: {}", clone != null ? clone.getFullName() : "null");
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
        logger.debug("Entering getCellListAsString for list: {} items", list != null ? list.size() : "null");
        List<String> theList = new ArrayList<String>();
        for (ICell cell : list) {
            theList.add(cell.getName());
        }
        Collections.sort(theList);
        String result = String.join(", ", theList);
        logger.debug("Exiting getCellListAsString with result: {}", result);
        return result;
    }

    /**
     * Converts a list of grammar elements into a formatted string representation
     * for display or comparison purposes.
     *
     * @param statementList the list of statements to convert
     * @return String concatenation of all statement names
     */
    public static String getLineListAsString(List<ILine> lineList) {
        logger.debug("Entering getLineListAsString for lineList: {} items",
                lineList != null ? lineList.size() : "null");
        StringBuilder sb = new StringBuilder();
        for (ILine s : lineList) {
            sb.append(s.getName());
        }
        String documentation = sb.toString();
        logger.debug("Exiting getLineListAsString with result: {}", documentation);
        return documentation;
    }

    /**
     * Constructs fully qualified or long-form names for grammar elements by
     * combining components, objects, and contextual information from parent
     * elements.
     *
     * @param theStep the test step to process
     * @return full name string with component, object, and file extension
     */
    public static String getStepObjectFullNameForTestStep(ITestStep theStep) {
        logger.debug("Entering getStepObjectFullNameForTestStep for theStep: {}",
                theStep != null ? theStep.getStepObjectName() : "null");
        if (theStep == null) {
            logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", "");
            return "";
        }
        String stepFullName = SheepDogUtility.getTestStepFullName(theStep);
        if (stepFullName == null || stepFullName.isEmpty()) {
            logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", "");
            return "";
        }
        String component = StepObjectRefFragments.getComponent(stepFullName);
        String object = StepObjectRefFragments.getObject(stepFullName);
        if (component.isEmpty() || object.isEmpty()) {
            logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", "");
            return "";
        }
        ITestProject project = getTestProjectParentForTestStep(theStep);
        if (project == null) {
            logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", "");
            return "";
        }
        String fileExt = project.getFileExtension();
        if (fileExt == null || fileExt.isEmpty()) {
            logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", "");
            return "";
        }
        String result = "stepdefs/" + component + "/" + object + fileExt;
        logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", result);
        return result;
    }

    /**
     * Constructs fully qualified or long-form names for grammar elements by
     * combining components, objects, and contextual information from parent
     * elements.
     *
     * @param theStep the test step to process
     * @return the full name of the test step
     */
    public static String getTestStepFullName(ITestStep theStep) {
        logger.debug("Entering getTestStepFullName for theStep: {}",
                theStep != null ? theStep.getStepObjectName() : "null");
        String component = StepObjectRefFragments.getComponent(theStep.getStepObjectName());
        String object = StepObjectRefFragments.getObject(theStep.getStepObjectName());

        if (component.isEmpty()) {
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
        String result = "The " + component + " " + object + " " + theStep.getStepDefinitionName();
        logger.debug("Exiting getTestStepFullName with result: {}", result);
        return result;
    }

    /**
     * Gets the grand parent or great grand parent etc for a type. Navigates the
     * parent hierarchy to reach the TestProject from a Text element.
     *
     * @param theText the text element to navigate from
     * @return the TestProject parent, or null if not found
     */
    public static ITestProject getTestProjectParentForText(IText theText) {
        logger.debug("Entering getTestProjectParentForText for theText: {}",
                theText != null ? theText.getName() : "null");
        if (theText != null) {
            ITestStep testStep = theText.getParent();
            if (testStep != null) {
                ITestStepContainer container = testStep.getParent();
                if (container != null) {
                    ITestSuite suite = container.getParent();
                    if (suite != null) {
                        ITestProject result = suite.getParent();
                        logger.debug("Exiting getTestProjectParentForText with result: {}",
                                result != null ? "non-null" : "null");
                        return result;
                    }
                }
            }
        }
        logger.debug("Exiting getTestProjectParentForText with result: {}", "null");
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
        logger.debug("Entering getTestProjectParentForTestStep for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        if (theTestStep != null) {
            ITestStepContainer container = theTestStep.getParent();
            if (container != null) {
                ITestSuite suite = container.getParent();
                if (suite != null) {
                    ITestProject result = suite.getParent();
                    logger.debug("Exiting getTestProjectParentForTestStep with result: {}",
                            result != null ? "non-null" : "null");
                    return result;
                }
            }
        }
        logger.debug("Exiting getTestProjectParentForTestStep with result: {}", "null");
        return null;
    }

    /**
     * Gets the grand parent or great grand parent etc for a type. Navigates the
     * parent hierarchy to reach the TestProject from a Row element.
     *
     * @param theRow the row element to navigate from
     * @return the TestProject parent, or null if not found
     */
    public static ITestProject getTestProjectParentForRow(IRow theRow) {
        logger.debug("Entering getTestProjectParentForRow for theRow: {}", theRow != null ? "non-null" : "null");
        if (theRow != null) {
            ITable table = theRow.getParent();
            if (table != null) {
                Object tableParent = table.getParent();
                if (tableParent instanceof ITestStep) {
                    ITestProject result = getTestProjectParentForTestStep((ITestStep) tableParent);
                    logger.debug("Exiting getTestProjectParentForRow with result: {}",
                            result != null ? "non-null" : "null");
                    return result;
                }
            }
        }
        logger.debug("Exiting getTestProjectParentForRow with result: {}", "null");
        return null;
    }

    /**
     * Gets a list of elements up to (but not including) the specified element.
     * Returns elements in reverse chronological order (most recent first) for
     * context inference. Includes background/setup steps when processing
     * scenario/test case steps.
     *
     * @param theTestStep the current test step
     * @return list of test steps up to the specified step in reverse chronological
     *         order
     */
    public static ArrayList<ITestStep> getTestStepListUpToTestStep(ITestStep theTestStep) {
        logger.debug("Entering getTestStepListUpToTestStep for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
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

            // If current container is a TestCase, also include all steps from TestSetup
            // (Background)
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
        logger.debug("Exiting getTestStepListUpToTestStep with result: {} steps", steps.size());
        return steps;
    }
}
