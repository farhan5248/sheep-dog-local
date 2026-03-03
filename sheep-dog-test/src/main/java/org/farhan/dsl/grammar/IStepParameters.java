package org.farhan.dsl.grammar;

public interface IStepParameters {

    String getName();

    IStepDefinition getParent();

    INestedDescription getNestedDescription();

    ITable getTable();

    void setName(String value);

    void setNestedDescription(INestedDescription value);

    void setTable(ITable value);
}
