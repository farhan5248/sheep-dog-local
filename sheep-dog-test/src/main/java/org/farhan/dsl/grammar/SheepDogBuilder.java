package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class SheepDogBuilder {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(SheepDogBuilder.class);

    public static ITestProject createTestProject() {
        logger.debug("createTestProject:");
        ITestProject testProject = SheepDogFactory.instance.createTestProject();
        logger.debug("createTestProject: return {}", testProject);
        return testProject;
    }

    public static IStepObject createStepObject(ITestProject parent, String fullName) {
        logger.debug("createStepObject: parent={}, fullName={}", parent, fullName);
        IStepObject stepObject = null;
        if (parent != null) {
            ITestDocument existing = parent.getTestDocument(fullName);
            if (existing instanceof IStepObject)
                stepObject = (IStepObject) existing;
        }
        if (stepObject == null) {
            stepObject = SheepDogFactory.instance.createStepObject();
            stepObject.setFullName(fullName);
            if (parent != null)
                parent.addStepObject(stepObject);
        }
        logger.debug("createStepObject: return {}", stepObject);
        return stepObject;
    }

    public static ITestSuite createTestSuite(ITestProject parent, String fullName) {
        logger.debug("createTestSuite: parent={}, fullName={}", parent, fullName);
        ITestSuite testSuite = null;
        if (parent != null) {
            ITestDocument existing = parent.getTestDocument(fullName);
            if (existing instanceof ITestSuite)
                testSuite = (ITestSuite) existing;
        }
        if (testSuite == null) {
            testSuite = SheepDogFactory.instance.createTestSuite();
            testSuite.setFullName(fullName);
            if (parent != null)
                parent.addTestSuite(testSuite);
        }
        logger.debug("createTestSuite: return {}", testSuite);
        return testSuite;
    }

    public static ITestCase createTestCase(ITestSuite parent, String name) {
        logger.debug("createTestCase: parent={}, name={}", parent, name);
        ITestCase testCase = null;
        if (parent != null) {
            ITestStepContainer existing = parent.getTestStepContainer(name);
            if (existing instanceof ITestCase)
                testCase = (ITestCase) existing;
        }
        if (testCase == null) {
            testCase = SheepDogFactory.instance.createTestCase();
            testCase.setName(name);
            if (parent != null)
                parent.addTestCase(testCase);
        }
        logger.debug("createTestCase: return {}", testCase);
        return testCase;
    }

    public static ITestSetup createTestSetup(ITestSuite parent, String name) {
        logger.debug("createTestSetup: parent={}, name={}", parent, name);
        ITestSetup testSetup = null;
        if (parent != null) {
            ITestStepContainer existing = parent.getTestStepContainer(name);
            if (existing instanceof ITestSetup)
                testSetup = (ITestSetup) existing;
        }
        if (testSetup == null) {
            testSetup = SheepDogFactory.instance.createTestSetup();
            testSetup.setName(name);
            if (parent != null)
                parent.addTestSetup(testSetup);
        }
        logger.debug("createTestSetup: return {}", testSetup);
        return testSetup;
    }

    public static ITestStep createTestStep(ITestStepContainer parent, String fullName) {
        logger.debug("createTestStep: parent={}, fullName={}", parent, fullName);
        ITestStep testStep = SheepDogFactory.instance.createTestStep();
        testStep.setFullName(fullName);
        if (parent != null)
            parent.addTestStep(testStep);
        logger.debug("createTestStep: return {}", testStep);
        return testStep;
    }

    public static IDescription createDescription(ITestSuite parent) {
        logger.debug("createDescription: parent={}", parent);
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        logger.debug("createDescription: return {}", description);
        return description;
    }

    public static IDescription createDescription(ITestStepContainer parent) {
        logger.debug("createDescription: parent={}", parent);
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        logger.debug("createDescription: return {}", description);
        return description;
    }

    public static IDescription createDescription(IStepObject parent) {
        logger.debug("createDescription: parent={}", parent);
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        logger.debug("createDescription: return {}", description);
        return description;
    }

    public static IDescription createDescription(IStepDefinition parent) {
        logger.debug("createDescription: parent={}", parent);
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        logger.debug("createDescription: return {}", description);
        return description;
    }

    public static IDescription createDescription(IStepParameters parent) {
        logger.debug("createDescription: parent={}", parent);
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        logger.debug("createDescription: return {}", description);
        return description;
    }

    public static IDescription createDescription(ITestData parent) {
        logger.debug("createDescription: parent={}", parent);
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        logger.debug("createDescription: return {}", description);
        return description;
    }

    public static ILine createLine(IDescription parent, String name) {
        logger.debug("createLine: parent={}, name={}", parent, name);
        ILine line = SheepDogFactory.instance.createLine();
        line.setName(name);
        if (parent != null)
            parent.addLine(line);
        logger.debug("createLine: return {}", line);
        return line;
    }

    public static ICell createCell(IRow parent, String name) {
        logger.debug("createCell: parent={}, name={}", parent, name);
        ICell cell = SheepDogFactory.instance.createCell();
        cell.setName(name);
        if (parent != null)
            parent.addCell(cell);
        logger.debug("createCell: return {}", cell);
        return cell;
    }

    public static IRow createRow(ITable parent) {
        logger.debug("createRow: parent={}", parent);
        IRow row = SheepDogFactory.instance.createRow();
        if (parent != null)
            parent.addRow(row);
        logger.debug("createRow: return {}", row);
        return row;
    }

    public static ITable createTable(ITestStep parent) {
        logger.debug("createTable: parent={}", parent);
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        logger.debug("createTable: return {}", table);
        return table;
    }

    public static ITable createTable(ITestData parent) {
        logger.debug("createTable: parent={}", parent);
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        logger.debug("createTable: return {}", table);
        return table;
    }

    public static ITable createTable(IStepParameters parent) {
        logger.debug("createTable: parent={}", parent);
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        logger.debug("createTable: return {}", table);
        return table;
    }

    public static IText createText(ITestStep parent) {
        logger.debug("createText: parent={}", parent);
        IText text = SheepDogFactory.instance.createText();
        if (parent != null)
            parent.setText(text);
        logger.debug("createText: return {}", text);
        return text;
    }

    public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
        logger.debug("createStepDefinition: parent={}, name={}", parent, name);
        IStepDefinition stepDefinition = null;
        if (parent != null)
            stepDefinition = parent.getStepDefinition(name);
        if (stepDefinition == null) {
            stepDefinition = SheepDogFactory.instance.createStepDefinition();
            stepDefinition.setName(name);
            if (parent != null)
                parent.addStepDefinition(stepDefinition);
        }
        logger.debug("createStepDefinition: return {}", stepDefinition);
        return stepDefinition;
    }

    public static IStepParameters createStepParameters(IStepDefinition parent, String name) {
        logger.debug("createStepParameters: parent={}, name={}", parent, name);
        IStepParameters stepParameters = null;
        if (parent != null)
            stepParameters = parent.getStepParameters(name);
        if (stepParameters == null) {
            stepParameters = SheepDogFactory.instance.createStepParameters();
            stepParameters.setName(name);
            if (parent != null)
                parent.addStepParameters(stepParameters);
        }
        logger.debug("createStepParameters: return {}", stepParameters);
        return stepParameters;
    }

    public static ITestData createTestData(ITestCase parent, String name) {
        logger.debug("createTestData: parent={}, name={}", parent, name);
        ITestData testData = null;
        if (parent != null)
            testData = parent.getTestData(name);
        if (testData == null) {
            testData = SheepDogFactory.instance.createTestData();
            testData.setName(name);
            if (parent != null)
                parent.addTestData(testData);
        }
        logger.debug("createTestData: return {}", testData);
        return testData;
    }

}
