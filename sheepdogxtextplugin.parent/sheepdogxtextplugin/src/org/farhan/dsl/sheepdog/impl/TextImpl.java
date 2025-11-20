package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.sheepdog.sheepDog.Text;

public class TextImpl implements IText {

	private ITestStep parent;
	private Text eObject;

	public TextImpl(Text text) {
		eObject = text;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public void setName(String value) {
		eObject.setName(value);
	}

	@Override
	public ITestStep getParent() {
		return parent;
	}

	@Override
	public void setParent(ITestStep value) {
		parent = value;
	}

}
