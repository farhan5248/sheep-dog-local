package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ValidateAction {

    public void transition();

    public void setElementType(HashMap<String, String> keyMap);

    public void setSelectedStep(HashMap<String, String> keyMap);
}
