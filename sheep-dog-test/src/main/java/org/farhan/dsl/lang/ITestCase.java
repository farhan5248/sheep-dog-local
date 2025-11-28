package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestCase extends ITestStepContainer {

	ITestData getTestData(int index);

	ITestData getTestData(String name);

	ArrayList<ITestData> getTestDataList();

	void setTestDataList(ArrayList<ITestData> value);

}