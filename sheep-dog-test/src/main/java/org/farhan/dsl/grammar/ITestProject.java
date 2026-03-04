package org.farhan.dsl.grammar;

import java.util.List;

public interface ITestProject {

	boolean addStepObject(IStepObject value);

	boolean addTestSuite(ITestSuite value);

	String getFileExtension();

	String getName();

	ITestDocument getTestDocument(int index);

	ITestDocument getTestDocument(String fullName);

	List<ITestDocument> getTestDocumentList();

	void setName(String name);

}
