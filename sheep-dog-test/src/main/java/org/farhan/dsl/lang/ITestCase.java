package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestCase extends ITestStepContainer {

	// TODO change String value to Object element.
	// This way, a DSL object can be passed in for those projects
	// or a String for testing in this one
	ITestStep createTestStep(String value);

	ArrayList<String> getTags();

	ArrayList<ITestData> getTestDataList();

	void setTags(ArrayList<String> value);

	void setTestDataList(ArrayList<ITestData> value);

}