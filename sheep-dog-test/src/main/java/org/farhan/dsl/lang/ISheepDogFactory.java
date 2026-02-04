package org.farhan.dsl.lang;

public interface ISheepDogFactory {

    // TODO none of these should take an argument. The Factory impl class would
    // create an empty TypeImpl class and return it just as the EMF stuff does
    // typically. The builder will set the attributes and children etc. Add this
    // desc to the pattern

    ICell createCell();

    IRow createRow();

    IStatement createStatement();

    IStepDefinition createStepDefinition();

    IStepObject createStepObject();

    IStepParameters createStepParameters();

    ITable createTable();

    ITestCase createTestCase();

    ITestProject createTestProject();

    ITestSetup createTestSetup();

    ITestStep createTestStep();

    ITestSuite createTestSuite();

    IText createText();
}
