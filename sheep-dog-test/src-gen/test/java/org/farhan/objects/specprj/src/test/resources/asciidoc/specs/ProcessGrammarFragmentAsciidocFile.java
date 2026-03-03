package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface ProcessGrammarFragmentAsciidocFile {

    public void setLineTypeLine(HashMap<String, String> keyMap);

    public void assertPhraseTagFragmentTagList(HashMap<String, String> keyMap);

    public void assertPhraseTodoFragmentTodoType(HashMap<String, String> keyMap);

    public void assertPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefPartFragmentPart(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefPartFragmentPartDescription(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefPartFragmentPartType(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefPartFragmentPartTypeDescription(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefStateFragmentState(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefStateFragmentStateDescription(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefStateFragmentStateType(HashMap<String, String> keyMap);

    public void assertStepDefinitionRefStateFragmentStateTypeDescription(HashMap<String, String> keyMap);

    public void assertStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap);

    public void assertStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap);

    public void assertStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap);

    public void assertStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap);

    public void assertStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap);

    public void assertStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap);

    public void assertStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap);

    public void assertStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap);

    public void assertStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap);

    public void assertStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap);

    public void assertStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap);

    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap);
}
