package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ValidateErrorAction {

    public void transition();

    public void setSelectedStep(HashMap<String, String> keyMap);
}
