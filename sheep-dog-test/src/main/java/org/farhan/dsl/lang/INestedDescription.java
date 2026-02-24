package org.farhan.dsl.lang;

import java.util.List;

public interface INestedDescription {

	ILine getLine(int index);

	ILine getLine(String name);

	List<ILine> getLineList();

	Object getParent();

	boolean addLine(ILine value);
}
