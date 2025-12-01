package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;

public class CellImpl implements ICell {

	private RowImpl parent;
	Cell eObject;

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
		if (parent == null) {
			parent = new RowImpl((Row) eObject.eContainer());
		}
		return parent;
	}

	@Override
	public void setParent(IRow value) {
		this.parent = (RowImpl) value;
		this.parent.eObject.getCellList().add(eObject);
	}

}
