package org.farhan.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;

public class RowImpl implements IRow {

	List<ICell> cellList;
	private TableImpl parent;

	public RowImpl() {
		cellList = new ArrayList<ICell>();
	}

	@Override
	public ITable getParent() {
		return parent;
	}

	@Override
	public void setParent(ITable parent) {
		this.parent = (TableImpl) parent;
		this.parent.rowList.add(this);
	}

	@Override
	public List<ICell> getCellList() {
		return Collections.unmodifiableList(cellList);
	}

	@Override
	public ICell getCell(int index) {
		throw new UnsupportedOperationException("getCell(int index) is not implemented");
	}

	@Override
	public ICell getCell(String name) {
		throw new UnsupportedOperationException("getCell(String name) is not implemented");
	}

}
