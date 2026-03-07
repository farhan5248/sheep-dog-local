package org.farhan.objects.xtext;

import java.util.HashMap;

public interface EditDocumentNodeAction {

    public void transition();

    public void setNodePath(HashMap<String, String> keyMap);

    public void setCellName(HashMap<String, String> keyMap);

    public void setLineContent(HashMap<String, String> keyMap);

    public void setRowContent(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepParametersName(HashMap<String, String> keyMap);

    public void setTestDataName(HashMap<String, String> keyMap);

    public void setStepObjectFullName(HashMap<String, String> keyMap);

    public void setTestSuiteFullName(HashMap<String, String> keyMap);

    public void setTestCaseName(HashMap<String, String> keyMap);

    public void setTestSetupName(HashMap<String, String> keyMap);

    public void setAndStepObjectRefName(HashMap<String, String> keyMap);

    public void setAndStepDefinitionRefName(HashMap<String, String> keyMap);

    public void setGivenStepObjectRefName(HashMap<String, String> keyMap);

    public void setGivenStepDefinitionRefName(HashMap<String, String> keyMap);

    public void setThenStepObjectRefName(HashMap<String, String> keyMap);

    public void setThenStepDefinitionRefName(HashMap<String, String> keyMap);

    public void setWhenStepObjectRefName(HashMap<String, String> keyMap);

    public void setWhenStepDefinitionRefName(HashMap<String, String> keyMap);
}
