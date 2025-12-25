package org.farhan.impl;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.TestStepUtility;

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
		return TestStepUtility.getNameLong(this);
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

	@Override
	public String getStepObjectName() {
		return TestStepUtility.getStepObjectName(name);
	}

	@Override
	public String getStepDefinitionName() {
		return TestStepUtility.getStepDefinitionName(name);
	}

	@Override
	public void setStepObjectName(String value) {
		throw new UnsupportedOperationException("setStepObjectName(String value) is not implemented");
	}

	@Override
	public void setStepDefinitionName(String value) {
		throw new UnsupportedOperationException("setStepDefinitionName(String value) is not implemented");
	}

}
