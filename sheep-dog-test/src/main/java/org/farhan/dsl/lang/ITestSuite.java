package org.farhan.dsl.lang;

import java.util.List;

public interface ITestSuite extends IModel {

    boolean addLine(ILine value);

    boolean addTestCase(ITestCase value);

    boolean addTestSetup(ITestSetup value);

    String getContent() throws Exception;

    String getName();

    ITestProject getParent();

    IDescription getDescription();

    ITestStepContainer getTestStepContainer(int index);

    ITestStepContainer getTestStepContainer(String name);

    List<ITestStepContainer> getTestStepContainerList();

    void setContent(String text) throws Exception;

    void setName(String value);

}
