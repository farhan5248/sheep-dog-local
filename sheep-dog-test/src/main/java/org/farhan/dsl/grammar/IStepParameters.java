package org.farhan.dsl.grammar;

public interface IStepParameters {

    String getName();

    IStepDefinition getParent();

    INestedDescription getNestedDescription();

    ITable getTable();

    void setName(String value);

    void setNestedDescription(INestedDescription value);

    boolean addLine(ILine value);

    void setTable(ITable value);
}
