package org.farhan.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;

public class TestSuiteImpl implements ITestSuite {

	private ArrayList<ITestStepContainer> testStepContainerList;
	private String qualifiedName;
	private String name;
	private ITestProject testProject;

	public TestSuiteImpl(String qualifiedName) {
		this.testStepContainerList = new ArrayList<ITestStepContainer>();
		this.qualifiedName = qualifiedName;
		String[] nameParts = qualifiedName.split("/");
		this.name = nameParts[nameParts.length - 1];
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ITestProject getParent() {
		return testProject;
	}

	@Override
	public String getQualifiedName() {
		return qualifiedName;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		throw new UnsupportedOperationException("getStatementList() is not implemented");
	}

	@Override
	public ITestStepContainer getTestStepContainer(String name) {
		for (ITestStepContainer tsc : this.testStepContainerList) {
			if (tsc.getName().contentEquals(name)) {
				return tsc;
			}
		}
		return null;
	}

	@Override
	public ArrayList<ITestStepContainer> getTestStepContainerList() {
		return testStepContainerList;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setParent(ITestProject value) {
		testProject = value;
	}

	@Override
	public void setQualifiedName(String value) {
		throw new UnsupportedOperationException("setQualifiedName(String value) is not implemented");
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		throw new UnsupportedOperationException("setStatementList(ArrayList<IStatement> value) is not implemented");
	}

	@Override
	public void setTestSetup(ITestSetup value) {
		throw new UnsupportedOperationException("setTestSetup(ITestSetup value) is not implemented");
	}

	@Override
	public void setTestStepContainerList(ArrayList<ITestStepContainer> value) {
		this.testStepContainerList = value;
	}

	@Override
	public String getResourceName() {
		throw new UnsupportedOperationException("getResourceName() is not implemented");
	}

	@Override
	public void setResourceName(String value) {
		throw new UnsupportedOperationException("setResourceName(String value) is not implemented");
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
	public ITestStepContainer getTestStepContainer(int index) {
		return testStepContainerList.get(index);
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

}
