package org.farhan.dsl.lang;

public interface ITestStep {

	String getName();

	String getNameLong();

	ITestStepContainer getParent();

	ITable getTable();

	String getText();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestStepContainer value);

	void setTable(ITable value);

	void setText(String value);

}