package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestCase extends ITestStepContainer {

	ArrayList<String> getTags();

	ArrayList<ITestData> getTestDataList();

	void setTags(ArrayList<String> value);

	void setTestDataList(ArrayList<ITestData> value);

	ITestStep createTestStep(String value);

}