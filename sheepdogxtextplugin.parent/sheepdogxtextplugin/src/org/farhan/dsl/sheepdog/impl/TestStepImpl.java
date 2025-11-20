package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.IText;
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
	public IText getText() {
		if (eObject.getText() != null) {
			TextImpl text = new TextImpl(eObject.getText());
			// eObject.getText().getName().replaceFirst("^----\n",
			// "").replaceFirst("\n----$", "").replace("\\----",----")

			return text;
		} else {
			return null;
		}
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
	public void setTable(ITable value) {
		// Not needed in this project
	}

	@Override
	public void setText(IText value) {
		// TODO Auto-generated method stub

	}

}
