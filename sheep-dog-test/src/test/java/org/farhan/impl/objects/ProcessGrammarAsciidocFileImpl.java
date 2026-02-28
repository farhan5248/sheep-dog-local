package org.farhan.impl.objects;

import java.util.Arrays;
import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.PhraseFragments;
import org.farhan.dsl.lang.StepDefinitionRefFragments;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessGrammarAsciidocFileImpl extends TestIDEObject implements ProcessGrammarAsciidocFile {

    @Override
    public void setLineTypeLine(HashMap<String, String> keyMap) {
        objectKeyMap.put("Line", keyMap.get("Line"));
    }

    @Override
    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap) {
        objectKeyMap.put("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    @Override
    public void assertPhraseTagFragmentTagList(HashMap<String, String> keyMap) {
        Assertions.assertTrue(Arrays.asList(replaceKeyword(keyMap.get("Tag List")).split(", "))
                .containsAll(PhraseFragments.getTagAsList(objectKeyMap.get("Line").toString())));
    }

    @Override
    public void assertPhraseTodoFragmentTodoType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Type")),
                PhraseFragments.getTodoType(objectKeyMap.get("Line").toString()));
    }

    @Override
    public void assertPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Description")),
                PhraseFragments.getTodoDesc(objectKeyMap.get("Line").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component")),
                StepObjectRefFragments.getComponent(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Name")),
                StepObjectRefFragments.getComponentName(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type")),
                StepObjectRefFragments.getComponentType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object")),
                StepObjectRefFragments.getObject(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Name")),
                StepObjectRefFragments.getObjectName(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectVertexFragmentObjectName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Name")),
                StepObjectRefFragments.getObjectName(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectVertexType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectEdgeFragmentObjectName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Name")),
                StepObjectRefFragments.getObjectName(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectEdgeType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepDefinitionRefPartFragmentPart(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part")), StepDefinitionRefFragments.getPart(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefPartFragmentPartDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Description")),
                StepDefinitionRefFragments.getPartDesc(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefPartFragmentPartType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type")),
                StepDefinitionRefFragments.getPartType(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefStateFragmentState(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State")), StepDefinitionRefFragments.getState(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefStateFragmentStateDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Description")),
                StepDefinitionRefFragments.getStateDesc(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefStateFragmentStateType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type")),
                StepDefinitionRefFragments.getStateType(stepDefRef));
    }

    private String getStepDefinitionRef() {
        String testStep = objectKeyMap.get("Test Step Full Name").toString();
        return testStep.substring(StepObjectRefFragments.getAll(testStep).length()).trim();
    }
}
