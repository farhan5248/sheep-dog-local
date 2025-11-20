package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.TestSuite;

public class TestSuiteImpl implements ITestSuite {

	private static final Logger logger = Logger.getLogger(TestSuiteImpl.class);

	private ITestProject parent;
	private TestSuite eObject;

	public TestSuiteImpl(TestSuite testSuite) {
		this.eObject = testSuite;
	}

	@Override
	public ITestCase createTestCase(String value) {
		// Not needed in this project
		return null;
	}

	@Override
	public ITestStepContainer createTestSetup(String name) {
		// Not needed in this project
		return null;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public ITestProject getParent() {
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
	public void setParent(ITestProject value) {
		this.parent = value;
	}

	@Override
	public void setQualifiedName(String value) {
		// Not needed in this project
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		// Not needed in this project
	}

	@Override
	public void setTestSetup(ITestSetup value) {
		// Not needed in this project
	}

	@Override
	public void setTestStepContainerList(ArrayList<ITestStepContainer> value) {
		// Not needed in this project
	}

	@Override
	public String getResourceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResourceName(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNameLong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatement getStatement(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatement getStatement(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestStepContainer getTestStepContainer(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNameLong(String value) {
		// TODO Auto-generated method stub

	}

}
