package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.IResourceRepository;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSetup;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Description;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.farhan.dsl.sheepdog.sheepDog.Table;
import org.farhan.dsl.sheepdog.sheepDog.Text;

public class SheepDogFactoryImpl extends org.farhan.dsl.grammar.impl.SheepDogFactoryImpl {

    private TestProjectImpl testProject;
    private IResourceRepository sr;

    public SheepDogFactoryImpl(IResourceRepository sourceFileRepository) {
        sr = sourceFileRepository;
    }

    @Override
    public IDescription createDescription() {
        return new DescriptionImpl(SheepDogFactory.eINSTANCE.createDescription());
    }

    @Override
    public IStepDefinition createStepDefinition() {
        return new StepDefinitionImpl(SheepDogFactory.eINSTANCE.createStepDefinition());
    }

    @Override
    public IStepObject createStepObject() {
        return new StepObjectImpl(SheepDogFactory.eINSTANCE.createStepObject());
    }

    @Override
    public IStepParameters createStepParameters() {
        return new StepParametersImpl(SheepDogFactory.eINSTANCE.createStepParameters());
    }

    @Override
    public ITestCase createTestCase() {
        return new TestCaseImpl(SheepDogFactory.eINSTANCE.createTestCase());
    }

    @Override
    public ITestSetup createTestSetup() {
        return new TestSetupImpl(SheepDogFactory.eINSTANCE.createTestSetup());
    }

    @Override
    public ITestStep createTestStep() {
        return new TestStepImpl(SheepDogFactory.eINSTANCE.createTestStep());
    }

    @Override
    public ITestSuite createTestSuite() {
        return new TestSuiteImpl(SheepDogFactory.eINSTANCE.createTestSuite());
    }

    @Override
    public ITestProject createTestProject() {
        if (testProject == null) {
            testProject = new TestProjectImpl(sr);
        }
        return testProject;
    }

    @Override
    public ILine createLine() {
        return new LineImpl(SheepDogFactory.eINSTANCE.createLine());
    }

    @Override
    public ITable createTable() {
        return new TableImpl(SheepDogFactory.eINSTANCE.createTable());
    }

    @Override
    public IRow createRow() {
        return new RowImpl(SheepDogFactory.eINSTANCE.createRow());
    }

    @Override
    public ICell createCell() {
        return new CellImpl(SheepDogFactory.eINSTANCE.createCell());
    }

    @Override
    public IText createText() {
        return new TextImpl(SheepDogFactory.eINSTANCE.createText());
    }

}
