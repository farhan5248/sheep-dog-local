package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;
import java.util.List;

import org.farhan.dsl.lang.ILine;
import org.farhan.dsl.lang.INestedDescription;
import org.farhan.dsl.sheepdog.sheepDog.Line;
import org.farhan.dsl.sheepdog.sheepDog.NestedDescription;

public class NestedDescriptionImpl implements INestedDescription {

	NestedDescription eObject;

	public NestedDescriptionImpl(NestedDescription nestedDescription) {
		this.eObject = nestedDescription;
	}

	@Override
	public ILine getLine(int index) {
		return new LineImpl(eObject.getLineList().get(index));
	}

	@Override
	public ILine getLine(String name) {
		for (Line l : eObject.getLineList()) {
			if (l.getContent().equals(name)) {
				return new LineImpl(l);
			}
		}
		return null;
	}

	@Override
	public List<ILine> getLineList() {
		List<ILine> lineList = new ArrayList<ILine>();
		for (Line l : eObject.getLineList()) {
			lineList.add(new LineImpl(l));
		}
		return lineList;
	}

	@Override
	public Object getParent() {
		return eObject.eContainer();
	}

	@Override
	public boolean addLine(ILine value) {
		eObject.getLineList().add(((LineImpl) value).eObject);
		return true;
	}

}
