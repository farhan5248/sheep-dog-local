package org.farhan.objects.xtext;

import java.util.HashMap;

public interface EditDocumentAction {

    public void setPerformedToModifyStepDefinitionListWith(HashMap<String, String> keyMap);

    public void setStepObjectFullName(HashMap<String, String> keyMap);

    public void setNodePath(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setPerformedToModifyStepParametersListWith(HashMap<String, String> keyMap);

    public void setStepParametersName(HashMap<String, String> keyMap);
}
