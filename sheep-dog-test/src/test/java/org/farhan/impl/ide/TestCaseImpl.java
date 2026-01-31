package org.farhan.impl.ide;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestData;

public class TestCaseImpl extends TestStepContainerImpl implements ITestCase {

	public TestCaseImpl(String value) {
		super(value);
	}

	@Override
	public ArrayList<ITestData> getTestDataList() {
		throw new UnsupportedOperationException("getTestDataList() is not implemented");
	}

	@Override
	public ITestData getTestData(int index) {
		throw new UnsupportedOperationException("getTestData(int index) is not implemented");
	}

	@Override
	public ITestData getTestData(String name) {
		throw new UnsupportedOperationException("getTestData(String name) is not implemented");
	}

}
