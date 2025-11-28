package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITable {
	Object getParent();

	void setParent(Object value);

	IRow getRow(int index);

	ArrayList<IRow> getRowList();

	void setRowList(ArrayList<IRow> value);
}
