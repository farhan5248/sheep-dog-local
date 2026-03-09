package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListQuickfixesAction {

    public void transition();

    public void setPerformedAsFollows(HashMap<String, String> keyMap);

    public void setTestSuiteFullName(HashMap<String, String> keyMap);

    public void setNodePath(HashMap<String, String> keyMap);
}
