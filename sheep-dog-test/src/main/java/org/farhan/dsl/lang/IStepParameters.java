package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepParameters {

	String getName();

	IStepDefinition getParent();

	ArrayList<IStatement> getStatementList();

	void setStatementList(ArrayList<IStatement> value);

	ArrayList<ArrayList<String>> getTable();

	void setName(String value);
	
	void setParent(IStepDefinition value);
	
	void setTable(ArrayList<ArrayList<String>> value);

}