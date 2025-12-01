package org.farhan.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.StepDefinitionUtility;

public class StepDefinitionImpl implements IStepDefinition {

	String name;
	ArrayList<StepParametersImpl> stepParametersList;
	ArrayList<StatementImpl> statementList;
	StepObjectImpl parent;

	public StepDefinitionImpl(String name) {
		this.name = name;
		this.stepParametersList = new ArrayList<StepParametersImpl>();
		this.statementList = new ArrayList<StatementImpl>();
	}

	private String cellsToString(List<ICell> cells) {
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (ICell cell : cells) {
			sortedCells.add(cell.getName());
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getNameLong() {
		throw new UnsupportedOperationException("getNameLong() is not implemented");
	}

	@Override
	public IStepObject getParent() {
		throw new UnsupportedOperationException("getParent() is not implemented");
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
	public List<IStatement> getStatementList() {
		return Collections.unmodifiableList(statementList);
	}

	@Override
	public List<IStepParameters> getStepParameterList() {
		return Collections.unmodifiableList(stepParametersList);
	}

	@Override
	public IStepParameters getStepParameters(int index) {
		throw new UnsupportedOperationException("getStepParameters(int index) is not implemented");
	}

	@Override
	public IStepParameters getStepParameters(IRow row) {
		return StepDefinitionUtility.getStepParameters(this, cellsToString(row.getCellList()));
	}

	@Override
	public IStepParameters getStepParameters(IText value) {
		return StepDefinitionUtility.getStepParameters(this, "| Content");
	}

	@Override
	public IStepParameters getStepParameters(String name) {
		throw new UnsupportedOperationException("getStepParameters(String name) is not implemented");
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

	@Override
	public boolean addStatement(IStatement value) {
		statementList.add((StatementImpl) value);
		statementList.getLast().parent = this;
		return true;
	}

	@Override
	public boolean addStepParameters(IStepParameters value) {
		stepParametersList.add((StepParametersImpl) value);
		stepParametersList.getLast().parent = this;
		return true;
	}

}
