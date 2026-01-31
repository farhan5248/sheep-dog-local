package org.farhan.impl.ide;

import org.farhan.dsl.lang.IStatement;

public class StatementImpl implements IStatement {

	String name;
	Object parent;

	public StatementImpl(String name) {
		this.name = name;
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

}
