package org.farhan.dsl.sheepdog.impl;

import org.eclipse.emf.common.util.EList;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;

public class TestCaseImpl extends TestStepContainerImpl implements ITestCase {

    public TestCaseImpl(TestCase testCase) {
        super(testCase);
    }

    @Override
    public EList<ITestData> getTestDataList() {
        throw new UnsupportedOperationException("ArrayList<ITestData> getTestDataList() is not implemented");
    }

}
