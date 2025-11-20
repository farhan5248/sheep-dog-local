package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestCase extends ITestStepContainer {

	// TODO change String value to Object element.
	// This way, a DSL object can be passed in for those projects
	// or a String for testing in this one
	ITestStep createTestStep(String value);

	ITestData getTestData(int index);

	ITestData getTestData(String name);

	ArrayList<ITestData> getTestDataList();

	void setTestDataList(ArrayList<ITestData> value);

}