package org.farhan.impl;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.IText;

public class TestStepImpl implements ITestStep {

	String name;
	private TestStepContainerImpl parent;
	ITable table;
	IText text;

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
		return parent;
	}

	@Override
	public ITable getTable() {
		return table;
	}

	@Override
	public IText getText() {
		return text;
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
		parent = (TestStepContainerImpl) value;
		parent.testStepList.add(this);
	}

	@Override
	public void setTable(ITable value) {
		table = value;
	}

	@Override
	public void setText(IText value) {
		text = value;
	}

	public boolean equals(TestStepImpl object) {
		return this.equals(object);
	}

}
