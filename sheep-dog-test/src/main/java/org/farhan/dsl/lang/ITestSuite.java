package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestSuite {

	String getName();

	ITestProject getParent();

	String getQualifiedName();

	ArrayList<IStatement> getStatementList();

	ArrayList<String> getTags();

	String getTestSetup();

	ArrayList<ITestStepContainer> getTestStepContainerList();

	void setName(String value);

	void setParent(ITestProject value);

	void setQualifiedName(String value);

	void setStatementList(ArrayList<IStatement> value);

	void setTags(ArrayList<String> value);
	
	void setTestSetup(String value);
	
	void setTestStepContainerList(ArrayList<ITestStepContainer> value);
}