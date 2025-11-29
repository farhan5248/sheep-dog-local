package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.TestSuite;

public class TestSuiteImpl implements ITestSuite {

	private static ITestProject parent;
	private TestSuite eObject;

	public TestSuiteImpl(TestSuite testSuite) {
		this.eObject = testSuite;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public ITestProject getParent() {
		if (parent == null) {
			// TODO pass in the project root
			parent = new TestProjectImpl(new SourceFileRepository(eObject.eResource().getURI().toPlatformString(true)));
		}
		return parent;
	}

	@Override
	public String getQualifiedName() {
		// Not needed in this project
		return null;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		// Not needed in this project
		return null;
	}

	@Override
	public ITestStepContainer getTestStepContainer(String name) {

		for (TestStepContainer t : eObject.getTestStepContainerList()) {
			if (t instanceof TestCase) {
				if (t.getName().contentEquals(name)) {
					TestCaseImpl testCase = new TestCaseImpl((TestCase) t);
					testCase.setParent(this);
					return testCase;
				}
			} else {
				if (t.getName().contentEquals(name)) {
					TestSetupImpl testCase = new TestSetupImpl((TestSetup) t);
					testCase.setParent(this);
					return testCase;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<ITestStepContainer> getTestStepContainerList() {
		// Not needed in this project
		return null;
	}

	@Override
	public void setName(String value) {
		eObject.setName(value);
	}

	@Override
	public void setParent(ITestProject parent) {
		TestSuiteImpl.parent = parent;
	}

	@Override
	public void setQualifiedName(String value) {
		throw new UnsupportedOperationException("setQualifiedName(String value) is not implemented");
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		throw new UnsupportedOperationException("setStatementList(ArrayList<IStatement> value) is not implemented");
	}

	@Override
	public void setTestSetup(ITestSetup value) {
		throw new UnsupportedOperationException("setTestSetup(ITestSetup value) is not implemented");
	}

	@Override
	public void setTestStepContainerList(ArrayList<ITestStepContainer> value) {
		throw new UnsupportedOperationException(
				"setTestStepContainerList(ArrayList<ITestStepContainer> value) is not implemented");
	}

	@Override
	public String getResourceName() {
		throw new UnsupportedOperationException("getResourceName() is not implemented");
	}

	@Override
	public void setResourceName(String value) {
		throw new UnsupportedOperationException("setResourceName(String value) is not implemented");
	}

	@Override
	public String getNameLong() {
		throw new UnsupportedOperationException("getNameLong() is not implemented");
	}

	@Override
	public IStatement getStatement(int index) {
		throw new UnsupportedOperationException("getStatement(int index) is not implemented");
	}

	@Override
	public IStatement getStatement(String name) {
		throw new UnsupportedOperationException("getStatement(String name) is not implemented");
	}

	@Override
	public ITestStepContainer getTestStepContainer(int index) {
		return new TestStepContainerImpl(eObject.getTestStepContainerList().get(index));
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

}
