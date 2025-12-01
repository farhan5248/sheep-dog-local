package org.farhan.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.IText;

public class StepParametersImpl implements IStepParameters {

	private StepDefinitionImpl parent;
	ITable table;
	ArrayList<IStatement> statementList;

	public StepParametersImpl(IRow header) {
		this.table = new TableImpl();
		this.table.setParent(this);
		RowImpl row = new RowImpl();
		row.setParent(table);
		for (ICell c : header.getCellList()) {
			CellImpl newCell = new CellImpl(c.getName());
			newCell.setParent(row);
		}
		this.statementList = new ArrayList<IStatement>();
	}

	public StepParametersImpl(IText value) {
		CellImpl cell = new CellImpl(value.getName());
		RowImpl row = new RowImpl();
		cell.setParent(row);
		row.getCellList().add(cell);
		this.table = new TableImpl();
		this.table.setParent(this);
		this.table.getRowList().add(row);
		this.statementList = new ArrayList<IStatement>();
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("getName() is not implemented");
	}

	@Override
	public IStepDefinition getParent() {
		return parent;
	}

	@Override
	public List<IStatement> getStatementList() {
		return Collections.unmodifiableList(statementList);
	}

	@Override
	public ITable getTable() {
		return table;
	}

	@Override
	public void setName(String value) {
		throw new UnsupportedOperationException("setName(String value) is not implemented");
	}

	@Override
	public void setParent(IStepDefinition value) {
		parent = (StepDefinitionImpl) value;
		parent.stepParametersList.add(this);
	}

	@Override
	public void setTable(ITable value) {
		this.table = value;
	}

	@Override
	public String getNameLong() {
		throw new UnsupportedOperationException("getNameLong() is not implemented");
	}

	@Override
	public IStatement getStatement(int index) {
		throw new UnsupportedOperationException("getStatement(int index) is not implemented");
	}

	@Override
	public IStatement getStatement(String name) {
		throw new UnsupportedOperationException("getStatement(String name) is not implemented");
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

}
