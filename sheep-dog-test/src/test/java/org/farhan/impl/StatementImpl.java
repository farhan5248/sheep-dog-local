package org.farhan.impl;

import org.farhan.dsl.lang.IStatement;

public class StatementImpl implements IStatement {

	String name;
	private Object parent;

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

	@Override
	public void setParent(Object parent) {
		this.parent = parent;
		if (this.parent instanceof StepDefinitionImpl) {
			((StepDefinitionImpl) this.parent).statementList.add(this);
		} else if (this.parent instanceof StepObjectImpl) {
			((StepObjectImpl) this.parent).statementList.add(this);
		}
	}

}
