package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.INestedDescription;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.junit.jupiter.api.Assertions;

public class TestIDEObject extends TestObject {

    public static ITestProject testProject;
    public static Object focus;
    public static String selectedNode;

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
        selectedNode = null;
        validateDialog = "";
        listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
        listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
    }

    @Override
    protected void setSelectedNode(String path) {
        selectedNode = path;
        String[] parts = path.split("/");
        Object current = testProject;

        int i = 0;
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
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                current = getChildNode(current, elementType, index);
                i += 2;
            }
            if (current != null)
                focus = current;
        }

    }

    private Object getChildNode(Object parent, String elementType, int index) {
        switch (elementType) {
        case "TestSuiteList":
            return ((ITestProject) parent).getTestSuite(index);
        case "TestCaseList":
        case "TestSetupList":
            return ((ITestSuite) parent).getTestStepContainer(index);
        case "TestStepList":
            return ((ITestStepContainer) parent).getTestStep(index);
        case "RowList":
            return ((ITable) parent).getRow(index);
        case "CellList":
            return ((IRow) parent).getCell(index);
        case "StepObjectList":
            return ((ITestProject) parent).getStepObject(index);
        case "StepDefinitionList":
            return ((IStepObject) parent).getStepDefinition(index);
        case "StepParametersList":
            return ((IStepDefinition) parent).getStepParameters(index);
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
            case "TestCaseList":
                return SheepDogBuilder.createTestCase((ITestSuite) parent, "Test Case");
            case "TestSetupList":
                return SheepDogBuilder.createTestSetup((ITestSuite) parent, "Background");
            case "TestStepList":
                return SheepDogBuilder.createTestStep((ITestStepContainer) parent, "");
            case "RowList":
                return SheepDogBuilder.createRow((ITable) parent);
            case "CellList":
                return SheepDogBuilder.createCell((IRow) parent, "");
            case "StepObjectList":
                return SheepDogBuilder.createStepObject((ITestProject) parent, "");
            case "StepDefinitionList":
                return SheepDogBuilder.createStepDefinition((IStepObject) parent, "");
            case "StepParametersList":
                return SheepDogBuilder.createStepParameters((IStepDefinition) parent, "");
            default:
                throw new IllegalArgumentException("Unknown element type: " + elementType);
            }
        }
    }

    protected void assertCellByName(String name) {
        if (focus instanceof ICell) {
            focus = ((ICell) focus).getParent();
        }
        focus = ((IRow) focus).getCell(name);
        Assertions.assertNotNull(focus);
    }

    protected void assertStepDefinitionByName(String name) {
        if (focus instanceof IStepDefinition) {
            focus = ((IStepDefinition) focus).getParent();
        }
        focus = ((IStepObject) focus).getStepDefinition(name);
        Assertions.assertNotNull(focus);
    }

    protected void assertStepObjectByName(String name) {
        if (focus instanceof IStepObject) {
            focus = ((IStepObject) focus).getParent();
        }
        focus = ((ITestProject) focus).getStepObject(name);
        Assertions.assertNotNull(focus);
    }

    protected void assertStepParametersByName(String name) {
        if (focus instanceof IStepParameters) {
            focus = ((IStepParameters) focus).getParent();
        }
        focus = ((IStepDefinition) focus).getStepParameters(name);
        Assertions.assertNotNull(focus);
    }

    protected void assertTestStepContainerByName(String name) {
        if (focus instanceof ITestStepContainer) {
            focus = ((ITestStepContainer) focus).getParent();
        }
        focus = ((ITestSuite) focus).getTestStepContainer(name);
        Assertions.assertNotNull(focus);
    }

    protected void assertTestSuiteByName(String name) {
        if (focus instanceof ITestSuite) {
            focus = ((ITestSuite) focus).getParent();
        }
        focus = ((ITestProject) focus).getTestSuite(name);
        Assertions.assertNotNull(focus);
    }

    protected void addCellWithName(String name) {
        if (focus instanceof ICell) {
            focus = ((ICell) focus).getParent();
        }
        focus = SheepDogBuilder.createCell((IRow) focus, name);
    }

    protected void addStepDefinitionWithName(String name) {
        if (focus instanceof IStepDefinition) {
            focus = ((IStepDefinition) focus).getParent();
        }
        focus = SheepDogBuilder.createStepDefinition((IStepObject) focus, name);
    }

    protected void addStepObjectWithName(String stepObjectName) {
        if (focus instanceof IStepObject) {
            focus = ((IStepObject) focus).getParent();
        }
        focus = SheepDogBuilder.createStepObject(testProject, stepObjectName);
    }

    protected void addStepParametersWithName(String name) {

        if (focus instanceof IStepParameters) {
            focus = ((IStepParameters) focus).getParent();
        }
        focus = SheepDogBuilder.createStepParameters((IStepDefinition) focus, name);
    }

    protected void addTestCaseWithName(String testStepContainerName) {
        if (focus instanceof ITestCase) {
            focus = ((ITestCase) focus).getParent();
        }
        focus = SheepDogBuilder.createTestCase((ITestSuite) focus, testStepContainerName);
    }

    protected void addTestStepWithFullName(String stepName) {
        if (focus instanceof ITestStep) {
            focus = ((ITestStep) focus).getParent();
        }
        focus = SheepDogBuilder.createTestStep((ITestStepContainer) focus, stepName);
    }

    protected void addTestSuiteWithName(String testSuiteName) {
        if (focus instanceof ITestSuite) {
            focus = ((ITestSuite) focus).getParent();
        }
        focus = SheepDogBuilder.createTestSuite(testProject, testSuiteName);
    }

    protected void addTextWithContent(String content) {
        focus = SheepDogBuilder.createText((ITestStep) focus, content);
    }

    @Override
    protected void createStepDependencies(String part) {
        selectedNode = part;
        String[] parts = part.split("/");
        Object current = testProject;
        int i = 0;

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

        focus = current;
    }

    protected void setStepDefinitionDescription(String name) {
        IDescription description = SheepDogBuilder.createDescription((IStepDefinition) focus);
        SheepDogBuilder.createLine(description, name);
    }

    protected void setStepParametersDescription(String name) {
        INestedDescription nestedDescription = SheepDogBuilder.createNestedDescription((IStepParameters) focus);
        SheepDogBuilder.createLine(nestedDescription, name);
    }

}
