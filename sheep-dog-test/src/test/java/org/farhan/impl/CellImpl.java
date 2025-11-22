package org.farhan.impl;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;

public class CellImpl implements ICell {

	private String name;
	private IRow parent;

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
	public void setParent(IRow value) {
		parent = value;
	}

}
