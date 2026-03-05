package org.farhan.objects.xtext;

import java.util.HashMap;

public interface EditDocumentAction {

    public void transition();

    public void setCellName(HashMap<String, String> keyMap);

    public void setLineContent(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepParametersName(HashMap<String, String> keyMap);

    public void setStepObjectFullName(HashMap<String, String> keyMap);

    public void setTestSuiteFullName(HashMap<String, String> keyMap);

    public void setTestCaseName(HashMap<String, String> keyMap);

    public void setRowContent(HashMap<String, String> keyMap);

    public void setTestDataName(HashMap<String, String> keyMap);

    public void setTestSetupName(HashMap<String, String> keyMap);

    public void setAndStepObjectName(HashMap<String, String> keyMap);

    public void setAndStepDefinitionName(HashMap<String, String> keyMap);

    public void setGivenStepObjectName(HashMap<String, String> keyMap);

    public void setGivenStepDefinitionName(HashMap<String, String> keyMap);

    public void setThenStepObjectName(HashMap<String, String> keyMap);

    public void setThenStepDefinitionName(HashMap<String, String> keyMap);

    public void setWhenStepObjectName(HashMap<String, String> keyMap);

    public void setWhenStepDefinitionName(HashMap<String, String> keyMap);
}
