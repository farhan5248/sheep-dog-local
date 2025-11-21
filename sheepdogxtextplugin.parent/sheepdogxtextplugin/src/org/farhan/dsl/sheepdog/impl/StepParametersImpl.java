package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.farhan.dsl.sheepdog.sheepDog.Table;
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
		// TODO why does this need 2 nested statement list calls?
		if (eObject.getStatementList() != null) {
			for (Statement s : eObject.getStatementList().getStatementList()) {
				statementList.add(new StatementImpl(s));
			}
		}
		return statementList;
	}

	@Override
	public ITable getTable() {
		ITable newTable = new TableImpl();
		Table table = eObject.getTable();
		if (table != null) {
			for (Row r : table.getRowList()) {
				RowImpl row = new RowImpl(r);
				row.setParent(newTable);
				newTable.getRowList().add(row);
				for (Cell c : r.getCellList()) {
					CellImpl cell = new CellImpl(c);
					cell.setParent(row);
					row.getCellList().add(cell);
				}
			}
		}
		return newTable;
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
		// TODO should setters like these be used instead of directly accessing the
		// eObject setters?
		// Not needed in this project
	}

	@Override
	public void setTable(ITable value) {
		// Not needed in this project
	}

	@Override
	public String getNameLong() {
		// TODO Auto-generated method stub
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
	public void setNameLong(String value) {
		// TODO Auto-generated method stub
		
	}

}
