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
                SheepDogBuilder.createLine(clonedDescription, line.getContent());
            }
        }

        // Clone step definitions
        for (IStepDefinition stepDefinition : original.getStepDefinitionList()) {
            IStepDefinition clonedStepDef = SheepDogBuilder.createStepDefinition(clone, stepDefinition.getName());

            // Clone lines for step definition
            if (stepDefinition.getDescription() != null) {
                IDescription clonedStepDefDescription = SheepDogBuilder.createDescription(clonedStepDef);
                for (ILine line : stepDefinition.getDescription().getLineList()) {
                    SheepDogBuilder.createLine(clonedStepDefDescription, line.getContent());
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
                        SheepDogBuilder.createLine(clonedDescription, line.getContent());
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
     * Walks up the eContainer() chain to find the nearest ancestor of the given
     * type.
     */
    private static <T> T getAncestor(Object node, Class<T> type) {
        Object current = node;
        while (current != null) {
            if (type.isInstance(current)) {
                return (T) current;
            }
            current = getContainerOf(current);
        }
        return null;
    }

    private static Object getContainerOf(Object node) {
        if (node instanceof ITestDocument) return ((ITestDocument) node).getContainer();
        if (node instanceof IStepDefinition) return ((IStepDefinition) node).getContainer();
        if (node instanceof IStepParameters) return ((IStepParameters) node).getContainer();
        if (node instanceof ITestStepContainer) return ((ITestStepContainer) node).getContainer();
        if (node instanceof ITestData) return ((ITestData) node).getContainer();
        if (node instanceof ITestStep) return ((ITestStep) node).getContainer();
        if (node instanceof IText) return ((IText) node).getContainer();
        if (node instanceof ITable) return ((ITable) node).getContainer();
        if (node instanceof IRow) return ((IRow) node).getContainer();
        if (node instanceof ICell) return ((ICell) node).getContainer();
        if (node instanceof IDescription) return ((IDescription) node).getContainer();
        if (node instanceof ILine) return ((ILine) node).getContainer();
        return null;
    }

    public static ICell getCell(IRow row, String name) {
        logger.debug("Entering getCell for row: {}, name: {}", row, name);
        for (ICell c : row.getCellList()) {
            if (c.getName().contentEquals(name)) {
                logger.debug("Exiting getCell with result: {}", c);
                return c;
            }
        }
        logger.debug("Exiting getCell with result: null");
        return null;
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
        String cellsAsString = "";
        List<String> theList = new ArrayList<String>();
        for (ICell cell : list) {
            theList.add(cell.getName());
        }
        Collections.sort(theList);
        for (String cell : theList) {
            cellsAsString += ", " + cell;
        }
        String result = cellsAsString.replaceFirst(", ", "").trim();
        logger.debug("Exiting getCellListAsString with result: {}", result);
        return result;
    }

    public static ILine getLine(IDescription description, String content) {
        logger.debug("Entering getLine for description: {}, content: {}", description, content);
        for (ILine l : description.getLineList()) {
            if (l.getContent().equals(content)) {
                logger.debug("Exiting getLine with result: {}", l);
                return l;
            }
        }
        logger.debug("Exiting getLine with result: null");
        return null;
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
        String documentation = "";
        for (ILine s : lineList) {
            documentation += s.getContent();
        }
        logger.debug("Exiting getLineListAsString with result: {}", documentation);
        return documentation;
    }

    public static IStepDefinition getStepDefinition(IStepObject stepObject, String name) {
        logger.debug("Entering getStepDefinition for stepObject: {}, name: {}", stepObject, name);
        for (IStepDefinition sd : stepObject.getStepDefinitionList()) {
            if (sd.getName().contentEquals(name)) {
                logger.debug("Exiting getStepDefinition with result: {}", sd);
                return sd;
            }
        }
        logger.debug("Exiting getStepDefinition with result: null");
        return null;
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
        if (theStep != null) {
            String stepFullName = SheepDogUtility.getTestStepFullName(theStep);
            if (stepFullName != null && !stepFullName.isEmpty()) {
                String component = StepObjectRefFragments.getComponent(stepFullName);
                String object = StepObjectRefFragments.getObject(stepFullName);

                if (!component.isEmpty() && !object.isEmpty()) {
                    // Use the new utility method to navigate to project
                    ITestProject project = getTestProjectParent(theStep);
                    if (project != null) {
                        String fileExt = project.getFileExtension();
                        if (fileExt != null && !fileExt.isEmpty()) {
                            String result = "stepdefs/" + component + "/" + object + fileExt;
                            logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", result);
                            return result;
                        }
                    }
                }
            }
        }
        logger.debug("Exiting getStepObjectFullNameForTestStep with result: {}", "");
        return "";
    }

    public static IStepParameters getStepParameters(IStepDefinition stepDefinition, String name) {
        logger.debug("Entering getStepParameters for stepDefinition: {}, name: {}", stepDefinition, name);
        for (IStepParameters sp : stepDefinition.getStepParameterList()) {
            if (name.contentEquals(sp.getName())) {
                logger.debug("Exiting getStepParameters with result: {}", sp);
                return sp;
            }
        }
        logger.debug("Exiting getStepParameters with result: null");
        return null;
    }

    public static ITestData getTestData(ITestCase testCase, String name) {
        logger.debug("Entering getTestData for testCase: {}, name: {}", testCase, name);
        for (ITestData td : testCase.getTestDataList()) {
            if (td.getName().contentEquals(name)) {
                logger.debug("Exiting getTestData with result: {}", td);
                return td;
            }
        }
        logger.debug("Exiting getTestData with result: null");
        return null;
    }

    public static ITestDocument getTestDocument(ITestProject project, String fullName) {
        logger.debug("Entering getTestDocument for project: {}, fullName: {}", project, fullName);
        for (ITestDocument td : project.getTestDocumentList()) {
            if (td.getFullName().contentEquals(fullName)) {
                logger.debug("Exiting getTestDocument with result: {}", td);
                return td;
            }
        }
        logger.debug("Exiting getTestDocument with result: null");
        return null;
    }

    public static IDescription getDescriptionParent(Object node) {
        logger.debug("Entering getDescriptionParent for node: {}", node);
        IDescription result = getAncestor(node, IDescription.class);
        logger.debug("Exiting getDescriptionParent with result: {}", result);
        return result;
    }

    public static IRow getRowParent(Object node) {
        logger.debug("Entering getRowParent for node: {}", node);
        IRow result = getAncestor(node, IRow.class);
        logger.debug("Exiting getRowParent with result: {}", result);
        return result;
    }

    public static ITable getTableParent(Object node) {
        logger.debug("Entering getTableParent for node: {}", node);
        ITable result = getAncestor(node, ITable.class);
        logger.debug("Exiting getTableParent with result: {}", result);
        return result;
    }

    public static IStepDefinition getStepDefinitionParent(Object node) {
        logger.debug("Entering getStepDefinitionParent for node: {}", node);
        IStepDefinition result = getAncestor(node, IStepDefinition.class);
        logger.debug("Exiting getStepDefinitionParent with result: {}", result);
        return result;
    }

    public static IStepObject getStepObjectParent(Object node) {
        logger.debug("Entering getStepObjectParent for node: {}", node);
        IStepObject result = getAncestor(node, IStepObject.class);
        logger.debug("Exiting getStepObjectParent with result: {}", result);
        return result;
    }

    public static ITestCase getTestCaseParent(Object node) {
        logger.debug("Entering getTestCaseParent for node: {}", node);
        ITestCase result = getAncestor(node, ITestCase.class);
        logger.debug("Exiting getTestCaseParent with result: {}", result);
        return result;
    }

    public static ITestStepContainer getTestStepContainerParent(Object node) {
        logger.debug("Entering getTestStepContainerParent for node: {}", node);
        ITestStepContainer result = getAncestor(node, ITestStepContainer.class);
        logger.debug("Exiting getTestStepContainerParent with result: {}", result);
        return result;
    }

    public static ITestSuite getTestSuiteParent(Object node) {
        logger.debug("Entering getTestSuiteParent for node: {}", node);
        ITestSuite result = getAncestor(node, ITestSuite.class);
        logger.debug("Exiting getTestSuiteParent with result: {}", result);
        return result;
    }

    public static ITestDocument getTestDocumentParent(Object node) {
        logger.debug("Entering getTestDocumentParent for node: {}", node);
        ITestDocument result = getAncestor(node, ITestDocument.class);
        logger.debug("Exiting getTestDocumentParent with result: {}", result);
        return result;
    }

    public static ITestStep getTestStepParent(Object node) {
        logger.debug("Entering getTestStepParent for node: {}", node);
        ITestStep result = getAncestor(node, ITestStep.class);
        logger.debug("Exiting getTestStepParent with result: {}", result);
        return result;
    }

    public static ITestProject getTestProjectParent(Object node) {
        logger.debug("Entering getTestProjectParent for node: {}", node);
        ITestProject result = getAncestor(node, ITestProject.class);
        logger.debug("Exiting getTestProjectParent with result: {}", result);
        return result;
    }

    public static ITestStep getTestStep(ITestStepContainer container, String name) {
        logger.debug("Entering getTestStep for container: {}, name: {}", container, name);
        for (ITestStep ts : container.getTestStepList()) {
            if (name.contentEquals(ts.getStepObjectName() + " " + ts.getStepDefinitionName())) {
                logger.debug("Exiting getTestStep with result: {}", ts);
                return ts;
            }
        }
        logger.debug("Exiting getTestStep with result: null");
        return null;
    }

    public static ITestStepContainer getTestStepContainer(ITestSuite testSuite, String name) {
        logger.debug("Entering getTestStepContainer for testSuite: {}, name: {}", testSuite, name);
        for (ITestStepContainer tsc : testSuite.getTestStepContainerList()) {
            if (tsc.getName().contentEquals(name)) {
                logger.debug("Exiting getTestStepContainer with result: {}", tsc);
                return tsc;
            }
        }
        logger.debug("Exiting getTestStepContainer with result: null");
        return null;
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
        if (theTestStep != null && getTestStepContainerParent(theTestStep) != null) {
            ITestStepContainer currentContainer = getTestStepContainerParent(theTestStep);

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
                ITestSuite suite = getTestSuiteParent(currentContainer);
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

    /**
     * Returns all TestSuites from a project's unified TestDocumentList.
     *
     * @param project the test project to filter
     * @return list of ITestSuite instances from the project's document list
     */
    public static List<ITestSuite> getTestSuiteList(ITestProject project) {
        List<ITestSuite> result = new ArrayList<>();
        for (ITestDocument doc : project.getTestDocumentList()) {
            if (doc instanceof ITestSuite) {
                result.add((ITestSuite) doc);
            }
        }
        return result;
    }
}
