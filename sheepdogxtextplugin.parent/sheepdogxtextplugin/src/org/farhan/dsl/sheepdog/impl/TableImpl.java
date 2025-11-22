package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.farhan.dsl.sheepdog.sheepDog.Table;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;

public class TableImpl implements ITable {

	private Table eObject;
	private ArrayList<IRow> rowList;
	private Object parent;

	public TableImpl() {
		rowList = new ArrayList<IRow>();
	}

	@Override
	public Object getParent() {
		if (parent == null && eObject != null) {
			if (eObject.eContainer() instanceof TestStep) {
				parent = new TestStepImpl((TestStep) eObject.eContainer());
			} else if (eObject.eContainer() instanceof StepParameters) {
				parent = new StepParametersImpl((StepParameters) eObject.eContainer());
			}
		}
		return parent;
	}

	@Override
	public void setParent(Object value) {
		parent = value;
	}

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

	@Override
	public IRow getRow(int index) {
		throw new UnsupportedOperationException("getRow(int index) is not implemented");
	}

}
