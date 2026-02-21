package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IResourceRepository;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ISheepDogFactory;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.farhan.dsl.sheepdog.sheepDog.Table;
import org.farhan.dsl.sheepdog.sheepDog.Text;

public class SheepDogFactoryImpl implements ISheepDogFactory {

    // TODO this assumes that there's just one open project in the eclipse
    // workspace.
    private static TestProjectImpl testProject;
    private static IResourceRepository sr;

    public SheepDogFactoryImpl(IResourceRepository sourceFileRepository) {
        sr = sourceFileRepository;
    }

    @Override
    public IStepDefinition createStepDefinition() {
        StepDefinition stepDefinition = SheepDogFactory.eINSTANCE.createStepDefinition();
        return new StepDefinitionImpl(stepDefinition);
    }

    @Override
    public IStepObject createStepObject() {
        StepObject eObject = SheepDogFactory.eINSTANCE.createStepObject();
        return new StepObjectImpl(eObject);
    }

    @Override
    public IStepParameters createStepParameters() {
        StepParameters parameters = SheepDogFactory.eINSTANCE.createStepParameters();
        return new StepParametersImpl(parameters);
    }

    @Override
    public ITestCase createTestCase() {
        throw new UnsupportedOperationException("createTestCase(String value) is not implemented");
    }

    @Override
    public ITestProject createTestProject() {
        if (testProject == null) {
            testProject = new TestProjectImpl(sr);
        }
        return testProject;
    }

    @Override
    public ITestSetup createTestSetup() {
        throw new UnsupportedOperationException("createTestSetup(String name) is not implemented");
    }

    @Override
    public ITestStep createTestStep() {
        throw new UnsupportedOperationException("createTestStep(String value) is not implemented");
    }

    @Override
    public ITestSuite createTestSuite() {
        throw new UnsupportedOperationException("createTestSuite(String qualifiedName) is not implemented");
    }

    @Override
    public IStatement createStatement() {
        return new StatementImpl(SheepDogFactory.eINSTANCE.createStatement());
    }

    @Override
    public ITable createTable() {
        Table table = SheepDogFactory.eINSTANCE.createTable();
        return new TableImpl(table);
    }

    @Override
    public IRow createRow() {
        Row row = SheepDogFactory.eINSTANCE.createRow();
        return new RowImpl(row);
    }

    @Override
    public ICell createCell() {
        Cell cell = SheepDogFactory.eINSTANCE.createCell();
        return new CellImpl(cell);
    }

    @Override
    public IText createText() {
        Text text = SheepDogFactory.eINSTANCE.createText();
        return new TextImpl(text);
    }

}
