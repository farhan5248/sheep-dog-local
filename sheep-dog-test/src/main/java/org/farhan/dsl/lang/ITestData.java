package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestData {

	String getName();

	ITestCase getParent();

	ArrayList<IStatement> getStatementList();

	ArrayList<ArrayList<String>> getTable();

	ArrayList<String> getTags();

	void setName(String value);

	void setParent(ITestCase value);

	void setStatementList(ArrayList<IStatement> value);
	
	void setTable(ArrayList<ArrayList<String>> value);
	
	void setTags(ArrayList<String> value);

}