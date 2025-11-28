package org.farhan.dsl.lang;

public interface ISheepDogFactory {

	IStepDefinition createStepDefinition(String name);

	IStepObject createStepObject(String qualifiedName);

	IStepParameters createStepParameters(IRow row);

	IStepParameters createStepParameters(IText value);

	ITestCase createTestCase(String name);

	ITestSetup createTestSetup(String name);

	ITestStep createTestStep(String name);

	ITestSuite createTestSuite(String qualifiedName);
}
