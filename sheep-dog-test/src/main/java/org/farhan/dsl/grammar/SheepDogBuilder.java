package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class SheepDogBuilder {

    public static ITestCase createTestCase(ITestSuite parent, String name) {
        logger.debug("createTestCase(parent={}, name={})", parent, name);
        ITestCase testCase = null;
        if (parent != null)
            testCase = (ITestCase) parent.getTestStepContainer(name);
        if (testCase == null) {
            testCase = SheepDogFactory.instance.createTestCase();
            testCase.setName(name);
            if (parent != null)
                parent.addTestCase(testCase);
        }
        logger.debug("createTestCase() = {}", testCase);
        return testCase;
    }

    private static final Logger logger = SheepDogLoggerFactory.getLogger(SheepDogBuilder.class);

    public static ITestProject createTestProject() {
        logger.debug("createTestProject()");
        ITestProject testProject = SheepDogFactory.instance.createTestProject();
        logger.debug("createTestProject() = {}", testProject);
        return testProject;
    }

    public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
        logger.debug("createStepDefinition(parent={}, name={})", parent, name);
        IStepDefinition stepDefinition = null;
        if (parent != null)
            stepDefinition = parent.getStepDefinition(name);
        if (stepDefinition == null) {
            stepDefinition = SheepDogFactory.instance.createStepDefinition();
            stepDefinition.setName(name);
            if (parent != null)
                parent.addStepDefinition(stepDefinition);
        }
        logger.debug("createStepDefinition() = {}", stepDefinition);
        return stepDefinition;
    }

    public static IStepParameters createStepParameters(IStepDefinition parent, String name) {
        logger.debug("createStepParameters(parent={}, name={})", parent, name);
        IStepParameters stepParameters = null;
        if (parent != null)
            stepParameters = parent.getStepParameters(name);
        if (stepParameters == null) {
            stepParameters = SheepDogFactory.instance.createStepParameters();
            stepParameters.setName(name);
            if (parent != null)
                parent.addStepParameters(stepParameters);
        }
        logger.debug("createStepParameters() = {}", stepParameters);
        return stepParameters;
    }

    public static ITestSuite createTestSuite(ITestProject parent, String fullName) {
        logger.debug("createTestSuite(parent={}, fullName={})", parent, fullName);
        ITestSuite testSuite = SheepDogFactory.instance.createTestSuite();
        testSuite.setFullName(fullName);
        String[] tsParts = fullName.split("/");
        String name = tsParts[tsParts.length - 1].replaceFirst("\\.[^.]+$", "");
        testSuite.setName(name);
        if (parent != null)
            parent.addTestSuite(testSuite);
        logger.debug("createTestSuite() = {}", testSuite);
        return testSuite;
    }

    public static ITestSetup createTestSetup(ITestSuite parent, String name) {
        logger.debug("createTestSetup(parent={}, name={})", parent, name);
        ITestSetup testSetup = null;
        if (parent != null)
            testSetup = (ITestSetup) parent.getTestStepContainer(name);
        if (testSetup == null) {
            testSetup = SheepDogFactory.instance.createTestSetup();
            testSetup.setName(name);
            if (parent != null)
                parent.addTestSetup(testSetup);
        }
        logger.debug("createTestSetup() = {}", testSetup);
        return testSetup;
    }

    public static ITestData createTestData(ITestCase parent, String name) {
        logger.debug("createTestData(parent={}, name={})", parent, name);
        ITestData testData = null;
        if (parent != null)
            testData = parent.getTestData(name);
        if (testData == null) {
            testData = SheepDogFactory.instance.createTestData();
            testData.setName(name);
            if (parent != null)
                parent.addTestData(testData);
        }
        logger.debug("createTestData() = {}", testData);
        return testData;
    }

    public static ITestStep createTestStep(ITestStepContainer parent, String fullName) {
        logger.debug("createTestStep(parent={}, fullName={})", parent, fullName);
        ITestStep testStep = SheepDogFactory.instance.createTestStep();
        testStep.setFullName(fullName);
        if (parent != null)
            parent.addTestStep(testStep);
        logger.debug("createTestStep() = {}", testStep);
        return testStep;
    }

    public static IText createText(ITestStep parent, String name) {
        logger.debug("createText(parent={}, name={})", parent, name);
        IText text = null;
        if (parent != null)
            text = parent.getText();
        if (text == null) {
            text = SheepDogFactory.instance.createText();
            text.setName(name);
            if (parent != null)
                parent.setText(text);
        }
        logger.debug("createText() = {}", text);
        return text;
    }

    public static ITable createTable(ITestStep parent) {
        logger.debug("createTable(parent={})", parent);
        ITable table = null;
        if (parent != null)
            table = parent.getTable();
        logger.debug("createTable() = {}", table);
        return table;
    }

    public static ITable createTable(ITestData parent) {
        logger.debug("createTable(parent={})", parent);
        ITable table = null;
        if (parent != null)
            table = parent.getTable();
        if (table == null) {
            table = SheepDogFactory.instance.createTable();
            if (parent != null)
                parent.setTable(table);
        }
        logger.debug("createTable() = {}", table);
        return table;
    }

    public static IRow createRow(ITable parent) {
        logger.debug("createRow(parent={})", parent);
        IRow row = SheepDogFactory.instance.createRow();
        if (parent != null)
            parent.addRow(row);
        logger.debug("createRow() = {}", row);
        return row;
    }

    public static ICell createCell(IRow parent, String name) {
        logger.debug("createCell(parent={}, name={})", parent, name);
        ICell cell = SheepDogFactory.instance.createCell();
        cell.setName(name);
        if (parent != null)
            parent.addCell(cell);
        logger.debug("createCell() = {}", cell);
        return cell;
    }

    public static ILine createLine(IDescription parent, String content) {
        logger.debug("createLine(parent={}, content={})", parent, content);
        ILine line = SheepDogFactory.instance.createLine();
        line.setName(content);
        if (parent != null)
            parent.addLine(line);
        logger.debug("createLine() = {}", line);
        return line;
    }

    public static IStepObject createStepObject(ITestProject parent, String fullName) {
        logger.debug("createStepObject(parent={}, fullName={})", parent, fullName);
        IStepObject stepObject = SheepDogFactory.instance.createStepObject();
        stepObject.setFullName(fullName);
        String[] soParts = fullName.split("/");
        String name = soParts[soParts.length - 1].replaceFirst("\\.[^.]+$", "");
        stepObject.setName(name);
        if (parent != null)
            parent.addStepObject(stepObject);
        logger.debug("createStepObject() = {}", stepObject);
        return stepObject;
    }

}
