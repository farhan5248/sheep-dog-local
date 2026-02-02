package org.farhan.dsl.lang;

public interface ISheepDogFactory {

	// TODO none of these should take an argument. The Factory impl class would
	// create an empty TypeImpl class and return it just as the EMF stuff does
	// typically. The builder will set the attributes and children etc. Add this
	// desc to the pattern

	IStepDefinition createStepDefinition();

	IStepObject createStepObject();

	IStepParameters createStepParameters();

	ITestCase createTestCase();

	ITestProject createTestProject();

	ITestSetup createTestSetup();

	ITestStep createTestStep();

	ITestSuite createTestSuite();

	IStatement createStatement();

	ITable createTable();

	IRow createRow();

	ICell createCell();
}
