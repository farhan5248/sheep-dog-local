package org.farhan.dsl.lang;

import java.util.List;

public interface ITestSuite extends IModel {

	String getName();

	String getNameLong();

	ITestProject getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	List<IStatement> getStatementList();

	ITestStepContainer getTestStepContainer(int index);

	ITestStepContainer getTestStepContainer(String name);

	List<ITestStepContainer> getTestStepContainerList();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestProject value);

	void setTestSetup(ITestSetup value);

}