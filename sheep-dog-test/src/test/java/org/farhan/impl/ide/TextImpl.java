package org.farhan.impl.ide;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;

public class TextImpl implements IText {

	TestStepImpl parent;
	String name;

	public TextImpl() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public ITestStep getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return name != null ? name : "";
	}

}
