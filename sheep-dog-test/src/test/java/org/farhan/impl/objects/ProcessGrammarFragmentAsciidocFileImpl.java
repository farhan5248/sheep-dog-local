package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarFragmentAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessGrammarFragmentAsciidocFileImpl extends TestObjectSheepDogImpl
        implements ProcessGrammarFragmentAsciidocFile {

    @Override
    public void setTestStepTypeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap) {
        addTestCaseWithName("TestCase1");
        addTestStepWithFullName(keyMap.get("Test Step Full Name"));
    }

    @Override
    public String getStepObjectRefComponentFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestSuite doc = (ITestSuite) workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
        return "";
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getComponentType(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getComponentTypeDesc(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getComponent(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getComponentName(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefObjectFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestSuite doc = (ITestSuite) workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
        return "";
    }

    @Override
    public String getStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getObject(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getObjectName(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getObjectType(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestSuite doc = (ITestSuite) workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
        return "";
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getObjectType(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getObjectTypeDesc(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestSuite doc = (ITestSuite) workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
        return "";
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getObjectType(testStep.getFullName());
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepObjectRefFragments.getObjectEdgeTypeDesc(testStep.getFullName());
    }

    private ITestStep getFirstTestStep() {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestSuite doc = (ITestSuite) workspace.getTestDocument(getFullNameFromPath());
        return doc.getTestStepContainer(0).getTestStepList().get(0);
    }
}
