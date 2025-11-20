package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestSuite extends IModel {

	ITestCase createTestCase(String name);

	ITestStepContainer createTestSetup(String name);

	String getName();

	String getNameLong();

	ITestProject getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	ArrayList<IStatement> getStatementList();

	ITestStepContainer getTestStepContainer(int index);

	ITestStepContainer getTestStepContainer(String name);

	ArrayList<ITestStepContainer> getTestStepContainerList();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestProject value);

	void setStatementList(ArrayList<IStatement> value);

	void setTestSetup(ITestSetup value);

	void setTestStepContainerList(ArrayList<ITestStepContainer> value);
}