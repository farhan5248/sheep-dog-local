package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepObject {

	IStepDefinition createStepDefinition(String predicate);

	String getName();

	ITestProject getParent();

	String getQualifiedName();

	ArrayList<IStatement> getStatementList();

	IStepDefinition getStepDefinition(String predicate);

	ArrayList<IStepDefinition> getStepDefinitionList();

	void setName(String value);

	void setParent(ITestProject value);

	void setQualifiedName(String value);

	void setStepDefinitionList(ArrayList<IStepDefinition> value);
}