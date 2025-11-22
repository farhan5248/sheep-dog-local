package org.farhan.impl;

import org.farhan.dsl.lang.IStatement;

public class StatementImpl implements IStatement {

	private String name;

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

}
