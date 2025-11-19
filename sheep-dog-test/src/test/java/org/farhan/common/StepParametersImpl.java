package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;

public class StepParametersImpl implements IStepParameters {

	private ITable table;
	private ArrayList<IStatement> statementList;

	public StepParametersImpl(IRow header) {
		this.table = new TableImpl();
		this.table.getRowList().add(header);
		this.statementList = new ArrayList<IStatement>();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStepDefinition getParent() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(IStepDefinition value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTable(ITable value) {
		this.table = value;
	}

}
