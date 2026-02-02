package org.farhan.impl.ide;

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

	TestStepImpl() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getNameLong() {
		try {
			return TestStepUtility.getNameLong(this);
		} catch (Exception e) {
			return null;
		}
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
		text = (TextImpl) value;
		text.parent = this;
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
		name = value;
	}

	@Override
	public void setStepDefinitionName(String value) {
		name += " " + value;
	}

}
