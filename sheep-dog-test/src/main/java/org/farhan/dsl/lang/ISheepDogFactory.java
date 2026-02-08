package org.farhan.dsl.lang;

/**
 * Factory interface for creating empty grammar instances.
 * <p>
 * Separates factory contract from initialization logic and concrete
 * implementations (EMF vs POJO).
 * </p>
 */
public interface ISheepDogFactory {

    // TODO none of these should take an argument. The Factory impl class would
    // create an empty TypeImpl class and return it just as the EMF stuff does
    // typically. The builder will set the attributes and children etc. Add this
    // desc to the pattern

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    ICell createCell();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    IRow createRow();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    IStatement createStatement();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    IStepDefinition createStepDefinition();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    IStepObject createStepObject();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    IStepParameters createStepParameters();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    ITable createTable();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    ITestCase createTestCase();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    ITestProject createTestProject();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    ITestSetup createTestSetup();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    ITestStep createTestStep();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    ITestSuite createTestSuite();

    /**
     * Creates uninitialized grammar element instance for subsequent attribute
     * setting by builder.
     *
     * @return the created instance
     */
    IText createText();
}
