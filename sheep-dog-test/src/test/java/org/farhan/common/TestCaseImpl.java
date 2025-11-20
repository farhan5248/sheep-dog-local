package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestData;

public class TestCaseImpl extends TestStepContainerImpl implements ITestCase {

	public TestCaseImpl(String value) {
		super(value);
	}

	@Override
	public ArrayList<ITestData> getTestDataList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTestDataList(ArrayList<ITestData> value) {
		// TODO Auto-generated method stub

	}

	@Override
	public ITestData getTestData(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestData getTestData(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
