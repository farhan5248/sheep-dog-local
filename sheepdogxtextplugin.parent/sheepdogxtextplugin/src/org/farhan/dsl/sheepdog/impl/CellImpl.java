package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.sheepdog.sheepDog.Cell;

public class CellImpl implements ICell {

	private IRow parent;
	private Cell eObject;

	public CellImpl(Cell cell) {
		this.eObject = cell;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public void setName(String value) {
		eObject.setName(value);
	}

	@Override
	public IRow getParent() {
		return parent;
	}

	@Override
	public void setParent(IRow value) {
		this.parent = value;
	}

}
