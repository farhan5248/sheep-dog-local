package org.farhan.objects.xtext;

import java.util.HashMap;

public interface EditDocumentAction {

    public void transition();

    public void setLineContent(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepObjectName(HashMap<String, String> keyMap);
}
