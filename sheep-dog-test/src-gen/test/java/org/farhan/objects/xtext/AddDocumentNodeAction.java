package org.farhan.objects.xtext;

import java.util.HashMap;

public interface AddDocumentNodeAction {

    public void transition();

    public void setPerformedToAddTableAt(HashMap<String, String> keyMap);

    public void setTestSuiteFullName(HashMap<String, String> keyMap);

    public void setNodePath(HashMap<String, String> keyMap);

    public void setPerformedToAddTextAt(HashMap<String, String> keyMap);
}
