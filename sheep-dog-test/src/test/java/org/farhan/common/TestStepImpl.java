package org.farhan.common;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;

public class TestStepImpl implements ITestStep {

	private String name;
	private ITestStepContainer testStepContainer;
	private ITable theTable;

	public TestStepImpl(String value) {
		name = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getNameLong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestStepContainer getParent() {
		return testStepContainer;
	}

	@Override
	public ITable getTable() {
		return theTable;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public void setNameLong(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(ITestStepContainer value) {
		testStepContainer = value;
	}

	@Override
	public void setTable(ITable value) {
		theTable = value;
	}

	@Override
	public void setText(String value) {
		// TODO Auto-generated method stub

	}

}
