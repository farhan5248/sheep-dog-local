package org.farhan.dsl.grammar;

public interface ITestStep {

    String getStepObjectName();

    String getStepDefinitionName();

    ITestStepContainer getParent();

    ITable getTable();

    IText getText();

    void setStepObjectName(String value);

    void setStepDefinitionName(String value);

    void setTable(ITable value);

    void setText(IText value);

}