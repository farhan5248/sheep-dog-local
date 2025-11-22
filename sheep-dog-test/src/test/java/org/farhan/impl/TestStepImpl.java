package org.farhan.impl;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.IText;

public class TestStepImpl implements ITestStep {

	private String name;
	private ITestStepContainer testStepContainer;
	private ITable theTable;
	private IText theText;

	public TestStepImpl(String value) {
		name = value;
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
	public ITestStepContainer getParent() {
		return testStepContainer;
	}

	@Override
	public ITable getTable() {
		return theTable;
	}

	@Override
	public IText getText() {
		return theText;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
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
	public void setText(IText value) {
		theText = value;
	}
	
	public boolean equals(TestStepImpl object) {
		return this.equals(object);
	}

}
