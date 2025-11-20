package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestData {

	String getName();

	String getNameLong();

	ITestCase getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	ArrayList<IStatement> getStatementList();

	ArrayList<ArrayList<String>> getTable();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestCase value);

	void setStatementList(ArrayList<IStatement> value);

	void setTable(ArrayList<ArrayList<String>> value);

}