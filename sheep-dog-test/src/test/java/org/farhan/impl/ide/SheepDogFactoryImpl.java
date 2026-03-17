package org.farhan.impl.ide;

import org.farhan.dsl.grammar.*;

public class SheepDogFactoryImpl implements ISheepDogFactory {

    @Override
    public IDescription createDescription() {
        return new DescriptionImpl();
    }

    @Override
    public ICell createCell() {
        return new CellImpl();
    }

    @Override
    public IRow createRow() {
        return new RowImpl();
    }

    @Override
    public ILine createLine() {
        return new LineImpl();
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
        return new StepParametersImpl();
    }

    @Override
    public ITable createTable() {
        return new TableImpl();
    }

    @Override
    public ITestCase createTestCase() {
        return new TestCaseImpl();
    }

    @Override
    public ITestProject createTestProject() {
        return new TestProjectImpl();
    }

    @Override
    public ITestSetup createTestSetup() {
        return new TestSetupImpl();
    }

    @Override
    public ITestStep createTestStep() {
        return new TestStepImpl();
    }

    @Override
    public ITestSuite createTestSuite() {
        return new TestSuiteImpl();
    }

    @Override
    public IText createText() {
        return new TextImpl();
    }

    @Override
    public ITestData createTestData() {
        return new TestDataImpl();
    }

}
