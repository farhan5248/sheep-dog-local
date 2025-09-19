package org.farhan.common;

import java.util.ArrayList;
import java.util.TreeSet;

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
	public IStepObject createStepObject(String qualifiedName) {
		IStepObject stepObject = getStepObject(qualifiedName);
		if (stepObject == null) {
			stepObject = new StepObjectImpl(qualifiedName);
			stepObject.setParent(this);
			stepObjectList.add(stepObject);
		}
		return stepObject;
	}

	@Override
	public ITestSuite createTestSuite(String qualifiedName) {
		ITestSuite testSuite = getTestSuite(qualifiedName);
		if (testSuite == null) {
			testSuite = new TestSuiteImpl(qualifiedName);
			testSuite.setParent(this);
			testSuiteList.add(testSuite);
		}
		return testSuite;
	}

	@Override
	public ArrayList<String> getComponentList() {
		TreeSet<String> componentSet = new TreeSet<String>();
		for (IStepObject so : this.stepObjectList) {
			componentSet.add(so.getQualifiedName().split("/")[0]);
		}
		ArrayList<String> componentList = new ArrayList<String>();
		componentList.addAll(componentSet);
		return componentList;
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
	public ArrayList<IStepObject> getStepObjectList(String component) {
		ArrayList<IStepObject> componentStepObjectList = new ArrayList<IStepObject>();
		for (IStepObject so : this.stepObjectList) {
			if (so.getQualifiedName().startsWith(component)) {
				componentStepObjectList.add(so);
			}
		}
		return componentStepObjectList;
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

}
