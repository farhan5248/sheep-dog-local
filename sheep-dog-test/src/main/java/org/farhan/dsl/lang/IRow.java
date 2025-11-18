package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IRow {
	ITable getParent();

	void setParent(ITable value);

	ArrayList<ICell> getCellList();

	void setCellList(ArrayList<ICell> value);
}
