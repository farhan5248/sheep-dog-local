package org.farhan.dsl.grammar;

import java.util.List;

public interface ITestData {

    String getName();

    ITestCase getParent();

    INestedDescription getNestedDescription();

    List<List<String>> getTable();

    void setName(String value);

    boolean addLine(ILine value);

}
