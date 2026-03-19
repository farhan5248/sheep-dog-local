package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;

public class TestCaseImpl extends TestStepContainerImpl implements ITestCase {

	ArrayList<TestDataImpl> testDataList;

	TestCaseImpl() {
		super();
		testDataList = new ArrayList<TestDataImpl>();
	}

	@Override
	public List<ITestData> getTestDataList() {
		return Collections.unmodifiableList(testDataList);
	}

	@Override
	public ITestData getTestData(int index) {
		return testDataList.get(index);
	}

	@Override
	public ITestData getTestData(String name) {
		for (ITestData td : testDataList) {
			if (td.getName().contentEquals(name)) {
				return td;
			}
		}
		return null;
	}

	@Override
	public boolean addTestData(ITestData value) {
		TestDataImpl impl = (TestDataImpl) value;
		testDataList.add(impl);
		impl.parent = this;
		return true;
	}

}
