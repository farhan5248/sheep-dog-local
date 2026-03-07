package org.farhan.dsl.grammar;

public interface IStepParameters {

    String getName();

    IStepDefinition getParent();

    IDescription getDescription();

    ITable getTable();

    void setName(String value);

    void setDescription(IDescription value);

    boolean addLine(ILine value);

    void setTable(ITable value);
}
