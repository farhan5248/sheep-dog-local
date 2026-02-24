package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IDescription;
import org.farhan.dsl.lang.ILine;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;

public class TestSuiteImpl implements ITestSuite {

	ArrayList<TestStepContainerImpl> testStepContainerList;
	String qualifiedName;
	String name;
	TestProjectImpl parent;
	DescriptionImpl description;

	TestSuiteImpl() {
		this.testStepContainerList = new ArrayList<TestStepContainerImpl>();
	}

	@Override
	public String getContent() throws Exception {
		throw new UnsupportedOperationException("getContent() is not implemented");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ITestProject getParent() {
		return parent;
	}

	@Override
	public String getNameLong() {
		return qualifiedName;
	}

	@Override
	public IDescription getDescription() {
		return description;
	}

	@Override
	public ITestStepContainer getTestStepContainer(int index) {
		return testStepContainerList.get(index);
	}

	@Override
	public ITestStepContainer getTestStepContainer(String name) {
		for (ITestStepContainer tsc : this.testStepContainerList) {
			if (tsc.getName().contentEquals(name)) {
				return tsc;
			}
		}
		return null;
	}

	@Override
	public List<ITestStepContainer> getTestStepContainerList() {
		return Collections.unmodifiableList(testStepContainerList);
	}

	@Override
	public void setContent(String text) throws Exception {
		throw new UnsupportedOperationException("setContent(String text)  is not implemented");
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setNameLong(String value) {
		this.qualifiedName = value;
		String[] nameParts = qualifiedName.split("/");
		this.name = nameParts[nameParts.length - 1];
	}

	@Override
	public boolean addLine(ILine value) {
		if (description == null) {
			description = new DescriptionImpl();
			description.parent = this;
		}
		description.addLine(value);
		return true;
	}

	@Override
	public boolean addTestCase(ITestCase value) {
		testStepContainerList.add((TestCaseImpl) value);
		testStepContainerList.getLast().parent = this;
		return true;
	}

	@Override
	public boolean addTestSetup(ITestSetup value) {
		testStepContainerList.add(0, (TestSetupImpl) value);
		testStepContainerList.getFirst().parent = this;
		return true;
	}

	@Override
	public String toString() {
		return qualifiedName != null ? qualifiedName : (name != null ? name : "");
	}

}
