package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.ILine;
import org.farhan.dsl.sheepdog.sheepDog.Line;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;

public class LineImpl implements ILine {

	Line eObject;
	private Object parent;

	public LineImpl(Line line) {
		this.eObject = line;
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

}
