package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestStepContainer {

	ITestStep createTestStep(String name);

	String getName();

	String getNameLong();

	ITestSuite getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	ArrayList<IStatement> getStatementList();

	ITestStep getTestStep(int index);

	ITestStep getTestStep(String name);

	ArrayList<ITestStep> getTestStepList();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestSuite value);
	
	void setStatementList(ArrayList<IStatement> value);

	void setTestStepList(ArrayList<ITestStep> value);
}