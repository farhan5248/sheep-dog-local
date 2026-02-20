package org.farhan.impl.ide;

import org.farhan.dsl.lang.IStatement;

public class StatementImpl implements IStatement {

	String name;
	Object parent;

	StatementImpl() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public Object getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return name != null ? name : "";
	}

}
