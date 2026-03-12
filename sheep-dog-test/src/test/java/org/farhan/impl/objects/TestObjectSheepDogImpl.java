package org.farhan.impl.objects;

import java.util.ArrayList;

import org.farhan.common.TestObject;
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

public class TestObjectSheepDogImpl extends TestObject {

    public static void reset() {
        properties.clear();
        ITestProject workspace = SheepDogBuilder.createTestProject();
        setProperty("workspace", workspace);
        setProperty("cursor", workspace);
        setProperty("validate annotation.Content", "");
        setProperty("list proposals popup", new ArrayList<SheepDogIssueProposal>());
        setProperty("list quickfixes popup", new ArrayList<SheepDogIssueProposal>());
    }

    // === add* helpers ===

    protected void addCellWithName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ICell) {
            cursor = ((ICell) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createCell((IRow) cursor, name));
    }

    protected void addLineWithContent(String content) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ILine) {
            cursor = ((ILine) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createLine((IDescription) cursor, content));
    }

    protected void addRowWithContent(String content) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IRow) {
            cursor = ((IRow) cursor).getParent();
        }
        IRow row = SheepDogBuilder.createRow((ITable) cursor);
        SheepDogBuilder.createCell(row, content);
        setProperty("cursor", row);
    }

    protected void addStepDefinitionWithName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepDefinition) {
            cursor = ((IStepDefinition) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createStepDefinition((IStepObject) cursor, name));
    }

    protected void addStepObjectWithFullName(String stepObjectName) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepObject) {
            cursor = ((IStepObject) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createStepObject((ITestProject) getProperty("workspace"), stepObjectName));
    }

    protected void addStepParametersWithName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepParameters) {
            cursor = ((IStepParameters) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createStepParameters((IStepDefinition) cursor, name));
    }

    protected void addTable() {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStep) {
            setProperty("cursor", SheepDogBuilder.createTable((ITestStep) cursor));
        } else if (cursor instanceof IStepParameters) {
            setProperty("cursor", SheepDogBuilder.createTable((IStepParameters) cursor));
        }
    }

    protected void addTestCaseWithName(String testStepContainerName) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestCase) {
            cursor = ((ITestCase) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createTestCase((ITestSuite) cursor, testStepContainerName));
    }

    protected void addTestDataWithName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestData) {
            cursor = ((ITestData) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createTestData((ITestCase) cursor, name));
    }

    protected void addTestSetupWithName(String testSetupName) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStepContainer) {
            cursor = ((ITestStepContainer) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createTestSetup((ITestSuite) cursor, testSetupName));
    }

    protected void addTestStepWithFullName(String stepName) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStep) {
            cursor = ((ITestStep) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepName));
    }

    protected void addTestSuiteWithFullName(String testSuiteFullName) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite) {
            cursor = ((ITestSuite) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createTestSuite((ITestProject) getProperty("workspace"), testSuiteFullName));
    }

    protected void addTextWithContent(String content) {
        setProperty("cursor", SheepDogBuilder.createText((ITestStep) getProperty("cursor"), content));
    }

    // === cursor query helpers ===

    protected IDescription getDescriptionFromCursor() {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite) return ((ITestSuite) cursor).getDescription();
        else if (cursor instanceof ITestStepContainer) return ((ITestStepContainer) cursor).getDescription();
        else if (cursor instanceof IStepObject) return ((IStepObject) cursor).getDescription();
        else if (cursor instanceof IStepDefinition) return ((IStepDefinition) cursor).getDescription();
        else if (cursor instanceof IStepParameters) return ((IStepParameters) cursor).getDescription();
        else if (cursor instanceof ITestData) return ((ITestData) cursor).getDescription();
        return null;
    }

    protected ITable getTableFromCursor() {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepParameters) return ((IStepParameters) cursor).getTable();
        else if (cursor instanceof ITestData) return ((ITestData) cursor).getTable();
        else if (cursor instanceof ITestStep) return ((ITestStep) cursor).getTable();
        return null;
    }

    // === assert* helpers (from TestObjectDoc) ===

    protected String assertCellName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ICell) {
            return ((ICell) cursor).getName();
        } else {
            Object cell = ((IRow) cursor).getCell(name);
            setProperty("cursor", cell);
            return cell == null ? null : ((ICell) cell).getName();
        }
    }

    protected String assertLineContent(String content) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ILine) {
            return ((ILine) cursor).getName();
        } else {
            Object line = ((IDescription) cursor).getLine(content);
            setProperty("cursor", line);
            return line == null ? null : ((ILine) line).getName();
        }
    }

    protected String assertRowContent(String content) {
        Object cell = ((IRow) getProperty("cursor")).getCell(content);
        setProperty("cursor", cell);
        return cell == null ? null : ((ICell) cell).getName();
    }

    protected String assertStepDefinitionName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepDefinition) {
            return ((IStepDefinition) cursor).getName();
        } else {
            Object sd = ((IStepObject) cursor).getStepDefinition(name);
            setProperty("cursor", sd);
            return sd == null ? null : ((IStepDefinition) sd).getName();
        }
    }

    protected String assertStepObjectName(String name) {
        return ((IStepObject) getProperty("cursor")).getName();
    }

    protected String assertStepParametersName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepParameters) {
            return ((IStepParameters) cursor).getName();
        } else {
            Object sp = ((IStepDefinition) cursor).getStepParameters(name);
            setProperty("cursor", sp);
            return sp == null ? null : ((IStepParameters) sp).getName();
        }
    }

    protected String assertTestDataName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestData) {
            return ((ITestData) cursor).getName();
        } else {
            Object td = ((ITestCase) cursor).getTestData(name);
            setProperty("cursor", td);
            return td == null ? null : ((ITestData) td).getName();
        }
    }

    protected String assertTestStepContainerName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStepContainer) {
            return ((ITestStepContainer) cursor).getName();
        } else {
            Object tsc = ((ITestSuite) cursor).getTestStepContainer(name);
            setProperty("cursor", tsc);
            return tsc == null ? null : ((ITestStepContainer) tsc).getName();
        }
    }

    protected String assertTestStepFullName(String fullName) {
        return ((ITestStep) getProperty("cursor")).getFullName();
    }

    protected String assertStepDefinitionRefName(String name) {
        return ((ITestStep) getProperty("cursor")).getStepDefinitionName();
    }

    protected String assertStepObjectRefName(String name) {
        return ((ITestStep) getProperty("cursor")).getStepObjectName();
    }

    protected String assertTestSuiteName(String name) {
        return ((ITestSuite) getProperty("cursor")).getName();
    }

    // === set* helpers (from TestObjectDoc) ===

    protected void setStepDefinitionName(String name) {
        ((ITestStep) getProperty("cursor")).setStepDefinitionName(name);
    }

    protected void setTestSuiteName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite) {
            ((ITestSuite) cursor).setName(name);
        }
    }

    // === Node navigation ===

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
                    return SheepDogBuilder.createTestCase((ITestSuite) parent, "Test Case");
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
        Object current = getDocumentFromNode(getProperty("cursor"));
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

        setProperty("cursor", current);
    }

    protected String getFullNameFromPath() {
        return object.replace("src/test/resources/asciidoc/", "");
    }

    protected String listToString(ArrayList<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object item : list) {
            sb.append("\n").append(item.toString());
        }
        return sb.toString();
    }

    protected void setCursorAtNode(String path) {
        String[] parts = path.split("/");
        Object current = getDocumentFromNode(getProperty("cursor"));

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
                    setProperty("cursor", null);
                    return;
                }
                i += 2;
            }
            if (current != null)
                setProperty("cursor", current);
        }

    }

}
