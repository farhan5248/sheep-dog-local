package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.sheepdog.sheepDog.Table;

public class TableImpl implements ITable {

	private Table eObject;
	private ArrayList<IRow> rowList;

	public TableImpl(Table table) {
		this.eObject = table;
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
