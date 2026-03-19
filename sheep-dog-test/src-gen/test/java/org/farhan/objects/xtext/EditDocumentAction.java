package org.farhan.objects.xtext;

import java.util.HashMap;

public interface EditDocumentAction {

    public void setPerformedToModifyStepDefinitionListWith(HashMap<String, String> keyMap);

    public void setStepObjectFullName(HashMap<String, String> keyMap);

    public void setNodePath(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setPerformedToModifyStepParametersListWith(HashMap<String, String> keyMap);

    public void setStepParametersName(HashMap<String, String> keyMap);

    public void setPerformedToModifyTestStepContainerListWith(HashMap<String, String> keyMap);

    public void setTestSuiteFullName(HashMap<String, String> keyMap);

    public void setTestCaseName(HashMap<String, String> keyMap);

    public void setTestSetupName(HashMap<String, String> keyMap);

    public void setPerformedToModifyTestDataListWith(HashMap<String, String> keyMap);

    public void setTestDataName(HashMap<String, String> keyMap);

    public void setPerformedToModifyTestStepListWith(HashMap<String, String> keyMap);

    public void setTestStepFullName(HashMap<String, String> keyMap);

    public void setPerformedToAddTextAt(HashMap<String, String> keyMap);
}
