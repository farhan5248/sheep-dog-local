package org.farhan.impl.ide;

import org.farhan.dsl.lang.ICell;
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

public class SheepDogFactoryImpl implements ISheepDogFactory {

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
	public IStatement createStatement() {
		return new StatementImpl();
	}

	@Override
	public ITable createTable() {
		return new TableImpl();
	}

	@Override
	public IRow createRow() {
		return new RowImpl();
	}

	@Override
	public ICell createCell() {
		return new CellImpl();
	}

}
