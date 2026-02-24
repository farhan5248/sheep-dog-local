package org.farhan.dsl.lang;

public interface IStepParameters {

    String getName();

    IStepDefinition getParent();

    INestedDescription getNestedDescription();

    ITable getTable();

    void setName(String value);

    boolean addLine(ILine value);

    void setTable(ITable value);
}
