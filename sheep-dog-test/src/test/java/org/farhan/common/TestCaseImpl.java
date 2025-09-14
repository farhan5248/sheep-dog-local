package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestData;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestSuite;

public class TestCaseImpl implements ITestCase {

	private ArrayList<ITestStep> testStepList;
	private String name;
	private ITestSuite testSuite;

	public TestCaseImpl(String value) {
		name = value;
		testStepList = new ArrayList<ITestStep>();
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setTestStepList(ArrayList<ITestStep> value) {
		testStepList = value;
	}

	@Override
	public ArrayList<String> getTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITestData> getTestDataList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTags(ArrayList<String> value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTestDataList(ArrayList<ITestData> value) {
		// TODO Auto-generated method stub

	}

	@Override
	public ITestStep createTestStep(String value) {
		ITestStep testStep = new TestStepImpl(value);
		testStep.setParent(this);
		testStepList.add(testStep);
		return testStep;
	}

}
