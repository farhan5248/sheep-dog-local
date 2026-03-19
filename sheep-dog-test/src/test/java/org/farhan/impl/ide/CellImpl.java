package org.farhan.impl.ide;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;

public class CellImpl implements ICell {

	String name;
	RowImpl parent;

	CellImpl() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public IRow getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return name != null ? name : "";
	}

}
