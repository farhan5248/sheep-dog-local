package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.PhraseFragments;
import org.farhan.dsl.grammar.StepDefinitionRefFragments;
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
        setProperty("cursor", getDocument());
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
        setProperty("cursor", getDocument());
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
        setProperty("cursor", getDocument());
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
        setProperty("cursor", getDocument());
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

    @Override
    public String getStepDefinitionRefPartFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", getDocument());
        return "";
    }

    @Override
    public String getStepDefinitionRefPartFragmentPart(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getPart(testStep.getFullName());
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartDescription(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getPartDesc(testStep.getFullName());
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartType(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getPartType(testStep.getFullName());
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartTypeDescription(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getPartTypeDesc(testStep.getFullName());
    }

    @Override
    public String getStepDefinitionRefStateFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", getDocument());
        return "";
    }

    @Override
    public String getStepDefinitionRefStateFragmentState(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getState(testStep.getFullName());
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateDescription(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getStateDesc(testStep.getFullName());
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateType(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getStateType(testStep.getFullName());
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateTypeDescription(HashMap<String, String> keyMap) {
        ITestStep testStep = getFirstTestStep();
        return StepDefinitionRefFragments.getStateTypeDesc(testStep.getFullName());
    }

    @Override
    public void setLineTypeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setLineTypeLine(HashMap<String, String> keyMap) {
        setProperty("Line", keyMap.get("Line"));
    }

    @Override
    public String getPhraseTagFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", getDocument());
        return "";
    }

    @Override
    public String getPhraseTagFragmentTagList(HashMap<String, String> keyMap) {
        return PhraseFragments.getTagList((String) getProperty("Line"));
    }

    @Override
    public String getPhraseTodoFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", getDocument());
        return "";
    }

    @Override
    public String getPhraseTodoFragmentTodoType(HashMap<String, String> keyMap) {
        return PhraseFragments.getTodoType((String) getProperty("Line"));
    }

    @Override
    public String getPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap) {
        return PhraseFragments.getTodoDesc((String) getProperty("Line"));
    }

    private ITestSuite getDocument() {
        return (ITestSuite) ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath());
    }

    private ITestStep getFirstTestStep() {
        return getDocument().getTestStepContainer(0).getTestStepList().get(0);
    }
}
