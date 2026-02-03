package org.farhan.dsl.lang;

import java.util.List;

public interface ITestProject {

	boolean addStepObject(IStepObject value);

	boolean addTestSuite(ITestSuite value);

	String getFileExtension();

	String getName();

	IStepObject getStepObject(int index);

	IStepObject getStepObject(String qualifiedName);

	List<IStepObject> getStepObjectList();

	ITestSuite getTestSuite(int index);

	ITestSuite getTestSuite(String qualifiedName);

	List<ITestSuite> getTestSuiteList();

	void setName(String name);

}