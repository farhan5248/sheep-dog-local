package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IDescription;
import org.farhan.dsl.lang.ILine;

public class DescriptionImpl implements IDescription {

	ArrayList<LineImpl> lineList;
	Object parent;

	DescriptionImpl() {
		this.lineList = new ArrayList<LineImpl>();
	}

	@Override
	public ILine getLine(int index) {
		return lineList.get(index);
	}

	@Override
	public ILine getLine(String name) {
		for (ILine l : lineList) {
			if (l.getName().equals(name)) {
				return l;
			}
		}
		return null;
	}

	@Override
	public List<ILine> getLineList() {
		return Collections.unmodifiableList(lineList);
	}

	@Override
	public Object getParent() {
		return parent;
	}

	@Override
	public boolean addLine(ILine value) {
		lineList.add((LineImpl) value);
		lineList.getLast().parent = this;
		return true;
	}

}
