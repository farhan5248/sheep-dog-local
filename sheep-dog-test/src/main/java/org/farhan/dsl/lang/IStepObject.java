package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepObject extends IModel {

	IStepDefinition createStepDefinition(String name);

	String getName();

	String getNameLong();

	ITestProject getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	ArrayList<IStatement> getStatementList();

	IStepDefinition getStepDefinition(int index);

	IStepDefinition getStepDefinition(String name);

	ArrayList<IStepDefinition> getStepDefinitionList();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestProject value);

	void setStepDefinitionList(ArrayList<IStepDefinition> value);
}