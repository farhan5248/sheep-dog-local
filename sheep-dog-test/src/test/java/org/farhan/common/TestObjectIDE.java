package org.farhan.common;

import java.util.ArrayList;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;

public class TestObjectIDE extends TestObjectDoc {

    public static ArrayList<SheepDogIssueProposal> listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
    public static ArrayList<SheepDogIssueProposal> listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
    public static String validateDialog = "";

    protected static Object getDocumentFromNode(Object node) {
        Object current = node;
        while (current != null && !(current instanceof ITestDocument)) {
            if (current instanceof ICell) {
                current = ((ICell) current).getParent();
            } else if (current instanceof IRow) {
                current = ((IRow) current).getParent();
            } else if (current instanceof ITable) {
                current = ((ITable) current).getParent();
            } else if (current instanceof IText) {
                current = ((IText) current).getParent();
            } else if (current instanceof ILine) {
                current = ((ILine) current).getParent();
            } else if (current instanceof IDescription) {
                current = ((IDescription) current).getParent();
            } else if (current instanceof ITestStep) {
                current = ((ITestStep) current).getParent();
            } else if (current instanceof ITestData) {
                current = ((ITestData) current).getParent();
            } else if (current instanceof ITestStepContainer) {
                current = ((ITestStepContainer) current).getParent();
            } else if (current instanceof IStepParameters) {
                current = ((IStepParameters) current).getParent();
            } else if (current instanceof IStepDefinition) {
                current = ((IStepDefinition) current).getParent();
            } else if (current instanceof ITestProject) {
                return null;
            } else {
                return null;
            }
        }
        return current;
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
        case "Table":
            if (parent instanceof ITestStep) return ((ITestStep) parent).getTable();
            if (parent instanceof ITestData) return ((ITestData) parent).getTable();
            return ((IStepParameters) parent).getTable();
        case "Text":
            return ((ITestStep) parent).getText();
        case "Description":
            if (parent instanceof ITestSuite) return ((ITestSuite) parent).getDescription();
            if (parent instanceof ITestStepContainer) return ((ITestStepContainer) parent).getDescription();
            if (parent instanceof IStepObject) return ((IStepObject) parent).getDescription();
            if (parent instanceof IStepDefinition) return ((IStepDefinition) parent).getDescription();
            if (parent instanceof IStepParameters) return ((IStepParameters) parent).getDescription();
            return ((ITestData) parent).getDescription();
        case "TestStepContainerList":
            return ((ITestSuite) parent).getTestStepContainer(index);
        case "TestStepList":
            return ((ITestStepContainer) parent).getTestStep(index);
        case "RowList":
            return ((ITable) parent).getRow(index);
        case "CellList":
            return ((IRow) parent).getCell(index);
        case "StepDefinitionList":
            return ((IStepObject) parent).getStepDefinition(index);
        case "StepParametersList":
            return ((IStepDefinition) parent).getStepParameters(index);
        case "LineList":
            return ((IDescription) parent).getLine(index);
        case "TestDataList":
            return ((ITestCase) parent).getTestData(index);
        default:
            throw new IllegalArgumentException("Unknown element type: " + elementType);
        }
    }

    private Object getOrCreateNode(Object parent, String elementType, int index) {
        switch (elementType) {
        case "Table": {
            Object child = getChildNode(parent, elementType, index);
            if (child != null) return child;
            if (parent instanceof ITestStep) return SheepDogBuilder.createTable((ITestStep) parent);
            if (parent instanceof ITestData) return SheepDogBuilder.createTable((ITestData) parent);
            return SheepDogBuilder.createTable((IStepParameters) parent);
        }
        case "Description": {
            Object child = getChildNode(parent, elementType, index);
            if (child != null) return child;
            if (parent instanceof ITestSuite) return SheepDogBuilder.createDescription((ITestSuite) parent);
            if (parent instanceof ITestStepContainer) return SheepDogBuilder.createDescription((ITestStepContainer) parent);
            if (parent instanceof IStepObject) return SheepDogBuilder.createDescription((IStepObject) parent);
            if (parent instanceof IStepDefinition) return SheepDogBuilder.createDescription((IStepDefinition) parent);
            if (parent instanceof IStepParameters) return SheepDogBuilder.createDescription((IStepParameters) parent);
            return SheepDogBuilder.createDescription((ITestData) parent);
        }
        default:
            try {
                return getChildNode(parent, elementType, index);
            } catch (IndexOutOfBoundsException e) {
                switch (elementType) {
                case "TestStepContainerList":
                    return SheepDogBuilder.createTestCase((ITestSuite) parent, "");
                case "TestStepList":
                    return SheepDogBuilder.createTestStep((ITestStepContainer) parent, "");
                case "RowList":
                    return SheepDogBuilder.createRow((ITable) parent);
                case "CellList":
                    return SheepDogBuilder.createCell((IRow) parent, "");
                case "StepDefinitionList":
                    return SheepDogBuilder.createStepDefinition((IStepObject) parent, "");
                case "StepParametersList":
                    return SheepDogBuilder.createStepParameters((IStepDefinition) parent, "");
                case "LineList":
                    return SheepDogBuilder.createLine((IDescription) parent, "");
                case "TestDataList":
                    return SheepDogBuilder.createTestData((ITestCase) parent, "");
                default:
                    throw new IllegalArgumentException("Unknown element type: " + elementType);
                }
            }
        }
    }

    protected void createNodeDependencies(String part) {
        String[] parts = part.split("/");
        Object current = getDocumentFromNode(cursor);
        int i = 0;

        while (i < parts.length) {
            String elementType = parts[i];

            if (elementType.equals("Table") || elementType.equals("Description")
                    || elementType.equals("NestedDescription")) {
                current = getOrCreateNode(current, elementType, 0);
                i++;
            } else if (elementType.equals("Text") || elementType.equals("CellList")) {
                break;
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                if (elementType.equals("TestStepContainerList") && i + 2 < parts.length
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

protected String getFullNameFromPath() {
        String path = (String) properties.get("path");
        return path.replace("src/test/resources/asciidoc/", "");
    }

    protected void setCursorAtNode(String path) {
        String[] parts = path.split("/");
        Object current = getDocumentFromNode(cursor);

        int i = 0;
        while (i < parts.length && current != null) {
            String elementType = parts[i];

            if (elementType.equals("Table") || elementType.equals("Text")
                    || elementType.equals("Description") || elementType.equals("NestedDescription")) {
                current = getChildNode(current, elementType, 0);
                i++;
            } else {
                if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                    break;
                }
                int index = Integer.parseInt(parts[i + 1]) - 1;
                try {
                    current = getChildNode(current, elementType, index);
                } catch (IndexOutOfBoundsException e) {
                    cursor = null;
                    return;
                }
                i += 2;
            }
            if (current != null)
                cursor = current;
        }

    }

    public void transition() {
        if (properties.get("Test Suite Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        } else if (properties.get("Step Object Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Step Object Full Name").toString()));
            properties.remove("Step Object Full Name");
        }
    }

}
