package org.farhan.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;

public class RowImpl implements IRow {

	private ArrayList<ICell> cellList;
	private ITable parent;

	public RowImpl() {
		cellList = new ArrayList<ICell>();
	}

	@Override
	public ITable getParent() {
		return parent;
	}

	@Override
	public void setParent(ITable value) {
		parent = value;
	}

	@Override
	public ArrayList<ICell> getCellList() {
		return cellList;
	}

	@Override
	public void setCellList(ArrayList<ICell> value) {
		cellList = value;
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
