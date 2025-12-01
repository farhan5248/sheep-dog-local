package org.farhan.dsl.lang;

import java.util.List;

public interface ITestProject {

	String getFileExtension();

	IStepObject getStepObject(int index);

	IStepObject getStepObject(String qualifiedName);

	List<IStepObject> getStepObjectList();

	ITestSuite getTestSuite(int index);

	ITestSuite getTestSuite(String name);

	List<ITestSuite> getTestSuiteList();

	boolean addTestSuite(ITestSuite value);

	boolean addStepObject(IStepObject value);

}