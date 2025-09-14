package org.farhan.common;

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
	public ArrayList<IStepObject> getStepObjectList() {
		return stepObjectList;
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
	public String getFileExtension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStepObject getStepObject(String qualifiedName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStepObject createStepObject(String qualifiedName) {
		IStepObject stepObject = new StepObjectImpl(qualifiedName);
		stepObject.setParent(this);
		stepObjectList.add(stepObject);
		return stepObject;
	}

	@Override
	public ArrayList<IStepObject> getStepObjectList(String component) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getComponentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestSuite createTestSuite(String qualifiedName) {
		ITestSuite testSuite = new TestSuiteImpl(qualifiedName);
		testSuite.setParent(this);
		testSuiteList.add(testSuite);
		return testSuite;
	}

}
