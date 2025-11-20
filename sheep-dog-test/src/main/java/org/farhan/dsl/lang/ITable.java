package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITable {
	// TODO, what should getParent return? for now TestStepContainer

	Object getParent();

	void setParent(Object value);

	IRow getRow(int index);

	ArrayList<IRow> getRowList();

	void setRowList(ArrayList<IRow> value);
}
