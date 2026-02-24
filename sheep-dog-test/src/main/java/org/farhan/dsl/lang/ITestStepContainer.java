package org.farhan.dsl.lang;

import java.util.List;

public interface ITestStepContainer {

    String getName();

    ITestSuite getParent();

    IDescription getDescription();

    ITestStep getTestStep(int index);

    ITestStep getTestStep(String name);

    List<ITestStep> getTestStepList();

    void setName(String value);

    boolean addLine(ILine value);

    boolean addTestStep(ITestStep value);

}
