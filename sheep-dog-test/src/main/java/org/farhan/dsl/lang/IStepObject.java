package org.farhan.dsl.lang;

import java.util.List;

public interface IStepObject extends IModel {

	String getContent() throws Exception;

	String getName();

	String getNameLong();

	ITestProject getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	List<IStatement> getStatementList();

	IStepDefinition getStepDefinition(int index);

	IStepDefinition getStepDefinition(String name);

	List<IStepDefinition> getStepDefinitionList();

	void setContent(String text) throws Exception;

	void setName(String value);

	boolean addStatement(IStatement value);

	boolean addStepDefinition(IStepDefinition value);

}