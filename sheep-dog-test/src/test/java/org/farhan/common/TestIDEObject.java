package org.farhan.common;

import java.util.ArrayList;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogIssueProposal;

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
        case "TestSuite":
            return ((ITestProject) parent).getTestSuite(index);
        case "TestCase":
        case "TestSetup":
            return ((ITestSuite) parent).getTestStepContainer(index);
        case "TestStep":
            return ((ITestStepContainer) parent).getTestStep(index);
        case "Row":
            return ((ITable) parent).getRow(index);
        case "Cell":
            return ((IRow) parent).getCell(index);
        case "StepObject":
            return ((ITestProject) parent).getStepObject(index);
        case "StepDefinition":
            return ((IStepObject) parent).getStepDefinition(index);
        case "StepParameters":
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
            case "TestSuite":
                return SheepDogBuilder.createTestSuite((ITestProject) parent, "Test Suite");
            case "TestCase":
                return SheepDogBuilder.createTestCase((ITestSuite) parent, "Test Case");
            case "TestSetup":
                return SheepDogBuilder.createTestSetup((ITestSuite) parent, "Background");
            case "TestStep":
                return SheepDogBuilder.createTestStep((ITestStepContainer) parent, "");
            case "Row":
                return SheepDogBuilder.createRow((ITable) parent);
            case "Cell":
                return SheepDogBuilder.createCell((IRow) parent, "");
            case "StepObject":
                return SheepDogBuilder.createStepObject((ITestProject) parent, "");
            case "StepDefinition":
                return SheepDogBuilder.createStepDefinition((IStepObject) parent, "");
            case "StepParameters":
                return SheepDogBuilder.createStepParameters((IStepDefinition) parent, "");
            default:
                throw new IllegalArgumentException("Unknown element type: " + elementType);
            }
        }
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
            } else if (elementType.equals("Text") || elementType.equals("Cell")) {
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
        SheepDogBuilder.createLine((IStepDefinition) focus, name);
    }

    protected void setStepParametersDescription(String name) {
        SheepDogBuilder.createLine((IStepParameters) focus, name);
    }

}
