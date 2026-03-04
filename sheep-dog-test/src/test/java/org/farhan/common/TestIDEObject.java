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
                testProject.addTestDocument((IStepObject) p.getValue());
            } else {
                if (cursor instanceof ICell) {
                    ((ICell) cursor).setName(p.getValue().toString());
                } else if (cursor instanceof ITestSuite) {
                    ((ITestSuite) cursor).setName(p.getValue().toString());
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
        case "TestSuiteList":
            return ((ITestProject) parent).getTestSuite(index);
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
            case "TestSuiteList":
                return SheepDogBuilder.createTestSuite((ITestProject) parent, "Test Suite");
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

    protected void addCellWithName(String name) {
        if (cursor instanceof ICell) {
            cursor = ((ICell) cursor).getParent();
        }
        cursor = SheepDogBuilder.createCell((IRow) cursor, name);
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

    protected void addTestSuiteWithName(String testSuiteName) {
        if (cursor instanceof ITestSuite) {
            cursor = ((ITestSuite) cursor).getParent();
        }
        cursor = SheepDogBuilder.createTestSuite(testProject, testSuiteName);
    }

    protected void addTextWithContent(String content) {
        cursor = SheepDogBuilder.createText((ITestStep) cursor, content);
    }

    protected void assertCellName(String name) {
        if (cursor instanceof ICell) {
            if (getNode(properties.get("part").toString()) instanceof ICell) {
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

    protected void assertLineContent(String content) {
        if (cursor instanceof ILine) {
            if (getNode(properties.get("part").toString()) instanceof ILine) {
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

    protected void assertStepDefinitionListEmpty(String state) {
        Assertions.assertTrue(((IStepObject) cursor).getStepDefinitionList().isEmpty());
    }

    protected void assertStepDefinitionName(String name) {
        if (cursor instanceof IStepDefinition) {
            if (getNode(properties.get("part").toString()) instanceof IStepDefinition) {
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

    protected void assertStepObjectFullName(String name) {
        if (cursor instanceof IStepObject) {
            if (getNode(properties.get("part").toString()) instanceof IStepObject) {
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

    protected void assertStepParametersName(String name) {
        if (cursor instanceof IStepParameters) {
            if (getNode(properties.get("part").toString()) instanceof IStepParameters) {
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

    protected void assertTestStepContainerName(String name) {
        if (cursor instanceof ITestStepContainer) {
            if (getNode(properties.get("part").toString()) instanceof ITestStepContainer) {
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

    protected void assertTestSuiteName(String name) {
        if (cursor instanceof ITestSuite) {
            if (getNode(properties.get("part").toString()) instanceof ITestSuite) {
                Assertions.assertEquals(name, ((ITestSuite) cursor).getName());
            } else {
                cursor = ((ITestSuite) cursor).getParent();
                cursor = ((ITestProject) cursor).getTestSuite(name);
                Assertions.assertNotNull(cursor);
            }
        } else {
            cursor = ((ITestProject) cursor).getTestSuite(name);
            Assertions.assertNotNull(cursor);
        }
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
                } else {
                    table = ((IStepParameters) current).getTable();
                }
                if (table == null) {
                    if (current instanceof ITestStep) {
                        current = SheepDogBuilder.createTable((ITestStep) current);
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
                current = getOrCreateNode(current, elementType, index);
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

        Object part = properties.get("part");
        if (part != null) {
            if (operation.contentEquals("set")) {
                createStepDependencies(part.toString());
            } else if (operation.contentEquals("assert")) {
                setCursor(part.toString());
            }
        }

        super.processInputOutputs(dataTable, operation, sectionName);
    }

    protected void processInputOutputs(String key, String value, String operation, String sectionName) {

        Object part = properties.get("part");
        if (part != null) {
            if (operation.contentEquals("set")) {
                createStepDependencies(part.toString());
            } else if (operation.contentEquals("assert")) {
                setCursor(part.toString());
            }
        }

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

    // TODO this needs to be changed to Table/RowList/Cell style of building
    protected void setStepDefinitionDescription(String content) {
        IDescription description = SheepDogBuilder.createDescription((IStepDefinition) cursor);
        SheepDogBuilder.createLine(description, content);
    }

    // TODO this needs to be changed to Table/RowList/Cell style of building
    protected void setStepObjectDescription(String content) {
        IDescription description = SheepDogBuilder.createDescription((IStepObject) cursor);
        SheepDogBuilder.createLine(description, content);
    }

    // TODO this needs to be changed to Table/RowList/Cell style of building
    protected void setStepParametersDescription(String name) {
        INestedDescription nestedDescription = SheepDogBuilder.createNestedDescription((IStepParameters) cursor);
        SheepDogBuilder.createLine(nestedDescription, name);
    }
}
