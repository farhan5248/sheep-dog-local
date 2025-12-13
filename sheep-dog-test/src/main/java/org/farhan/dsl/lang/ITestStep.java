package org.farhan.dsl.lang;

public interface ITestStep {

	String getName();

	String getNameLong();

	String getStepObjectName();

	String getStepDefinitionName();

	ITestStepContainer getParent();

	ITable getTable();

	IText getText();

	void setStepObjectName(String value);

	void setStepDefinitionName(String value);

	void setTable(ITable value);

	void setText(IText value);

}