package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;

public class StepDefinitionImpl implements IStepDefinition {

	private IStepObject parent;
	private StepDefinition eObject;

	public StepDefinitionImpl(StepDefinition value) {
		this.eObject = value;
	}

	private String cellsToString(List<Cell> cells, boolean sorted) {
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (Cell cell : cells) {
			if (cell.getName() != null) {
				sortedCells.add(cell.getName());
			}
		}
		if (sorted) {
			Collections.sort(sortedCells);
		}
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString;
	}

	private String cellsToString(ArrayList<ICell> arrayList) {
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (ICell cell : arrayList) {
			sortedCells.add(cell.getName());
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}

	@Override
	public IStepParameters createStepParameters(IRow header) {
		StepParameters parameters = SheepDogFactory.eINSTANCE.createStepParameters();
		parameters.setName(Integer.toString(eObject.getStepParameterList().size() + 1));
		eObject.getStepParameterList().add(parameters);

		parameters.setTable(SheepDogFactory.eINSTANCE.createTable());
		Row row = SheepDogFactory.eINSTANCE.createRow();
		parameters.getTable().getRowList().add(row);
		if (header == null) {
			// TODO there's no automated test for this..
			// This is a docstring and also the abuse of this method :P
			Cell cell = SheepDogFactory.eINSTANCE.createCell();
			cell.setName("Content");
			row.getCellList().add(cell);
		} else {
			for (ICell srcCell : header.getCellList()) {
				Cell cell = SheepDogFactory.eINSTANCE.createCell();
				cell.setName(srcCell.getName());
				row.getCellList().add(cell);
			}
		}

		IStepParameters stepParameters = new StepParametersImpl(parameters);
		stepParameters.setParent(this);
		return stepParameters;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public String getNameLong() {
		// Not needed in this project
		return null;
	}

	@Override
	public IStepObject getParent() {
		if (parent == null) {
			parent = new StepObjectImpl((StepObject) eObject.eContainer());
		}
		return parent;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		ArrayList<IStatement> statementList = new ArrayList<IStatement>();
		for (Statement s : eObject.getStatementList()) {
			statementList.add(new StatementImpl(s));
		}
		return statementList;
	}

	@Override
	public ArrayList<IStepParameters> getStepParameterList() {
		ArrayList<IStepParameters> list = new ArrayList<IStepParameters>();
		for (StepParameters t : eObject.getStepParameterList()) {
			StepParametersImpl stepParameters = new StepParametersImpl((StepParameters) t);
			stepParameters.setParent(this);
			list.add(stepParameters);
		}
		return list;
	}

	@Override
	public IStepParameters getStepParameters(IRow headers) {
		for (StepParameters sp : eObject.getStepParameterList()) {
			String spString = cellsToString(sp.getTable().getRowList().getFirst().getCellList(), true);
			String headersString = cellsToString(headers.getCellList());
			if (spString.contentEquals(headersString)) {
				StepParametersImpl stepParameters = new StepParametersImpl(sp);
				stepParameters.setParent(this);
				return stepParameters;
			}
		}
		return null;
	}

	@Override
	public void setName(String value) {
		eObject.setName(value);
	}

	@Override
	public void setNameLong(String value) {
		// Not needed in this project
	}

	@Override
	public void setParent(IStepObject value) {
		parent = value;
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		// Not needed in this project
	}

	@Override
	public void setStepParametersList(ArrayList<IStepParameters> value) {
		// Not needed in this project
	}

	public EObject getEObject() {
		// TODO add this to all interfaces
		return eObject;
	}

	@Override
	public IStepParameters createStepParametersTmp(ArrayList<String> table) {
		// TODO delete after IText creation
		return null;
	}

	@Override
	public IStepParameters getStepParametersTmp(ArrayList<String> table) {
		// TODO delete after IText creation
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
