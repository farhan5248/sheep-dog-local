package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IDescription;
import org.farhan.dsl.lang.ILine;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;

public class TestStepContainerImpl implements ITestStepContainer {

    ArrayList<TestStepImpl> testStepList;
    String name;
    TestSuiteImpl parent;
    DescriptionImpl description;

    TestStepContainerImpl() {
        testStepList = new ArrayList<TestStepImpl>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITestSuite getParent() {
        return parent;
    }

    @Override
    public IDescription getDescription() {
        return description;
    }

    @Override
    public List<ITestStep> getTestStepList() {
        return Collections.unmodifiableList(testStepList);
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public ITestStep getTestStep(int index) {
        return testStepList.get(index);
    }

    @Override
    public ITestStep getTestStep(String name) {
        for (ITestStep ts : testStepList) {
            if (name.contentEquals(ts.getStepObjectName() + " " + ts.getStepDefinitionName())) {
                return ts;
            }
        }
        return null;
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
    public boolean addTestStep(ITestStep value) {
        testStepList.add((TestStepImpl) value);
        testStepList.getLast().parent = this;
        return true;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
