package org.farhan.impl.objects;

import java.util.Arrays;
import java.util.HashMap;
import org.farhan.common.TestObjectIDE;
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
public class ProcessGrammarFragmentAsciidocFileImpl extends TestObjectIDE implements ProcessGrammarFragmentAsciidocFile {

    @Override
    public void assertPhraseTagFragmentTagList(HashMap<String, String> keyMap) {
        String expected = replaceKeyword(keyMap.get("Tag List"));
        Assertions.assertTrue(PhraseFragments.getTagAsList(properties.get("Line").toString())
                .containsAll(expected.isEmpty() ? Arrays.asList() : Arrays.asList(expected.split(", "))));
    }

    @Override
    public void assertPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Description")),
                PhraseFragments.getTodoDesc(properties.get("Line").toString()));
    }

    @Override
    public void assertPhraseTodoFragmentTodoType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Type")),
                PhraseFragments.getTodoType(properties.get("Line").toString()));
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
    public void assertStepDefinitionRefPartFragmentPartTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String partType = StepDefinitionRefFragments.getPartType(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type Description")),
                StepDefinitionRefPartTypes.valueOf(partType.toUpperCase()).description);
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

    @Override
    public void assertStepDefinitionRefStateFragmentStateTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String stateType = StepDefinitionRefFragments.getStateType(stepDefRef);
        String description = Arrays.stream(StepDefinitionRefStateTypes.values()).filter(e -> e.value.equals(stateType))
                .findFirst().orElseThrow().description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type Description")), description);
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component")),
                StepObjectRefFragments.getComponent(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Name")),
                StepObjectRefFragments.getComponentName(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type")),
                StepObjectRefFragments.getComponentType(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap) {
        String componentType = StepObjectRefFragments
                .getComponentType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type Description")),
                StepObjectRefComponentTypes.valueOf(componentType.toUpperCase()).description);
    }

    @Override
    public void assertStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectEdgeType(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectEdgeType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")),
                StepObjectRefObjectEdgeTypes.valueOf(objectType.toUpperCase()).description);
    }

    @Override
    public void assertStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object")),
                StepObjectRefFragments.getObject(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Name")),
                StepObjectRefFragments.getObjectName(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectType(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectVertexType(properties.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectVertexType(properties.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")),
                StepObjectRefObjectVertexTypes.valueOf(objectType.toUpperCase()).description);
    }

    @Override
    public void setLineTypeLine(HashMap<String, String> keyMap) {
        properties.put("Line", keyMap.get("Line"));
    }

    @Override
    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap) {
        properties.put("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    private String getStepDefinitionRef() {
        String testStep = properties.get("Test Step Full Name").toString();
        return testStep.substring(StepObjectRefFragments.getAll(testStep).length()).trim();
    }

}
