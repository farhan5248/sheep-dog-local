package org.farhan.dsl.sheepdog.impl;

import java.util.ArrayList;

import org.farhan.dsl.lang.IDescription;
import org.farhan.dsl.lang.ILine;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.sheepdog.sheepDog.Description;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;
import org.farhan.dsl.sheepdog.sheepDog.TestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.TestSuite;

public class TestStepContainerImpl implements ITestStepContainer {

    TestStepContainer eObject;
    private TestSuiteImpl parent;

    public TestStepContainerImpl(TestStepContainer testCase) {
        this.eObject = testCase;
    }

    @Override
    public String getName() {
        return eObject.getName();
    }

    @Override
    public ITestSuite getParent() {
        if (parent == null) {
            parent = new TestSuiteImpl((TestSuite) eObject.eContainer());
        }
        return parent;
    }

    @Override
    public IDescription getDescription() {
        if (eObject.getDescription() != null) {
            return new DescriptionImpl(eObject.getDescription());
        }
        return null;
    }

    @Override
    public ArrayList<ITestStep> getTestStepList() {
        ArrayList<ITestStep> testStepList = new ArrayList<ITestStep>();
        for (TestStep s : eObject.getTestStepList()) {
            TestStepImpl testStep = new TestStepImpl(s);
            testStepList.add(testStep);
        }
        return testStepList;
    }

    @Override
    public void setName(String value) {
        throw new UnsupportedOperationException("setName(String value) is not implemented");
    }

    @Override
    public ITestStep getTestStep(int index) {
        return new TestStepImpl(eObject.getTestStepList().get(index));
    }

    @Override
    public ITestStep getTestStep(String name) {
        throw new UnsupportedOperationException("getTestStep(String name) is not implemented");
    }

    @Override
    public boolean addLine(ILine value) {
        Description list = eObject.getDescription();
        if (list == null) {
            list = SheepDogFactory.eINSTANCE.createDescription();
            eObject.setDescription(list);
        }
        list.getLineList().add(((LineImpl) value).eObject);
        return true;
    }

    @Override
    public boolean addTestStep(ITestStep value) {
        eObject.getTestStepList().add(((TestStepImpl) value).eObject);
        return true;
    }

}
