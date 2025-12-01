package org.farhan.dsl.lang;

import java.util.List;

public interface IRow {
	
	boolean addCell(ICell value);

	ICell getCell(int index);

	ICell getCell(String name);

	List<ICell> getCellList();

	ITable getParent();

}
