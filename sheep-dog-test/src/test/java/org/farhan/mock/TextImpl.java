package org.farhan.mock;

import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;

public class TextImpl implements IText {

	TestStepImpl parent;
	String content;

	public TextImpl() {
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String value) {
		content = value;
	}

	@Override
	public ITestStep getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return content != null ? content : "";
	}

}
