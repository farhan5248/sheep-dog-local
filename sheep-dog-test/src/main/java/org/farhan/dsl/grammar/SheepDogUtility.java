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
                    ITestProject project = getTestProjectParentForTestStep(theStep);
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
     * Gets the TestProject ancestor for a Text element.
     */
    public static ITestProject getTestProjectParentForText(IText theText) {
        logger.debug("Entering getTestProjectParentForText for theText: {}",
                theText != null ? theText.getContent() : "null");
        ITestProject result = getAncestor(theText, ITestProject.class);
        logger.debug("Exiting getTestProjectParentForText with result: {}",
                result != null ? "non-null" : "null");
        return result;
    }

    /**
     * Gets the TestProject ancestor for a TestStep element.
     */
    public static ITestProject getTestProjectParentForTestStep(ITestStep theTestStep) {
        logger.debug("Entering getTestProjectParentForTestStep for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ITestProject result = getAncestor(theTestStep, ITestProject.class);
        logger.debug("Exiting getTestProjectParentForTestStep with result: {}",
                result != null ? "non-null" : "null");
        return result;
    }

    /**
     * Gets the TestProject ancestor for a Row element.
     */
    public static ITestProject getTestProjectParentForRow(IRow theRow) {
        logger.debug("Entering getTestProjectParentForRow for theRow: {}", theRow != null ? "non-null" : "null");
        ITestProject result = getAncestor(theRow, ITestProject.class);
        logger.debug("Exiting getTestProjectParentForRow with result: {}",
                result != null ? "non-null" : "null");
        return result;
    }

    // === Parent navigation utility methods ===
    // These consolidate getParent() calls, preparing for EMF cutover
    // where eContainer() replaces all typed getParent() methods.

    /**
     * Gets the parent container of any grammar node. Replaces the typed
     * getParent() calls across all interfaces with a single dispatch point.
     * In Phase 2 (EMF cutover), this becomes: return ((EObject) node).eContainer()
     */
    public static Object getParent(Object node) {
        if (node instanceof ICell) return ((ICell) node).getParent();
        if (node instanceof IRow) return ((IRow) node).getParent();
        if (node instanceof ITable) return ((ITable) node).getParent();
        if (node instanceof IText) return ((IText) node).getParent();
        if (node instanceof ILine) return ((ILine) node).getParent();
        if (node instanceof IDescription) return ((IDescription) node).getParent();
        if (node instanceof ITestStep) return ((ITestStep) node).getParent();
        if (node instanceof ITestData) return ((ITestData) node).getParent();
        if (node instanceof ITestStepContainer) return ((ITestStepContainer) node).getParent();
        if (node instanceof IStepParameters) return ((IStepParameters) node).getParent();
        if (node instanceof IStepDefinition) return ((IStepDefinition) node).getParent();
        if (node instanceof IStepObject) return ((IStepObject) node).getParent();
        if (node instanceof ITestSuite) return ((ITestSuite) node).getParent();
        return null;
    }

    /**
     * Walks up the parent chain to find the nearest ancestor of the given type.
     * In Phase 2 (EMF cutover), this becomes a loop over eContainer().
     */
    public static <T> T getAncestor(Object node, Class<T> type) {
        Object current = node;
        while (current != null) {
            if (type.isInstance(current)) {
                return (T) current;
            }
            current = getParent(current);
        }
        return null;
    }

    // === Sorted insertion utility ===
    // Extracts the binary search + insert pattern used by mock impls, preparing for EMF cutover
    // where EList.add(index, element) works the same way.

    /**
     * Inserts an element into a sorted list at the correct position using binary search.
     *
     * @param list          the sorted list to insert into
     * @param element       the element to insert
     * @param nameExtractor function to extract the sort key from elements
     * @param <T>           the element type
     */
    public static <T> void addSorted(List<T> list, T element, java.util.function.Function<T, String> nameExtractor) {
        String name = nameExtractor.apply(element);
        int insertIndex = Collections.binarySearch(
                list.stream().map(nameExtractor).toList(), name);
        if (insertIndex < 0) {
            insertIndex = -(insertIndex + 1);
        }
        list.add(insertIndex, element);
    }

    // === Lookup-by-name utility methods ===
    // These replace the get(String name) methods on interfaces, preparing for EMF cutover
    // where interfaces only expose getXxxList() and lookups must be external.

    public static ICell getCell(IRow row, String name) {
        for (ICell c : row.getCellList()) {
            if (c.getName().contentEquals(name)) {
                return c;
            }
        }
        return null;
    }

    public static ILine getLine(IDescription description, String content) {
        for (ILine l : description.getLineList()) {
            if (l.getContent().equals(content)) {
                return l;
            }
        }
        return null;
    }

    public static IStepDefinition getStepDefinition(IStepObject stepObject, String name) {
        for (IStepDefinition sd : stepObject.getStepDefinitionList()) {
            if (sd.getName().contentEquals(name)) {
                return sd;
            }
        }
        return null;
    }

    public static IStepParameters getStepParameters(IStepDefinition stepDefinition, String name) {
        for (IStepParameters sp : stepDefinition.getStepParameterList()) {
            if (name.contentEquals(sp.getName())) {
                return sp;
            }
        }
        return null;
    }

    public static ITestStepContainer getTestStepContainer(ITestSuite testSuite, String name) {
        for (ITestStepContainer tsc : testSuite.getTestStepContainerList()) {
            if (tsc.getName().contentEquals(name)) {
                return tsc;
            }
        }
        return null;
    }

    public static ITestStep getTestStep(ITestStepContainer container, String name) {
        for (ITestStep ts : container.getTestStepList()) {
            if (name.contentEquals(ts.getStepObjectName() + " " + ts.getStepDefinitionName())) {
                return ts;
            }
        }
        return null;
    }

    public static ITestData getTestData(ITestCase testCase, String name) {
        for (ITestData td : testCase.getTestDataList()) {
            if (td.getName().contentEquals(name)) {
                return td;
            }
        }
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
