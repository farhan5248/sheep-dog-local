package org.farhan.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSetup;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogBuilder;

public class TestSuiteImpl implements ITestSuite {

	ArrayList<TestStepContainerImpl> testStepContainerList;
	String fullName;
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
	public String getFullName() {
		return fullName;
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
	public void setFullName(String value) {
		this.fullName = value;
		String[] nameParts = fullName.split("/");
		this.name = nameParts[nameParts.length - 1].replaceAll("\\.[^.]+$", "");
	}

	@Override
	public void setDescription(IDescription value) {
		this.description = (DescriptionImpl) value;
		this.description.parent = this;
	}

	@Override
	public boolean addLine(ILine value) {
		description = (DescriptionImpl) SheepDogBuilder.createDescription(this);
		description.addLine(value);
		return true;
	}

	@Override
	public boolean addTestCase(ITestCase value) {
		TestCaseImpl impl = (TestCaseImpl) value;
		testStepContainerList.add(impl);
		impl.parent = this;
		return true;
	}

	@Override
	public boolean addTestSetup(ITestSetup value) {
		TestStepContainerImpl impl = (TestStepContainerImpl) value;
		int insertIndex = 0;
		while (insertIndex < testStepContainerList.size()
				&& testStepContainerList.get(insertIndex) instanceof TestSetupImpl) {
			insertIndex++;
		}
		testStepContainerList.add(insertIndex, impl);
		impl.parent = this;
		return true;
	}

	@Override
	public String toString() {
		return fullName != null ? fullName : (name != null ? name : "");
	}

}
