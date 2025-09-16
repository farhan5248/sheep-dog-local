package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;
import org.farhan.dsl.sheepdog.sheepDog.TestSuite;

public class TestSetupImpl implements ITestSetup {
	
	private TestSetup eObject;

	public TestSetupImpl(TestSetup testSetup) {
		this.eObject = testSetup;
	}

	@Override
	public ITestStep createTestStep(String stepName) {
		// Not needed in this project
		return null;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public ITestSuite getParent() {
		return new TestSuiteImpl((TestSuite) eObject.eContainer());
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		ArrayList<IStatement> statementList = new ArrayList<IStatement>();
		for (Statement s : eObject.getStatementList()) {
			statementList.add(new StatementImpl(s));
		}
		return statementList;
	}

	@Override
	public ArrayList<ITestStep> getTestStepList() {
		ArrayList<ITestStep> testStepList = new ArrayList<ITestStep>();
		for (TestStep s : eObject.getTestStepList()) {
			TestStepImpl testStep = new TestStepImpl(s);
			testStep.setParent(this);
			testStepList.add(testStep);
		}
		return testStepList;
	}

	@Override
	public void setName(String value) {
		// Not needed in this project
	}

	@Override
	public void setParent(ITestSuite value) {
		// Not needed in this project
	}

	@Override
	public void setStatementList(ArrayList<IStatement> value) {
		// Not needed in this project
	}

	@Override
	public void setTestStepList(ArrayList<ITestStep> value) {
		// Not needed in this project
	}

}
