package org.farhan.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;

public class TestSuiteImpl implements ITestSuite {

	ArrayList<TestStepContainerImpl> testStepContainerList;
	String qualifiedName;
	String name;
	TestProjectImpl parent;

	public TestSuiteImpl(String qualifiedName) {
		this.testStepContainerList = new ArrayList<TestStepContainerImpl>();
		this.qualifiedName = qualifiedName;
		String[] nameParts = qualifiedName.split("/");
		this.name = nameParts[nameParts.length - 1];
	}

	@Override
	public String getContent() throws Exception {
		throw new UnsupportedOperationException("getContent() is not implemented");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getNameLong() {
		throw new UnsupportedOperationException("getNameLong() is not implemented");
	}

	@Override
	public ITestProject getParent() {
		return parent;
	}

	@Override
	public String getQualifiedName() {
		return qualifiedName;
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
	public ArrayList<IStatement> getStatementList() {
		throw new UnsupportedOperationException("getStatementList() is not implemented");
	}

	@Override
	public ITestStepContainer getTestStepContainer(int index) {
		return testStepContainerList.get(index);
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
	public List<ITestStepContainer> getTestStepContainerList() {
		return Collections.unmodifiableList(testStepContainerList);
	}

	@Override
	public void setContent(String text) throws Exception {
		throw new UnsupportedOperationException("setContent(String text)  is not implemented");
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

	@Override
	public void setQualifiedName(String value) {
		throw new UnsupportedOperationException("setQualifiedName(String value) is not implemented");
	}

	@Override
	public boolean addStatement(IStatement value) {
		throw new UnsupportedOperationException("addStatement(IStatement value) is not implemented");
	}

	@Override
	public boolean addTestCase(ITestCase value) {
		testStepContainerList.add((TestCaseImpl) value);
		testStepContainerList.getLast().parent = this;
		return true;
	}

	@Override
	public boolean addTestSetup(ITestSetup value) {
		testStepContainerList.add(0, (TestSetupImpl) value);
		testStepContainerList.getFirst().parent = this;
		return true;
	}

}
