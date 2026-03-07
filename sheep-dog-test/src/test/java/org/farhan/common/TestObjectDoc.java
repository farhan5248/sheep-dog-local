package org.farhan.common;

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
import org.junit.jupiter.api.Assertions;

public class TestObjectDoc extends TestObject {

    protected static Object cursor;
    protected static ITestProject testProject;

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
        cursor = SheepDogBuilder.createLine((IDescription) cursor, content);
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

    protected void addTable() {
        if (cursor instanceof ITestStep) {
            cursor = SheepDogBuilder.createTable((ITestStep) cursor);
        } else if (cursor instanceof IStepParameters) {
            cursor = SheepDogBuilder.createTable((IStepParameters) cursor);
        }
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

    protected void assertCellName(String name) {
        if (cursor instanceof ICell) {
            Assertions.assertEquals(name, ((ICell) cursor).getName());
        } else {
            cursor = ((IRow) cursor).getCell(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertDescriptionEmpty() {
        IDescription desc = null;
        if (cursor instanceof ITestSuite)
            desc = ((ITestSuite) cursor).getDescription();
        else if (cursor instanceof ITestStepContainer)
            desc = ((ITestStepContainer) cursor).getDescription();
        else if (cursor instanceof IStepObject)
            desc = ((IStepObject) cursor).getDescription();
        else if (cursor instanceof IStepDefinition)
            desc = ((IStepDefinition) cursor).getDescription();
        else if (cursor instanceof IStepParameters)
            desc = ((IStepParameters) cursor).getDescription();
        else if (cursor instanceof ITestData)
            desc = ((ITestData) cursor).getDescription();
        Assertions.assertNull(desc);
    }

    protected void assertLineContent(String content) {
        if (cursor instanceof ILine) {
            Assertions.assertEquals(content, ((ILine) cursor).getName());
        } else {
            cursor = ((IDescription) cursor).getLine(content);
            Assertions.assertNotNull(cursor);
        }
    }


    protected void assertRowContent(String content) {
        cursor = ((IRow) cursor).getCell(content);
        Assertions.assertNotNull(cursor);
    }

    protected void assertStepDefinitionListEmpty() {
        Assertions.assertTrue(((IStepObject) cursor).getStepDefinitionList().isEmpty());
    }

    protected void assertStepDefinitionName(String name) {
        if (cursor instanceof IStepDefinition) {
            Assertions.assertEquals(name, ((IStepDefinition) cursor).getName());
        } else {
            cursor = ((IStepObject) cursor).getStepDefinition(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertStepObjectName(String name) {
        Assertions.assertEquals(name, ((IStepObject) cursor).getName());
    }

    protected void assertStepParametersListEmpty() {
        Assertions.assertTrue(((IStepDefinition) cursor).getStepParameterList().isEmpty());
    }

    protected void assertStepParametersName(String name) {
        if (cursor instanceof IStepParameters) {
            Assertions.assertEquals(name, ((IStepParameters) cursor).getName());
        } else {
            cursor = ((IStepDefinition) cursor).getStepParameters(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTableAbsent() {
        ITable t = null;
        if (cursor instanceof IStepParameters)
            t = ((IStepParameters) cursor).getTable();
        else if (cursor instanceof ITestData)
            t = ((ITestData) cursor).getTable();
        Assertions.assertNull(t);
    }

    protected void assertTablePresent() {
        Assertions.assertNotNull(cursor);
    }

    protected void assertTestDataListEmpty() {
        Assertions.assertTrue(((ITestCase) cursor).getTestDataList().isEmpty());
    }

    protected void assertTestDataName(String name) {
        if (cursor instanceof ITestData) {
            Assertions.assertEquals(name, ((ITestData) cursor).getName());
        } else {
            cursor = ((ITestCase) cursor).getTestData(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestStepContainerListEmpty() {
        Assertions.assertTrue(((ITestSuite) cursor).getTestStepContainerList().isEmpty());
    }

    protected void assertTestStepContainerName(String name) {
        if (cursor instanceof ITestStepContainer) {
            Assertions.assertEquals(name, ((ITestStepContainer) cursor).getName());
        } else {
            cursor = ((ITestSuite) cursor).getTestStepContainer(name);
            Assertions.assertNotNull(cursor);
        }
    }

    protected void assertTestStepFullName(String fullName) {
        Assertions.assertEquals(fullName, ((ITestStep) cursor).getFullName());
    }

    protected void assertTestStepListEmpty() {
        Assertions.assertTrue(((ITestStepContainer) cursor).getTestStepList().isEmpty());
    }

    protected void assertStepDefinitionRefName(String name) {
        Assertions.assertEquals(name, ((ITestStep) cursor).getStepDefinitionName());
    }

    protected void assertStepObjectRefName(String name) {
        Assertions.assertEquals(name, ((ITestStep) cursor).getStepObjectName());
    }

    protected void assertTestSuiteName(String name) {
        Assertions.assertEquals(name, ((ITestSuite) cursor).getName());
    }

    protected void assertTextAbsent() {
        Assertions.assertNull(((ITestStep) cursor).getText());
    }

    protected void assertTextPresent() {
        Assertions.assertNotNull(((ITestStep) cursor).getText());
    }

    protected void setStepDefinitionName(String name) {
        ((ITestStep) cursor).setStepDefinitionName(name);
    }

    protected void setTestSuiteName(String name) {
        if (cursor instanceof ITestSuite) {
            ((ITestSuite) cursor).setName(name);
        }
    }

}
