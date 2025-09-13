package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestProject {

    ArrayList<String> getStepObjectList();

    ArrayList<String> getTestSuiteList();

    void setStepObjectList(ArrayList<String> stepObjectList);

    void setTestSuiteList(ArrayList<String> testSuiteList);
}