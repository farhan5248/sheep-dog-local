package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.*;

public class TestCaseImpl implements ITestCase {

    private String name;
    private ITestSuite parent;
    private IDescription description;
    private List<ITestStep> testStepList = new ArrayList<>();
    private List<ITestData> testDataList = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public ITestSuite getParent() {
        return parent;
    }

    @Override
    public void setParent(ITestSuite value) {
        this.parent = value;
    }

    @Override
    public IDescription getDescription() {
        return description;
    }

    @Override
    public void setDescription(IDescription value) {
        this.description = value;
    }

    @Override
    public boolean addLine(ILine value) {
        return false;
    }

    @Override
    public boolean addTestStep(ITestStep value) {
        return testStepList.add(value);
    }

    @Override
    public ITestStep getTestStep(int index) {
        return testStepList.get(index);
    }

    @Override
    public ITestStep getTestStep(String name) {
        for (ITestStep ts : testStepList) {
            if (name.equals(ts.getFullName())) {
                return ts;
            }
        }
        return null;
    }

    @Override
    public List<ITestStep> getTestStepList() {
        return testStepList;
    }

    @Override
    public boolean addTestData(ITestData value) {
        return testDataList.add(value);
    }

    @Override
    public ITestData getTestData(int index) {
        return testDataList.get(index);
    }

    @Override
    public ITestData getTestData(String name) {
        for (ITestData td : testDataList) {
            if (name.equals(td.getName())) {
                return td;
            }
        }
        return null;
    }

    @Override
    public List<ITestData> getTestDataList() {
        return testDataList;
    }

}
