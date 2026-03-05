package org.farhan.common;

import java.util.ArrayList;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.INestedDescription;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;

public class TestIDEObject extends TestObject {

    public static ITestProject testProject;
    public static Object cursor;
    public static ArrayList<SheepDogIssueProposal> listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
    public static ArrayList<SheepDogIssueProposal> listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
    public static String validateDialog = "";

    public static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
        for (SheepDogIssueProposal p : proposals) {
            if (p.getValue() instanceof IStepObject) {
                testProject.addStepObject((IStepObject) p.getValue());
            } else {
                if (cursor instanceof ICell) {
                    ((ICell) cursor).setName(p.getValue().toString());
                } else if (cursor instanceof ITestSuite) {
                    ((ITestSuite) cursor).setFullName(p.getValue().toString());
                } else if (cursor instanceof ITestStepContainer) {
                    ((ITestStepContainer) cursor).setName(p.getValue().toString());
                }
            }
        }
    }

    public static void reset() {
        testProject = SheepDogBuilder.createTestProject();
        cursor = testProject;
        validateDialog = "";
        listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
        listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
    }

    private Object getChildNode(Object parent, String elementType, int index) {
        switch (elementType) {
        case "TestStepContainerList":
            return ((ITestSuite) parent).getTestStepContainer(index);
        case "TestStepList":
            return ((ITestStepContainer) parent).getTestStep(index);
        case "RowList":
            return ((ITable) parent).getRow(index);
        case "CellList":
            return ((IRow) parent).getCell(index);
        case "TestDocumentList":
            return ((ITestProject) parent).getTestDocument(index);
        case "StepDefinitionList":
            return ((IStepObject) parent).getStepDefinition(index);
        case "StepParametersList":
            return ((IStepDefinition) parent).getStepParameters(index);
        case "LineList":
            if (parent instanceof IDescription) {
                return ((IDescription) parent).getLine(index);
            } else {
                return ((INestedDescription) parent).getLine(index);
            }
        case "TestDataList":
            return ((ITestCase) parent).getTestData(index);
        default:
            throw new IllegalArgumentException("Unknown element type: " + elementType);
        }
    }

    private Object getOrCreateNode(Object parent, String elementType, int index) {
        try {
            return getChildNode(parent, elementType, index);
        } catch (IndexOutOfBoundsException e) {
            switch (elementType) {
            case "TestStepContainerList":
                return SheepDogBuilder.createTestCase((ITestSuite) parent, "Test Case");
            case "TestStepList":
                return SheepDogBuilder.createTestStep((ITestStepContainer) parent, "");
            case "RowList":
                return SheepDogBuilder.createRow((ITable) parent);
            case "CellList":
                return SheepDogBuilder.createCell((IRow) parent, "");
            case "TestDocumentList":
                return SheepDogBuilder.createStepObject((ITestProject) parent, "");
            case "StepDefinitionList":
                return SheepDogBuilder.createStepDefinition((IStepObject) parent, "");
            case "StepParametersList":
                return SheepDogBuilder.createStepParameters((IStepDefinition) parent, "");
            case "LineList":
                if (parent instanceof IDescription) {
                    return SheepDogBuilder.createLine((IDescription) parent, "");
                } else {
                    return SheepDogBuilder.createLine((INestedDescription) parent, "");
                }
            case "TestDataList":
                return SheepDogBuilder.createTestData((ITestCase) parent, "");
            default:
                throw new IllegalArgumentException("Unknown element type: " + elementType);
            }
        }
    }

    protected void addAndWithStepObjectName(String stepObjectName) {
        if (cursor instanceof ITestStep) {
            cursor = ((ITestStep) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepObjectName);
    }

    protected void addCellWithName(String name) {
        if (cursor instanceof ICell) {
            cursor = ((ICell) cursor).getParent();
        }
        cursor = SheepDogBuilder.createCell((IRow) cursor, name);
    }

    protected void addGivenWithStepObjectName(String stepObjectName) {
        if (cursor instanceof ITestStep) {
            cursor = ((ITestStep) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepObjectName);
    }

    protected void addLineWithContent(String content) {
        if (cursor instanceof ILine) {
            cursor = ((ILine) cursor).getParent();
        }
        if (cursor instanceof IDescription) {
            cursor = SheepDogBuilder.createLine((IDescription) cursor, content);
        } else {
            cursor = SheepDogBuilder.createLine((INestedDescription) cursor, content);
        }
    }

    protected void addRowWithContent(String content) {
        if (cursor instanceof IRow) {
            cursor = ((IRow) cursor).getParent();
        }
        IRow row = SheepDogBuilder.createRow((ITable) cursor);
        SheepDogBuilder.createCell(row, content);
        cursor = row;
    }

    protected void addStepDefinitionWithName(String name) {
        if (cursor instanceof IStepDefinition) {
            cursor = ((IStepDefinition) cursor).getParent();
        }
        cursor = SheepDogBuilder.createStepDefinition((IStepObject) cursor, name);
    }

    protected void addStepObjectWithFullName(String stepObjectName) {
        if (cursor instanceof IStepObject) {
            cursor = ((IStepObject) cursor).getParent();
        }
        cursor = SheepDogBuilder.createStepObject(testProject, stepObjectName);
    }

    protected void addStepParametersWithName(String name) {

        if (cursor instanceof IStepParameters) {
            cursor = ((IStepParameters) cursor).getParent();
        }
        cursor = SheepDogBuilder.createStepParameters((IStepDefinition) cursor, name);
    }

    protected void addTestCaseWithName(String testStepContainerName) {
        if (cursor instanceof ITestCase) {
            cursor = ((ITestCase) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestCase((ITestSuite) cursor, testStepContainerName);
    }

    protected void addTestDataWithName(String name) {
        if (cursor instanceof ITestData) {
            cursor = ((ITestData) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestData((ITestCase) cursor, name);
    }

    protected void addTestSetupWithName(String testSetupName) {
        if (cursor instanceof ITestStepContainer) {
            cursor = ((ITestStepContainer) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestSetup((ITestSuite) cursor, testSetupName);
    }

    protected void addTestStepWithFullName(String stepName) {
        if (cursor instanceof ITestStep) {
            cursor = ((ITestStep) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepName);
    }

    protected void addTestSuiteWithFullName(String testSuiteFullName) {
        if (cursor instanceof ITestSuite) {
            cursor = ((ITestSuite) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestSuite(testProject, testSuiteFullName);
    }

    protected void addTextWithContent(String content) {
        cursor = SheepDogBuilder.createText((ITestStep) cursor, content);
    }

    protected void addThenWithStepObjectName(String stepObjectName) {
        if (cursor instanceof ITestStep) {
            cursor = ((ITestStep) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepObjectName);
    }

    protected void addWhenWithStepObjectName(String stepObjectName) {
        if (cursor instanceof ITestStep) {
            cursor = ((ITestStep) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepObjectName);
    }

    protected void assertCellName(String name, String nodePath) {
        if (cursor instanceof ICell) {
            if (getNode(nodePath) instanceof ICell) {
                Assertions.assertEquals(name, ((ICell) cursor).getName());
            } else {
                cursor = ((ICell) cursor).getParent();
                cursor = ((IRow) cursor).getCell(name);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((IRow) cursor).getCell(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertDescriptionEmpty(String replaceKeyword) {
        Assertions.assertTrue(((IDescription) cursor).getLineList().isEmpty());
    }

    protected void assertLineContent(String content, String nodePath) {
        if (cursor instanceof ILine) {
            if (getNode(nodePath) instanceof ILine) {
                Assertions.assertEquals(content, ((ILine) cursor).getName());
            } else {
                cursor = ((ILine) cursor).getParent();
                if (cursor instanceof IDescription) {
                    cursor = ((IDescription) cursor).getLine(content);
                } else {
                    cursor = ((INestedDescription) cursor).getLine(content);
                }
                Assertions.assertNotNull(cursor);
            }
        } else {
            if (cursor instanceof IDescription) {
                cursor = ((IDescription) cursor).getLine(content);
            } else {
                cursor = ((INestedDescription) cursor).getLine(content);
            }
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertNestedDescriptionEmpty(String state) {
        Assertions.assertTrue(((INestedDescription) cursor).getLineList().isEmpty());
    }

    protected void assertRowContent(String content) {
        cursor = ((IRow) cursor).getCell(content);
        Assertions.assertNotNull(cursor);
    }

    protected void assertStepDefinitionListEmpty(String state) {
        Assertions.assertTrue(((IStepObject) cursor).getStepDefinitionList().isEmpty());
    }

    protected void assertStepDefinitionName(String name, String nodePath) {
        if (cursor instanceof IStepDefinition) {
            if (getNode(nodePath) instanceof IStepDefinition) {
                Assertions.assertEquals(name, ((IStepDefinition) cursor).getName());
            } else {
                cursor = ((IStepDefinition) cursor).getParent();
                cursor = ((IStepObject) cursor).getStepDefinition(name);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((IStepObject) cursor).getStepDefinition(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertStepObjectFullName(String name, String nodePath) {
        if (cursor instanceof IStepObject) {
            if (getNode(nodePath) instanceof IStepObject) {
                Assertions.assertEquals(name, ((IStepObject) cursor).getFullName());
            } else {
                cursor = ((IStepObject) cursor).getParent();
                cursor = ((ITestProject) cursor).getTestDocument(name);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((ITestProject) cursor).getTestDocument(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertStepObjectName(String name) {
        Assertions.assertEquals(name, ((IStepObject) cursor).getName());
    }

    protected void assertStepParametersListEmpty(String state) {
        Assertions.assertTrue(((IStepDefinition) cursor).getStepParameterList().isEmpty());
    }

    protected void assertStepParametersName(String name, String nodePath) {
        if (cursor instanceof IStepParameters) {
            if (getNode(nodePath) instanceof IStepParameters) {
                Assertions.assertEquals(name, ((IStepParameters) cursor).getName());
            } else {
                cursor = ((IStepParameters) cursor).getParent();
                cursor = ((IStepDefinition) cursor).getStepParameters(name);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((IStepDefinition) cursor).getStepParameters(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestDataListEmpty(String state) {
        Assertions.assertTrue(((ITestCase) cursor).getTestDataList().isEmpty());
    }

    protected void assertTestDataName(String name, String nodePath) {
        if (cursor instanceof ITestData) {
            if (getNode(nodePath) instanceof ITestData) {
                Assertions.assertEquals(name, ((ITestData) cursor).getName());
            } else {
                cursor = ((ITestData) cursor).getParent();
                cursor = ((ITestCase) cursor).getTestData(name);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((ITestCase) cursor).getTestData(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestStepContainerListEmpty(String state) {
        Assertions.assertTrue(((ITestSuite) cursor).getTestStepContainerList().isEmpty());
    }

    protected void assertTestStepContainerName(String name, String nodePath) {
        if (cursor instanceof ITestStepContainer) {
            if (getNode(nodePath) instanceof ITestStepContainer) {
                Assertions.assertEquals(name, ((ITestStepContainer) cursor).getName());
            } else {
                cursor = ((ITestStepContainer) cursor).getParent();
                cursor = ((ITestSuite) cursor).getTestStepContainer(name);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((ITestSuite) cursor).getTestStepContainer(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestStepListEmpty(String state) {
        Assertions.assertTrue(((ITestStepContainer) cursor).getTestStepList().isEmpty());
    }

    protected void assertTestStepStepDefinitionName(String name) {
        Assertions.assertEquals(name, ((ITestStep) cursor).getStepDefinitionName());
    }

    protected void assertTestStepStepObjectName(String name) {
        Assertions.assertEquals(name, ((ITestStep) cursor).getStepObjectName());
    }

    protected void assertTestSuiteFullName(String fullName, String nodePath) {
        if (cursor instanceof ITestSuite) {
            if (getNode(nodePath) instanceof ITestSuite) {
                Assertions.assertEquals(fullName, ((ITestSuite) cursor).getFullName());
            } else {
                cursor = ((ITestSuite) cursor).getParent();
                cursor = ((ITestProject) cursor).getTestDocument(fullName);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((ITestProject) cursor).getTestDocument(fullName);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestSuiteName(String name) {
        Assertions.assertEquals(name, ((ITestSuite) cursor).getName());
    }

    protected void createStepDependencies(String part) {
        String[] parts = part.split("/");
        Object current = testProject;
        int i = 0;
        if (parts.length > 0 && parts[0].equals("TestProject")) {
            i = 1;
        }

        while (i < parts.length) {
            String elementType = parts[i];

            if (elementType.equals("Table")) {
                ITable table;
                if (current instanceof ITestStep) {
                    table = ((ITestStep) current).getTable();
                } else if (current instanceof ITestData) {
                    table = ((ITestData) current).getTable();
                } else {
                    table = ((IStepParameters) current).getTable();
                }
                if (table == null) {
                    if (current instanceof ITestStep) {
                        current = SheepDogBuilder.createTable((ITestStep) current);
                    } else if (current instanceof ITestData) {
                        current = SheepDogBuilder.createTable((ITestData) current);
                    } else {
                        current = SheepDogBuilder.createTable((IStepParameters) current);
                    }
                } else {
                    current = table;
                }
                i++;
            } else if (elementType.equals("Description")) {
                if (current instanceof ITestSuite) {
                    IDescription desc = ((ITestSuite) current).getDescription();
                    current = desc != null ? desc : SheepDogBuilder.createDescription((ITestSuite) current);
                } else if (current instanceof ITestStepContainer) {
                    IDescription desc = ((ITestStepContainer) current).getDescription();
                    current = desc != null ? desc : SheepDogBuilder.createDescription((ITestStepContainer) current);
                } else if (current instanceof IStepObject) {
                    IDescription desc = ((IStepObject) current).getDescription();
                    current = desc != null ? desc : SheepDogBuilder.createDescription((IStepObject) current);
                } else {
                    IDescription desc = ((IStepDefinition) current).getDescription();
                    current = desc != null ? desc : SheepDogBuilder.createDescription((IStepDefinition) current);
                }
                i++;
            } else if (elementType.equals("NestedDescription")) {
                if (current instanceof IStepParameters) {
                    INestedDescription nd = ((IStepParameters) current).getNestedDescription();
                    current = nd != null ? nd : SheepDogBuilder.createNestedDescription((IStepParameters) current);
                } else {
                    INestedDescription nd = ((ITestData) current).getNestedDescription();
                    current = nd != null ? nd : SheepDogBuilder.createNestedDescription((ITestData) current);
                }
                i++;
            } else if (elementType.equals("Text") || elementType.equals("CellList")) {
                break;
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                if (elementType.equals("TestDocumentList") && i + 2 < parts.length
                        && parts[i + 2].equals("TestStepContainerList")) {
                    Object doc = null;
                    try {
                        doc = getChildNode(current, elementType, index);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    if (doc instanceof ITestSuite) {
                        current = doc;
                    } else {
                        current = SheepDogBuilder.createTestSuite((ITestProject) current, "");
                    }
                } else if (elementType.equals("TestDocumentList") && i + 2 < parts.length
                        && parts[i + 2].equals("StepDefinitionList")) {
                    Object doc = null;
                    try {
                        doc = getChildNode(current, elementType, index);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    if (doc instanceof IStepObject) {
                        current = doc;
                    } else {
                        current = SheepDogBuilder.createStepObject((ITestProject) current, "");
                    }
                } else if (elementType.equals("TestStepContainerList") && i + 2 < parts.length
                        && parts[i + 2].equals("TestDataList")) {
                    Object container = null;
                    try {
                        container = getChildNode(current, elementType, index);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    if (container instanceof ITestCase) {
                        current = container;
                    } else {
                        current = SheepDogBuilder.createTestCase((ITestSuite) current, "Test Case");
                    }
                } else {
                    current = getOrCreateNode(current, elementType, index);
                }
                i += 2;
            }
        }

        cursor = current;
    }

    protected Object getNode(String path) {
        String[] parts = path.split("/");
        Object current = testProject;

        int i = 0;
        if (parts.length > 0 && parts[0].equals("TestProject")) {
            i = 1;
        }
        while (i < parts.length && current != null) {
            String elementType = parts[i];

            if (elementType.equals("Table")) {
                if (current instanceof ITestStep) {
                    current = ((ITestStep) current).getTable();
                } else if (current instanceof ITestData) {
                    current = ((ITestData) current).getTable();
                } else {
                    current = ((IStepParameters) current).getTable();
                }
                i++;
            } else if (elementType.equals("Text")) {
                current = ((ITestStep) current).getText();
                i++;
            } else if (elementType.equals("Description")) {
                if (current instanceof ITestSuite) {
                    current = ((ITestSuite) current).getDescription();
                } else if (current instanceof ITestStepContainer) {
                    current = ((ITestStepContainer) current).getDescription();
                } else if (current instanceof IStepObject) {
                    current = ((IStepObject) current).getDescription();
                } else {
                    current = ((IStepDefinition) current).getDescription();
                }
                i++;
            } else if (elementType.equals("NestedDescription")) {
                if (current instanceof IStepParameters) {
                    current = ((IStepParameters) current).getNestedDescription();
                } else {
                    current = ((ITestData) current).getNestedDescription();
                }
                i++;
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                current = getChildNode(current, elementType, index);
                i += 2;
            }
        }

        return current;
    }

    protected void processInputOutputs(DataTable dataTable, String operation, String sectionName) {
        super.processInputOutputs(dataTable, operation, sectionName);
    }

    protected void processInputOutputs(String key, String value, String operation, String sectionName) {
        super.processInputOutputs(key, value, operation, sectionName);
    }

    protected void setCursor(String path) {
        String[] parts = path.split("/");
        Object current = testProject;

        int i = 0;
        if (parts.length > 0 && parts[0].equals("TestProject")) {
            i = 1;
        }
        while (i < parts.length && current != null) {
            String elementType = parts[i];

            // Table and Text don't have indices in the path
            if (elementType.equals("Table")) {
                if (current instanceof ITestStep) {
                    current = ((ITestStep) current).getTable();
                } else if (current instanceof ITestData) {
                    current = ((ITestData) current).getTable();
                } else {
                    current = ((IStepParameters) current).getTable();
                }
                i++;
            } else if (elementType.equals("Text")) {
                current = ((ITestStep) current).getText();
                i++;
            } else if (elementType.equals("Description")) {
                if (current instanceof ITestSuite) {
                    current = ((ITestSuite) current).getDescription();
                } else if (current instanceof ITestStepContainer) {
                    current = ((ITestStepContainer) current).getDescription();
                } else if (current instanceof IStepObject) {
                    current = ((IStepObject) current).getDescription();
                } else {
                    current = ((IStepDefinition) current).getDescription();
                }
                i++;
            } else if (elementType.equals("NestedDescription")) {
                if (current instanceof IStepParameters) {
                    current = ((IStepParameters) current).getNestedDescription();
                } else {
                    current = ((ITestData) current).getNestedDescription();
                }
                i++;
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                current = getChildNode(current, elementType, index);
                i += 2;
            }
            if (current != null)
                cursor = current;
        }

    }

    protected void setTestStepDefinitionName(String name) {
        ((ITestStep) cursor).setStepDefinitionName(name);
    }

    protected void setTestSuiteName(String name) {
        if (cursor instanceof ITestSuite) {
            ((ITestSuite) cursor).setName(name);
        }
    }

}
