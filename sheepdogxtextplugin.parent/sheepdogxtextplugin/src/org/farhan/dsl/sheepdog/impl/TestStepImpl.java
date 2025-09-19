package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.Table;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;

public class TestStepImpl implements ITestStep {

	TestStep eObject;
	ITestStepContainer parent;

	public TestStepImpl(TestStep testStep) {
		this.eObject = testStep;
		parent = null;
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
	public ITestStepContainer getParent() {
		if (parent == null) {
			if (eObject.eContainer() instanceof TestCase) {
				parent = new TestCaseImpl((TestCase) eObject.eContainer());
			} else {
				parent = new TestSetupImpl((TestSetup) eObject.eContainer());
			}
		}
		return parent;

	}

	@Override
	public ArrayList<ArrayList<String>> getTable() {
		ArrayList<ArrayList<String>> newTable = new ArrayList<ArrayList<String>>();
		Table table = eObject.getTable();
		if (table != null) {
			for (Row r : table.getRowList()) {
				ArrayList<String> newRow = new ArrayList<String>();
				newTable.add(newRow);
				for (Cell c : r.getCellList()) {
					newRow.add(c.getName());
				}
			}
		}
		return newTable;
	}

	@Override
	public String getText() {
		// Not needed in this project
		return null;
	}

	@Override
	public void setName(String value) {
		// Not needed in this project
	}

	@Override
	public void setNameLong(String value) {
		// Not needed in this project
	}

	@Override
	public void setParent(ITestStepContainer value) {
		this.parent = value;
	}

	@Override
	public void setTable(ArrayList<ArrayList<String>> value) {
		// Not needed in this project
	}

	@Override
	public void setText(String value) {
		// Not needed in this project
	}

}
