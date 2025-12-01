package org.farhan.dsl.lang;

import java.util.List;

public interface ITable {
	Object getParent();

	void setParent(Object value);

	IRow getRow(int index);

	List<IRow> getRowList();

}
