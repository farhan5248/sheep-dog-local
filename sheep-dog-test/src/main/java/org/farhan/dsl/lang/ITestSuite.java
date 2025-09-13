package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestSuite {

	String getName();

	ITestProject getParent();

	String getQualifiedName();

	ArrayList<IStatement> getStatementList();

	ArrayList<String> getTags();

	ITestSetup getTestSetup();

	ArrayList<ITestStepContainer> getTestStepContainerList();

	void setName(String value);

	void setParent(ITestProject value);

	void setQualifiedName(String value);

	void setStatementList(ArrayList<IStatement> value);

	void setTags(ArrayList<String> value);
	
	void setTestSetup(ITestSetup value);
	
	void setTestStepContainerList(ArrayList<ITestStepContainer> value);
}