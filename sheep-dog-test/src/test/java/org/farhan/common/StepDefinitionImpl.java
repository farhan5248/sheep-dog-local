package org.farhan.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	private String cellsToString(List<String> cells) {
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (String cell : cells) {
			sortedCells.add(cell);
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}

	@Override
	public IStepParameters createStepParameters(ArrayList<String> table) {
		IStepParameters stepParameters = getStepParameters(table);
		if (stepParameters == null) {
			stepParameters = new StepParametersImpl(table);
		}
		stepParameters.setParent(this);
		stepParametersList.add(stepParameters);
		return stepParameters;
	}

	@Override
	public IStepParameters createStepParameters(String text) {
		// Not needed in this project
		return null;
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
	public IStepParameters getStepParameters(ArrayList<String> table) {
		for (IStepParameters sp : stepParametersList) {
			if (cellsToString(table).contentEquals(cellsToString(sp.getTable().getFirst()))) {
				return sp;
			}
		}
		return null;
	}

	@Override
	public IStepParameters getStepParameters(String text) {
		// Not needed in this project
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

}
