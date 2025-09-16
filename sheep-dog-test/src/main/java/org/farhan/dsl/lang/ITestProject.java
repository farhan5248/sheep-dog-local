package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestProject {

	IStepObject createStepObject(String qualifiedName);

	ITestSuite createTestSuite(String qualifiedName);

	// TODO move to helper, wrap around getStepObjectList();
	ArrayList<String> getComponentList();

	String getFileExtension();

	IStepObject getStepObject(String qualifiedName);

	ArrayList<IStepObject> getStepObjectList();

	// TODO move to helper, wrap around getStepObjectList();
	ArrayList<IStepObject> getStepObjectList(String component);

	ITestSuite getTestSuite(String name);

	ArrayList<ITestSuite> getTestSuiteList();

	void setStepObjectList(ArrayList<IStepObject> stepObjectList);

	void setTestSuiteList(ArrayList<ITestSuite> testSuiteList);
}