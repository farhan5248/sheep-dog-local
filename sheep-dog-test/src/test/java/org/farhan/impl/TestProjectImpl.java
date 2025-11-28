package org.farhan.impl;

import java.util.ArrayList;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSuite;

public class TestProjectImpl implements ITestProject {

	private ArrayList<ITestSuite> testSuiteList;
	private ArrayList<IStepObject> stepObjectList;

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
	public ArrayList<IStepObject> getStepObjectList() {
		return stepObjectList;
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
	public ArrayList<ITestSuite> getTestSuiteList() {
		return testSuiteList;
	}

	@Override
	public void setStepObjectList(ArrayList<IStepObject> stepObjectList) {
		this.stepObjectList = stepObjectList;
	}

	@Override
	public void setTestSuiteList(ArrayList<ITestSuite> testSuiteList) {
		this.testSuiteList = testSuiteList;
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
