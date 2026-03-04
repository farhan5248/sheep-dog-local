package org.farhan.impl.ide;

import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.INestedDescription;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;

public class TestDataImpl implements ITestData {

	String name;
	TestCaseImpl parent;
	NestedDescriptionImpl nestedDescription;
	TableImpl table;

	TestDataImpl() {
		this.nestedDescription = new NestedDescriptionImpl();
		this.nestedDescription.parent = this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ITestCase getParent() {
		return parent;
	}

	@Override
	public INestedDescription getNestedDescription() {
		return nestedDescription;
	}

	@Override
	public ITable getTable() {
		return table;
	}

	@Override
	public void setTable(ITable value) {
		this.table = (TableImpl) value;
		this.table.parent = this;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public boolean addLine(ILine value) {
		if (nestedDescription == null) {
			nestedDescription = new NestedDescriptionImpl();
			nestedDescription.parent = this;
		}
		nestedDescription.addLine(value);
		return true;
	}

	@Override
	public void setNestedDescription(INestedDescription value) {
		this.nestedDescription = (NestedDescriptionImpl) value;
		this.nestedDescription.parent = this;
	}

	@Override
	public String toString() {
		return name != null ? name : "";
	}

}
