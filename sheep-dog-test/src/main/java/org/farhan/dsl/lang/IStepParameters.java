package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepParameters {

	String getName();

	IStepDefinition getParent();

	ArrayList<IStatement> getStatementList();

	ArrayList<ArrayList<String>> getTable();

	void setName(String value);

	void setParent(IStepDefinition value);
	
	void setStatementList(ArrayList<IStatement> value);
	
	void setTable(ArrayList<ArrayList<String>> value);

}