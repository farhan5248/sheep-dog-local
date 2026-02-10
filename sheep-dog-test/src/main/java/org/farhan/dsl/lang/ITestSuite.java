package org.farhan.dsl.lang;

import java.util.List;

public interface ITestSuite extends IModel {

    boolean addStatement(IStatement value);

    boolean addTestCase(ITestCase value);

    boolean addTestSetup(ITestSetup value);

    String getContent() throws Exception;

    String getName();

    ITestProject getParent();

    IStatement getStatement(int index);

    IStatement getStatement(String name);

    List<IStatement> getStatementList();

    ITestStepContainer getTestStepContainer(int index);

    ITestStepContainer getTestStepContainer(String name);

    List<ITestStepContainer> getTestStepContainerList();

    void setContent(String text) throws Exception;

    void setName(String value);

}