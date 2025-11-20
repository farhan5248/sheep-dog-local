package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestData;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;

public class TestCaseImpl extends TestStepContainerImpl implements ITestCase {

	public TestCaseImpl(TestCase testCase) {
		super(testCase);
	}

	@Override
	public ArrayList<ITestData> getTestDataList() {
		// Not needed in this project
		return null;
	}

	@Override
	public void setTestDataList(ArrayList<ITestData> value) {
		// Not needed in this project
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
	public ITestStep getTestStep(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestStep getTestStep(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNameLong(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public ITestData getTestData(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestData getTestData(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
