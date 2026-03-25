package org.farhan.dsl.sheepdog.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;

public class RowImpl implements IRow {

	Row eObject;

	public RowImpl(Row row) {
		this.eObject = row;
	}

	@Override
	public EList<ICell> getCellList() {
		EList<ICell> cells = new BasicEList<ICell>();
		for (Cell c : eObject.getCellList()) {
			cells.add(new CellImpl(c));
		}
		return cells;
	}

	@Override
	public boolean equals(Object object) {
		return eObject.equals(((RowImpl) object).eObject);
	}

}
