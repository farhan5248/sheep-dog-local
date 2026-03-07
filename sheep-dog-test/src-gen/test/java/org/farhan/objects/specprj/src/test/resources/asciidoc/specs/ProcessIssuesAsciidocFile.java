package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface ProcessIssuesAsciidocFile {

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

    public void setRowListNodeNodePath(HashMap<String, String> keyMap);

    public void setRowListNodeRowContent(HashMap<String, String> keyMap);

    public void assertRowListNodeNodePath(HashMap<String, String> keyMap);

    public void assertRowListNodeRowContent(HashMap<String, String> keyMap);

    public void setTableNodeNodePath(HashMap<String, String> keyMap);

    public void assertTableNodeNodePath(HashMap<String, String> keyMap);

    public void assertTableNodeState(HashMap<String, String> keyMap);

    public void setTestDataListNodeNodePath(HashMap<String, String> keyMap);

    public void setTestDataListNodeTestDataName(HashMap<String, String> keyMap);

    public void assertTestDataListNodeNodePath(HashMap<String, String> keyMap);

    public void assertTestDataListNodeState(HashMap<String, String> keyMap);

    public void assertTestDataListNodeTestDataName(HashMap<String, String> keyMap);

    public void setTestDocumentListNodeNodePath(HashMap<String, String> keyMap);

    public void setTestDocumentListNodeTestSuiteFullName(HashMap<String, String> keyMap);

    public void setTestDocumentListNodeTestSuiteName(HashMap<String, String> keyMap);

    public void assertTestDocumentListNodeNodePath(HashMap<String, String> keyMap);

    public void assertTestDocumentListNodeTestSuiteFullName(HashMap<String, String> keyMap);

    public void assertTestDocumentListNodeTestSuiteName(HashMap<String, String> keyMap);

    public void setTestStepContainerListNodeNodePath(HashMap<String, String> keyMap);

    public void setTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap);

    public void setTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap);

    public void assertTestStepContainerListNodeNodePath(HashMap<String, String> keyMap);

    public void assertTestStepContainerListNodeState(HashMap<String, String> keyMap);

    public void assertTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap);

    public void assertTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap);

    public void setTestStepListNodeNodePath(HashMap<String, String> keyMap);

    public void setTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap);

    public void setTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap);

    public void setTestStepListNodeTestStepFullName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeNodePath(HashMap<String, String> keyMap);

    public void assertTestStepListNodeState(HashMap<String, String> keyMap);

    public void assertTestStepListNodeAndFullName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeAndStepObjectRefName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeAndStepDefinitionRefName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeGivenFullName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeThenFullName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeThenStepObjectRefName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeThenStepDefinitionRefName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeWhenFullName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeWhenStepObjectRefName(HashMap<String, String> keyMap);

    public void assertTestStepListNodeWhenStepDefinitionRefName(HashMap<String, String> keyMap);

    public void setTextNodeNodePath(HashMap<String, String> keyMap);

    public void setTextNodeTextContent(HashMap<String, String> keyMap);

    public void assertTextNodeNodePath(HashMap<String, String> keyMap);

    public void assertTextNodeState(HashMap<String, String> keyMap);
}
