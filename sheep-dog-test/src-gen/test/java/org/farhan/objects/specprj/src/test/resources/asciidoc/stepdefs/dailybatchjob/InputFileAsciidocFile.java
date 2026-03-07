package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import java.util.HashMap;

public interface InputFileAsciidocFile {

    public void setCellListNodeNodePath(HashMap<String, String> keyMap);

    public void setCellListNodeCellName(HashMap<String, String> keyMap);

    public void assertCellListNodeNodePath(HashMap<String, String> keyMap);

    public void assertCellListNodeCellName(HashMap<String, String> keyMap);

    public void assertDescriptionNodeNodePath(HashMap<String, String> keyMap);

    public void assertDescriptionNodeState(HashMap<String, String> keyMap);

    public void setLineListNodeNodePath(HashMap<String, String> keyMap);

    public void setLineListNodeLineContent(HashMap<String, String> keyMap);

    public void assertLineListNodeNodePath(HashMap<String, String> keyMap);

    public void assertLineListNodeLineContent(HashMap<String, String> keyMap);

    public void assertNestedDescriptionNodeNodePath(HashMap<String, String> keyMap);

    public void assertNestedDescriptionNodeState(HashMap<String, String> keyMap);

    public void setStepDefinitionListNodeNodePath(HashMap<String, String> keyMap);

    public void setStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertStepDefinitionListNodeNodePath(HashMap<String, String> keyMap);

    public void assertStepDefinitionListNodeState(HashMap<String, String> keyMap);

    public void assertStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepParametersListNodeNodePath(HashMap<String, String> keyMap);

    public void setStepParametersListNodeStepParametersName(HashMap<String, String> keyMap);

    public void assertStepParametersListNodeNodePath(HashMap<String, String> keyMap);

    public void assertStepParametersListNodeState(HashMap<String, String> keyMap);

    public void assertStepParametersListNodeStepParametersName(HashMap<String, String> keyMap);

    public void assertTableNodeNodePath(HashMap<String, String> keyMap);

    public void assertTableNodeState(HashMap<String, String> keyMap);

    public void setTestDocumentListNodeNodePath(HashMap<String, String> keyMap);

    public void setTestDocumentListNodeStepObjectFullName(HashMap<String, String> keyMap);

    public void setTestDocumentListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void setTestDocumentListNodeStepParametersName(HashMap<String, String> keyMap);

    public void assertTestDocumentListNodeNodePath(HashMap<String, String> keyMap);

    public void assertTestDocumentListNodeStepObjectFullName(HashMap<String, String> keyMap);

    public void assertTestDocumentListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertTestDocumentListNodeStepParametersName(HashMap<String, String> keyMap);
}
