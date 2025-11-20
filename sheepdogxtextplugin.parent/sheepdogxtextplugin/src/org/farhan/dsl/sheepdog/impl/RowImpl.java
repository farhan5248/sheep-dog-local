package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;

public class RowImpl implements IRow {

	private ITable parent;
	private Row eObject;

	public RowImpl(Row row) {
		this.eObject = row;
	}

	@Override
	public ITable getParent() {
		return parent;
	}

	@Override
	public void setParent(ITable value) {
		this.parent = value;
	}

	@Override
	public ArrayList<ICell> getCellList() {
		ArrayList<ICell> cells = new ArrayList<ICell>();
		for (Cell c : eObject.getCellList()) {
			cells.add(new CellImpl(c));
		}
		return cells;
	}

	@Override
	public void setCellList(ArrayList<ICell> value) {
		// Not needed for this implementation
	}

	@Override
	public ICell getCell(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICell getCell(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
