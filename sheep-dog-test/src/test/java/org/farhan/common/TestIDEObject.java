package org.farhan.common;

import java.util.ArrayList;
import java.util.List;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.impl.ide.CellImpl;
import org.farhan.impl.ide.RowImpl;

public class TestIDEObject extends TestObject {

    public static ITestProject testProject;
    public static Object focus;
    public static String selectedElement;

    public static ArrayList<SheepDogIssueProposal> listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
    public static ArrayList<SheepDogIssueProposal> listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
    public static String validateDialog = "";

    public static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
        for (SheepDogIssueProposal p : proposals) {
            if (p.getValue() instanceof IStepObject) {
                testProject.addStepObject((IStepObject) p.getValue());
            } else {
                if (focus instanceof ICell) {
                    ((ICell) focus).setName(p.getValue().toString());
                } else if (focus instanceof ITestSuite) {
                    ((ITestSuite) focus).setName(p.getValue().toString());
                } else if (focus instanceof ITestStepContainer) {
                    ((ITestStepContainer) focus).setName(p.getValue().toString());
                }
            }
        }
    }

    public static void reset() {
        testProject = SheepDogBuilder.createTestProject();
        focus = testProject;
        selectedElement = null;
        validateDialog = "";
        listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
        listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
    }

    public void addCell(String name) {
        RowImpl row;
        if (focus instanceof IRow) {
            row = (RowImpl) focus;
        } else {
            row = (RowImpl) ((CellImpl) focus).getParent();
        }
        focus = SheepDogBuilder.createCell(row, name);
    }

    public void addRow() {
        focus = SheepDogBuilder.createRow((ITable) focus);
    }

    public void addTable() {
        focus = SheepDogBuilder.createTable((ITestStep) focus);
    }

    public void addTestCaseStep(String stepName) {
        addTestStepContainer("Test Case");

        List<ITestStep> testStepList = ((ITestStepContainer) focus).getTestStepList();
        if (!testStepList.isEmpty()) {
            ITestStep testStep = testStepList.getLast();
            if (stepName.contentEquals(testStep.getStepObjectName() + " " + testStep.getStepDefinitionName())) {
                focus = testStep;
                return;
            }
        }
        focus = SheepDogBuilder.createTestStep((ITestStepContainer) focus, stepName);
    }

    public void addTestSetupStep(String stepName) {
        addTestStepContainer("Background");
        focus = SheepDogBuilder.createTestStep((ITestStepContainer) focus, stepName);
    }

    public void addTestStepContainer(String testStepContainerName) {
        // TODO find the last applicable parent and use that instead of this basic
        // check. Revisit this when adding grammar proposal tests
        if (!(focus instanceof ITestSuite))
            addTestSuite("Test Suite");
        if (testStepContainerName.contentEquals("Background")) {
            focus = SheepDogBuilder.createTestSetup((ITestSuite) focus, testStepContainerName);
        } else {
            focus = SheepDogBuilder.createTestCase((ITestSuite) focus, testStepContainerName);
        }
    }

    public void addTestSuite(String testSuiteName) {
        focus = SheepDogBuilder.createTestSuite(testProject, testSuiteName);
    }

    public void addText(String name) {
        focus = SheepDogBuilder.createText((ITestStep) focus, name);
    }

    public void setSelectedElement(String path) {
        selectedElement = path;
        String[] parts = path.split("/");
        Object current = testProject;

        int i = 0;
        while (i < parts.length && current != null) {
            String elementType = parts[i];

            // Table and Text don't have indices in the path
            if (elementType.equals("Table")) {
                current = ((ITestStep) current).getTable();
                i++;
            } else if (elementType.equals("Text")) {
                current = ((ITestStep) current).getText();
                i++;
            } else {
                // All other elements have indices
                if (i + 1 >= parts.length) {
                    throw new IllegalArgumentException("Missing index for element type: " + elementType);
                }
                int index = Integer.parseInt(parts[i + 1]) - 1; // Convert from 1-based to 0-based

                if (elementType.equals("TestSuite")) {
                    current = ((ITestProject) current).getTestSuite(index);
                } else if (elementType.equals("TestStepContainer")) {
                    current = ((ITestSuite) current).getTestStepContainer(index);
                } else if (elementType.equals("TestStep")) {
                    current = ((ITestStepContainer) current).getTestStep(index);
                } else if (elementType.equals("Row")) {
                    current = ((ITable) current).getRow(index);
                } else if (elementType.equals("Cell")) {
                    current = ((IRow) current).getCell(index);
                } else {
                    throw new IllegalArgumentException("Unknown element type: " + elementType);
                }
                i += 2; // Skip elementType and index
            }
            if (current != null)
                focus = current;
        }

    }

    /**
     * Gets an object of the specified type from the current selectedElement path.
     *
     * @param elementType The type to retrieve (e.g., "TestStep", "Row", "Cell",
     *                    "Table", "Text", "TestSuite", "TestStepContainer")
     * @return The object of the specified type, or null if not found in the path
     * @throws IllegalArgumentException if the element type is not found in
     *                                  selectedElement or is invalid
     */
    public static Object getElementByType(String elementType) {
        if (selectedElement == null || selectedElement.isEmpty()) {
            throw new IllegalArgumentException("selectedElement is null or empty");
        }

        // Check if the element type exists in the path
        if (!selectedElement.contains(elementType + "/") && !selectedElement.endsWith(elementType)) {
            throw new IllegalArgumentException(
                    "Element type '" + elementType + "' not found in selectedElement: " + selectedElement);
        }

        String[] parts = selectedElement.split("/");
        Object current = testProject;

        int i = 0;
        while (i < parts.length && current != null) {
            String currentType = parts[i];

            // Table and Text don't have indices in the path
            if (currentType.equals("Table")) {
                current = ((ITestStep) current).getTable();
                if (currentType.equals(elementType)) {
                    return current;
                }
                i++;
            } else if (currentType.equals("Text")) {
                current = ((ITestStep) current).getText();
                if (currentType.equals(elementType)) {
                    return current;
                }
                i++;
            } else {
                // All other elements have indices
                if (i + 1 >= parts.length) {
                    throw new IllegalArgumentException("Missing index for element type: " + currentType);
                }
                int index = Integer.parseInt(parts[i + 1]) - 1; // Convert from 1-based to 0-based

                if (currentType.equals("TestSuite")) {
                    current = ((ITestProject) current).getTestSuite(index);
                } else if (currentType.equals("TestStepContainer")) {
                    current = ((ITestSuite) current).getTestStepContainer(index);
                } else if (currentType.equals("TestStep")) {
                    current = ((ITestStepContainer) current).getTestStep(index);
                } else if (currentType.equals("Row")) {
                    current = ((ITable) current).getRow(index);
                } else if (currentType.equals("Cell")) {
                    current = ((IRow) current).getCell(index);
                } else {
                    throw new IllegalArgumentException("Unknown element type: " + currentType);
                }

                // Return if we've reached the desired type
                if (currentType.equals(elementType)) {
                    return current;
                }

                i += 2; // Skip elementType and index
            }
        }

        return null;
    }
}
