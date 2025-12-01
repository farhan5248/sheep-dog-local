package org.farhan.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSuite;

public class TestProjectImpl implements ITestProject {

	ArrayList<ITestSuite> testSuiteList;
	ArrayList<IStepObject> stepObjectList;

	public TestProjectImpl() {
		this.testSuiteList = new ArrayList<ITestSuite>();
		this.stepObjectList = new ArrayList<IStepObject>();
	}

	@Override
	public String getFileExtension() {
		return ".feature";
	}

	@Override
	public IStepObject getStepObject(String qualifiedName) {
		for (IStepObject so : this.stepObjectList) {
			if (so.getQualifiedName().contentEquals(qualifiedName)) {
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

}
