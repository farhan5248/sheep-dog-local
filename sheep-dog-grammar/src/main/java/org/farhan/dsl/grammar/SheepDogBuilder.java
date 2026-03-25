package org.farhan.dsl.grammar;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;

/**
 * Static factory for creating and initializing grammar elements.
 * <p>
 * Separates object construction and initialization logic from factory
 * operations and grammar model definitions.
 * </p>
 */
public class SheepDogBuilder {

    // TODO Builder creates the child and adds it to the parent. It also adds
    // statement list etc. The child source type is String. Add this desc to the
    // pattern
    private static final Logger logger = SheepDogLoggerFactory.getLogger(SheepDogBuilder.class);

    private static <T> void addSorted(List<T> list, T element, java.util.function.Function<T, String> nameExtractor) {
        String name = nameExtractor.apply(element);
        int insertIndex = Collections.binarySearch(
                list.stream().map(nameExtractor).toList(), name);
        if (insertIndex < 0) {
            insertIndex = -(insertIndex + 1);
        }
        list.add(insertIndex, element);
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @param name   the name of the cell
     * @return the created and initialized instance
     */
    public static ICell createCell(IRow parent, String name) {
        logger.debug("Entering createCell for name: {}", name);
        ICell cell = SheepDogFactory.instance.createCell();
        cell.setName(name);
        if (parent != null)
            parent.getCellList().add(cell);
        logger.debug("Exiting createCell with result: {}", cell != null ? cell.getName() : "null");
        return cell;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @return the created and initialized instance
     */
    public static IDescription createDescription(IStepObject parent) {
        logger.debug("Entering createDescription for parent: {}", parent != null ? parent.getName() : "null");
        IDescription description = parent != null ? parent.getDescription() : null;
        if (description == null) {
            description = SheepDogFactory.instance.createDescription();
            if (parent != null)
                parent.setDescription(description);
        }
        logger.debug("Exiting createDescription with result: {}", description != null ? "non-null" : "null");
        return description;
    }

    public static IDescription createDescription(IStepDefinition parent) {
        logger.debug("Entering createDescription for parent: {}", parent != null ? parent.getName() : "null");
        IDescription description = parent != null ? parent.getDescription() : null;
        if (description == null) {
            description = SheepDogFactory.instance.createDescription();
            if (parent != null)
                parent.setDescription(description);
        }
        logger.debug("Exiting createDescription with result: {}", description != null ? "non-null" : "null");
        return description;
    }

    public static IDescription createDescription(ITestSuite parent) {
        logger.debug("Entering createDescription for parent: {}", parent != null ? parent.getName() : "null");
        IDescription description = parent != null ? parent.getDescription() : null;
        if (description == null) {
            description = SheepDogFactory.instance.createDescription();
            if (parent != null)
                parent.setDescription(description);
        }
        logger.debug("Exiting createDescription with result: {}", description != null ? "non-null" : "null");
        return description;
    }

    public static IDescription createDescription(ITestStepContainer parent) {
        logger.debug("Entering createDescription for parent: {}", parent != null ? parent.getName() : "null");
        IDescription description = parent != null ? parent.getDescription() : null;
        if (description == null) {
            description = SheepDogFactory.instance.createDescription();
            if (parent != null)
                parent.setDescription(description);
        }
        logger.debug("Exiting createDescription with result: {}", description != null ? "non-null" : "null");
        return description;
    }

    public static IDescription createDescription(IStepParameters parent) {
        logger.debug("Entering createDescription for parent: {}", parent != null ? parent.getName() : "null");
        IDescription description = parent != null ? parent.getDescription() : null;
        if (description == null) {
            description = SheepDogFactory.instance.createDescription();
            if (parent != null)
                parent.setDescription(description);
        }
        logger.debug("Exiting createDescription with result: {}", description != null ? "non-null" : "null");
        return description;
    }

    public static IDescription createDescription(ITestData parent) {
        logger.debug("Entering createDescription for parent: {}", parent != null ? parent.getName() : "null");
        IDescription description = parent != null ? parent.getDescription() : null;
        if (description == null) {
            description = SheepDogFactory.instance.createDescription();
            if (parent != null)
                parent.setDescription(description);
        }
        logger.debug("Exiting createDescription with result: {}", description != null ? "non-null" : "null");
        return description;
    }

    public static ITestData createTestData(ITestCase parent, String name) {
        logger.debug("Entering createTestData for name: {}", name);
        ITestData testData = null;
        if (parent != null)
            testData = SheepDogUtility.getTestData(parent, name);
        if (testData == null) {
            testData = SheepDogFactory.instance.createTestData();
            testData.setName(name);
            if (parent != null)
                parent.getTestDataList().add(testData);
        }
        logger.debug("Exiting createTestData with result: {}", testData != null ? testData.getName() : "null");
        return testData;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @param name   the name of the line
     * @return the created and initialized instance
     */
    public static ILine createLine(IDescription parent, String name) {
        logger.debug("Entering createLine for name: {}", name);
        ILine line = SheepDogFactory.instance.createLine();
        line.setContent(name);
        if (parent != null)
            parent.getLineList().add(line);
        logger.debug("Exiting createLine with result: {}", line != null ? line.getContent() : "null");
        return line;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @return the created and initialized instance
     */
    public static IRow createRow(ITable parent) {
        logger.debug("Entering createRow for parent: {}", parent != null ? "non-null" : "null");
        IRow row = SheepDogFactory.instance.createRow();
        if (parent != null)
            parent.getRowList().add(row);
        logger.debug("Exiting createRow with result: {}", row != null ? "non-null" : "null");
        return row;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @param name   the name of the step definition
     * @return the created and initialized instance
     */
    public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
        logger.debug("Entering createStepDefinition for name: {}", name);
        IStepDefinition stepDefinition = null;
        if (parent != null)
            stepDefinition = SheepDogUtility.getStepDefinition(parent, name);
        if (stepDefinition == null) {
            stepDefinition = SheepDogFactory.instance.createStepDefinition();
            stepDefinition.setName(name);
            if (parent != null)
                addSorted(parent.getStepDefinitionList(), stepDefinition, IStepDefinition::getName);
        }
        logger.debug("Exiting createStepDefinition with result: {}",
                stepDefinition != null ? stepDefinition.getName() : "null");
        return stepDefinition;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent   the parent element (or null if root)
     * @param fullName the full name of the step object
     * @return the created and initialized instance
     */
    public static IStepObject createStepObject(ITestProject parent, String fullName) {
        logger.debug("Entering createStepObject for fullName: {}", fullName);
        IStepObject stepObject = null;
        if (parent != null)
            stepObject = (IStepObject) SheepDogUtility.getTestDocument(parent, fullName);
        if (stepObject == null) {
            stepObject = SheepDogFactory.instance.createStepObject();
            stepObject.setFullName(fullName);
            String[] nameParts = fullName.split("/");
            stepObject.setName(nameParts[nameParts.length - 1].replaceAll("\\.[^.]+$", ""));
            if (parent != null)
                parent.getTestDocumentList().add(stepObject);
        }
        logger.debug("Exiting createStepObject with result: {}",
                stepObject != null ? stepObject.getFullName() : "null");
        return stepObject;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent  the parent element (or null if root)
     * @param headers the headers for the step parameters
     * @return the created and initialized instance
     */
    public static IStepParameters createStepParameters(IStepDefinition parent, String name) {
        logger.debug("Entering createStepParameters for name: {}", name);
        IStepParameters stepParameters = null;
        if (parent != null)
            stepParameters = SheepDogUtility.getStepParameters(parent, name);
        if (stepParameters == null) {
            stepParameters = SheepDogFactory.instance.createStepParameters();
            stepParameters.setName(name);
            if (parent != null)
                addSorted(parent.getStepParameterList(), stepParameters, IStepParameters::getName);
        }
        logger.debug("Exiting createStepParameters with result: {}",
                stepParameters != null ? stepParameters.getName() : "null");
        return stepParameters;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @return the created and initialized instance
     */
    public static ITable createTable(IStepParameters parent) {
        logger.debug("Entering createTable for parent: {}", parent != null ? parent.getName() : "null");
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        logger.debug("Exiting createTable with result: {}", table != null ? "non-null" : "null");
        return table;
    }

    public static ITable createTable(ITestData parent) {
        logger.debug("Entering createTable for parent: {}", parent != null ? parent.getName() : "null");
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        logger.debug("Exiting createTable with result: {}", table != null ? "non-null" : "null");
        return table;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @return the created and initialized instance
     */
    public static ITable createTable(ITestStep parent) {
        logger.debug("Entering createTable for parent: {}", parent != null ? parent.getStepObjectName() : "null");
        ITable table;
        if (parent != null) {
            if (parent.getText() != null)
                return null;
            table = parent.getTable();
            if (table == null) {
                table = SheepDogFactory.instance.createTable();
                parent.setTable(table);
            }
        } else {
            table = SheepDogFactory.instance.createTable();
        }
        logger.debug("Exiting createTable with result: {}", table != null ? "non-null" : "null");
        return table;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @param name   the name of the test case
     * @return the created and initialized instance
     */
    public static ITestCase createTestCase(ITestSuite parent, String name) {
        logger.debug("Entering createTestCase for name: {}", name);
        ITestCase testCase = (ITestCase) SheepDogUtility.getTestStepContainer(parent, name);
        if (testCase == null) {
            testCase = SheepDogFactory.instance.createTestCase();
            testCase.setName(name);
            if (parent != null)
                parent.getTestStepContainerList().add(testCase);
        }
        logger.debug("Exiting createTestCase with result: {}", testCase != null ? testCase.getName() : "null");
        return testCase;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @return the created and initialized instance
     */
    public static ITestProject createTestProject() {
        logger.debug("Entering createTestProject");
        ITestProject testProject = SheepDogFactory.instance.createTestProject();
        testProject.setFileExtension(".asciidoc");
        logger.debug("Exiting createTestProject with result: {}", testProject != null ? "non-null" : "null");
        return testProject;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @param name   the name of the test setup
     * @return the created and initialized instance
     */
    public static ITestSetup createTestSetup(ITestSuite parent, String name) {
        logger.debug("Entering createTestSetup for name: {}", name);
        ITestSetup testSetup = (ITestSetup) SheepDogUtility.getTestStepContainer(parent, name);
        if (testSetup == null) {
            testSetup = SheepDogFactory.instance.createTestSetup();
            testSetup.setName(name);
            if (parent != null) {
                int insertIndex = 0;
                for (ITestStepContainer c : parent.getTestStepContainerList()) {
                    if (c instanceof ITestSetup)
                        insertIndex++;
                    else
                        break;
                }
                parent.getTestStepContainerList().add(insertIndex, testSetup);
            }
        }
        logger.debug("Exiting createTestSetup with result: {}", testSetup != null ? testSetup.getName() : "null");
        return testSetup;
    }

    public static ITestStep createTestStep(ITestStepContainer parent, String stepObjectName,
            String stepDefinitionName) {
        logger.debug("Entering createTestStep for stepObjectName and stepDefinitionName: {} {}", stepObjectName,
                stepDefinitionName);
        ITestStep testStep = SheepDogFactory.instance.createTestStep();
        testStep.setStepObjectName(stepObjectName);
        testStep.setStepDefinitionName(stepDefinitionName);
        testStep.setFullName(stepObjectName + (stepDefinitionName.isEmpty() ? "" : " " + stepDefinitionName));
        if (parent != null)
            parent.getTestStepList().add(testStep);
        logger.debug("Exiting createTestStep with result: {}",
                testStep != null ? testStep.getStepObjectName() : "null");
        return testStep;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent   the parent element (or null if root)
     * @param fullName the full name of the test suite
     * @return the created and initialized instance
     */
    public static ITestSuite createTestSuite(ITestProject parent, String fullName) {
        logger.debug("Entering createTestSuite for fullName: {}", fullName);
        ITestSuite testSuite = (ITestSuite) SheepDogUtility.getTestDocument(parent, fullName);
        if (testSuite == null) {
            testSuite = SheepDogFactory.instance.createTestSuite();
            testSuite.setFullName(fullName);
            String[] nameParts = fullName.split("/");
            testSuite.setName(nameParts[nameParts.length - 1].replaceAll("\\.[^.]+$", ""));
            if (parent != null)
                parent.getTestDocumentList().add(testSuite);
        }
        logger.debug("Exiting createTestSuite with result: {}", testSuite != null ? testSuite.getFullName() : "null");
        return testSuite;
    }

    /**
     * Creates grammar element using factory, initializes attributes, establishes
     * parent-child relationships, and handles singleton lookups where needed.
     *
     * @param parent the parent element (or null if root)
     * @param name   the name of the text
     * @return the created and initialized instance
     */
    public static IText createText(ITestStep parent, String name) {
        logger.debug("Entering createText for name: {}", name);
        if (parent != null && parent.getTable() != null)
            return null;
        IText text = SheepDogFactory.instance.createText();
        text.setContent(name);
        if (parent != null)
            parent.setText(text);
        logger.debug("Exiting createText with result: {}", text != null ? text.getContent() : "null");
        return text;
    }

}
