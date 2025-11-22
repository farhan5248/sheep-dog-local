package org.farhan.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.IText;

public class StepParametersImpl implements IStepParameters {

	private IStepDefinition parent;
	private ITable table;
	private ArrayList<IStatement> statementList;

	public StepParametersImpl(IRow header) {
		this.table = new TableImpl();
		this.table.getRowList().add(header);
		this.statementList = new ArrayList<IStatement>();
	}

	public StepParametersImpl(IText value) {
		CellImpl cell = new CellImpl(value.getName());
		RowImpl row = new RowImpl();
		cell.setParent(row);
		row.getCellList().add(cell);		
		this.table = new TableImpl();
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
	public ArrayList<IStatement> getStatementList() {
		return statementList;
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
		parent = value;
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		throw new UnsupportedOperationException("setStatementList(ArrayList<IStatement> value) is not implemented");
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
