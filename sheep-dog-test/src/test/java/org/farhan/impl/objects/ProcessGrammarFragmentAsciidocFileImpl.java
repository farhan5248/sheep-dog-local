package org.farhan.impl.objects;

import java.util.Arrays;
import java.util.HashMap;

import org.farhan.dsl.grammar.PhraseFragments;
import org.farhan.dsl.grammar.StepDefinitionRefFragments;
import org.farhan.dsl.grammar.StepDefinitionRefPartTypes;
import org.farhan.dsl.grammar.StepDefinitionRefStateTypes;
import org.farhan.dsl.grammar.StepObjectRefComponentTypes;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.farhan.dsl.grammar.StepObjectRefObjectEdgeTypes;
import org.farhan.dsl.grammar.StepObjectRefObjectVertexTypes;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarFragmentAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessGrammarFragmentAsciidocFileImpl extends TestObjectFileImpl implements ProcessGrammarFragmentAsciidocFile {

    @Override
    public String getPhraseTagFragmentTagList(HashMap<String, String> keyMap) {
        String expected = replaceKeyword(keyMap.get("Tag List"));
        java.util.List<String> actual = PhraseFragments.getTagAsList(properties.get("Line").toString());
        Assertions.assertTrue(actual
                .containsAll(expected.isEmpty() ? Arrays.asList() : Arrays.asList(expected.split(", "))));
        return listToString(actual);
    }

    @Override
    public String getPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap) {
        return PhraseFragments.getTodoDesc(properties.get("Line").toString());
    }

    @Override
    public String getPhraseTodoFragmentTodoType(HashMap<String, String> keyMap) {
        return PhraseFragments.getTodoType(properties.get("Line").toString());
    }

    @Override
    public String getStepDefinitionRefPartFragmentPart(HashMap<String, String> keyMap) {
        return StepDefinitionRefFragments.getPart(getStepDefinitionRef());
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartDescription(HashMap<String, String> keyMap) {
        return StepDefinitionRefFragments.getPartDesc(getStepDefinitionRef());
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartType(HashMap<String, String> keyMap) {
        return StepDefinitionRefFragments.getPartType(getStepDefinitionRef());
    }

    @Override
    public String getStepDefinitionRefPartFragmentPartTypeDescription(HashMap<String, String> keyMap) {
        String partType = StepDefinitionRefFragments.getPartType(getStepDefinitionRef());
        return StepDefinitionRefPartTypes.valueOf(partType.toUpperCase()).description;
    }

    @Override
    public String getStepDefinitionRefStateFragmentState(HashMap<String, String> keyMap) {
        return StepDefinitionRefFragments.getState(getStepDefinitionRef());
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateDescription(HashMap<String, String> keyMap) {
        return StepDefinitionRefFragments.getStateDesc(getStepDefinitionRef());
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateType(HashMap<String, String> keyMap) {
        return StepDefinitionRefFragments.getStateType(getStepDefinitionRef());
    }

    @Override
    public String getStepDefinitionRefStateFragmentStateTypeDescription(HashMap<String, String> keyMap) {
        String stateType = StepDefinitionRefFragments.getStateType(getStepDefinitionRef());
        return Arrays.stream(StepDefinitionRefStateTypes.values()).filter(e -> e.value.equals(stateType))
                .findFirst().orElseThrow().description;
    }

    @Override
    public String getStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getComponent(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getComponentName(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getComponentType(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap) {
        String componentType = StepObjectRefFragments
                .getComponentType(properties.get("Test Step Full Name").toString());
        return StepObjectRefComponentTypes.valueOf(componentType.toUpperCase()).description;
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getObjectEdgeType(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectEdgeType(properties.get("Test Step Full Name").toString());
        return StepObjectRefObjectEdgeTypes.valueOf(objectType.toUpperCase()).description;
    }

    @Override
    public String getStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getObject(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getObjectName(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getObjectType(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap) {
        return StepObjectRefFragments.getObjectVertexType(properties.get("Test Step Full Name").toString());
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectVertexType(properties.get("Test Step Full Name").toString());
        return StepObjectRefObjectVertexTypes.valueOf(objectType.toUpperCase()).description;
    }

    @Override
    public void setLineTypeLine(HashMap<String, String> keyMap) {
        properties.put("Line", keyMap.get("Line"));
    }

    @Override
    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap) {
        properties.put("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    @Override
    public void setTestStepTypeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepObjectRefObjectVertexFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepObjectRefObjectFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public void setLineTypeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getPhraseTagFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getPhraseTodoFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepDefinitionRefPartFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepDefinitionRefStateFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepObjectRefComponentFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    @Override
    public String getStepObjectRefObjectEdgeFragmentDecomposedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }

    private String getStepDefinitionRef() {
        String testStep = properties.get("Test Step Full Name").toString();
        return testStep.substring(StepObjectRefFragments.getAll(testStep).length()).trim();
    }

}
