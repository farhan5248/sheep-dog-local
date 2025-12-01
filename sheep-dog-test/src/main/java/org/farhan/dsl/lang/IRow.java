package org.farhan.dsl.lang;

import java.util.List;

public interface IRow {
	ITable getParent();

	void setParent(ITable value);

	ICell getCell(int index);

	ICell getCell(String name);

	List<ICell> getCellList();

}
