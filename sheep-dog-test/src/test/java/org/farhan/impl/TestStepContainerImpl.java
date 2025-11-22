package org.farhan.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;

public class TestStepContainerImpl implements ITestStepContainer {

	private ArrayList<ITestStep> testStepList;
	private String name;
	private ITestSuite testSuite;

	public TestStepContainerImpl(String value) {
		name = value;
		testStepList = new ArrayList<ITestStep>();
	}

	@Override
	public ITestStep createTestStep(String value) {
		ITestStep testStep = new TestStepImpl(value);
		testStep.setParent(this);
		testStepList.add(testStep);
		return testStep;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ITestSuite getParent() {
		return testSuite;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		throw new UnsupportedOperationException("getStatementList() is not implemented");
	}

	@Override
	public ArrayList<ITestStep> getTestStepList() {
		return testStepList;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setParent(ITestSuite value) {
		testSuite = value;
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		throw new UnsupportedOperationException("setStatementList(ArrayList<IStatement> value) is not implemented");
	}

	@Override
	public void setTestStepList(ArrayList<ITestStep> value) {
		testStepList = value;
	}

	@Override
	public String getNameLong() {
		throw new UnsupportedOperationException("getNameLong() is not implemented");
	}

	@Override
	public IStatement getStatement(int index) {
		throw new UnsupportedOperationException("getStatement(int index) is not implemented");
	}

	@Override
	public IStatement getStatement(String name) {
		throw new UnsupportedOperationException("getStatement(String name) is not implemented");
	}

	@Override
	public ITestStep getTestStep(int index) {
		throw new UnsupportedOperationException("getTestStep(int index) is not implemented");
	}

	@Override
	public ITestStep getTestStep(String name) {
		throw new UnsupportedOperationException("getTestStep(String name) is not implemented");
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

}
