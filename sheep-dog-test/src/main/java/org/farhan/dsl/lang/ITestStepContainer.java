package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestStepContainer {

	String getName();

	ITestSuite getParent();

	ArrayList<IStatement> getStatementList();

	ArrayList<ITestStep> getTestStepList();

	void setName(String value);

	void setParent(ITestSuite value);
	
	void setStatementList(ArrayList<IStatement> value);
	
	void setTestStepList(ArrayList<ITestStep> value);
}