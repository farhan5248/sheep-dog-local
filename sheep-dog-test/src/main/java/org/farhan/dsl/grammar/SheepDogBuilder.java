package org.farhan.dsl.grammar;

public class SheepDogBuilder {

    public static ITestProject createTestProject() {
        return SheepDogFactory.instance.createTestProject();
    }

    public static IStepObject createStepObject(ITestProject parent, String fullName) {
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
        return stepObject;
    }

    public static ITestSuite createTestSuite(ITestProject parent, String fullName) {
        ITestSuite testSuite = SheepDogFactory.instance.createTestSuite();
        testSuite.setFullName(fullName);
        if (parent != null)
            parent.addTestSuite(testSuite);
        return testSuite;
    }

    public static ITestCase createTestCase(ITestSuite parent, String name) {
        ITestCase testCase = SheepDogFactory.instance.createTestCase();
        testCase.setName(name);
        if (parent != null)
            parent.addTestCase(testCase);
        return testCase;
    }

    public static ITestStep createTestStep(ITestStepContainer parent, String fullName) {
        ITestStep testStep = SheepDogFactory.instance.createTestStep();
        testStep.setFullName(fullName);
        if (parent != null)
            parent.addTestStep(testStep);
        return testStep;
    }

    public static IDescription createDescription(ITestSuite parent) {
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        return description;
    }

    public static IDescription createDescription(ITestStepContainer parent) {
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        return description;
    }

    public static IDescription createDescription(IStepObject parent) {
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        return description;
    }

    public static IDescription createDescription(IStepDefinition parent) {
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        return description;
    }

    public static IDescription createDescription(IStepParameters parent) {
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        return description;
    }

    public static IDescription createDescription(ITestData parent) {
        IDescription description = SheepDogFactory.instance.createDescription();
        if (parent != null)
            parent.setDescription(description);
        return description;
    }

    public static ILine createLine(IDescription parent, String name) {
        ILine line = SheepDogFactory.instance.createLine();
        line.setName(name);
        if (parent != null)
            parent.addLine(line);
        return line;
    }

    public static ICell createCell(IRow parent, String name) {
        ICell cell = SheepDogFactory.instance.createCell();
        cell.setName(name);
        if (parent != null)
            parent.addCell(cell);
        return cell;
    }

    public static IRow createRow(ITable parent) {
        IRow row = SheepDogFactory.instance.createRow();
        if (parent != null)
            parent.addRow(row);
        return row;
    }

    public static ITable createTable(ITestStep parent) {
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        return table;
    }

    public static ITable createTable(ITestData parent) {
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        return table;
    }

    public static ITable createTable(IStepParameters parent) {
        ITable table = SheepDogFactory.instance.createTable();
        if (parent != null)
            parent.setTable(table);
        return table;
    }

    public static IText createText(ITestStep parent) {
        IText text = SheepDogFactory.instance.createText();
        if (parent != null)
            parent.setText(text);
        return text;
    }

    public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
        IStepDefinition stepDefinition = null;
        if (parent != null)
            stepDefinition = parent.getStepDefinition(name);
        if (stepDefinition == null) {
            stepDefinition = SheepDogFactory.instance.createStepDefinition();
            stepDefinition.setName(name);
            if (parent != null)
                parent.addStepDefinition(stepDefinition);
        }
        return stepDefinition;
    }

    public static IStepParameters createStepParameters(IStepDefinition parent, String name) {
        IStepParameters stepParameters = SheepDogFactory.instance.createStepParameters();
        stepParameters.setName(name);
        if (parent != null)
            parent.addStepParameters(stepParameters);
        return stepParameters;
    }

    public static ITestData createTestData(ITestCase parent, String name) {
        ITestData testData = SheepDogFactory.instance.createTestData();
        testData.setName(name);
        if (parent != null)
            parent.addTestData(testData);
        return testData;
    }

}
