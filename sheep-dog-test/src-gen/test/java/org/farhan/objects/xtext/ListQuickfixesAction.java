package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListQuickfixesAction {

    public void transition();

    public void setSelectedElement(HashMap<String, String> keyMap);
}
