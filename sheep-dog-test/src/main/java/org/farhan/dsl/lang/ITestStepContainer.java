package org.farhan.dsl.lang;

import java.util.List;

public interface ITestStepContainer {

    String getName();

    ITestSuite getParent();

    IStatement getStatement(int index);

    IStatement getStatement(String name);

    List<IStatement> getStatementList();

    ITestStep getTestStep(int index);

    ITestStep getTestStep(String name);

    List<ITestStep> getTestStepList();

    void setName(String value);

    boolean addStatement(IStatement value);

    boolean addTestStep(ITestStep value);

}