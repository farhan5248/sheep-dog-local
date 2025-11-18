package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITable {
	// TODO, what would getParent return? a test step or test data? Maybe there
	// needs to be a TableContainer which is either TestStep or TestData

	ArrayList<IRow> getRowList();

	void setRowList(ArrayList<IRow> value);
}
