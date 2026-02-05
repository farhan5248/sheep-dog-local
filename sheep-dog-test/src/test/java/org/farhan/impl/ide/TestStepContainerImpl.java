package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;

public class TestStepContainerImpl implements ITestStepContainer {

    ArrayList<TestStepImpl> testStepList;
    String name;
    TestSuiteImpl parent;

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
    public ArrayList<IStatement> getStatementList() {
        throw new UnsupportedOperationException("getStatementList() is not implemented");
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
    public ITestStep getTestStep(int index) {
        return testStepList.get(index);
    }

    @Override
    public ITestStep getTestStep(String name) {
        for (ITestStep ts : testStepList) {
            if (ts.getName().contentEquals(name)) {
                return ts;
            }
        }
        return null;
    }

    @Override
    public boolean addStatement(IStatement value) {
        throw new UnsupportedOperationException("addStatement(IStatement value) is not implemented");
    }

    @Override
    public boolean addTestStep(ITestStep value) {
        testStepList.add((TestStepImpl) value);
        testStepList.getLast().parent = this;
        return true;
    }

}
