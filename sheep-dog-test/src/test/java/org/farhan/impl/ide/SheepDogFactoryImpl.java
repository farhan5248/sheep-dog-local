package org.farhan.impl.ide;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ISheepDogFactory;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;

public class SheepDogFactoryImpl implements ISheepDogFactory {

	@Override
	public IStepDefinition createStepDefinition(String name) {
		return new StepDefinitionImpl(name);
	}

	@Override
	public IStepObject createStepObject(String qualifiedName) {
		return new StepObjectImpl(qualifiedName);
	}

	@Override
	public IStepParameters createStepParameters(IRow row) {
		return new StepParametersImpl(row);
	}

	@Override
	public IStepParameters createStepParameters(IText value) {
		return new StepParametersImpl(value);
	}

	@Override
	public ITestCase createTestCase(String value) {
		return new TestCaseImpl(value);
	}

	@Override
	public ITestProject createTestProject() {
		return new TestProjectImpl();
	}

	@Override
	public ITestSetup createTestSetup(String name) {
		return new TestSetupImpl(name);
	}

	@Override
	public ITestStep createTestStep(String value) {
		return new TestStepImpl(value);
	}

	@Override
	public ITestSuite createTestSuite(String qualifiedName) {
		return new TestSuiteImpl(qualifiedName);
	}

}
