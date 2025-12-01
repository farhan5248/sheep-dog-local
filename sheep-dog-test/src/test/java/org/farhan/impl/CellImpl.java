package org.farhan.impl;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;

public class CellImpl implements ICell {

	String name;
	private RowImpl parent;

	public CellImpl(String value) {
		name = value;
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
	public void setParent(IRow parent) {
		this.parent = (RowImpl) parent;
		this.parent.cellList.add(this);
	}

}
