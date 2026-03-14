package org.farhan.impl.objects;

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
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogBuilder;

public class TestObjectSheepDogImpl extends TestObject {

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
        setProperty("cursor",
                SheepDogBuilder.createStepObject((ITestProject) getProperty("workspace"), stepObjectName));
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
        setProperty("cursor",
                SheepDogBuilder.createTestSuite((ITestProject) getProperty("workspace"), testSuiteFullName));
    }

    protected void addTextWithContent(String content) {
        setProperty("cursor", SheepDogBuilder.createText((ITestStep) getProperty("cursor"), content));
    }

    // === cursor query helpers ===

    protected IDescription getDescriptionFromCursor() {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite)
            return ((ITestSuite) cursor).getDescription();
        else if (cursor instanceof ITestStepContainer)
            return ((ITestStepContainer) cursor).getDescription();
        else if (cursor instanceof IStepObject)
            return ((IStepObject) cursor).getDescription();
        else if (cursor instanceof IStepDefinition)
            return ((IStepDefinition) cursor).getDescription();
        else if (cursor instanceof IStepParameters)
            return ((IStepParameters) cursor).getDescription();
        else if (cursor instanceof ITestData)
            return ((ITestData) cursor).getDescription();
        return null;
    }

    protected ITable getTableFromCursor() {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepParameters)
            return ((IStepParameters) cursor).getTable();
        else if (cursor instanceof ITestData)
            return ((ITestData) cursor).getTable();
        else if (cursor instanceof ITestStep)
            return ((ITestStep) cursor).getTable();
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

}
