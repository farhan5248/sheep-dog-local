package org.farhan.dsl.grammar;

public interface ITestData {

    String getName();

    ITestCase getParent();

    INestedDescription getNestedDescription();

    ITable getTable();

    void setTable(ITable value);

    void setName(String value);

    boolean addLine(ILine value);

    void setNestedDescription(INestedDescription value);

}
