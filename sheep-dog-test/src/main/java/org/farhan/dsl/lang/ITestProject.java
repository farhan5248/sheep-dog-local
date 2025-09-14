package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestProject {

	ArrayList<IStepObject> getStepObjectList();

	ArrayList<ITestSuite> getTestSuiteList();

	void setStepObjectList(ArrayList<IStepObject> stepObjectList);

	void setTestSuiteList(ArrayList<ITestSuite> testSuiteList);

	String getFileExtension();

	IStepObject getStepObject(String qualifiedName);

	IStepObject createStepObject(String qualifiedName);

	ArrayList<IStepObject> getStepObjectList(String component);

	ArrayList<String> getComponentList();

	ITestSuite createTestSuite(String qualifiedName);
}