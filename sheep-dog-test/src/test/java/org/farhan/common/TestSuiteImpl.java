package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestCase;
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
	public ITestCase createTestCase(String value) {
		ITestCase testCase = new TestCaseImpl(value);
		testCase.setParent(this);
		testStepContainerList.add(testCase);
		return testCase;
	}

	@Override
	public ITestSetup createTestSetup(String name) {
		ITestSetup testSetup = new TestSetupImpl(name);
		testSetup.setParent(this);
		testStepContainerList.add(testSetup);
		return testSetup;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTestSetup(ITestSetup value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTestStepContainerList(ArrayList<ITestStepContainer> value) {
		this.testStepContainerList = value;
	}

	@Override
	public String getResourceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResourceName(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNameLong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatement getStatement(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatement getStatement(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestStepContainer getTestStepContainer(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNameLong(String value) {
		// TODO Auto-generated method stub

	}

}
