package org.farhan.impl.ide;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;

public class TestDataImpl implements ITestData {

	String name;
	TestCaseImpl parent;
	DescriptionImpl description;
	TableImpl table;

	TestDataImpl() {
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
	public IDescription getDescription() {
		return description;
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
		if (description == null) {
			description = new DescriptionImpl();
			description.parent = this;
		}
		description.addLine(value);
		return true;
	}

	@Override
	public void setDescription(IDescription value) {
		this.description = (DescriptionImpl) value;
		this.description.parent = this;
	}

	@Override
	public String toString() {
		return name != null ? name : "";
	}

}
