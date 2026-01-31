package org.farhan.impl.ide;

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

	StepDefinitionImpl parent;
	TableImpl table;
	ArrayList<StatementImpl> statementList;

	public StepParametersImpl(IRow header) {
		this.table = new TableImpl();
		this.table.parent = this;
		RowImpl row = new RowImpl();
		this.table.addRow(row);
		for (ICell c : header.getCellList()) {
			CellImpl newCell = new CellImpl(c.getName());
			row.addCell(newCell);
		}
		this.statementList = new ArrayList<StatementImpl>();
	}

	public StepParametersImpl(IText value) {
		this.table = new TableImpl();
		this.table.parent = this;
		RowImpl row = new RowImpl();
		this.table.addRow(row);
		CellImpl newCell = new CellImpl(value.getName());
		row.addCell(newCell);
		this.statementList = new ArrayList<StatementImpl>();
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
	public void setTable(ITable value) {
		this.table = (TableImpl) value;
		this.table.parent = this;
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
	public boolean addStatement(IStatement value) {
		statementList.add((StatementImpl) value);
		statementList.getLast().parent = this;
		return true;
	}

}
