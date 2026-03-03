package org.farhan.dsl.grammar;

import java.util.List;

public interface ITable {
	Object getParent();

	boolean addRow(IRow value);

	IRow getRow(int index);

	List<IRow> getRowList();

}
