package org.farhan.dsl.lang;

import java.util.List;

public interface ITestData {

    String getName();

    ITestCase getParent();

    IStatement getStatement(int index);

    IStatement getStatement(String name);

    List<IStatement> getStatementList();

    List<List<String>> getTable();

    void setName(String value);

    boolean addStatement(IStatement value);

}