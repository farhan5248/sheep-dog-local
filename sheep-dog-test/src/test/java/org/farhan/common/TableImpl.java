package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;

public class TableImpl implements ITable {

	private ArrayList<IRow> rowList;
	private ITestStep parent;

	public TableImpl() {
		rowList = new ArrayList<IRow>();
	}

	@Override
	public ITestStep getParent() {
		return parent;
	}

	@Override
	public void setParent(ITestStep value) {
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

}
