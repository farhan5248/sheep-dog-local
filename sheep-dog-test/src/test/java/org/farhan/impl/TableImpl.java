package org.farhan.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;

public class TableImpl implements ITable {

	private ArrayList<IRow> rowList;
	private Object parent;

	public TableImpl() {
		rowList = new ArrayList<IRow>();
	}

	@Override
	public Object getParent() {
		return parent;
	}

	@Override
	public void setParent(Object value) {
		parent = value;
	}

	@Override
	public ArrayList<IRow> getRowList() {
		return rowList;
	}

	@Override
	public void setRowList(ArrayList<IRow> value) {
		rowList = value;
	}

	@Override
	public IRow getRow(int index) {
		throw new UnsupportedOperationException("getRow(int index) is not implemented");
	}

}
