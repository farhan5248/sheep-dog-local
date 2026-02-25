package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSuite;

public class TestProjectImpl implements ITestProject {

	ArrayList<TestSuiteImpl> testSuiteList;
	ArrayList<StepObjectImpl> stepObjectList;

	TestProjectImpl() {
		this.testSuiteList = new ArrayList<TestSuiteImpl>();
		this.stepObjectList = new ArrayList<StepObjectImpl>();
	}

	@Override
	public String getFileExtension() {
		return ".feature";
	}

	@Override
	public IStepObject getStepObject(String fullName) {
		for (IStepObject so : this.stepObjectList) {
			if (so.getFullName().contentEquals(fullName)) {
				return so;
			}
		}
		return null;
	}

	@Override
	public List<IStepObject> getStepObjectList() {
		return Collections.unmodifiableList(stepObjectList);
	}

	@Override
	public ITestSuite getTestSuite(String name) {
		for (ITestSuite ts : this.testSuiteList) {
			if (ts.getName().contentEquals(name)) {
				return ts;
			}
		}
		return null;
	}

	@Override
	public List<ITestSuite> getTestSuiteList() {
		return Collections.unmodifiableList(testSuiteList);
	}

	@Override
	public IStepObject getStepObject(int index) {
		return stepObjectList.get(index);
	}

	@Override
	public ITestSuite getTestSuite(int index) {
		return testSuiteList.get(index);
	}

	@Override
	public boolean addTestSuite(ITestSuite value) {
		// Check for duplicates using getFullName as unique identifier and replace if found
		for (int i = 0; i < testSuiteList.size(); i++) {
			if (testSuiteList.get(i).getFullName().contentEquals(value.getFullName())) {
				testSuiteList.set(i, (TestSuiteImpl) value);
				testSuiteList.get(i).parent = this;
				return true;
			}
		}
		testSuiteList.add((TestSuiteImpl) value);
		testSuiteList.getLast().parent = this;
		return true;
	}

	@Override
	public boolean addStepObject(IStepObject value) {
		// Check for duplicates using getFullName as unique identifier and replace if found
		for (int i = 0; i < stepObjectList.size(); i++) {
			if (stepObjectList.get(i).getFullName().contentEquals(value.getFullName())) {
				stepObjectList.set(i, (StepObjectImpl) value);
				stepObjectList.get(i).parent = this;
				return true;
			}
		}
		stepObjectList.add((StepObjectImpl) value);
		stepObjectList.getLast().parent = this;
		return true;
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("getName() is not implemented");
	}

	@Override
	public void setName(String name) {
		throw new UnsupportedOperationException("setName(String name) is not implemented");
	}

	@Override
	public String toString() {
		int count = testSuiteList != null ? testSuiteList.size() : 0;
		return "TestProject[" + count + " suites]";
	}

}
