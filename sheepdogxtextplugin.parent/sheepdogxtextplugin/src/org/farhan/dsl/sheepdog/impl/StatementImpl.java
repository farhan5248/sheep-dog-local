package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;

public class StatementImpl implements IStatement {

	Statement eObject;
	private Object parent;

	public StatementImpl(Statement statement) {
		this.eObject = statement;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public void setName(String value) {
		this.eObject.setName(value);
	}

	@Override
	public Object getParent() {
		if (parent == null) {

			if (eObject.eContainer() instanceof org.farhan.dsl.sheepdog.sheepDog.impl.StepDefinitionImpl) {
				parent = new StepDefinitionImpl((StepDefinition) eObject.eContainer());
			} else if (eObject.eContainer() instanceof org.farhan.dsl.sheepdog.sheepDog.impl.StepObjectImpl) {
				parent = new StepObjectImpl((StepObject) eObject.eContainer());
			}

		}
		return parent;
	}

	@Override
	public void setParent(Object parent) {
		if (this.parent instanceof StepDefinitionImpl) {
			((StepDefinitionImpl) this.parent).eObject.getStatementList().add(eObject);
		} else if (this.parent instanceof StepObjectImpl) {
			((StepObjectImpl) this.parent).eObject.getStatementList().add(eObject);
		}
	}

}
