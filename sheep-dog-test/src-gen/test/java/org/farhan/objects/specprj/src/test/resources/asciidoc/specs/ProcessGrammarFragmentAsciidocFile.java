package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface ProcessGrammarFragmentAsciidocFile {

    public String getStepObjectRefComponentFragmentDecomposedAsFollows(HashMap<String, String> keyMap);

    public String getStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap);

    public String getStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap);

    public String getStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap);

    public String getStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap);

    public void setTestStepTypeCreatedAsFollows(HashMap<String, String> keyMap);

    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectFragmentDecomposedAsFollows(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectVertexFragmentDecomposedAsFollows(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectEdgeFragmentDecomposedAsFollows(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap);

    public String getStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap);
}
