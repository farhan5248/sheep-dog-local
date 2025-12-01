package org.farhan.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;

public class TableImpl implements ITable {

	ArrayList<IRow> rowList;
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
	public List<IRow> getRowList() {
		return Collections.unmodifiableList(rowList);
	}

	@Override
	public IRow getRow(int index) {
		throw new UnsupportedOperationException("getRow(int index) is not implemented");
	}

}
