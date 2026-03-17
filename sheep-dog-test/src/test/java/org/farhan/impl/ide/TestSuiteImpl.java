package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.*;

public class TestSuiteImpl implements ITestSuite {

    private String fullName;
    private String name;
    private IDescription description;
    private List<ITestStepContainer> testStepContainerList = new ArrayList<>();

    @Override
    public boolean addLine(ILine value) {
        return false;
    }

    @Override
    public boolean addTestCase(ITestCase value) {
        return testStepContainerList.add(value);
    }

    @Override
    public boolean addTestSetup(ITestSetup value) {
        return false;
    }

    @Override
    public String getContent() throws Exception {
        return null;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITestProject getParent() {
        return null;
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
        for (ITestStepContainer tsc : testStepContainerList) {
            if (name.equals(tsc.getName())) {
                return tsc;
            }
        }
        return null;
    }

    @Override
    public List<ITestStepContainer> getTestStepContainerList() {
        return testStepContainerList;
    }

    @Override
    public void setContent(String text) throws Exception {
    }

    @Override
    public void setFullName(String value) {
        this.fullName = value;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public void setDescription(IDescription value) {
        this.description = value;
    }

}
