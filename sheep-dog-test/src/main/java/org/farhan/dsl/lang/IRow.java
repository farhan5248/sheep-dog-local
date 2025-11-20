package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IRow {
	ITable getParent();

	void setParent(ITable value);

	ICell getCell(int index);

	ICell getCell(String name);

	ArrayList<ICell> getCellList();

	void setCellList(ArrayList<ICell> value);
}
