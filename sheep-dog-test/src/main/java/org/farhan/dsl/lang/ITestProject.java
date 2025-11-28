package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestProject {

	String getFileExtension();

	IStepObject getStepObject(int index);

	IStepObject getStepObject(String qualifiedName);

	ArrayList<IStepObject> getStepObjectList();

	ITestSuite getTestSuite(int index);

	ITestSuite getTestSuite(String name);

	ArrayList<ITestSuite> getTestSuiteList();

	void setStepObjectList(ArrayList<IStepObject> stepObjectList);

	void setTestSuiteList(ArrayList<ITestSuite> testSuiteList);
}