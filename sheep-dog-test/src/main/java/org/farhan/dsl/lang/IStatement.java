package org.farhan.dsl.lang;

public interface IStatement {

	String getName();

	void setName(String value);

	Object getParent();

	void setParent(Object parent);
}
