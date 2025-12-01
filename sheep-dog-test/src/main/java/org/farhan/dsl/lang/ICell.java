package org.farhan.dsl.lang;

public interface ICell {

	String getName();

	void setName(String value);

	IRow getParent();
}
