package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.*;

public class TestSetupImpl implements ITestSetup {

    private String name;
    private IDescription description;
    private List<ITestStep> testStepList = new ArrayList<>();

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
        return null;
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

}
