package org.farhan.dsl.grammar;

import java.util.List;

public interface ITestProject {

	boolean addTestDocument(ITestDocument value);

	boolean addTestSuite(ITestSuite value);

	String getFileExtension();

	String getName();

	ITestDocument getTestDocument(int index);

	ITestDocument getTestDocument(String fullName);

	List<ITestDocument> getTestDocumentList();

	ITestSuite getTestSuite(int index);

	ITestSuite getTestSuite(String fullName);

	List<ITestSuite> getTestSuiteList();

	void setName(String name);

}
