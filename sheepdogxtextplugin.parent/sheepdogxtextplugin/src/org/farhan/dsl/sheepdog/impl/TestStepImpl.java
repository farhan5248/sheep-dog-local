package org.farhan.dsl.sheepdog.impl;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;

public class TestStepImpl implements ITestStep {

	TestStep eObject;
	private TestStepContainerImpl parent;

	public TestStepImpl(TestStep testStep) {
		this.eObject = testStep;
		parent = null;
	}

	@Override
	public String getName() {
		String name = "";
		name += eObject.getObject() != null ? eObject.getObject() : "";
		name += eObject.getPredicate() != null ? eObject.getPredicate() : "";
		return name;
	}

	@Override
	public String getNameLong() {
		throw new UnsupportedOperationException("getNameLong() is not implemented");
	}

	@Override
	public ITestStepContainer getParent() {
		if (parent == null) {
			if (eObject.eContainer() instanceof TestCase) {
				parent = new TestCaseImpl((TestCase) eObject.eContainer());
			} else {
				parent = new TestSetupImpl((TestSetup) eObject.eContainer());
			}
		}
		return parent;

	}

	@Override
	public ITable getTable() {
		if (eObject.getTable() != null) {
			return new TableImpl(eObject.getTable());
		} else {
			return null;
		}
	}

	@Override
	public IText getText() {
		if (eObject.getText() != null) {
			TextImpl text = new TextImpl(eObject.getText());
			// eObject.getText().getName().replaceFirst("^----\n",
			// "").replaceFirst("\n----$", "").replace("\\----",----")

			return text;
		} else {
			return null;
		}
	}

	@Override
	public void setName(String value) {
		throw new UnsupportedOperationException("setName(String value) is not implemented");
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

	@Override
	public void setTable(ITable value) {
		throw new UnsupportedOperationException("setTable(ITable value) is not implemented");
	}

	@Override
	public void setText(IText value) {
		throw new UnsupportedOperationException("setText(IText value) is not implemented");
	}

	public boolean equals(Object object) {
		return eObject.equals(((TestStepImpl) object).eObject);
	}
}
