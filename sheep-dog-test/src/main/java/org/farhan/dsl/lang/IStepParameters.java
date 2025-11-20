package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepParameters {

	String getName();

	String getNameLong();

	IStepDefinition getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	ArrayList<IStatement> getStatementList();

	ITable getTable();

	void setName(String value);

	void setNameLong(String value);

	void setParent(IStepDefinition value);

	void setStatementList(ArrayList<IStatement> value);

	void setTable(ITable value);
}