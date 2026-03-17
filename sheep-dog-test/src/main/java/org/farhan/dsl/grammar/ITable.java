package org.farhan.dsl.grammar;

import java.util.List;

public interface ITable {
	Object getParent();

	void setParent(Object value);

	boolean addRow(IRow value);

	IRow getRow(int index);

	List<IRow> getRowList();

}
