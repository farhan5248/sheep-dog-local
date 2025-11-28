package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;

public class StepParametersImpl implements IStepParameters {
	private IStepDefinition parent;
	private StepParameters eObject;

	public StepParametersImpl(StepParameters stepParameters) {
		eObject = stepParameters;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public IStepDefinition getParent() {
		if (parent == null) {
			parent = new StepDefinitionImpl((StepDefinition) eObject.eContainer());
		}
		return parent;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		ArrayList<IStatement> statementList = new ArrayList<IStatement>();
		if (eObject.getStatementList() != null) {
			for (Statement s : eObject.getStatementList().getStatementList()) {
				statementList.add(new StatementImpl(s));
			}
		}
		return statementList;
	}

	@Override
	public ITable getTable() {
		return new TableImpl(eObject.getTable());
	}

	@Override
	public void setName(String value) {
		eObject.setName(value);
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
		// Not needed in this project
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
