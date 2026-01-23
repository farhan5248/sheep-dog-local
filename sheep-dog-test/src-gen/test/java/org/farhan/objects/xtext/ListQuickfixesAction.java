package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListQuickfixesAction {

    public void transition();

    public void setElementType(HashMap<String, String> keyMap);
}
