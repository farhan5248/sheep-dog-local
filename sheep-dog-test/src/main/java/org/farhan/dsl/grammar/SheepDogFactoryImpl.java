package org.farhan.dsl.grammar;

public class SheepDogFactoryImpl implements ISheepDogFactory {

    @Override
    public IDescription createDescription() {
        return null;
    }

    @Override
    public ICell createCell() {
        return null;
    }

    @Override
    public IRow createRow() {
        return null;
    }

    @Override
    public ILine createLine() {
        return null;
    }

    @Override
    public IStepDefinition createStepDefinition() {
        return new StepDefinitionImpl();
    }

    @Override
    public IStepObject createStepObject() {
        return new StepObjectImpl();
    }

    @Override
    public IStepParameters createStepParameters() {
        return null;
    }

    @Override
    public ITable createTable() {
        return null;
    }

    @Override
    public ITestCase createTestCase() {
        return null;
    }

    @Override
    public ITestProject createTestProject() {
        return new TestProjectImpl();
    }

    @Override
    public ITestSetup createTestSetup() {
        return null;
    }

    @Override
    public ITestStep createTestStep() {
        return null;
    }

    @Override
    public ITestSuite createTestSuite() {
        return null;
    }

    @Override
    public IText createText() {
        return null;
    }

    @Override
    public ITestData createTestData() {
        return null;
    }

}
