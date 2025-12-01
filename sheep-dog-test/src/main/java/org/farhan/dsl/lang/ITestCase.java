package org.farhan.dsl.lang;

import java.util.List;

public interface ITestCase extends ITestStepContainer {

	ITestData getTestData(int index);

	ITestData getTestData(String name);

	List<ITestData> getTestDataList();

}