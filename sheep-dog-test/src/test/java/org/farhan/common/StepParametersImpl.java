package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;

public class StepParametersImpl implements IStepParameters {

	private ArrayList<ArrayList<String>> table;
	private ArrayList<IStatement> statementList;

	public StepParametersImpl(ArrayList<String> header) {
		this.table = new ArrayList<ArrayList<String>>();
		this.table.add(header);
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
	public ArrayList<ArrayList<String>> getTable() {
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
	public void setTable(ArrayList<ArrayList<String>> value) {
		this.table = value;
	}

}
