package org.farhan.impl;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.IText;

public class TestStepImpl implements ITestStep {

	String name;
	TestStepContainerImpl parent;
	TableImpl table;
	TextImpl text;

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
	public void setTable(ITable value) {
		table = (TableImpl) value;
		table.parent = this;
	}

	@Override
	public void setText(IText value) {
		throw new UnsupportedOperationException("setText(IText value) is not implemented");
	}

	public boolean equals(TestStepImpl object) {
		return this.equals(object);
	}

}
