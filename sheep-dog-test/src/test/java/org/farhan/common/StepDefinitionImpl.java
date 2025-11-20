package org.farhan.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;

public class StepDefinitionImpl implements IStepDefinition {

	String predicate;
	ArrayList<IStepParameters> stepParametersList;
	ArrayList<IStatement> statementList;

	public StepDefinitionImpl(String predicate) {
		this.predicate = predicate;
		this.stepParametersList = new ArrayList<IStepParameters>();
		this.statementList = new ArrayList<IStatement>();
	}

	private String cellsToString(ArrayList<ICell> cells) {
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
	public IStepParameters createStepParameters(IRow row) {
		IStepParameters stepParameters = getStepParameters(row);
		if (stepParameters == null) {
			stepParameters = new StepParametersImpl(row);
		}
		stepParameters.setParent(this);
		stepParametersList.add(stepParameters);
		return stepParameters;
	}

	@Override
	public String getName() {

		return predicate;
	}

	@Override
	public String getNameLong() {
		// Not needed in this project
		return null;
	}

	@Override
	public IStepObject getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		return statementList;
	}

	@Override
	public ArrayList<IStepParameters> getStepParameterList() {
		return stepParametersList;
	}

	@Override
	public IStepParameters getStepParameters(IRow row) {
		for (IStepParameters sp : stepParametersList) {
			if (cellsToString(row.getCellList())
					.contentEquals(cellsToString(sp.getTable().getRowList().getFirst().getCellList()))) {
				return sp;
			}
		}
		return null;
	}

	@Override
	public void setName(String value) {
		this.predicate = value;
	}

	@Override
	public void setNameLong(String value) {
		// Not needed in this project
	}

	@Override
	public void setParent(IStepObject value) {
		// Not needed in this project
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		statementList = value;
	}

	@Override
	public void setStepParametersList(ArrayList<IStepParameters> value) {
		this.stepParametersList = value;
	}

	@Override
	public IStepParameters createStepParametersTmp(ArrayList<String> table) {
		return null;
	}

	@Override
	public IStepParameters getStepParametersTmp(ArrayList<String> table) {
		return null;
	}

	@Override
	public IStatement getStatement(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatement getStatement(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStepParameters getStepParameters(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStepParameters getStepParameters(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
