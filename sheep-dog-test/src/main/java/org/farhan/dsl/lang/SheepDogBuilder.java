package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.farhan.dsl.issues.LoggerFactory;

public class SheepDogBuilder {

    // TODO Builder creates the child and adds it to the parent. It also adds
    // statement list etc. The child source type is String. Add this desc to the
    // pattern
    private static final Logger logger = LoggerFactory.getLogger(SheepDogBuilder.class);

    public static ICell createCell(IRow parent, String name) {
        logger.debug("Entering createCell");
        ICell cell = SheepDogFactory.instance.createCell();
        cell.setName(name);
        if (parent != null)
            parent.addCell(cell);
        logger.debug("Exiting createCell");
        return cell;
    }

    public static IRow createRow(ITable parent) {
        logger.debug("Entering createRow");
        IRow row = SheepDogFactory.instance.createRow();
        if (parent != null)
            parent.addRow(row);
        logger.debug("Exiting createRow");
        return row;
    }

    public static IStatement createStatement(IStepDefinition parent, String name) {
        logger.debug("Entering createStatement for name: {}", name);
        IStatement statement = SheepDogFactory.instance.createStatement();
        statement.setName(name);
        if (parent != null)
            parent.addStatement(statement);
        logger.debug("Exiting createStatement");
        return statement;
    }

    public static IStatement createStatement(IStepObject parent, String name) {
        logger.debug("Entering createStatement for name: {}", name);
        IStatement statement = SheepDogFactory.instance.createStatement();
        statement.setName(name);
        if (parent != null)
            parent.addStatement(statement);
        logger.debug("Exiting createStatement");
        return statement;
    }

    public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
        logger.debug("Entering createStepDefinition for name: {}", name);
        IStepDefinition stepDefinition = null;
        if (parent != null)
            stepDefinition = parent.getStepDefinition(name);
        if (stepDefinition == null) {
            stepDefinition = SheepDogFactory.instance.createStepDefinition();
            stepDefinition.setName(name);
            if (parent != null)
                parent.addStepDefinition(stepDefinition);
        }
        logger.debug("Exiting createStepDefinition");
        return stepDefinition;
    }

    public static IStepObject createStepObject(ITestProject parent, String qualifiedName) {
        logger.debug("Entering createStepObject for qualifiedName: {}", qualifiedName);
        IStepObject stepObject = null;
        if (parent != null)
            stepObject = parent.getStepObject(qualifiedName);
        if (stepObject == null) {
            stepObject = SheepDogFactory.instance.createStepObject();
            stepObject.setNameLong(qualifiedName);
            if (parent != null)
                parent.addStepObject(stepObject);
        }
        logger.debug("Exiting createStepObject");
        return stepObject;
    }

    public static IStepParameters createStepParameters(IStepDefinition parent, String headers) {
        logger.debug("Entering createStepParameters for IRow");
        IStepParameters stepParameters = null;
        if (parent != null)
            stepParameters = parent.getStepParameters(headers);
        if (stepParameters == null) {
            stepParameters = SheepDogFactory.instance.createStepParameters();
            ITable table = createTable(stepParameters);
            IRow row = createRow(table);
            for (String h : headers.replaceFirst("^\\|\\s+", "").split("\\|")) {
                SheepDogBuilder.createCell(row, h);
            }
            if (parent != null)
                parent.addStepParameters(stepParameters);
        }
        logger.debug("Exiting createStepParameters");
        return stepParameters;
    }

    public static ITable createTable(IStepParameters parent) {
        logger.debug("Entering createTable");
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        logger.debug("Exiting createTable");
        return table;
    }

    public static ITable createTable(ITestStep parent) {
        logger.debug("Entering createTable");
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        logger.debug("Exiting createTable");
        return table;
    }

    public static ITestCase createTestCase(ITestSuite parent, String name) {
        logger.debug("Entering createTestCase for name: {}", name);
        ITestCase testCase = (ITestCase) parent.getTestStepContainer(name);
        if (testCase == null) {
            testCase = SheepDogFactory.instance.createTestCase();
            testCase.setName(name);
            if (parent != null)
                parent.addTestCase(testCase);
        }
        logger.debug("Exiting createTestCase");
        return testCase;
    }

    public static ITestSetup createTestSetup(ITestSuite parent, String name) {
        logger.debug("Entering createTestSetup for name: {}", name);
        ITestSetup testSetup = (ITestSetup) parent.getTestStepContainer(name);
        if (testSetup == null) {
            testSetup = SheepDogFactory.instance.createTestSetup();
            testSetup.setName(name);
            if (parent != null)
                parent.addTestSetup(testSetup);
        }
        logger.debug("Exiting createTestSetup");
        return testSetup;
    }

    public static ITestStep createTestStep(ITestStepContainer parent, String name) {
        logger.debug("Entering createTestStep for name: {}", name);
        ITestStep testStep = SheepDogFactory.instance.createTestStep();
        testStep.setStepObjectName(TestStepUtility.getStepObjectName(name));
        testStep.setStepDefinitionName(TestStepUtility.getStepDefinitionName(name));
        if (parent != null)
            parent.addTestStep(testStep);
        logger.debug("Exiting createTestStep");
        return testStep;
    }

    public static ITestSuite createTestSuite(ITestProject parent, String qualifiedName) {
        logger.debug("Entering createTestSuite for qualifiedName: {}", qualifiedName);
        ITestSuite testSuite = parent.getTestSuite(qualifiedName);
        if (testSuite == null) {
            testSuite = SheepDogFactory.instance.createTestSuite();
            testSuite.setNameLong(qualifiedName);
            if (parent != null)
                parent.addTestSuite(testSuite);
        }
        logger.debug("Exiting createTestSuite");
        return testSuite;
    }

    public static ITestProject createTestProject() {
        logger.debug("Entering createTestProject");
        ITestProject testProject = SheepDogFactory.instance.createTestProject();
        logger.debug("Exiting createTestProject");
        return testProject;
    }

}
