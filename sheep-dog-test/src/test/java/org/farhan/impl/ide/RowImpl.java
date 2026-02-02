package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;

public class RowImpl implements IRow {

	List<CellImpl> cellList;
	TableImpl parent;

	RowImpl() {
		cellList = new ArrayList<CellImpl>();
	}

	@Override
	public ITable getParent() {
		return parent;
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

	@Override
	public boolean addCell(ICell value) {
		cellList.add((CellImpl) value);
		cellList.getLast().parent = this;
		return true;
	}

}
