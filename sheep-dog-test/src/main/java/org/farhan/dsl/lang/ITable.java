package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITable {
	// TODO, what should getParent return? for now TestStepContainer

	ITestStep getParent();

	void setParent(ITestStep value);

	ArrayList<IRow> getRowList();

	void setRowList(ArrayList<IRow> value);
}
