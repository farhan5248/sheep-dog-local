package org.farhan.objects.xtext;

import java.util.HashMap;

public interface AddDocumentAction {

    public void transition();

    public void setPerformedToCreateAStepObjectWith(HashMap<String, String> keyMap);

    public void setStepObjectFullName(HashMap<String, String> keyMap);

    public void setPerformedToCreateATestSuiteWith(HashMap<String, String> keyMap);

    public void setTestSuiteFullName(HashMap<String, String> keyMap);
}
