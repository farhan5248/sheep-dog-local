package org.farhan.mock;

import org.farhan.dsl.grammar.ILine;

public class LineImpl implements ILine {

	String content;
	Object parent;

	LineImpl() {
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String value) {
		this.content = value;
	}

	@Override
	public Object getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return content != null ? content : "";
	}

}
