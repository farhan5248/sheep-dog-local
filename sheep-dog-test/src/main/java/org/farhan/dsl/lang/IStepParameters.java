package org.farhan.dsl.lang;

import java.util.List;

public interface IStepParameters {

	String getName();

	String getNameLong();

	IStepDefinition getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	List<IStatement> getStatementList();

	ITable getTable();

	void setName(String value);

	void setNameLong(String value);

	boolean addStatement(IStatement value);

	void setTable(ITable value);
}