package org.farhan.objects.xtext;

import java.util.HashMap;

public interface AddDocumentNodeAction {

    public void transition();

    public void setNodePath(HashMap<String, String> keyMap);
}
