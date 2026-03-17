package org.farhan.dsl.grammar;

public interface ITestStep {

    String getFullName();

    String getStepObjectName();

    String getStepDefinitionName();

    ITestStepContainer getParent();

    ITable getTable();

    IText getText();

    void setFullName(String value);

    void setStepObjectName(String value);

    void setStepDefinitionName(String value);

    void setParent(ITestStepContainer value);

    void setTable(ITable value);

    void setText(IText value);

}