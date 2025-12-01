package org.farhan.dsl.lang;

import java.util.List;

public interface IStepObject extends IModel {

	String getName();

	String getNameLong();

	ITestProject getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	List<IStatement> getStatementList();

	IStepDefinition getStepDefinition(int index);

	IStepDefinition getStepDefinition(String name);

	List<IStepDefinition> getStepDefinitionList();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestProject value);

}