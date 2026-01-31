package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;

public class TableImpl implements ITable {

	ArrayList<RowImpl> rowList;
	Object parent;

	public TableImpl() {
		rowList = new ArrayList<RowImpl>();
	}

	@Override
	public Object getParent() {
		return parent;
	}

	@Override
	public List<IRow> getRowList() {
		return Collections.unmodifiableList(rowList);
	}

	@Override
	public IRow getRow(int index) {
		throw new UnsupportedOperationException("getRow(int index) is not implemented");
	}

	@Override
	public boolean addRow(IRow value) {
		rowList.add((RowImpl) value);
		rowList.getLast().parent = this;
		return true;
	}

}
