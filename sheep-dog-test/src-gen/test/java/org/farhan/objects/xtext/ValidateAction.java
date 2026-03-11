package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ValidateAction {

    public void setPerformedAsFollows(HashMap<String, String> keyMap);

    public void setTestSuiteFullName(HashMap<String, String> keyMap);

    public void setNodePath(HashMap<String, String> keyMap);
}
