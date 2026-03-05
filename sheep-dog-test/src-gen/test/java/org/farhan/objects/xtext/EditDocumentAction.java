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
}
